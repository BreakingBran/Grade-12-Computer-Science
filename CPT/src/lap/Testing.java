package lap;

/**
 * LaPBot: A robot by LancePereira Industries
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Jun 3, 2017
 * 
 *        Source: http://www.dinbedstemedarbejder.dk/Dat3.pdf check if there is something better
 *        than event driven gaming
 */

import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.Queue;

import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;
import robocode.util.Utils;
import java.awt.geom.*;     // for Point2D's
import java.util.ArrayList; // for collection of waves


public class Testing extends AdvancedRobot {
  /**
   * run: SimpleMind ed's default behavior
   */
  private boolean enemyFound = false;
  private int counter100 = 0;
  private Queue<ScannedRobotEvent> enemyMovements = new LinkedList<ScannedRobotEvent>();
  private int[] enemyVelocities = new int[100];
  private int[] enemyHeadings = new int[100];
  private double turnAmount = 0;
  private boolean shotFired = false;
  private double enemyEnergy;
  private int debugginggCounter = 0;
  
  
  
  public static int BINS = 47;
  public static double _surfStats[] = new double[BINS];
  public Point2D.Double _myLocation;     // our bot's location
  public Point2D.Double _enemyLocation;  // enemy bot's location

  public ArrayList _enemyWaves;
  public ArrayList _surfDirections;
  public ArrayList _surfAbsBearings;

  public static double _oppEnergy = 100.0;

  /** This is a rectangle that represents an 800x600 battle field,
   * used for a simple, iterative WallSmoothing method (by PEZ).
   * If you're not familiar with WallSmoothing, the wall stick indicates
   * the amount of space we try to always have on either end of the tank
   * (extending straight out the front or back) before touching a wall.
   */
   public static Rectangle2D.Double _fieldRect
       = new java.awt.geom.Rectangle2D.Double(18, 18, 764, 564);
   public static double WALL_STICK = 160;


  public void run() {
    // ...
    // turnRadarRightRadians(Double.POSITIVE_INFINITY);
    _enemyWaves = new ArrayList();
    _surfDirections = new ArrayList();
    _surfAbsBearings = new ArrayList();

    setAdjustGunForRobotTurn(true);
    setAdjustRadarForGunTurn(true);

    do {
      // Check for new targets.
      // Only necessary for Narrow Lock because sometimes our radar is already
      // pointed at the enemy and our onScannedRobot code doesn't end up telling
      // it to turn, so the system doesn't automatically call scan() for us
      // [see the javadocs for scan()].
      // setTurnRight(2);
      // turnRight(2);
      
      //max it can move is 90 degrees ine one turn so any higher has no point
      //You have to use turn instead of setTurn as turn can be interupted while setTurn
      //will keep on moving
      turnRadarRight(90);
      setAhead(2);
      execute();
    } while (true);
  }

  public void onScannedRobot(ScannedRobotEvent e) {
    double radarTurn =
    // Absolute bearing to target
        getHeadingRadians() + e.getBearingRadians()
        // Subtract current radar heading to get turn
        // required
            - getRadarHeadingRadians();

    // normalRelativeAngle makes sure that the turn angle is
    // inbetween 180 and 180
    
    setTurnRadarRightRadians(Utils.normalRelativeAngle(radarTurn));


    // ...
  }

  class EnemyWave {
    Point2D.Double fireLocation;
    long fireTime;
    double bulletVelocity, directAngle, distanceTraveled;
    int direction;
    //allows variables to be accessed without getters and setters without being static
    public EnemyWave() {}
  }

  public double wallSmoothing(Point2D.Double botLocation, double angle, int orientation) {
    while (!_fieldRect.contains(project(botLocation, angle, WALL_STICK))) {
      angle += orientation * 0.05;
    }
    return angle;
  }

  public static Point2D.Double project(Point2D.Double sourceLocation, double angle, double length) {
    return new Point2D.Double(sourceLocation.x + Math.sin(angle) * length, sourceLocation.y + Math.cos(angle) * length);
  }

  public static double absoluteBearing(Point2D.Double source, Point2D.Double target) {
    //tells you angle from positive x axis to the vector (x2-x1,y2-y1)
    return Math.atan2(target.x - source.x, target.y - source.y);
  }

  public static double limit(double min, double value, double max) {
    return Math.max(min, Math.min(value, max));
  }

  public static double bulletVelocity(double power) {
    return (20.0 - (3.0 * power));
  }

  public static double maxEscapeAngle(double velocity) {
    return Math.asin(8.0 / velocity);
  }

  public static void setBackAsFront(AdvancedRobot robot, double goAngle) {
    double angle = Utils.normalRelativeAngle(goAngle - robot.getHeadingRadians());
    if (Math.abs(angle) > (Math.PI / 2)) {
      if (angle < 0) {
        robot.setTurnRightRadians(Math.PI + angle);
      } else {
        robot.setTurnLeftRadians(Math.PI - angle);
      }
      robot.setBack(100);
    } else {
      if (angle < 0) {
        robot.setTurnLeftRadians(-1 * angle);
      } else {
        robot.setTurnRightRadians(angle);
      }
      robot.setAhead(100);
    }
  }

}
