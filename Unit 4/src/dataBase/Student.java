package dataBase;

import java.util.*;

import sun.org.mozilla.javascript.internal.ast.ThrowStatement;

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
  private Map<String, String> studentInfoDirectory = new HashMap<String, String>();

  public Student(String lastname, String firstname, String gender, String studentId, String dob, String courses) {
    this.lastname = lastname;
    this.firstname = firstname;
    this.gender = gender;
    this.studentId = studentId;
    this.dob = dob;
    this.courses = courses;
    setupstudentInfoDirectory();
  }

  public Student(String[] params) {
    if (params.length != 6) {
      throw new java.lang.Error("Did not put proper size array when calling new Student(String[] params), params expected to be 6 element array");
    }
    this.lastname = params[0];
    this.firstname = params[1];
    this.gender = params[2];
    this.studentId = params[3];
    this.dob = params[4];
    this.courses = params[5];
    setupstudentInfoDirectory();
  }

  private void setupstudentInfoDirectory() {
    studentInfoDirectory.put("getLastname", this.lastname);
    studentInfoDirectory.put("getFirstname", this.firstname);
    studentInfoDirectory.put("getGender", this.gender);
    studentInfoDirectory.put("getStudentId", this.studentId);
    studentInfoDirectory.put("getDob", this.dob);
    studentInfoDirectory.put("getCourses", this.courses);
  }

  public String toString() {
    return (lastname + "," + firstname + "," + gender + "," + studentId + "," + dob + "," + courses);
  }

  public String getstudentInfoDirectory(String searchField) throws Exception{
    String value = studentInfoDirectory.get(searchField);
    if (value.equals(null)){      
      throw new Exception("Inputed searchField for getstudentInfoDirectory that does not exist in studentInfoDirectory");
    }
   return value;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }



  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public String getCourses() {
    return courses;
  }

  public void setCourses(String courses) {
    this.courses = courses;
  }

}
