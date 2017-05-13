package dataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchDatabase {
  
  public static int lineaerSearchFrquencyCount(String string, Student[] students) {

    int linearCounter = 0;

    for (int i = 0; i < students.length; i++) {
      String studentInfoPackage = students[i].toString();
      // System.out.println(studentInfoPackage);
      if (studentInfoPackage.contains(string)) {
        // System.out.println("True");
        linearCounter += 1;
      }
    }
    // System.out.println(linearCounter);
    return linearCounter;
  }

  /**
   * Outputs the student info of the first student that matches the search string For the purposes
   * of the class it outputs only the 1st occurance of the student that matches
   * 
   * @param string: that you want to search for in the database
   * @return: all info about first student who matches this description
   */
  public static String lineaerSearch(String string,Student[] students) {

    // I made two seperate linear search functions
    // so that they are not interdependant, and that the counter can run much faster
    List<Student> foundStudents = new ArrayList<Student>();

    // Goes through array and tries to find all students that match string
    for (int i = 0; i < students.length; i++) {
      String studentInfoPackage = students[i].toString();
      if (studentInfoPackage.contains(string)) {
        foundStudents.add(students[i]);
      }
    }

    // He said for the purpose of the class to just output the first occurance
    return foundStudents.get(0).toString();
  }


  public static String binarySearch(String searchField, Student[] halvedStudentArray,String criteria) throws Exception {
    // FIXME Horribly broken, refcctor so that it can be used for anything or take out recursion
    String studentInfo;
    Student[] newHalvedArray;
    int index = (int) halvedStudentArray.length / 2;

    // Check if equal
    if (searchField.equals(halvedStudentArray[index].getstudentInfoDirectory(criteria))) {
      return (halvedStudentArray[index].toString());
    }

    // Check if the search string is greater or less than middle element of halvedStudentArray
    boolean isLess = (searchField.compareToIgnoreCase(halvedStudentArray[index].getstudentInfoDirectory(criteria)) < 0);

    if (isLess) {
      newHalvedArray = Arrays.copyOfRange(halvedStudentArray, 0, index);
    } else {
      newHalvedArray = Arrays.copyOfRange(halvedStudentArray, index, halvedStudentArray.length);
    }

    if (halvedStudentArray.length == 1) {
      return halvedStudentArray[0].toString();
    } else {
      return binarySearch(searchField, newHalvedArray ,criteria);
    }

  }

}