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

  private Student students[];
  private int numberOfStudents;
  private int numOfFemales;
  private int numOfMales;
  private boolean sorted = false;
  private boolean updated = false;

  public StudentDataBase(String filename) throws IOException {
    this();
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
  public void readStudentDataBase(String filename, int numOfLines_Students)
      throws FileNotFoundException {
    Scanner sc = new Scanner(new FileReader(filename));
    numberOfStudents = numOfLines_Students;

    int i = 0;
    students = new Student[numOfLines_Students];

    while (sc.hasNext() && i < numOfLines_Students) {
      // gets entire line with name, number, etc
      String studentInfoPackage = sc.nextLine();

      // avoids making null variables for
      if (studentInfoPackage == "") {
        System.err
            .println("Student Data input has blank lines in file which may crash server during operation");
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
        // if two names are not ordred switch them

        if (!compareWords(students[i - 1].getLastname(), students[i].getLastname(), firstStudent,
            secondStudent)) {
          students[i] = firstStudent;
          students[i - 1] = secondStudent;
          performedSwap = true;
        }
      }
    }
    // System.out.println(Arrays.toString(students));
    saveStudentDataBase(filename);
    sorted = true;
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
        if (!compareWords(students[indexOfLowestName].getLastname(), students[j].getLastname(),
            students[indexOfLowestName], students[j])) {
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
    sorted = true;
  }

  public void selectSort() throws IOException {
    selectSort("StudentDataOutput/SortingOutput.txt");
  }

  // TODO fix returns of functions in StudentDataBase
  public String displayStudents() {
    return "TODO";
  }

  public int getNumFemaleStudents() {
    //Do not call 
    this.numOfFemales = lineaerSearchCount(",F,");
    return this.numOfFemales;
  }

  private int searchFor(String string) {
    // TODO create this function
    int counter = 0;
    if (this.sorted) {
      counter = binarySearch(string, this.students);
    } else {
      counter = lineaerSearchCount(string);
    }
    System.out.println(counter);
    return counter;
  }

  private int lineaerSearchCount(String string) {

    int linearCounter = 0;

    for (int i = 0; i < students.length; i++) {
      String studentInfoPackage = this.students[i].toString();
      // System.out.println(studentInfoPackage);
      if (studentInfoPackage.contains(string)) {
        // System.out.println("True");
        linearCounter += 1;
      }
    }
    // System.out.println(linearCounter);
    return linearCounter;
  }

  private int binarySearch(String string, Student[] halvedStudentArray) {
    //TODO finish binary search
    int counter = 0;
    Student[] newHalvedArray;
    int index = halvedStudentArray.length/2;
    
    //Check if the search string is greater or less than middle element of halvedStudentArray
    if ()
    
    if (halvedStudentArray.length == 1){
      return counter;
    }
    else{
      binarySearchCount(string,newHalvedArray);
    }
    
  }

  public int getNumStudentsByCourse(String course) {
    return 5;
  }

  public String search(String value) {
    return "To Do";
  }

  public void updateDatabase() {
    // TODO create a function that updates values after the database has been updated
    if (this.updated) {
      System.err.println("Still need to implement");
    }
    this.updated = false;
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
     * if it reaches here, then both strings were equal up until the length of the shortest string
     * Now we need to say that the shorter string comes first and that the longer comes second but
     * we also need to check if they are the same ordred already set to true, so don't need a case
     * for checking if firstname.length() > secondName.length()
     */
    if (firstName.length() > secondName.length() && !switched) {
      ordred = false;
    }

    return ordred;
  }

  private boolean compareWords(String firstName, String secondName, Student firstStudent,
      Student secondStudent) {

    boolean ordered = true;
    if (firstStudent.getLastname().equals(secondStudent.getLastname())) {
      if (!firstStudent.getFirstname().equals(secondStudent.getFirstname())) {
        ordered = compareWords(firstStudent.getFirstname(), secondStudent.getFirstname());
        // ordered = (firstStudent.getFirstname().compareToIgnoreCase(secondStudent.getFirstname())
        // < 0);
      } else {
        // If first name and last name same, seperate by student number
        if ((Integer.parseInt(firstStudent.getStudentId()) < Integer.parseInt(secondStudent
            .getStudentId()))) {
          ordered = true;
        } else if ((Integer.parseInt(firstStudent.getStudentId()) > Integer.parseInt(secondStudent
            .getStudentId()))) {
          ordered = false;
        } else {
          System.err.println("There are two students with the same student number of: "
              + secondStudent.getStudentId());
        }
      }
    } else {
      ordered = compareWords(firstStudent.getLastname(), secondStudent.getLastname());
      // ordered = (firstStudent.getLastname().compareToIgnoreCase(secondStudent.getLastname()) <
      // 0);
    }
    return ordered;
  }

  public void LanceSorting() {
    System.err.println("Not implemented yet");
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
