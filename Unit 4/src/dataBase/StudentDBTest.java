package dataBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import junitx.framework.FileAssert;

import junit.framework.TestCase;

import org.junit.Test;

public class StudentDBTest extends TestCase {

  public StudentDataBase testDataBase = new StudentDataBase();
  String completeSortFileName = "SortedDataSets/CompleteSort.txt";
  
  //TODO use these names soon
  String sampleData = "SortedDataSets/CompleteSort.txt";
  String completeDatabase = "SortedDataSets/CompleteSort.txt";
  String sampleDataSorted = "SortedDataSets/CompleteSort.txt";
  


  @Test
  public void testReadStudentDataBase() throws IOException {
    testDataBase.readStudentDataBase("StudentDataInput/StudentData.txt", 5);
    assertEquals(testDataBase.getStudents()[0].getFirstname(), "Moshira");
    assertEquals(testDataBase.getStudents()[0].getLastname(), "Fernando");
    assertEquals(testDataBase.getStudents()[0].getCourses(), "BDI3C102 ENG3C103 PAD3O101 TTJ2O102");
    assertEquals(testDataBase.getStudents()[0].getGender(), "M");
    assertEquals(testDataBase.getStudents()[0].getStudentId(), "730177");
    assertEquals(testDataBase.getStudents()[0].getDob(), "19890402");
    assertEquals(testDataBase.getStudents()[4].getLastname(), "Rizzuto");
    assertEquals(testDataBase.getStudents()[4].getCourses(), "ADA1O104 ENG1D112 MPM1D107 SNC1D112");
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
    testDataBase.bubbleSort();
    FileAssert.assertEquals(
        new File("SortedDataSets/StudentDataSorted.txt"), 
        new File("StudentDataOutput/SortingOutput.txt"));
  }

  @Test
  public void testBubbleSortEntire() throws IOException {
    testDataBase.readStudentDataBase("StudentDataInput/StudentData.txt");
    testDataBase.bubbleSort();
    FileAssert.assertEquals(
        new File("StudentDataOutput/SortingOutput.txt"), 
        new File(completeSortFileName));
  }

  @Test
  public void testSelectSort() throws IOException {
    testDataBase.readStudentDataBase("StudentDataInput/StudentData.txt", 5);
    testDataBase.selectSort();
    FileAssert.assertEquals(
        new File("SortedDataSets/StudentDataSorted.txt"), 
        new File("StudentDataOutput/SortingOutput.txt"));
  }


  @Test
  public void testSelectSortEntire() throws IOException {
    StudentDataBase selectSorted = new StudentDataBase("StudentDataInput/StudentData.txt");
    selectSorted.selectSort();
    FileAssert.assertEquals(
        new File("StudentDataOutput/SortingOutput.txt"), 
        new File(completeSortFileName));
  }
  
  @Test
  public void testGetNumFemaleStudentsSample() throws IOException {
    //first 10 elements
    testDataBase.readStudentDataBase("StudentDataInput/StudentData.txt", 10);
    assertEquals(7,testDataBase.getNumFemaleStudents());
    //testDataBase.selectSort();
    //assertEquals(testDataBase.getNumFemaleStudents(), 7);
    
  }
  
  @Test
  public void testGetNumFemaleStudentsEntire() throws IOException {
    testDataBase.readStudentDataBase("StudentDataInput/StudentData.txt", 10);
    assertEquals( 1016,testDataBase.getNumFemaleStudents());
    testDataBase.selectSort();
    assertEquals( 1016,testDataBase.getNumFemaleStudents());
    //Males are 1088
  }

  // TODO Find out what this piece of code does
  /*
   * @Rule public TemporaryFolder folder = new TemporaryFolder();
   */
}
