

/**
 * The "Locker" class for the CrazyObjects problem.
 * @author
 * @date
 * @version 2.00
 */
public class Locker
{
  private Student owner;
  private Jacket studentJacket;
  private Jacket lastJacket = studentJacket;
  private Book books[] = new Book[4];
  
  
  
  public Locker(Student me)
  {
    this.owner = me;
    this.studentJacket = me.getJacket();
    books[0] = new Book("MCV4U1", "Mr. Fernandes");
    books[1] = new Book("SPH4U1", "Mr. Jabir");
    books[2] = new Book("ICS4U1", "Mr. Reid");
    books[3] = new Book("HRE4M1", "Ms. Lombardi");
    
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
  
  public Book getABook(int index) {
    //System.out.println("Hello");
    return this.books[index];
  }
  
  public void putABook(int i, Book book)
  {
    this.books[i] = book;
  }
  
  public Jacket getJacket()
  {
    
    return this.studentJacket;
  }
  
  public void removeJacket()
  {
    this.studentJacket = null;
  }
  
  public void putJacket(Jacket thisJacket)
  {
    this.studentJacket = thisJacket;
    this.owner.setJacket();
  }
  
  public String toString()
  {
    String sentence = String.format("This locker is owned by %s", this.owner);
    return sentence;
  }
  
   public void bookLeftLocker(int i) {
    this.books[i] = null;
  }
} // Locker class
