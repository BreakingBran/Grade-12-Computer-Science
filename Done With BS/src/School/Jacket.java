package School;

/**
 * The "Jacket" class for the CrazyObjects problem.
 * @author 
 * @date 
 * @version 2.0
 */
public class Jacket
{
  
  private Student owner;
  
  public Jacket(Student me)
  {
    this.owner = me;
  }
  
  public Student getOwner()
  {
    return this.owner;
  }
  
  public String toString()
  {
    String sentence = "This is a jacket";
    return sentence;
  }
} // Jacket class
