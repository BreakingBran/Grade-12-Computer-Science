package dataBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// ctrl + F11 to compile
// ctl + shift + o = auto import
// syserr = like sysout but red
// ctrl + alt = copy line down
//

/**
 * 
 */
public class StudentDataBase {

  Student students[];
  int numberOfStudents;
  boolean sorted;

  public StudentDataBase() {

  }

  /**
   * Reads database from file and stores each line as an object in students[].
   * @param filename
   * @throws IOException
   */
  public void readStudentDataBase(String filename) throws IOException 
  {
    numberOfStudents = getLinesInFile("StudentData.txt");
    readStudentDataBase("StudentData.txt",numberOfStudents);
  }

  /**
   * Finds the number of lines in a file
   * @param filename
   * @param testingCounter
   * @throws FileNotFoundException
   */
  public void readStudentDataBase(String filename, int numOfLines_Students) throws FileNotFoundException {
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
      
      //System.out.println(Arrays.toString(studentInfoPackageArray));
      
    }
  }

  /**
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

  public void saveStudentDataBase(String filename) {}

  public void bubbleSort() {}

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



}
