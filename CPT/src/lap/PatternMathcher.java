package lap;


import java.awt.Color;
import java.awt.Point;

import robocode.AdvancedRobot;
import robocode.GunTurnCompleteCondition;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;
import robocode.util.Utils;

public class PatternMathcher extends AdvancedRobot {

  boolean isRoundOver = false;
  int moveDirection = 20;

  StringBuilder pastEnemyMovements = new StringBuilder("");
  boolean turnStarted = false;
  long counter = 0;

  double desiredGunRange = 0;
  double X;
  double Y;

  double diffX;
  double diffY;

  double width;
  double height;

  int wallBarrier = 30;

  public void run() {
    // ...
    setBodyColor(Color.black);
    setGunColor(Color.black);
    setRadarColor(Color.orange);

    width = getBattleFieldWidth();
    height = getBattleFieldHeight();

    // sets the position variables
    X = getX();
    Y = getY();

    // Stops us from repositioning the radar for every change in
    // robot direction
    setAdjustRadarForRobotTurn(true);
    setAdjustRadarForGunTurn(true);

    turnRadarRightRadians(Double.POSITIVE_INFINITY);



    System.out.println("Initial gun heading is: " + getGunHeading());

    do {
      // Check for new targets.
      // Only necessary for Narrow Lock because sometimes our radar is already
      // pointed at the enemy and our onScannedRobot code doesn't end up telling
      // it to turn, so the system doesn't automatically call scan() for us
      // [see the javadocs for scan()].

      // setAhead(moveDirection);
      // execute();

      scan();

    } while (true);
  }

  public void onScannedRobot(ScannedRobotEvent e) {

    counter += 1;

    double radarTurn =
    // Absolute bearing to target
        getHeadingRadians() + e.getBearingRadians()
        // Subtract current radar heading to get turn required
            - getRadarHeadingRadians();

    // System.out.println("Heading: " + e.getHeading() + "Velocity: " + e.getVelocity());

    // String versions of the enemey heading and velicoty with padded 0's on the left
    String formatedStringHeading = String.format("%03d", (int) e.getHeading());
    String formatedStringVelocity = formatVelocty(e.getVelocity());

    // System.out.println("Heading: " + formatedStringHeading + " Velocity: " +
    // formatedStringVelocity);

    // pastEnemyHeadings.append("Hello");

    pastEnemyMovements.append(formatedStringHeading);
    pastEnemyMovements.append(formatedStringVelocity);
    pastEnemyMovements.append(";");


    // Allows you to know that 100 turns have passed,
    // Change to allow more or less data to be pattern matched
    // controls how many past moves to pattern match against large move set
    // controls how much data to store and pattern match
    if (counter > 100) {
      pastEnemyMovements.delete(0, 6);

      // Find a movement in the 0 to 95 elements of pastEnemyMovements that matches the last 5
      // movements
      // Use that to get a x2 and y2
      // We want to get the last 5 elements, and the pastEnemyMovements is 100*6 characters long
      String lastFiveEnemyMovements = pastEnemyMovements.substring(95 * 6, 100 * 6);

      // finds index of first substring that matches this
      int indexOfMatchedMovement = pastEnemyMovements.indexOf(lastFiveEnemyMovements);

      // If a match is found that occured before the string that we gave in

      // FIXME CHANGED FROM 95 TO 90
      if (indexOfMatchedMovement <= 60 * 6 && !turnStarted && e.getDistance() < 400) {

        System.out.println("A pattern has been matched");

        // This will tryy to predict where the enemy will go next
        double xMe = getX();
        double yMe = getY();

        // Gets the element after the matched movement
        String nextMovement = pastEnemyMovements.substring(indexOfMatchedMovement + 39 * 6, indexOfMatchedMovement + 40 * 6);
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

        System.out.println("Rotang: " + rotAng);

        // If rotAng is negative turn into + heading
        if (rotAng < 0) {
          rotAng = 360 + rotAng;
        }

        // Get the rotational now in terms of how much the gun has to move from the current position
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
        setTurnGunRight(rotAng);
        turnStarted = true;
      }

    }


    // setAhead(moveDirection);


    if (getGunTurnRemaining() <= 2 && turnStarted) {
      setFire(1);
      turnStarted = false;
      System.out.println("Activated: " + getGunTurnRemaining());
    } else {
      System.out.println(getGunTurnRemaining());
    }

    // System.out.println(pastEnemyMovements.toString());
    X = getX();
    Y = getY();

    // Find diffirence in self movement
    diffX = Math.cos(getHeadingRadians()) * moveDirection;
    diffY = Math.sin(getHeadingRadians()) * moveDirection;

    if ((X + diffX) < wallBarrier || (X + diffX) > (width - wallBarrier) || (Y + diffY) < (wallBarrier) || (Y + diffY) > (height - wallBarrier)) {
      System.out.println(width + " " + height);
      moveDirection = -moveDirection;
    }
    setAhead(moveDirection);
    setTurnRadarRightRadians(1 * Utils.normalRelativeAngle(radarTurn));



    // ...
  }

  private String formatVelocty(double velocity) {
    String formatedVelocity = Integer.toString((int) velocity);
    if (velocity >= 0) {
      String sign = "+";
      formatedVelocity = sign + formatedVelocity.charAt(formatedVelocity.length() - 1);
    }
    return formatedVelocity;
  }

  public void onRoundWinEvent(WinEvent e) {

  }

  public void onHitWall(HitWallEvent e) {
    // moveDirection = -moveDirection;// reverse direction upon hitting a wall

    setBack(wallBarrier);

  }
}
