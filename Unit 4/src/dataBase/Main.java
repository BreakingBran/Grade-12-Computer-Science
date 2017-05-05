package dataBase;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
  
  public static void main(String[] args) throws IOException {
    StudentDataBase test = new StudentDataBase();
    test.readStudentDataBase("StudentDataInput/StudentData.txt",5);
    test.saveStudentDataBase("StudentDataOutput/SortingOutput.txt");
    test.bubbleSort();
  }
  
}
