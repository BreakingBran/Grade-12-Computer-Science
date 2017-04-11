package betterSchool;

/**
 * The "Student" class for the CrazyObjects problem.
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Apr 11, 2017
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

   /**
    * Prints our reason for being sent to office
    * @param reason
    */
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

   /**
    * Puts two (1st and 2nd period) books from hand into locker
    * Takes out other two books from locker
    */
   public void doLunch()
   {
     this.getLocker().putABook(this.books[0]);
     this.getLocker().putABook(this.books[1]);     
     this.books[0] = this.myLocker.getABook("ICS4U1");
     this.books[1] = this.myLocker.getABook("HRE4M1");
   }

   public String toString()
   {
     return this.name;
   }
} // Student class
