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
  
  //Looks through book array for book with same name
  public Book getABook(String course)
  {
    int counter = 0;
    boolean found = false;
    Book result = null;
    //looks to see if the book exists
    try
    {      
      while (!found && counter < books.length)
    {
      if (books[counter].getCourse() == course)
      {
        System.out.println(course);
        System.out.println("Found " + books[counter].getCourse());
        System.out.println("Found at " +counter);
        result = books[counter];
        found = true;
      }
      counter++;
    }
    return result;
    }
    //Always sets it to null after it was found
    finally
    {
      if (found)
      {
        books[counter] = null;
      }
      //System.out.println(result);
     // System.out.println(counter);
    }
  }
  
  //Puts book into first empty space found
  public void putABook(Book book)
  {
    boolean foundEmptySpace = false;
    int counter = 0;
    while (counter < this.books.length && !foundEmptySpace)
    {
      if (books[counter] == null)
      {
        books[counter] = book;
      }
    }
  }
  
  public Jacket getJacket()
  {
    return this.studentJacket;
  }
  
  public Jacket removeJacket()
  {
    try
    {
      return this.studentJacket;
    }
    finally
    {
      this.studentJacket = null;
    }
  }
  
  public void putJacket(Jacket thisJacket)
  {
    this.studentJacket = thisJacket;
    //this.studentJacket.getOwner().myJacket = null;
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
