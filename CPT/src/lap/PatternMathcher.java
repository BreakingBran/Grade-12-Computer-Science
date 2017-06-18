package lap;


import java.awt.Color;
import java.util.Arrays;

import robocode.AdvancedRobot;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;
import robocode.util.Utils;

public class PatternMathcher extends AdvancedRobot {

  boolean isRoundOver = false;
  int moveDirection = 20;

  StringBuilder pastEnemyHeadings = new StringBuilder("");
  StringBuilder pastEnemyVelocities = new StringBuilder("");
  long counter = 0;


  public void run() {
    // ...
    setBodyColor(Color.black);
    setGunColor(Color.black);
    setRadarColor(Color.orange);
    turnRadarRightRadians(Double.POSITIVE_INFINITY);

    /*
     * char[] chars = new char[300]; Arrays.fill(chars, '0'); String result = new String(chars);
     * 
     * pastEnemyHeadings = new StringBuilder(result);
     * 
     * result = new String(Arrays.copyOfRange(chars, 0, 200));
     * 
     * pastEnemyVelocities = new StringBuilder(result);
     * 
     * System.out.println(pastEnemyHeadings.toString());
     */

    // Stops us from repositioning the radar for every change in
    // robot direction
    setAdjustRadarForRobotTurn(true);

    do {
      // Check for new targets.
      // Only necessary for Narrow Lock because sometimes our radar is already
      // pointed at the enemy and our onScannedRobot code doesn't end up telling
      // it to turn, so the system doesn't automatically call scan() for us
      // [see the javadocs for scan()].
      setAhead(moveDirection);
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

    //System.out.println("Heading: " + formatedStringHeading + " Velocity: " + formatedStringVelocity);

    // pastEnemyHeadings.append("Hello");

    pastEnemyHeadings.append(formatedStringHeading);
    pastEnemyVelocities.append(formatedStringVelocity);

    //Allows you to know that 100  turns have passed,
    //Change to allow more or less data to be pattern matched
    if (counter > 100) {
      pastEnemyHeadings.delete(0, 3);
      pastEnemyVelocities.delete(0, 2);
    }
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
    moveDirection = -moveDirection;// reverse direction upon hitting a wall
  }
}
