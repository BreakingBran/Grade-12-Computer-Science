/**
 * SlotMachine
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Mar 29, 2017
 */

import java.util.*;
import java.io.*;


/**
 *Simulates a slot machine that has a assigned payout value
 *and number of times until payout
 */

public class SlotMachine {
  
  private int payoutValue;
  private int timesPlayed;
  private int numberOfTimesTillPayout;
  
  /**
   * initializes the values in the instance of the slot machine object
   * @param payoutValue: how many quarters the machine pays back when someone wins
   * @param numberOfTimesTillPayout: self explanatory
   * @param numberOfTimesAlreadyPlayed: self explanatory
   */
  public SlotMachine (int payoutValue, int numberOfTimesTillPayout, int numberOfTimesAlreadyPlayed) {
    this.payoutValue = payoutValue;
    this.numberOfTimesTillPayout = numberOfTimesTillPayout;
    this.timesPlayed = numberOfTimesAlreadyPlayed;
    if (this.timesPlayed > this.numberOfTimesTillPayout){
      this.timesPlayed = this.numberOfTimesTillPayout % this.timesPlayed;
    }
  }
  
  /**
   * Simulates playing a slot machine for 1 round
   * @return: if you win, returns the payout value, if you loose, subtracts one from your
   * quarters left variable
   */
  public int playSlotMachine(){
    int valueChange = 0;
    if (this.timesPlayed == this.numberOfTimesTillPayout)
    {
      valueChange = this.payoutValue - 1;
      this.timesPlayed = 0;
    }
    else{
      valueChange = -1;
      this.timesPlayed ++;
    }
    return valueChange;
  }

  
}
