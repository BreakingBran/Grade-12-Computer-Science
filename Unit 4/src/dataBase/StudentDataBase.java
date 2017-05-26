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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
  private Boolean sorted = false;
  private Boolean sortedLastName = false;
  private Boolean sortedFirstName = false;
  private Boolean sortedCourses = false;
  private Boolean sortedDOB = false;
  private Boolean sortedStudentID = false;
  private Boolean sortedGender = false;
  private Boolean[] sortedBooleanArray = {sortedLastName,sortedFirstName,sortedCourses,sortedDOB,sortedStudentID,sortedGender};
  private static Map<String, Integer> sortedArrayIndexMapping = new HashMap<String, Integer>();
  static {    
    sortedArrayIndexMapping.put("getLastName", 0);
    sortedArrayIndexMapping.put("getFirstName", 1);
    sortedArrayIndexMapping.put("getCourses", 2);
    sortedArrayIndexMapping.put("getDob", 3);
    sortedArrayIndexMapping.put("getStudentId", 4); //Really this one should throw an error
    sortedArrayIndexMapping.put("getGender", 5);
    
  }
  
  /**
   *  private Boolean sortedLastName = false;
   *  private Boolean sortedFirstName = false;
   *  private Boolean sortedCourses = false;
   *  private Boolean sortedDOB = false;
   *  private Boolean sortedStudentID = false;
   *  private Boolean sortedGender = false;
   *  private Boolean[] sortedBooleanArray = {sortedLastName,sortedFirstName,sortedCourses,sortedDOB,sortedStudentID,sortedGender};
   * @param i
   * @return
   */
  public Boolean getSortedBooleanArrayElement(int i) {
    return sortedBooleanArray[i];
  }

  private boolean updated = false;
  static int numberOfDataBases = 0;

  public StudentDataBase(String filename) throws IOException {
    this();
    readStudentDataBase(filename);
    
  }
  
  public StudentDataBase(String filename, int lines) throws IOException {
    this();
    readStudentDataBase(filename,lines);
   
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

  static public void saveStudentDataBase(String filename, Student[] students) throws IOException {
    PrintWriter pw = new PrintWriter(new FileWriter(filename));

    for (int j = 0; j < students.length; j++) {
      String student = students[j].toString();
      pw.println(student);
    }

    pw.close();
  }
  
  private void switchSortedBooleans(int j){
    for (int i = 0; i < sortedBooleanArray.length; i++) {
      if (i != j){
        sortedBooleanArray[i] = false;
      }
    }
  }

  /**
   * sorts using bubble sort by last name and stores in desired file
   * 
   * @throws Exception
   */
  public void bubbleSortLastName(String filename) throws Exception {
    SortingDatabase.bubbleSort(filename, students, "getLastName");
    updateDatabase(0,filename);
  }

  public void bubbleSortFirstName(String filename) throws Exception {
    SortingDatabase.bubbleSort(filename, students, "getFirstName");
    updateDatabase(1,filename);
  }

  public void bubbleSortCourses(String filename) throws Exception {
    SortingDatabase.bubbleSort(filename, students, "getCourses");
    updateDatabase(2,filename);
  }

  public void bubbleSortDob(String filename) throws Exception {
    SortingDatabase.bubbleSort(filename, students, "getDob");
    updateDatabase(3,filename);
  }
  
  public void bubbleSortStudentId(String filename) throws Exception {
    SortingDatabase.bubbleSort(filename, students, "getStudentId");
    updateDatabase(4,filename);
  }

  public void bubbleSortGender(String filename) throws Exception {
    SortingDatabase.bubbleSort(filename, students, "getGender");
    updateDatabase(5,filename);
  }




  /**
   * Sorts using selection sort by last name
   * 
   * @throws IOException
   */
  public void selectSortLastName(String filename) throws Exception {
    
    SortingDatabase.selectSort( this.students, "getLastName");
    updateDatabase(0,filename);
  }

  public void selectSortFirstName(String filename) throws Exception {
    SortingDatabase.selectSort( students, "getFirstName");
    updateDatabase(1,filename);
  }

  public void selectSortCourses(String filename) throws Exception {
    SortingDatabase.selectSort( students, "getCourses");
    updateDatabase(2,filename);
  }

  public void selectSortDob(String filename) throws Exception {
    SortingDatabase.selectSort( students, "getDob");
    updateDatabase(3,filename);
  }

  public void selectSortStudentId(String filename) throws Exception {
    SortingDatabase.selectSort( students, "getStudentId");
    updateDatabase(4,filename);
  }

  public void selectSortGender(String filename) throws Exception {
    SortingDatabase.selectSort(students, "getGender");
    updateDatabase(5,filename);
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
    
    counter = SearchDatabase.lineaerSearchFrquencyCount(course, students);
    
    return counter;
  }

 /**
  * Looks for desired string in entire database in specified criteria slot
  * @param string: thing you want to search for 
  * @param crtieria: getLastName, getFirstName, getCourses, getStudentId, getGender, getDob
  * @return Returns first instance of found match
  * @throws Exception
  */
  public String  search(String string, String crtieria) throws Exception {
    // TODO create this function
    String studentInfo = null;
    if (sortedBooleanArray[sortedArrayIndexMapping.get(crtieria)]) {
      
      //This one exception exists just b/c of how the data for courses is stored
      if (!crtieria.equalsIgnoreCase("getCourses")){
        //FIXME change these statements
        studentInfo = SearchDatabase.binarySearch(string, this.students, crtieria);
        //studentInfo = SearchDatabase.binarySearchWithoutRecursion(string, this.students, crtieria);
      }
      
      if (studentInfo == null){studentInfo = SearchDatabase.lineaerSearch(string, students,crtieria);}
    } else {
      studentInfo = SearchDatabase.lineaerSearch(string, students,crtieria);
    }
    return studentInfo;
  }

  public String searchByLastName(String string) throws Exception {    
    return search(string,"getLastName");
  }


  public void updateDatabase(int i, String filename) throws IOException {
    StudentDataBase.saveStudentDataBase(filename,students);
    sortedBooleanArray[i] = true;
    switchSortedBooleans(i);
    
  }


  public Student[] getStudents() {
    return students;
  }

  public int getNumberOfStudents() {
    return numberOfStudents;
  }


  public int getNumOfMales() {
    if (this.numOfFemales == -1 || this.updated){
      this.numOfFemales = getNumFemaleStudents();
    }
    return this.numberOfStudents - this.numOfFemales;
  }

  public boolean isSorted() {
    return sorted;
  }
}
