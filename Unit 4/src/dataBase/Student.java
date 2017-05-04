package dataBase;

/**
 * Student
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: May 3, 2017
 */


public class Student {
  
  private String lastname;
  private String firstname;
  private String gender;
  private String studentId;
  private String dob;
  private String courses;

  public Student( String lastname,String firstname,String gender,String studentId,String dob, String courses) {
    this.lastname = lastname;
    this.firstname = firstname;
    this.gender = gender;
    this.studentId = studentId;
    this.dob = dob;
    this.courses = courses;
  }
}
