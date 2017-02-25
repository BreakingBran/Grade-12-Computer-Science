import java.util.*;
import java.io.*;

public class FileIOExample
{
  public static void main(String args[]) throws Exception
  {
    // Read weight and height
    //Scanner sc = new Scanner(System.in);
	Scanner sc = new Scanner(new FileReader("input.txt"));
	    
	// Output to file
	//PrintWriter pw = new PrintWriter(System.out);
	PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

    pw.print("Enter Weight:");
    double weight = sc.nextDouble();
    double height = sc.nextDouble();
    
    // Calculate BMI
    double bmi = weight / (height*height);
         
    // Determine weight level  
    if (bmi > 25)
    {
      pw.println("Overweight");
    }
    else if (bmi < 25 && bmi > 18.5) // OR is ||
    {
    	pw.println("blah");
    }
    else
    {
    	pw.println("blah 7665");
    }
    
    pw.flush();
    pw.close();
    
  }
}

