package testingFunctions;

public class testingFunction1 {

  public static void main(String[] args) {
    double x = 0;
    double y = 0;
    double x2 = -5;
    double y2 = 3;
    System.out.println(Math.toDegrees(Math.atan2(x2 - x, y2 - y)));
    
    /**
     * double absBearing=e.getBearingRadians()+getHeadingRadians();//enemies absolute bearing
        double latVel=e.getVelocity() * Math.sin(e.getHeadingRadians() -absBearing);//enemies later velocity
        double gunTurnAmt;//amount to turn our gun
        setTurnRadarLeftRadians(getRadarTurnRemainingRadians());//lock on the radar
        if(Math.random()>.9){
            setMaxVelocity((12*Math.random())+12);//randomly change speed
        }
        if (e.getDistance() > 150) {//if distance is greater than 150
            gunTurnAmt = robocode.util.Utils.normalRelativeAngle(absBearing- getGunHeadingRadians()+latVel/22);//amount to turn our gun, lead just a little bit
            setTurnGunRightRadians(gunTurnAmt); //turn our gun
            setTurnRightRadians(robocode.util.Utils.normalRelativeAngle(absBearing-getHeadingRadians()+latVel/getVelocity()));//drive towards the enemies predicted future location
            setAhead((e.getDistance() - 140)*moveDirection);//move forward
            setFire(3);//fire
        }
     */
  }

}
