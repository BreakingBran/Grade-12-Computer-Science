//package School;

/**
 * The "Student" class for the CrazyObjects problem.
 * @author 
 * @date 
 * @version 2.000
 */
public class Student
{
  private String name;
  private Locker myLocker;
  private Jacket myJacket;
  private Book books[];
  
   public Student(String name)
   {
     this.name = name;

     this.myLocker = new Locker(this);
   }
   
   public void sentToOffice(String reason)
   {
     System.out.println(reason);
   }
   
   public Locker getLocker()
   {
     return myLocker;
   }
   
   public Jacket getJacket()
   {
     return myJacket;
   }
   
   public Book[] getBooks()
   {
     return books;
   }

   public void doLunch()
   {
   }

   public String toString()
   {
     return this.name;
   }
} // Student class
