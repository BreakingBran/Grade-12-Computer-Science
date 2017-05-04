package dataBase;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class StudentDBTest {
  
  static StudentDataBase testDataBase;

  public static void main(String[] args) throws FileNotFoundException {
    testDataBase = new StudentDataBase();
    assertNotEquals(testDataBase, null);
  }
  
  @Test
  public void testReadStudentDataBase() throws IOException {
    testDataBase.readStudentDataBase("StudentData.txt");
  }
}
