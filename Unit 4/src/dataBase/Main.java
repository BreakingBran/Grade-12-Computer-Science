package dataBase;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
  
  public static void main(String[] args) throws Exception {
    
    StudentDataBase test = new StudentDataBase();
    String outputFile = "StudentDataOutput/SortingOutput.txt";
    
    
    //Testing with only 5 elements
    test.readStudentDataBase("StudentDataInput/StudentData.txt");
    
    
    //Testing with entire file
    //test.readStudentDataBase("StudentDataInput/StudentData.txt");
    
    //Testing with sample of name
    //test.readStudentDataBase("StudentDataInput/StudentDataSample.txt");
    
    test.mergeSortLastName(outputFile);
    //test.selectSortDob(outputFile);
    //test.selectSortFirstName(outputFile);
    //test.selectSortGender(outputFile);
    //test.selectSortLastName(outputFile);
    //test.selectSortStudentId(outputFile);
    
  }
  
}
