package dataBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

//ctrl + F11 to compile
//ctl + shift + o = auto import
//syserr = like sysout but red
//ctrl + alt = copy line down
//
class StudentDataBase {
  
  Student students[];
  
  boolean sorted;

  public StudentDataBase(String filename) throws FileNotFoundException{
    Scanner sc = new Scanner(new FileReader(filename));
    ArrayList<Student> studentDatabase;
    
    //while there are lines to read from the file
    while (sc.hasNext()) {
      //gets entire line with name, number, etc
      String studentInfoPackage = sc.nextLine();
      
      
    }
  }
  
  public void readStudentDataBase(String filename){
    
  }
  public void saveStudentDataBase(String filename){}
  
  public void bubbleSort(){}
  
  public void selectSort(){}
  
  //TODO fix returns of functions in StudentDataBase
  public String displayStudents(){
    return "TODO";
  }
  
  public int getNumFemaleStudents(){
    return 5;
  }
  
  public int getNumStudentsByCourse(String course){
    return 5;
  }
  
  public String search(String value){
    return "To Do";
  }


  
}
