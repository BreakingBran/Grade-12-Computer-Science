package dataBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// ctrl + F11 to compile
// ctl + shift + o = auto import
// syserr = like sysout but red
// ctrl + alt = copy line down
//

/**
 * StudentDataBase class represents a database that you want to read and work with
 */
public class StudentDataBase {

  private Student students[];
  private int numberOfStudents;
  private int numOfFemales = -1;
  private int numOfMales = -1;
  private boolean sorted = false;
  private boolean updated = false;
  static int numberOfDataBases = 0;

  public StudentDataBase(String filename) throws IOException {
    this();
    readStudentDataBase(filename);
  }

  public StudentDataBase(){
    numberOfDataBases += 1;
    //just here to do nothing
  }
  
  /**
   * Reads database from file and stores each line as an object in students[].
   * 
   * @param filename
   * @throws IOException
   */
  public void readStudentDataBase(String filename) throws IOException {
    numberOfStudents = getLinesInFile(filename);
    readStudentDataBase(filename, numberOfStudents);
  }

  /**
   * Finds the number of lines in a file
   * 
   * @param filename
   * @param testingCounter
   * @throws FileNotFoundException
   */
  public void readStudentDataBase(String filename, int numOfLines_Students) throws FileNotFoundException {
    Scanner sc = new Scanner(new FileReader(filename));
    numberOfStudents = numOfLines_Students;

    int i = 0;
    students = new Student[numOfLines_Students];

    while (sc.hasNext() && i < numOfLines_Students) {
      // gets entire line with name, number, etc
      String studentInfoPackage = sc.nextLine();

      // avoids making null variables for
      if (studentInfoPackage == "") {
        System.err.println("Student Data input has blank lines in file which may crash server during operation");
        continue;
      }
      String[] studentInfoPackageArray = new String[6];
      studentInfoPackageArray = studentInfoPackage.split(",", 7);
      students[i] = new Student(studentInfoPackageArray);
      i++;

      // System.out.println(Arrays.toString(studentInfoPackageArray));
    }
    sc.close();
  }

  /**
   * Finds the number of lines in a file
   * 
   * @param filename
   * @return
   * @throws IOException
   */
  private int getLinesInFile(String filename) throws IOException {
    // Credit: er.vikas,Telmo Marques
    // :http://stackoverflow.com/questions/453018/number-of-lines-in-a-file-in-java

    LineNumberReader lnr = new LineNumberReader(new FileReader(new File(filename)));
    lnr.skip(Long.MAX_VALUE);
    // Finally, the LineNumberReader object should be closed to prevent resource leak
    lnr.close();
    return (lnr.getLineNumber() + 1);
  }

  /**
   * Writes sorted list into desired file
   * 
   * @param filename
   * @throws IOException
   */
  public void saveStudentDataBase(String filename) throws IOException {
    PrintWriter pw = new PrintWriter(new FileWriter(filename));

    for (int j = 0; j < this.students.length; j++) {
      String student = this.students[j].toString();
      pw.println(student);
    }

    pw.close();
  }


  /**
   * sorts using bubble sort by last name and stores in desired file
   * 
   * @throws Exception
   */
  public void bubbleSortLastName(String filename) throws Exception {
    SortingDatabase.bubbleSort(filename, students, "getLastName");
  }

  public void bubbleSortFirstName(String filename) throws Exception {
    SortingDatabase.bubbleSort(filename, students, "getFirstName");
  }

  public void bubbleSortCourses(String filename) throws Exception {
    SortingDatabase.bubbleSort(filename, students, "getCourses");
  }

  public void bubbleSortDob(String filename) throws Exception {
    SortingDatabase.bubbleSort(filename, students, "getDob");
  }

  public void bubbleSortGender(String filename) throws Exception {
    SortingDatabase.bubbleSort(filename, students, "getGender");
  }

  public void bubbleSortStudentId(String filename) throws Exception {
    SortingDatabase.bubbleSort(filename, students, "getStudentId");
  }



  /**
   * Sorts using selection sort by last name
   * 
   * @throws IOException
   */
  public void selectSortLastName(String filename) throws Exception {
    SortingDatabase.selectSort(filename, students, "getLastName");
  }

  public void selectSortFirstName(String filename) throws Exception {
    SortingDatabase.selectSort(filename, students, "getFirstName");
  }

  public void selectSortCourses(String filename) throws Exception {
    SortingDatabase.selectSort(filename, students, "getCourses");
  }

  public void selectSortDob(String filename) throws Exception {
    SortingDatabase.selectSort(filename, students, "getDob");
  }

  public void selectSortGender(String filename) throws Exception {
    SortingDatabase.selectSort(filename, students, "getGender");
  }

  public void selectSortStudentId(String filename) throws Exception {
    SortingDatabase.selectSort(filename, students, "getStudentId");
  }


  // TODO fix returns of functions in StudentDataBase
  public String displayStudents() {
    return "TODO";
  }

  public int getNumFemaleStudents() {
    // Finds number of females in the student array
    if (updated || this.numOfFemales == -1) {
      this.numOfFemales = SearchDatabase.lineaerSearchFrquencyCount(",F,", students);
    }
    return this.numOfFemales;
  }

  public int getNumStudentsByCourse(String course) {
    // Finds number of students in the student array by course
    int counter = 0;
    if (updated) {
      counter = SearchDatabase.lineaerSearchFrquencyCount(course, students);
    }
    return counter;
  }

  /**
   * Searches for the first instance of a search criteria
   * 
   * @param string
   * @return
   * @throws Exception
   */
  public String search(String string, String crtieria) throws Exception {
    // TODO create this function
    String studentInfo;
    if (this.sorted) {
      studentInfo = SearchDatabase.binarySearch(string, this.students, crtieria);
    } else {
      studentInfo = SearchDatabase.lineaerSearch(string, students);
    }
    return studentInfo;
  }



  public void updateDatabase() {
    // TODO create a function that updates values after the database has been updated
    if (this.updated) {
      System.err.println("Still need to implement");
    }
    this.updated = false;
  }


  public Student[] getStudents() {
    return students;
  }

  public int getNumberOfStudents() {
    return numberOfStudents;
  }


  public int getNumOfMales() {
    return numOfMales;
  }

  public boolean isSorted() {
    return sorted;
  }
}
