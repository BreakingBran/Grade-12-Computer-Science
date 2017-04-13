

/**
 * The "Jacket" class for the CrazyObjects problem.
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Apr 11, 2017
 * @version 2
 */

public class Jacket
{
  private Student owner;
  
  public Jacket(Student me)
  {
    this.owner = me;
  }
  
  //Last two functions are just getter and function
  //that modiefies what is printed when object is placed
  //in print function
  public Student getOwner()
  {
    return owner;
  }
  
  public String toString()
  {
    return null;
  }
} // Jacket class
