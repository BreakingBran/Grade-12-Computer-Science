

/**
 * The "Student" class for the CrazyObjects problem.
 * 
 * @author
 * @date
 * @version 2.0
 */
public class Student {
  private String name;
  private Locker myLocker;
  private Jacket myJacket;
  private Book books[] = new Book[2];

  public Student(String name) {
    this.name = name;
    this.myLocker = new Locker(this);
    this.myJacket = new Jacket(this);

  }

  public void sentToOffice(String reason) {
    System.out.println(reason);
  }

  public Locker getLocker() {
    return myLocker;
  }

  public Jacket getJacket() {
    return myJacket;
  }

  public Book[] getBooks() {
    return books;
  }

  public String doLunch() {
    putBookInHand(2);
    String sentence = String.format("%s had lunch", this.name);
    return sentence;
  }

  public String toString() {
    return this.name;
  }

  public void setJacket() {
    myJacket = null;
  }

  public void putBookInHand(int i) {
    // System.out.println(this.myLocker.getABook(i));
    if (i == 0) {
      this.books[0] = this.myLocker.getABook(i);
      this.myLocker.bookLeftLocker(i);
      this.books[1] = this.myLocker.getABook(i + 1);
      this.myLocker.bookLeftLocker(i + 1);
    } else if (i == 2) {
      this.books[0] = this.myLocker.getABook(i);
      this.myLocker.bookLeftLocker(i);
      this.books[1] = this.myLocker.getABook(i + 1);
      this.myLocker.bookLeftLocker(i + 1);
    }
  }

  public void putBookInLocker(int i) {
    this.myLocker.putABook(i, this.books[i]);
    this.books[i] = null;
  }
} // Student class
