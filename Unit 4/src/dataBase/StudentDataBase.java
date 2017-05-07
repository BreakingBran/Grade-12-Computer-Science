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

  Student students[];
  int numberOfStudents;
  boolean sorted = false;

  public StudentDataBase(String filename) throws IOException {
    readStudentDataBase(filename);
  }

  public StudentDataBase() {
    // Only here so other code doesn't break, that intiailizes with no params
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

    for (int j = 0; j < students.length; j++) {
      String student = students[j].toString();
      pw.println(student);
    }

    pw.close();
  }


  /**
   * sorts using bubble sort by last name and stores in desired file
   * 
   * @throws IOException
   */
  public void bubbleSort(String filename) throws IOException {
    boolean performedSwap = true;
    while (performedSwap) {
      performedSwap = false;
      for (int i = 1; i < students.length; i++) {
        Student firstStudent = students[i - 1];
        Student secondStudent = students[i];
        //if two names are not ordred switch them
        if (!compareWords(students[i - 1].getLastname(), students[i].getLastname(),firstStudent,secondStudent)) {
          students[i] = firstStudent;
          students[i - 1] = secondStudent;
          performedSwap = true;
        }
      }
    }
    // System.out.println(Arrays.toString(students));
    saveStudentDataBase(filename);
  }

  // other way of calling bubblesort
  public void bubbleSort() throws IOException {
    bubbleSort("StudentDataOutput/SortingOutput.txt");
  }

  /**
   * Sorts using selection sort by last name
   * 
   * @throws IOException
   */
  public void selectSort(String filename) throws IOException {

    //FIXME there is a problem in this code
    
    // Initializes the two tracking values with the value of the first student in students array
    String lowestName;
    int indexOfLowestName;

    // loop that is used to replace elements in sorted list
    for (int i = 0; i < students.length; i++) {

      lowestName = students[i].getLastname();
      indexOfLowestName = i;

      // loop that finds the best element in the list from the ith variable to it's end
      for (int j = i + 1; j < students.length; j++) {

        // if students[j] has a lower alphbetical name than students[indexOfLowestName]
        if (compareWords(students[j].getLastname(), students[indexOfLowestName].getLastname(),students[j],students[indexOfLowestName])) {
          lowestName = students[j].getLastname();
          indexOfLowestName = j;
          // System.out.println("I ran again");
        }
      }

      // switches the ith element with the indexOfLowestName element

      // if no need to switch, just skips over iteration
      if (i == indexOfLowestName) {
        continue;
      }

      Student newLower = students[indexOfLowestName];
      Student newHigher = students[i];

      // switches the two elements, so that the list is closer to being sorted
      students[i] = newLower;
      students[indexOfLowestName] = newHigher;

    }

    saveStudentDataBase(filename);
  }

  public void selectSort() throws IOException {
    selectSort("StudentDataOutput/SortingOutput.txt");
  }

  // TODO fix returns of functions in StudentDataBase
  public String displayStudents() {
    return "TODO";
  }

  public int getNumFemaleStudents() {
    return 5;
  }

  public int getNumStudentsByCourse(String course) {
    return 5;
  }

  public String search(String value) {
    return "To Do";
  }

  /**
   * Returns true if the first string is albabetically lower than the second string for example
   * {compareWords("Aa","Ba") : true, compareWords("Ab","AaC"): false} Note: Turns all strings to
   * lowercase before comparing
   * 
   * @param firstName
   * @param secondName
   * @return true if first string and second string in alphabetical order, false if not
   */
  private boolean compareWords(String firstName, String secondName) {
    boolean ordred = true;

    // determines how many times it needs to loop through
    int minNumOfChars = firstName.length();

    // converts to lowercase so upercase ascii value does not interfere with alphabetical sorting
    firstName = firstName.toLowerCase();
    secondName = secondName.toLowerCase();

    // if the second string is shorter, sets that as min iterations
    if (firstName.length() > secondName.length()) {
      minNumOfChars = secondName.length();
    }

    boolean switched = false;
    // Loops through two words until it finds a diffirence and determines which word comes first
    for (int i = 0; i < minNumOfChars; i++) {
      if ((int) (secondName.charAt(i)) < (int) firstName.charAt(i)) {
        ordred = false;
        switched = true;
        break;
      } else if ((int) secondName.charAt(i) > (int) firstName.charAt(i)) {
        ordred = true;
        switched = true;
        break;
      }
    }

    /*
     * if it reaches here, then both strings were equal up until the length of the shortest
     * string Now we need to say that the shorter string comes first and that the longer comes
     * second but we also need to check if they are the same
     */
    if(firstName.length() < secondName.length() && !switched){
      ordred = true;
    }
    
    return ordred;
  }

  private boolean compareWords(String firstName, String secondName, Student firstStudent, Student secondStudent) {
    boolean ordered = true;
    if (firstStudent.getLastname().equals(secondStudent.getLastname())) {
      if (!firstStudent.getFirstname().equals(secondStudent.getFirstname())) {
        ordered = compareWords(firstStudent.getFirstname(), secondStudent.getFirstname());
      }
    } else{
      ordered = compareWords(firstStudent.getLastname(), secondStudent.getLastname());
    }
    return ordered;
  }

  public void LanceSorting() {
    System.err.println("Not implemented yet");
  }
}
