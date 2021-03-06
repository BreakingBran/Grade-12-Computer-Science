package School;

/**
 * The "Locker" class for the CrazyObjects problem.
 * @author
 * @date
 * @version 2.000
 */
public class Locker
{
  private Student owner;
  private Jacket studentJacket;
  private Jacket lastJacket = studentJacket;
  private Book books[] = {null,null,null,null};
  
  
  public Locker(Student me)
  {
    this.owner = me;
    this.studentJacket = me.getJacket();
    
    
  }
  
  public Student getOwner(){
    return this.owner;
  }
  
  public Book getABook(String course)
  {
    for (int i = 0; i < this.books.length; i++){
      if (books[i].getCourse() == course && books[i].isInLocker())
      {
        return books[i];
      }
    }
    return null;
  }
  
  public void putABook(Book book)
  {
    for (int i = 0; i < this.books.length; i++){
      if (!books[i].isInLocker())
      {
        books[i].putInLocker();
      }
    }
  }
  
  public Jacket getJacket()
  {
    return this.studentJacket;
  }
  
  public Jacket removeJacket()
  {
    this.studentJacket = null;
    return this.lastJacket;
  }
  
  public void putJacket(Jacket thisJacket)
  {
    this.studentJacket = thisJacket;
  }
  
  public String toString()
  {
    String sentence = String.format("This locker is owned by %s", this.owner);
    return sentence;
  }
} // Locker class
