/**
 * SlotMachineTest
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Mar 27, 2017
 */

import static org.junit.Assert.*;

import org.junit.Test;


public class SlotMachineTest {

  int payout = 10;
  SlotMachine slot1 = new SlotMachine(payout, 5, 0);

  @Test
  public void testPlaySlotMachine() {
    // Times played == 1
    assertEquals(slot1.playSlotMachine(), -1);
    // Times played == 2
    assertEquals(slot1.playSlotMachine(), -1);
    // Times played == 3
    assertEquals(slot1.playSlotMachine(), -1);
    // Times played == 4
    assertEquals(slot1.playSlotMachine(), -1);
    // Times played == 5
    assertEquals(slot1.playSlotMachine(), -1);
    // Times played == 6
    assertEquals(slot1.playSlotMachine(),payout-1);
    
  }

}
