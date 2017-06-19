/**
 * LaPBot: Formerly known as ReidCrusherBor2
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Jun 2, 2017
 * 
 *        Credit/Sources: http://robowiki.net/wiki/Robocode/My_First_Robot
 *        http://robowiki.net/wiki/Pattern_Matching
 *        https://www.tutorialspoint.com/java/lang/stringbuilder_indexof_str.htm
 *        http://robowiki.net/wiki/SuperTracker http://www.javaranch.com/drive/modulo.html
 */

package lap;


import java.awt.Color;

import robocode.AdvancedRobot;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;

public class LaPBot extends AdvancedRobot {

  boolean isRoundOver = false;
  int moveDirection = 1;
  StringBuilder pastEnemyMovements = new StringBuilder("");
  boolean turnStarted = false;
  long counter = 0;

  double xPos;
  double yPos;

  double diffX;
  double diffY;

  double widthMap;
  double heighMap;

  int wallBarrier = 30;

  /**
   * This is the main Run class, it is the
   * first program run for the robot
   */
  public void run() {
    // ...
    setBodyColor(Color.black);
    setGunColor(Color.black);
    setRadarColor(Color.orange);

    widthMap = getBattleFieldWidth();
    heighMap = getBattleFieldHeight();

    // gets the position variables
    xPos = getX();
    yPos = getY();

    // Stops us from repositioning the radar for every change in
    // robot direction
    setAdjustRadarForRobotTurn(true);
    setAdjustRadarForGunTurn(true);

    
    //Super important, this basically scans everything
    //with an infinte amount of right turns
    turnRadarRightRadians(Double.POSITIVE_INFINITY);

    do {
      /*
       * Need to put scan in here because turning right for infinity doesn't guarantee a scan event
       * to occur
       */
      scan();

    } while (true);
  }



