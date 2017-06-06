/**
 * LaPBot: A robot by LancePereira Industries
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Jun 3, 2017
 * 
 * Source: http://www.dinbedstemedarbejder.dk/Dat3.pdf
 */

package lap;
import robocode.*;

import java.awt.Color;


public class LaPBot extends AdvancedRobot{
  /** 
   * run: SimpleMind ed's default behavior
   */ 
  public void run() 
  {
    // Decorate your Robot
    this.setColors(Color.blue,Color.blue,Color.red);
    
    // Main loop (infinite - game controls when it's over)
    while (true) 
    {
      // Walk around in a box
      if (this.getEnergy() > 50)
      {
        this.ahead(100);
        this.turnRight(90);
      }
      // Plan B
      else if (this.getEnergy() < 50)
      {
        this.ahead(200);
        this.turnLeft(120);
      }
      else 
      {
        // Always have an else
        this.scan();     
      }
    }
    
    // Code will never reach here -- and that okay for a change ;)
  }
  
  /**
   * onScannedRobot: What to do when you see another robot
   */
  public void onScannedRobot(ScannedRobotEvent e) 
  {
    // You get information on the other robots when you see them
    System.out.println("I just saw "+e.getName());
    System.out.println("Bearing:"+e.getBearing()+"  Heading:"+e.getHeading()+"  Energy:"+e.getEnergy());
    
    // Take a shot      
    if (this.getEnergy() > 50 && e.getDistance() < 100)
    {
      this.fire(3);
    } else {
      // Take a quick shot
      this.fire(1);
    }
  }
  
  /**
   * onHitByBullet: What to do when you're hit by a bullet
   */
  public void onHitByBullet(HitByBulletEvent e) 
  {
    if (this.getGunHeat() <= 0) {
      // Take a shot
      this.turnGunRight(e.getBearing());
      this.fire(1); 
      this.turnGunLeft(e.getBearing());   
    }
    // Get out of the way
    this.turnLeft(90 - e.getBearing());
    this.ahead(40);
  }
}
