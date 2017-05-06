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
  public void readStudentDataBase(String filename, int numOfLines_Students)
      throws FileNotFoundException {
    Scanner sc = new Scanner(new FileReader(filename));

    // TODO remove the testing counter after testing

    int i = 0;
    students = new Student[numOfLines_Students];

    while (sc.hasNext() && i < numOfLines_Students) {
      // gets entire line with name, number, etc
      String studentInfoPackage = sc.nextLine();
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
      pw.println(students[j]);
    }
    pw.close();
  }


  /**
   * sorts using bubble sort for last name
   * 
   * @throws IOException
   */
  public void bubbleSort() throws IOException {
    boolean performedSwap = true;
    while (performedSwap) {
      performedSwap = false;
      for (int i = 1; i < students.length; i++) {
        if (!compareWords(students[i-1].getLastname(), students[i].getLastname())) {
          Student firstStudent = students[i - 1];
          Student secondStudent = students[i];
          students[i] = firstStudent;
          students[i - 1] = secondStudent;
          performedSwap = true;
        }
      }
    }
    //System.out.println(Arrays.toString(students));
    saveStudentDataBase("StudentDataOutput/SortingOutput.txt");
  }

  public void selectSort() {}

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
   * {compareWords("Aa","Ba") : true, compareWords("Ab","AaC"): false}
   * 
   * @param firstName
   * @param secondName
   */
  private boolean compareWords(String firstName, String secondName) {
    boolean ordred = true;
    int numOfChars = firstName.length();

    if (firstName.length() > secondName.length()) {
      numOfChars = secondName.length();
    }
    for (int i = 0; i < numOfChars; i++) {
      if ((int) secondName.charAt(i) < (int) firstName.charAt(i)) {
        ordred = false;
        break;
      }
      else if ((int) secondName.charAt(i) > (int) firstName.charAt(i)) {
        ordred = true;
        break;
      }
    }
    return ordred;
  }

  public LanceSorting(){
    
  }
}