  /**
   * This does literally everything for the robot and is only called when a enemy is scanned
   */
  public void onScannedRobot(ScannedRobotEvent e) {

    //turn counter tells how many times this functions been called
    counter += 1;

    // String versions of the enemey heading and velicoty with padded 0's on the left
    String formatedStringHeading = String.format("%03d", (int) e.getHeading());
    String formatedStringVelocity = formatVelocty(e.getVelocity());

    //Appends latest enemy movement to enemy movement data structure
    pastEnemyMovements.append(formatedStringHeading);
    pastEnemyMovements.append(formatedStringVelocity);
    pastEnemyMovements.append(";");

    //if more than 100 movies in the database, delete the first move
    if (counter > 100) {
      pastEnemyMovements.delete(0, 6);
    }

    //pattern matching is semi-expensive compared to normal movement
    //moves, do it every 80 turns after a full data set to stop
    //robot from freezing
    if (counter % 80 == 0 && counter > 100) {//the && counter > 100 seems repetitive but is necessary

      double radarTurn =
      // Absolute bearing to target
          getHeadingRadians() + e.getBearingRadians()
          // Subtract current radar heading to get turn required
              - getRadarHeadingRadians();

     
      // Find a movement in the 0 to 95 elements of pastEnemyMovements that matches the last 5
      // movements
      // Use that to get a x2 and y2
      // We want to get the last 5 elements, and the pastEnemyMovements is 100*6 characters long
      String lastFiveEnemyMovements = pastEnemyMovements.substring(95 * 6, 100 * 6);

      // finds index of first substring that matches this
      int indexOfMatchedMovement = pastEnemyMovements.indexOf(lastFiveEnemyMovements);

      // If a match is found that occured before the string that we gave in
      if (indexOfMatchedMovement <= 90 * 6 && !turnStarted && e.getDistance() < 400) {

        // This will try to predict where the enemy will go next
        double xMe = getX();
        double yMe = getY();

        // Gets the element after the matched movement
        String nextMovement = pastEnemyMovements.substring(indexOfMatchedMovement + 9 * 6, indexOfMatchedMovement + 10 * 6);
        int enemyHeading = Integer.parseInt(nextMovement.substring(0, 3));
        int enemyVelocity = Integer.parseInt(nextMovement.substring(3, 5));

        // This get the predicted difference in the enemy movements (using basic trig)
        // the sin and cos are switched for x and y as the angle is from North instead of + x axis
        double xEnemyDiffirence = Math.sin(Math.toRadians(enemyHeading)) * enemyVelocity;
        double yEnemyDiffirence = Math.cos(Math.toRadians(enemyHeading)) * enemyVelocity;

        //enemies original position
        double xEnemyOriginal = xMe + Math.sin(getRadarHeadingRadians()) * e.getDistance();
        double yEnemyOriginal = yMe + Math.cos(getRadarHeadingRadians()) * e.getDistance();

        //enemies new position
        double xEnemyNew = xEnemyOriginal + xEnemyDiffirence;
        double yEnemyNew = yEnemyOriginal + yEnemyDiffirence; // FIXME MADE THAT A NEGATIVE
        // Are you feeling it now Mr.Krabs!!

        //gets diffirence in two points
        double difX = xEnemyNew - xMe;
        double difY = yEnemyNew - yMe;
        double rotAng = -Math.toDegrees(Math.atan2(-difX, difY));

        // If rotAng is negative turn into + heading
        if (rotAng < 0) {
          rotAng = 360 + rotAng;
        }

        // Get the rotational now in terms of how much the gun has to move from the current
        // position
        rotAng = (rotAng - getGunHeading());

        //stops gun from overturning and gives it shortest path to turn
        if (rotAng > 180) {
          rotAng -= 360;
        } else if (rotAng < -180) {
          rotAng += 360;
        }

        //tells gun to turn and sets the flag not to come here until done turning
        turnGunRight(rotAng);
        turnStarted = true;
      }

      //Decides if to shoot or not depending on angle of turn left
      if (getGunTurnRemaining() <= 2 && turnStarted) {
        if (e.getDistance() > 150) {//if far don't risk it
          fire(1);
        } else {//if close shoot to go home
          fire(3);
        }
        //signifies that a new turn can be made
        turnStarted = false;
      }

    } else {

      //gets needed data to calculate trajecteries
      double absBearing = e.getBearingRadians() + getHeadingRadians();// enemies absolute bearing
      double latVel = e.getVelocity() * Math.sin(e.getHeadingRadians() - absBearing);// enemies later velocity
      double gunRotationAmt;// amount to turn our gun

      // lock on the radar
      setTurnRadarLeftRadians(getRadarTurnRemainingRadians());
      if (Math.random() > .9) {
        setMaxVelocity((12 * Math.random()) + 12);// randomly change speed
      }
      // if they are far away be more conservative
      if (e.getDistance() > 150) {
        // add gun lead
        gunRotationAmt = robocode.util.Utils.normalRelativeAngle(absBearing - getGunHeadingRadians() + latVel / 22);
        setTurnGunRightRadians(gunRotationAmt); // turn our gun
        // drive towards predicted location
        setTurnRightRadians(robocode.util.Utils.normalRelativeAngle(absBearing - getHeadingRadians() + latVel / getVelocity()));

        setAhead((e.getDistance() - 140) * moveDirection);// move forward
        setFire(3);// fire
        // If close be more agressive
      } else {
        // add a lead amount to aim
        gunRotationAmt = robocode.util.Utils.normalRelativeAngle(absBearing - getGunHeadingRadians() + latVel / 15);
        setTurnGunRightRadians(gunRotationAmt);
        setTurnLeft(-90 - e.getBearing());
        //drive towards predicted area
        setAhead((e.getDistance() - 140) * moveDirection);
        setFire(3);// fire
      }


    }
    // ...
  }


  /**
   * Just a nice way to format the velocities in the enemyMovement Database it padds the velocity
   * with a + if > 0
   * 
   * @param velocity
   * @return
   */
  private String formatVelocty(double velocity) {
    String formatedVelocity = Integer.toString((int) velocity);
    if (velocity >= 0) {
      //adds + sign so that all data is length 2 for velocity
      String sign = "+";
      formatedVelocity = sign + formatedVelocity.charAt(formatedVelocity.length() - 1);
    }
    return formatedVelocity;
  }

  /**
   * Does this really need explaing?
   * @param e
   */
  public void onRoundWinEvent(WinEvent e) {
    System.out.println("We’re going to win so much, you’re going to be so sick and tired of winning");
  }

  /**
   * reverse movement if wall hit
   */
  public void onHitWall(HitWallEvent e) {
    moveDirection = -moveDirection;// reverse direction upon hitting a wall

    // setBack(wallBarrier);

  }
}
