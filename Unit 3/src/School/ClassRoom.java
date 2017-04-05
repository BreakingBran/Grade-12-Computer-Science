package School;

public class ClassRoom
{
  private String course;
  private String teacher;
  
  public ClassRoom(String thisCourse, String thisTeacher)
  {
    course = thisCourse;
    teacher = thisTeacher;
  }

  public boolean enter(Student me)
  {
    boolean result = false;
   
    System.out.println("Student " + me + " came to class " + course + " taught by " + teacher);
    
    if (me.getLocker() == null)
    {
      me.sentToOffice("Get a locker");
    }
    else if (me.getLocker().getOwner() != me)
    {
      me.sentToOffice("Get your own locker");
    }
    else if (me.getJacket() != null)
    {
      me.sentToOffice("Take off your jacket");
    }
    else if (!teacher.equals("Lombardi"))
    {
      Jacket studentJacket = me.getLocker().getJacket();
      if ((studentJacket == null) || (studentJacket.getOwner() != me))
      {

        me.sentToOffice("Where is YOUR jacket?  Put it in your locker");
      }
      else if ((teacher.equals("Mr. Reid")) || (teacher.equals("Mr. Fernandes")) || (teacher.equals("Mr. Jabir")))
      {

        Book[] books = me.getBooks();
        if ((books == null) || (books[0] == null))
        {
          me.sentToOffice("where is your textbook?");
        }
        else if (books.length != 2)
        {
          me.sentToOffice("only carry two books to class");
        }
        else
        {
          boolean foundBook = false;
          for (int i = 0; i < books.length; i++)
          {
            if ((books[i] != null) && (books[i].getCourse().equalsIgnoreCase(course)))
            {
              foundBook = true;
            }
          }
          
          if (!foundBook)
          {
            me.sentToOffice("did not bring the correct textbook");

          }
          else
          {
            result = true;
          }
          
        }
      }
      else
      {
        result = true;
      }
    }
    
    return result;
  }
}