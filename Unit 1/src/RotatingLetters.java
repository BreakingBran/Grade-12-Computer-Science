import java.util.*;
import java.io.*;

public class RotatingLetters {
  public static void main(String args[])
  {
    //Defines array of special characters that sign needs to consisit of
    char[] rotatable = new char[] {'I','O','S','H','Z','X','N'};
    
    Scanner sc = new Scanner(System.in);
    String sign = sc.next();
    boolean isRotatable = true;    
    
    //turns the user input to array of chars
    char[] signArray = sign.toCharArray();
    
    //declares two sets that will hold the values of the two arrays
    Set<Character> original = new HashSet<Character>();
    Set<Character> comparison = new HashSet<Character>();
    
    //holds distinct set values of special array rotatable
    for (char x: rotatable){
      original.add(x);
    }
    
    //holds distinct set of values from user input, no repeats
    for (char x: signArray){
      comparison.add(x);
    }
    
    //Use built in to see that user inputs set only consists of chars from special char array
    isRotatable = original.containsAll(comparison);
    
    
    if (isRotatable){
      System.out.println("YES");
    }else{
      System.out.println("NO");
    }
  }
}
