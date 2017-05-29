package recursion;

import java.util.Arrays;

import dataBase.Student;


/**
 * Searches for the specified searchfield in a certain colunm of the database
 * @param searchField: String of word you are looking for
 * @param halvedStudentArray
 * @param criteria
 * @return
 * @throws Exception
 */

public class BinarySearch{
  
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

  //I use contains because the courses functions are fucky 
  if (halvedStudentArray.length == 2) {
    if (searchField.contains(halvedStudentArray[0].getstudentInfoDirectory(criteria))){
      student =  halvedStudentArray[0].toString();
    }
    else if (searchField.contains(halvedStudentArray[1].getstudentInfoDirectory(criteria))){
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
}

