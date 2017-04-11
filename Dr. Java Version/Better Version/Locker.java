/**
 * The "Locker" class for the CrazyObjects problem.
 * @author
 * @date
 * @version 2
 */
public class Locker
{
  
  private Student owner;
  private Jacket studentJacket;
  private Book books[] = new Book[4];

  public Locker(Student me)
  {
    this.owner = me;
    books[0] = new Book("MCV4U1", "Mr. Fernandes");
    books[1] = new Book("SPH4U1", "Mr. Jabir");
    books[2] = new Book("ICS4U1", "Mr. Reid");
    books[3] = new Book("HRE4M1", "Ms. Lombardi");
  }
  
  public Book getABook(String course)
  {
    return null;
  }
  
  public void putABook(Book book)
  {
    try 
    {

    }
    finally
    {
      
    }
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
  
  public Student getOwner()
  {
    return this.owner;
  }
} // Locker class
