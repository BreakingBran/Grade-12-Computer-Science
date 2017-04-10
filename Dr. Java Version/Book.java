

/**
 * The "Book" class for the CrazyObjects problem.
 * @author 
 * @date 
 * @version 2.0
 */

public class Book
{
  private String title;
  private String course;
  private boolean inLocker = false;
  
  public Book(String aCourse, String aTitle)
  {
    this.title = aTitle;
    this.course = aCourse;
  }

  public String getTitle()
  {
    return this.title;
  }
  
  public String getCourse()
  {     
    return this.course;
  }
   
  public String toString()
  {
    String sentence = String.format("The book is called %s and is a part of the %s course",this.title,this.course);
    return sentence;
  }
  
  public boolean isInLocker()
  {
    return this.inLocker;
  }
  
  public void putInLocker()
  {
    this.inLocker = true;
  }
  
  public void takeOutOfLocker()
  {
    this.inLocker = false;
  }

} // Book class
