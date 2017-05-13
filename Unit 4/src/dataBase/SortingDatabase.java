package dataBase;

import java.io.IOException;

public class SortingDatabase {
  
  /**
   * sorts using bubble sort by last name and stores in desired file
   * @throws Exception 
   */
  static public boolean bubbleSort(String filename, Student[] students, String criteria) throws Exception {
    boolean performedSwap = true;
    while (performedSwap) {
      performedSwap = false;
      for (int i = 1; i < students.length; i++) {
        Student firstStudent = students[i - 1];
        Student secondStudent = students[i];
        // if two names are not ordred switch them

        if (!CompareDatabaseMembers.compareStudents(students[i - 1], students[i], criteria)) {
          students[i] = firstStudent;
          students[i - 1] = secondStudent;
          performedSwap = true;
        }
      }
    }
    // System.out.println(Arrays.toString(students));
    StudentDataBase.saveStudentDataBase(filename,students);
    return true;
  }

  // other way of calling bubblesort
  public void bubbleSort(Student[] students, String criteria) throws Exception {
    bubbleSort("StudentDataOutput/SortingOutput.txt",students, criteria);
  }

  /**
   * Sorts using selection sort by criteria
   * returns true, to indicate succesful sort
   * @throws Exception 
   */
  static public boolean selectSort(String filename, Student[] students, String criteria) throws Exception {

    // Initializes the two tracking values with the value of the first student in students array
    //String lowestName;
    int indexOfLowestName;

    // loop that is used to replace elements in sorted list
    for (int i = 0; i < students.length; i++) {

      //lowestName = students[i].getLastname();
      indexOfLowestName = i;

      // loop that finds the best element in the list from the ith variable to it's end
      for (int j = i + 1; j < students.length; j++) {

        // if students[j] has a lower alphbetical name than students[indexOfLowestName]
        if (!CompareDatabaseMembers.compareStudents(students[indexOfLowestName], students[j],criteria)) {
          //lowestName = students[j].getLastname();
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

    StudentDataBase.saveStudentDataBase(filename,students);
   
    return true;
  }

  public void selectSort( Student[] students, String criteria) throws Exception {
    selectSort("StudentDataOutput/SortingOutput.txt",students,criteria);
  }

}
