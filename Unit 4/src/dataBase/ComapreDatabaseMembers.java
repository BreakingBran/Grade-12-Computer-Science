package dataBase;

public class ComapreDatabaseMembers {
  
  
  /*
   * OKAY SO listen
   * Map<String, String> map = new HashMap<String, String>(); 
   * is going to hold StudentInfo Items, these student Info items are 
   */
  
  
  
  /**
   * Returns true if the first string is albabetically lower than the second string for example
   * {compareStudentsByLastName("Aa","Ba") : true, compareStudentsByLastName("Ab","AaC"): false} Note: Turns all strings to
   * lowercase before comparing
   * 
   * @param firstName
   * @param secondName
   * @return true if first string and second string in alphabetical order, false if not
   */
  private boolean compareStudentsByLastName(String firstName, String secondName) {
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

  private boolean compareStudentsByLastName(String firstName, String secondName, Student firstStudent,
      Student secondStudent) {

    boolean ordered = true;
    if (firstStudent.getLastname().equals(secondStudent.getLastname())) {
      if (!firstStudent.getFirstname().equals(secondStudent.getFirstname())) {
        ordered = compareStudentsByLastName(firstStudent.getFirstname(), secondStudent.getFirstname());
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
      ordered = compareStudentsByLastName(firstStudent.getLastname(), secondStudent.getLastname());
      // ordered = (firstStudent.getLastname().compareToIgnoreCase(secondStudent.getLastname()) <
      // 0);
    }
    return ordered;
  }

  

}
