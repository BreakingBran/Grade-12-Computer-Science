/**
 * BMIwithFileIO
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Feb 16, 2017
*/

import java.util.*;
import java.io.*;

public class BMIwithFileIO
{
  //Read in weight and height
  //Calculate BMI 
  //Determine weight level
  
  public static void main(String args[]) throws IOException
  {
    // Read Weight and Height 
    
    //initializes the input function
	  
    //Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(new FileReader("BMI IO/BMIinput.txt"));
    
    PrintWriter pw = new PrintWriter(new FileWriter("BMI IO/BMIoutput.txt"));
    // Using doubles b/c it is more accurate
    //System.out.print("Enter Weight:");
    double weight = sc.nextFloat();
    
    //System.out.print("Enter Height:");
    double height = sc.nextFloat();
    
    // Calculate BMI
    
    double BMI = (weight/Math.pow(height,2));
      
     //Determine Weight level
     
     String health = "Error";
     if(BMI > 25)
    {
    health = "Overweight";
    }
    else if ((18.5 <= BMI) && (BMI <= 25.0))
    {
    health = "Normal Weight";
    }
    else if (BMI < 18.5)
    {
    health = "Underweight";
    }
    
   //System.out.println(health);
   pw.print(health);
   pw.flush();
   pw.close();
   sc.close();
     
  }
}