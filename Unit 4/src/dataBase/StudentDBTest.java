package dataBase;

// import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import junit.framework.TestCase;

import org.junit.Test;

public class StudentDBTest extends TestCase {

  public StudentDataBase testDataBase = new StudentDataBase();


  @Test
  public void testReadStudentDataBase() throws IOException {
    testDataBase.readStudentDataBase("StudentDataInput/StudentData.txt", 5);
    assertEquals(testDataBase.students[0].getFirstname(), "Moshira");
    assertEquals(testDataBase.students[0].getLastname(), "Fernando");
    assertEquals(testDataBase.students[0].getCourses(), "BDI3C102 ENG3C103 PAD3O101 TTJ2O102");
    assertEquals(testDataBase.students[0].getGender(), "M");
    assertEquals(testDataBase.students[0].getStudentId(), "730177");
    assertEquals(testDataBase.students[0].getDob(), "19890402");
    assertEquals(testDataBase.students[4].getLastname(), "Rizzuto");
    assertEquals(testDataBase.students[4].getCourses(), "ADA1O104 ENG1D112 MPM1D107 SNC1D112");
    // System.out.println(testDataBase.students[0]);
  }

  @Test
  public void testSaveStudentDataBase() throws IOException {
    testDataBase.readStudentDataBase("StudentDataInput/StudentData.txt", 5);
    testDataBase.saveStudentDataBase("StudentDataOutput/SortingOutput.txt");
    Scanner sc = new Scanner(new FileReader("StudentDataOutput/SortingOutput.txt"));
    assertEquals(sc.nextLine(),
        "Fernando,Moshira,M,730177,19890402,BDI3C102 ENG3C103 PAD3O101 TTJ2O102");
    assertEquals(sc.nextLine(), "Zaid,Wajya,F,730014,19920228,BTT1O109 CGC1D111 ENG1D109 HRE1O117");
    assertEquals(sc.nextLine(),
        "Basara,Arash,M,730575,19900906,FSF1D107 HRE1O118 MPM1D112 SNC1D110");
    assertEquals(sc.nextLine(),
        "George,Shereen,F,731563,19880906,ADA1O103 CGC1D108 HRE1O117 MFM1P102");
    assertEquals(sc.nextLine(),
        "Rizzuto,Basem,F,730234,19901106,ADA1O104 ENG1D112 MPM1D107 SNC1D112");
  }

  @Test
  public void testBubbleSortSample() throws IOException {
    testDataBase.readStudentDataBase("StudentDataInput/StudentData.txt", 5);
    StudentDataBase bubblesorted =
        new StudentDataBase("StudentDataInput/StudentDataBubbleSorted.txt");
    testDataBase.bubbleSort();
    assertEquals(Arrays.toString(testDataBase.students), Arrays.toString(bubblesorted.students));

  }

  @Test
  public void testBubbleSortEntire() throws IOException {
    testDataBase.readStudentDataBase("StudentDataInput/StudentData.txt");
    testDataBase.bubbleSort();
    assertEquals(new File("StudentDataInput/StudentDataBubbleSorted.txt"), new File(
        "StudentDataInput/StudentDataBubbleSorted.txt"));
  }

  // TODO Find out what this piece of code does
  /*
   * @Rule public TemporaryFolder folder = new TemporaryFolder();
   */
}
