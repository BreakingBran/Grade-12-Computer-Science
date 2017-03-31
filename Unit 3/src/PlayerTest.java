/**
 * PlayerTest
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Mar 27, 2017
 */

import static org.junit.Assert.*;

import org.junit.Test;


public class PlayerTest {

  SlotMachine slot1 = new SlotMachine(30, 35, 3);
  SlotMachine slot2 = new SlotMachine(60, 100, 10);
  SlotMachine slot3 = new SlotMachine(9, 10, 4);
  SlotMachine[] arrayOfSlotMachines =  {slot1,slot2,slot3};
  
  Player Martha = new Player(48,arrayOfSlotMachines,3);
  
  @Test
  public void testGetQuartersLeft() {
    assertEquals(Martha.getQuartersLeft(), 48);
  }


  @Test
  public void testPlay() {
    assertEquals(Martha.play(), 66);;
    assertEquals(Martha.getQuartersLeft(), 0);
  }

}
