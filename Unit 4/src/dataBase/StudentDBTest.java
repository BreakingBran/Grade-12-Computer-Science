package dataBase;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class StudentDBTest {
  
  StudentDataBase testDataBase = new StudentDataBase();
  
  @Test
  public void testReadStudentDataBase() throws IOException {
    testDataBase.readStudentDataBase("StudentData.txt");
  }
}
