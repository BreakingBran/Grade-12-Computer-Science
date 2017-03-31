/**
 * SlotMachine
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Mar 29, 2017
 */

import java.util.*;
import java.io.*;

public class SlotMachine {
  
  private int payoutValue;
  private int timesPlayed;
  private int numberOfTimesTillPayout;
  
  public SlotMachine (int payoutValue, int numberOfTimesTillPayout, int numberOfTimesAlreadyPlayed) {
    this.payoutValue = payoutValue;
    this.numberOfTimesTillPayout = numberOfTimesTillPayout;
    this.timesPlayed = numberOfTimesAlreadyPlayed;
    if (this.timesPlayed > this.numberOfTimesTillPayout){
      this.timesPlayed = this.numberOfTimesTillPayout % this.timesPlayed;
    }
  }
  
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
