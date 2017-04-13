
/**
 * The "VirtualSchool" class for the CrazyObjects problem.
 * @author Mr. Reid
 * @date Oct 2011
 * @version 2.1
 */

//Only use import when testing, for printing arrays
//import java.util.*;


public class VirtualSchool
{
  /**
   *  Demo test driver for the Crazy Objects problem
   */
  public static void main (String[] args)
  {  // Create a student and display
    Student me = new Student("Lance");
    System.out.println("Student: "+me+"\n"); 
    
    // Here is your **dream** schedule
    ClassRoom[] schedule = new ClassRoom[4];
    schedule[0] = new ClassRoom("MCV4U1", "Mr. Fernandes");
    schedule[1] = new ClassRoom("SPH4U1", "Mr. Jabir");
    schedule[2] = new ClassRoom("ICS4U1", "Mr. Reid");
    schedule[3] = new ClassRoom("HRE4M1", "Ms. Lombardi");
    
    // Follow your schedule
    for (int i=0; i<4; i++)
    {
      if (i == 0)
      {
        //Just got into school, pick up first and second period books
        me.getBooks()[0] = me.getLocker().getABook("MCV4U1");
        me.getBooks()[1] = me.getLocker().getABook("SPH4U1");
      }
      // Go to class
      if (schedule[i].enter(me) == true)
      {
        System.out.println(me+" was allowed into class.");
      }  
      else
      {
        System.out.println(me+" was sent to the office.");        
      }
      //System.out.println(Arrays.toString(me.getLocker().getBooks()));
      System.out.println();
      
      
      // End of period 2
      if (i == 1)
      {
        // Don't forget lunch
        me.doLunch();
      }
    }
  } // main method
} // VirtualSchool class

