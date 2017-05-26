package dataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchDatabase {

  public static int lineaerSearchFrquencyCount(String string, Student[] students) {

    int linearCounter = 0;

    for (int i = 0; i < students.length; i++) {
      String studentInfoPackage = students[i].toString();
      
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
  public static String lineaerSearch(String string, Student[] students) {

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
    if (foundStudents.size() > 0){return foundStudents.get(0).toString();}
    else {return null;}
  }
  
  public static String lineaerSearch(String string, Student[] students, String criteria) throws Exception {

    // I made two seperate linear search functions
    // so that they are not interdependant, and that the counter can run much faster
    List<Student> foundStudents = new ArrayList<Student>();

    // Goes through array and tries to find all students that match string
    for (int i = 0; i < students.length; i++) {
      String studentInfoPackage = students[i].getstudentInfoDirectory(criteria);
      if (studentInfoPackage.contains(string)) {
        foundStudents.add(students[i]);
      }
    }

    // He said for the purpose of the class to just output the first occurance
    if (foundStudents.size() > 0){return foundStudents.get(0).toString();}
    else {return null;}
  }


  /**
   * Searches for the specified searchfield in a certain colunm of the database
   * @param searchField: String of word you are looking for
   * @param halvedStudentArray
   * @param criteria
   * @return
   * @throws Exception
   */
  public static String binarySearch(String searchField, Student[] halvedStudentArray, String criteria) throws Exception {
    // FIXME Horribly broken, refcctor so that it can be used for anything or take out recursion
    
    Student[] newHalvedArray;
    int index = (int) halvedStudentArray.length / 2;
    String student;

    // Check if equal
    if (searchField.equals(halvedStudentArray[index].getstudentInfoDirectory(criteria))) {
      return (halvedStudentArray[index].toString());
    }

    // Check if the search string is greater or less than middle element of halvedStudentArray
    boolean isLess = (searchField.compareToIgnoreCase(halvedStudentArray[index].getstudentInfoDirectory(criteria)) < 0);

    if (isLess) {
      newHalvedArray = Arrays.copyOfRange(halvedStudentArray, 0, index);
    } else {
      //the +1 is because the first index is inclusive 
      newHalvedArray = Arrays.copyOfRange(halvedStudentArray, index+1, halvedStudentArray.length);
    }

    if (halvedStudentArray.length == 2) {
      if (searchField.equals(halvedStudentArray[0].getstudentInfoDirectory(criteria))){
        student =  halvedStudentArray[0].toString();
      }
      else if (searchField.equals(halvedStudentArray[1].getstudentInfoDirectory(criteria))){
        student =  halvedStudentArray[1].toString();
      }
      else{
        student = null;
      }
      
      return student;
      
    } else {
      return binarySearch(searchField, newHalvedArray, criteria);
    }

  }
  
  public static String binarySearchWithoutRecursion(String searchField, Student[] halvedStudentArray, String criteria) throws Exception {
    //FIXME need to finish implementing this
    Student[] newHalvedArray = halvedStudentArray;
    //this always takes the whole digit, 5/2 -> 2
    int index = (int) halvedStudentArray.length / 2;
    String output = null;
    
    while (newHalvedArray.length > 2 && output == null){
      
      if (searchField.equals(newHalvedArray[index].getstudentInfoDirectory(criteria))) {
        output = (newHalvedArray[index].toString());
        break;
      }

      // Check if the search string is greater or less than middle element of halvedStudentArray
      boolean isLess = (searchField.compareToIgnoreCase(newHalvedArray[index].getstudentInfoDirectory(criteria)) < 0);

      //reinitialize with new index #
      index = (int)newHalvedArray.length/2;

      
      if (isLess) {
        newHalvedArray = Arrays.copyOfRange(newHalvedArray, 0, index);
      } else {
        //the +1 is because the first index is inclusive 
        newHalvedArray = Arrays.copyOfRange(newHalvedArray, index+1, halvedStudentArray.length);
      }
      
    }
    
    if (output == null){
      if (searchField.equals(newHalvedArray[0].getstudentInfoDirectory(criteria))) { 
        output = (newHalvedArray[index].toString());   
      }
      
      if (newHalvedArray.length == 2){
        if (searchField.equals(newHalvedArray[0].getstudentInfoDirectory(criteria))) { 
          output = (newHalvedArray[1].toString());  
        }
      }
    }
          
    return output;
    }

}
