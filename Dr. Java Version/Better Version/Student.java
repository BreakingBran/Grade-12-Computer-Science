/**
 * The "Student" class for the CrazyObjects problem.
 * @author 
 * @date 
 * @version 2
 */
public class Student
{
    private String name;
    private Locker myLocker;
    private Jacket myJacket;
    private Book books[] = new Book[2];

   public Student(String name)
   {
     this.name = name;
     this.myLocker = new Locker(this);
     this.myJacket = new Jacket(this);
     this.myLocker.putJacket(this.myJacket);
     this.myJacket = null;
     
   }
   
   public void sentToOffice(String reason)
   {
     System.out.println(this.name + " " + reason);
   }
   
   public Locker getLocker()
   {
     return this.myLocker;
   }
   
   public Jacket getJacket()
   {     
     return this.myJacket;     
   }
   
   public Book[] getBooks()
   {
     return this.books;
   }

   public void doLunch()
   {
     int counter = 0;     
     this.getLocker().putABook(this.books[0]);
     this.getLocker().putABook(this.books[1]);
     this.books[0] = null;
     this.books[1] = null;
     this.books[0] = this.myLocker.getABook("ICS4U1");
     this.books[1] = this.myLocker.getABook("HRE4M1");
   }

   public String toString()
   {
     return this.name;
   }
} // Student class
