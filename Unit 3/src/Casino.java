/**
 * Casino
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Mar 29, 2017
 */

import java.util.*;
import java.io.*;

public class Casino {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("How many quarters: ");
    //Gets number of quearters for Player Martha
    int intialQuarters = sc.nextInt();

    //temp variable that holds how many times each machine has been played
    int times;
    
    //Instantiates the 3 slot machines with their respective times played
    System.out.println("How many times machine 1 already played: ");
    times = sc.nextInt();
    SlotMachine slot1 = new SlotMachine(30, 35, times);
    System.out.println("How many times machine 2 already played: ");
    times = sc.nextInt();
    SlotMachine slot2 = new SlotMachine(60, 100, times);
    System.out.println("How many times machine 3 already played: ");
    times = sc.nextInt();
    SlotMachine slot3 = new SlotMachine(9, 10, times);
    
    //Creates an array of slot machines that Martha can play on
    SlotMachine[] arrayOfSlotMachines =  {slot1,slot2,slot3};
    int numberOfSlots = arrayOfSlotMachines.length;

    //Intitalizes Martha
    Player Martha = new Player(intialQuarters, arrayOfSlotMachines, numberOfSlots);
    System.out.println(Martha.play());
  }
}
