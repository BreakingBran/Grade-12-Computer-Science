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

package lap;

import robocode.*;
import robocode.util.Utils;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;


public class LapBot2 extends AdvancedRobot {
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

  public void run() {

    // TODO try to make the robot aim it's gun sideways and make the entire robot turn

    setTurnGunRight(90);

    // Decorate your Robot
    this.setColors(Color.blue, Color.blue, Color.red);

    turnRadarRight(360);
    // Main loop (infinite - game controls when it's over)
    do{
      //setAhead(1);
      //setBack(1);
      scan();
    }while(true);
  }

  private void swivel() {

    turnRadarLeft(2);
    turnRadarRight(2);

  }

  /**
   * onScannedRobot: What to do when you see another robot
   */
  public void onScannedRobot(ScannedRobotEvent e) {

    // On scanned robot, add the robots movement, velocitty, and heading
    // to the list of past movements from the robot

    // takes the heading of my robot, adds the difference to the enemy, and subtracts the diffirence
    // between my robot and radar
    double radarTurn = getHeadingRadians() + e.getBearingRadians() - getRadarHeadingRadians();

    if (!enemyFound) {
      enemyFound = true;
      enemyEnergy = e.getEnergy();
    } else {

      if (counter100 < 100) {
        // Adds the first intial movements
        enemyMovements.add(e);
      } else if (counter100 > 100) {
        // Adds new movmement to back of Queue, removes the oldest movement
        enemyMovements.remove();
        enemyMovements.add(e);
      }

      // They shot something
      if (e.getEnergy() < enemyEnergy) {
        System.out.println("He shot");
        shotFired = true;
        enemyEnergy = e.getEnergy();
      }
    }
    
    // The normal relative angle forces the answer to be -180 to +180 degrees
    setTurnRightRadians(Utils.normalRelativeAngle(radarTurn));

  }

  /**
   * onHitByBullet: What to do when you're hit by a bullet
   */
  public void onHitByBullet(HitByBulletEvent e) {
    // account for the extra energy that the enemy attained
    enemyEnergy = e.getPower() * 3;
  }
}

/*
 * // Walk around in a box if (this.getEnergy() > 50) { this.ahead(100); this.turnRight(90); } //
 * Plan B else if (this.getEnergy() < 50) { this.ahead(200); this.turnLeft(120); } else { // Always
 * have an else this.scan(); }
 */



/*
 * Scanning Strategies:
 * 
 * - Do not scan in 360 field, it is waste of time- In arena battles, move to corner, scan left till
 * all enemies found, then revenre directionof scanning and scan the other way- For one on one
 * battles use a targeting strategy,1) do 360, find target2) keep scanning in little arc, to
 * maintain position of robot- IMPORTANT: If an enemy has lost energy in some time of scanning,
 * assume a shot has been fired
 * 
 * • scan. Scans the arena using the radar at its current setting. This is only rarely needed to be
 * called explicitly, as Robocode calls this for each robot at each turn. • setTurnRadarLeft and
 * turnRadarLeft. Turns the radar left. • setTurnRadarRight and turnRadarRight. Turns the radar
 * right. • setAdjustRadarForRobotTurn. Enable or disable the locking of the radar to the base of
 * the robot. • setAdjustRadarForGunTurn. Enable or disable the locking of the radar to the gun
 * turret.
 */


/*
 * Planning:
 * 
 * In meles, plan who you want to kill, in one on ones decide when to attack and dodge Need to make
 * something that evaluated health and closeness
 */

/*
 * http://old.robowiki.net/robowiki?MicroAspid heard its good for moving
 * 
 * Moving BAD: Sitting still, straight lines,circular, Average: Random-but cons are harder tracking
 * and more ramming Anti Gravity: Always move away from danger to the most optimal position decided
 * from scanning Bullet Dodging: Determine energy loss from enemy, draw circle of death around them
 * that has varying speed based on energy loss, use this to ignore bullet until its close enough
 * that you have to make a random move In one on one battles, ramm the fuck out of the other robots
 * ass as they will loose first
 * 
 * 
 * 
 * • setBack and back. Move a given distance back.• setAhead and ahead. Move a given distance ahead.
 * • setMaxTurnRate. Limit the rate at which the robot turns.• setMaxVelocity. Limit the speed at
 * which the robot moves.• setStop and stop. Stop any movement and remember what the robotwas doing.
 * • setResume and resume. Resume the movement stopped with setStopor stop.• setTurnLeft and
 * turnLeft. Turn the robot left.• setTurnRight and turnRight. Turn the robot right.
 */


/*
 * Attack Strategies; http://old.robowiki.net/robowiki?ScruchiPu Neural Nework pattern matching
 * http://old.robowiki.net/robowiki?NeuralTargeting
 * 
 * Ram in and out: For 1v1 find the enemy, shotting small ones, move in close enough to ram, and
 * then keep firing big shots
 * 
 * Can also use pattern mathcing, gather info on ehading and velcoty and use that to match that
 * robot to a certain type of movement Based on that movement make a confidence calculation and
 * based on that decide if you want to shoot
 * 
 * • fire and fireBullet. Shoots a bullet if the gun is cold. fireBullet returns aBullet object for
 * the fired bullet.• setTurnGunLeft and turnGunLeft. Turns the gun left.• setTurnGunRight and
 * turnGunRight. Turns the gun right.• setAdjustGunForRobotTurn. Enable or disable the locking of
 * the gun tothe base of the robot.
 */


/*
 * Advanced strategies, detect turning by seeing if thheir speed falls from the original I think
 * they are stored as strings so you need to use regexes USE REGEXES to match previous movement
 * Maybe split up the velocity into a horizintal and vertical velcoty fot more info Have a switch to
 * detect random noise movement and to turn of pattern amtching for that bot If taking damage, move
 * closer to open space and start doing random movement
 */

/*
 * Create a hiegharchy of decision making based on danger, wvs good shot oppurtunity Danger overides
 * output overides good shot output Pg.27 Reactive architecture BAD FOR FINDING COMMON DECIISION'
 * 
 * pG 28, wIGHTED ARCHITECTURE, like a decision matrix
 */

// Code will never reach here -- and that okay for a change ;)

