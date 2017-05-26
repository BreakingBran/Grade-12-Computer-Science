package recursion;

import java.util.Arrays;

import dataBase.Student;

public class BinarySearch {

  public static String binarySearch(String searchField, Student[] halvedStudentArray,
      String criteria) throws Exception {
    // FIXME Horribly broken, refcctor so that it can be used for anything or take out recursion

    Student[] newHalvedArray;
    int index = (int) halvedStudentArray.length / 2;

    // Check if equal
    if (searchField.equals(halvedStudentArray[index].getstudentInfoDirectory(criteria))) {
      return (halvedStudentArray[index].toString());
    }

    // Check if the search string is greater or less than middle element of halvedStudentArray
    boolean isLess =
        (searchField.compareToIgnoreCase(halvedStudentArray[index]
            .getstudentInfoDirectory(criteria)) < 0);

    if (isLess) {
      newHalvedArray = Arrays.copyOfRange(halvedStudentArray, 0, index);
    } else {
      // the +1 is because the first index is inclusive
      newHalvedArray = Arrays.copyOfRange(halvedStudentArray, index + 1, halvedStudentArray.length);
    }

    if (halvedStudentArray.length == 1
        && !searchField.equals(halvedStudentArray[0].getstudentInfoDirectory(criteria))) {
      return null;
    } else {
      return binarySearch(searchField, newHalvedArray, criteria);
    }

  }
}
