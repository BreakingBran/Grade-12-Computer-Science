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
    System.out.print("How many quarters");
    int intialQuarters = sc.nextInt();
    
    for (int i = 0; i < 3; i++){
    
    System.out.print("How many times machine 1 already played");
    SlotMachine slot1 = new SlotMachine(50,35,5);
    }
    SlotMachine[] arrayOfSlotMachines;
    int numberOfSlots;
    
    Player Martha = new Player(intialQuarters, arrayOfSlotMachines,numberOfSlots);
  }
}
