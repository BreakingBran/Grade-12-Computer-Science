package School;

/**
 * The "Locker" class for the CrazyObjects problem.
 * @author
 * @date
 * @version 2.0
 */
public class Locker
{
  private Student owner;
  private Jacket studentJacket;
  private Book books[];
  
  public Locker(Student me)
  {
    this.owner = me;
    this.studentJacket = me.getJacket();
    //this.books[] = null;
    
  }
  
  public Book getABook(String course)
  {
    return null;
  }
  
  public void putABook(Book book)
  {
  }
  
  public Jacket getJacket()
  {
    return null;
  }
  
  public Jacket removeJacket()
  {
    return null;
  }
  
  public void putJacket(Jacket thisJacket)
  {
  }
  
  public String toString()
  {
    return null;
  }
} // Locker class
