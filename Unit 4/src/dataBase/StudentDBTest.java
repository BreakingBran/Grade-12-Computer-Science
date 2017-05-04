package dataBase;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class StudentDBTest {
  
  StudentDataBase testDataBase = new StudentDataBase();
  
  @Test
  public void testReadStudentDataBase() throws IOException {
    testDataBase.readStudentDataBase("StudentData.txt",5);
    assertEquals(testDataBase.students[0].getFirstname(),"Moshira" );
    assertEquals(testDataBase.students[0].getLastname(),"Fernando" );
    assertEquals(testDataBase.students[0].getCourses(),"BDI3C102 ENG3C103 PAD3O101 TTJ2O102" );
    assertEquals(testDataBase.students[0].getGender(),"M" );
    assertEquals(testDataBase.students[0].getStudentId(),"730177" );
    assertEquals(testDataBase.students[0].getDob(),"19890402" );
    assertEquals(testDataBase.students[4].getLastname(),"Rizzuto" );
    assertEquals(testDataBase.students[4].getCourses(),"ADA1O104 ENG1D112 MPM1D107 SNC1D112" );
    
  }
}
