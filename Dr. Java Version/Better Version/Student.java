
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
     //Kinda redundant to initialze the this.myJacket variable
     //with the Jacket object if it was just going to be reassigned
     //but it was done to show that the Student had the jacket first and 
     //then when he came to school he put it away
     //with no setter for the myJacket variable, the only place to take off the jaccket without adding more functions 
     //was within the constructor
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
    * Called when end of 1st period
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
