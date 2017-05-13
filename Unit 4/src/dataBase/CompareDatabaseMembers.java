package dataBase;

import java.util.HashMap;
import java.util.Map;

public class CompareDatabaseMembers {


  /*
   * OKAY SO listen Map<String, String> map = new HashMap<String, String>(); is going to hold
   * StudentInfo Items, these student Info items are
   */

  private static final Map<String, String> criteriaHierarchy = new HashMap<String, String>();

  static {    
    criteriaHierarchy.put("getLastName", "getFirstName");
    criteriaHierarchy.put("getFirstName", "getStudentId");
    //criteriaHierarchy.put("getStudentId", "getLastName"); //Really this one should throw an error
    criteriaHierarchy.put("getDob", "getStudentId");
    criteriaHierarchy.put("getCourses", "getStudentId");
    criteriaHierarchy.put("getGender", "getStudentId");
    
  }


  /**
   * Returns true if the first string is albabetically lower than the second string for example
   * {compareStudentsByLastName("Aa","Ba") : true, compareStudentsByLastName("Ab","AaC"): false}
   * Note: Turns all strings to lowercase before comparing
   * 
   * @param firstStudentField
   * @param secondStudentField
   * @return true if first string and second string in alphabetical order, false if not
   * @throws Exception
   */
  static boolean compareStudents(Student firstStudent, Student secondStudent, String criteria) throws Exception {
    boolean ordred = true;

    String firstStudentField = firstStudent.getstudentInfoDirectory(criteria);
    String secondStudentField = secondStudent.getstudentInfoDirectory(criteria);
    int diffirence = firstStudentField.compareToIgnoreCase(secondStudentField);
    if (diffirence > 0) {
      ordred = false;
    } else if (diffirence < 0) {
      ordred = true;
    } else if (diffirence == 0 && !criteria.equals("getStudentId")){
      ordred = compareStudents(firstStudent, secondStudent, criteriaHierarchy.get(criteria));
    }

    return ordred;

    /*
     * // determines how many times it needs to loop through int minNumOfChars =
     * firstStudentField.length();
     * 
     * // converts to lowercase so upercase ascii value does not interfere with alphabetical sorting
     * firstStudentField = firstStudentField.toLowerCase(); secondStudentField =
     * secondStudentField.toLowerCase();
     * 
     * // if the second string is shorter, sets that as min iterations if
     * (firstStudentField.length() > secondStudentField.length()) { minNumOfChars =
     * secondStudentField.length(); }
     * 
     * boolean switched = false; // Loops through two words until it finds a diffirence and
     * determines which word comes first for (int i = 0; i < minNumOfChars; i++) { if ((int)
     * (secondStudentField.charAt(i)) < (int) firstStudentField.charAt(i)) { ordred = false;
     * switched = true; break; } else if ((int) secondStudentField.charAt(i) > (int)
     * firstStudentField.charAt(i)) { ordred = true; switched = true; break; } }
     * 
     * 
     * if it reaches here, then both strings were equal up until the length of the shortest string
     * Now we need to say that the shorter string comes first and that the longer comes second but
     * we also need to check if they are the same ordred already set to true, so don't need a case
     * for checking if firstname.length() > secondName.length()
     * 
     * if (firstStudentField.length() > secondStudentField.length() && !switched) { ordred = false;
     * }
     * 
     * return ordred;
     */
  }

  static public boolean compareStudentsByLastName(Student firstStudent, Student secondStudent) throws Exception {

    boolean ordered = true;
    if (firstStudent.getLastname().equals(secondStudent.getLastname())) {
      if (!firstStudent.getFirstname().equals(secondStudent.getFirstname())) {
        ordered = compareStudents(firstStudent, secondStudent, "getFirstname");
        // ordered = (firstStudent.getFirstname().compareToIgnoreCase(secondStudent.getFirstname())
        // < 0);
      } else {
        // If first name and last name same, seperate by student number
        if ((Integer.parseInt(firstStudent.getStudentId()) < Integer.parseInt(secondStudent.getStudentId()))) {
          ordered = true;
        } else if ((Integer.parseInt(firstStudent.getStudentId()) > Integer.parseInt(secondStudent.getStudentId()))) {
          ordered = false;
        } else {
          System.err.println("There are two students with the same student number of: " + secondStudent.getStudentId());
        }
      }
    } else {
      ordered = compareStudents(firstStudent, secondStudent, "getLastname");

    }
    return ordered;
  }



}
