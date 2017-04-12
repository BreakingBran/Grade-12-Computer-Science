
/**
 * The "Book" class for the CrazyObjects problem.
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Apr 11, 2017
 * @version 2
 */
public class Book
{
  private String title;
  private String course;

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
    return this.course;
  }
} // Book class
