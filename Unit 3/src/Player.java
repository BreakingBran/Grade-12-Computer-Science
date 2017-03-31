/**
 * Player
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Mar 29, 2017
 */

import java.util.*;
import java.io.*;

public class Player {
  
  //private int initialQuarters;
  private int quartersLeft;
  private int numberOfTimesPlayed = 0;
  private SlotMachine[] arrayOfSlotMachines;
  private int numberOfSlots;
  
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
