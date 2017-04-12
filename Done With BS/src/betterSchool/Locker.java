package betterSchool;

/**
 * The "Locker" class for the CrazyObjects problem.
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Apr 11, 2017
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
  
  /**
   * Looks through book array for book object with same 
   * course name and returns the first book that matches it
   * @param course: name of the course
   * @return: book object with same course title
   */
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
      //Makes sure that the value of the array is not null
      //and then checks if it has same name
      //checking that it is null FIRST is crucial as the other arrangment causes an error
      if (books[counter] != null && books[counter].getCourse() == course)
      {
        result = books[counter];
        found = true;
      }
      counter++;
    }
    return result;
    }
    //Always sets books that was found to null after it was found
    finally
    {
      if (found)
      {
        books[counter-1] = null;
      }     
    }
  }
  
  /**
   * Puts book into first empty space found
   * empty space being a null in the array
   * @param book: book object passed in from the student book array
   */
  public void putABook(Book book)
  {

    boolean foundEmptySpace = false;
    int counter = 0;
    //loops through array and places book in first null space
    while (counter < this.books.length && !foundEmptySpace)
    {
      if (books[counter] == null)
      {
        books[counter] = book;
        foundEmptySpace = true;
      }
      counter++;
    }
  }
  
  public Jacket getJacket()
  {
    return this.studentJacket;
  }
  
  /**
   * Returns the jacket object but after doing so
   * always sets it to null within the Locker object
   * @return
   */
  public Jacket removeJacket()
  {
    try
    {
      return this.studentJacket;
    }
    //Always runs after the Jacket is taken out, making it null
    finally
    {
      this.studentJacket = null;
    }
  }
  
  public void putJacket(Jacket thisJacket)
  {
    this.studentJacket = thisJacket;
  }
  
  public String toString()
  {
    return null;
  }
  
  public Student getOwner()
  {
    return this.owner;
  }
  
 /* public Book[] getBooks()
  {
    return this.books;
  }*/
  
} // Locker class
