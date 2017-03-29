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
  }
  
  public int playSlotMachine(){
    int valueChange = 0;
    if (timesPlayed == numberOfTimesTillPayout)
    {
      valueChange = payoutValue;
    }
    else{
      valueChange = -1;
    }
    return valueChange;
  }

  
}
