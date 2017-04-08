package School;

/**
 * The "Student" class for the CrazyObjects problem.
 * @author 
 * @date 
 * @version 2.0
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
     return null;
   }
   
   public Jacket getJacket()
   {
     return null;
   }
   
   public Book[] getBooks()
   {
     return null;
   }

   public void doLunch()
   {
   }

   public String toString()
   {
     return this.name;
   }
} // Student class
