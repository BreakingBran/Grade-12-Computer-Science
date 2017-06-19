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
import java.awt.Point;

import robocode.AdvancedRobot;
import robocode.GunTurnCompleteCondition;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;
import robocode.util.Utils;

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
   * This is the main Run class
   */
  public void run() {
    // ...
    setBodyColor(Color.black);
    setGunColor(Color.black);
    setRadarColor(Color.orange);

    widthMap = getBattleFieldWidth();
    heighMap = getBattleFieldHeight();

    // sets the position variables
    xPos = getX();
    yPos = getY();

    // Stops us from repositioning the radar for every change in
    // robot direction
    setAdjustRadarForRobotTurn(true);
    setAdjustRadarForGunTurn(true);

    turnRadarRightRadians(Double.POSITIVE_INFINITY);



    System.out.println("Initial gun heading is: " + getGunHeading());

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

    counter += 1;


    // String versions of the enemey heading and velicoty with padded 0's on the left
    String formatedStringHeading = String.format("%03d", (int) e.getHeading());
    String formatedStringVelocity = formatVelocty(e.getVelocity());

    // System.out.println("Heading: " + formatedStringHeading + " Velocity: " +
    // formatedStringVelocity);

    // pastEnemyHeadings.append("Hello");

    pastEnemyMovements.append(formatedStringHeading);
    pastEnemyMovements.append(formatedStringVelocity);
    pastEnemyMovements.append(";");

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

      // System.out.println("Heading: " + e.getHeading() + "Velocity: " + e.getVelocity());

      // Allows you to know that 100 turns have passed,
      // Change to allow more or less data to be pattern matched
      // controls how many past moves to pattern match against large move set
      // controls how much data to store and pattern match



      // Find a movement in the 0 to 95 elements of pastEnemyMovements that matches the last 5
      // movements
      // Use that to get a x2 and y2
      // We want to get the last 5 elements, and the pastEnemyMovements is 100*6 characters long
      String lastFiveEnemyMovements = pastEnemyMovements.substring(95 * 6, 100 * 6);

      // finds index of first substring that matches this
      int indexOfMatchedMovement = pastEnemyMovements.indexOf(lastFiveEnemyMovements);

      // If a match is found that occured before the string that we gave in

      // FIXME CHANGED FROM 95 TO 90
      if (indexOfMatchedMovement <= 90 * 6 && !turnStarted && e.getDistance() < 400) {

        // System.out.println("A pattern has been matched");

        // This will tryy to predict where the enemy will go next
        double xMe = getX();
        double yMe = getY();

        // Gets the element after the matched movement
        String nextMovement = pastEnemyMovements.substring(indexOfMatchedMovement + 9 * 6, indexOfMatchedMovement + 10 * 6);
        int enemyHeading = Integer.parseInt(nextMovement.substring(0, 3));
        int enemyVelocity = Integer.parseInt(nextMovement.substring(3, 5));

        // This get the predicted difference in the enemy movements
        // the sin and cos are switched for x and y as the angle is from North instead of + x axis
        double xEnemyDiffirence = Math.sin(Math.toRadians(enemyHeading)) * enemyVelocity;
        double yEnemyDiffirence = Math.cos(Math.toRadians(enemyHeading)) * enemyVelocity;

        double xEnemyOriginal = xMe + Math.sin(getRadarHeadingRadians()) * e.getDistance();
        double yEnemyOriginal = yMe + Math.cos(getRadarHeadingRadians()) * e.getDistance();

        double xEnemyNew = xEnemyOriginal + xEnemyDiffirence;
        double yEnemyNew = yEnemyOriginal + yEnemyDiffirence; // FIXME MADE THAT A NEGATIVE
        // Are you feeling it now Mr.Krabs!!

        double difX = xEnemyNew - xMe;
        double difY = yEnemyNew - yMe;
        double rotAng = -Math.toDegrees(Math.atan2(-difX, difY));

        // System.out.println("Rotang: " + rotAng);

        // If rotAng is negative turn into + heading
        if (rotAng < 0) {
          rotAng = 360 + rotAng;
        }

        // Get the rotational now in terms of how much the gun has to move from the current
        // position
        rotAng = (rotAng - getGunHeading());

        if (rotAng > 180) {
          rotAng -= 360;
        } else if (rotAng < -180) {
          rotAng += 360;
        }

        /*
         * System.out.println("Rotang after: " + rotAng);
         * System.out.println("Detected at Radar Heading: " + getRadarHeading());
         * System.out.println("Gun currently at (Degrees): " + getGunHeading());
         * System.out.println("Gun rotation set at (Degrees): " + rotAng);
         * System.out.printf("Enemy currently at: (%s, %s) \n", xEnemyOriginal,yEnemyOriginal);
         * System.out.printf("Enemy predicted at: (%s, %s) \n", xEnemyNew,yEnemyNew);
         */

        // Try using Right
        // setTurnGunRight(rotAng);
        turnGunRight(rotAng);
        turnStarted = true;
        System.out.println("Hello");


      }


      // setAhead(moveDirection);


      if (getGunTurnRemaining() <= 2 && turnStarted) {
        if (e.getDistance() > 150) {
          fire(1);
        } else {
          fire(3);
        }
        turnStarted = false;
        // System.out.println("Activated: " + getGunTurnRemaining());
      }

    } else {

      // double absBearing = e.getHeadingRadians();
      double absBearing = e.getBearingRadians() + getHeadingRadians();// enemies absolute bearing
      double latVel = e.getVelocity() * Math.sin(e.getHeadingRadians() - absBearing);// enemies
                                                                                     // later
                                                                                     // velocity
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
      String sign = "+";
      formatedVelocity = sign + formatedVelocity.charAt(formatedVelocity.length() - 1);
    }
    return formatedVelocity;
  }

  public void onRoundWinEvent(WinEvent e) {
    System.out.println("We’re going to win so much, you’re going to be so sick and tired of winning");
  }

  public void onHitWall(HitWallEvent e) {
    moveDirection = -moveDirection;// reverse direction upon hitting a wall

    // setBack(wallBarrier);

  }
}
