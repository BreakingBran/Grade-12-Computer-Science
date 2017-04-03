/**
 * Player
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Mar 29, 2017
 */

import java.util.*;
import java.io.*;


/**
 * This class creates a plaer object
 * that simulates a person playing at a casino
 *
 */

public class Player {
  
  //private int initialQuarters;
  private int quartersLeft;
  private int numberOfTimesPlayed = 0;
  private SlotMachine[] arrayOfSlotMachines;
  private int numberOfSlots;
  
  /**
   * This initializes the instance of the Player object
   * @param initialQuarters: tells you how many quarters the person has
   * @param arrayOfSlotMachines: tells you all the machines the player can play on
   * @param numberOfSlots: number of slots in the slots array machine
   */
  public Player(int initialQuarters, SlotMachine[] arrayOfSlotMachines, int numberOfSlots) {
    //this.initialQuarters = initialQuarters;
    this.setQuartersLeft(initialQuarters);
    this.arrayOfSlotMachines = arrayOfSlotMachines;
    this.numberOfSlots = numberOfSlots;
  }

  public int getQuartersLeft() {
    return quartersLeft;
  }

  private void setQuartersLeft(int quartersLeft) {
    this.quartersLeft = quartersLeft;
  }
  
  /**
   * Simulates a person playing slots at a slot machine until they go bankrupt
   * @return: returns how many times the person played until they ran out of quearters
   */
  public int play(){
    int index = 0;
    
    while (quartersLeft > 0){
      index = index % this.numberOfSlots;
      //System.out.println(index);
      this.quartersLeft += arrayOfSlotMachines[index].playSlotMachine();
      index++;
      this.numberOfTimesPlayed++;
    }
    return this.numberOfTimesPlayed;
  }
  
}
