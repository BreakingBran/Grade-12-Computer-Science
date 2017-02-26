import java.util.*;
import java.io.*;

public class RotatingLetters {
  public static void main(String args[])
  {
    char[] rotatable = new char[] {'I','O','S','H','Z','X','N'};
    Scanner sc = new Scanner(System.in);
    
    String sign = sc.next();
    
    boolean isRotatable = true;    
    char[] signArray = sign.toCharArray();
    
    Set<Character> original = new HashSet<Character>();
    Set<Character> comparison = new HashSet<Character>();
    
    for (char x: rotatable){
      original.add(x);
    }
    
    for (char x: signArray){
      comparison.add(x);
    }
    
    isRotatable = original.containsAll(comparison);
    
    
    if (isRotatable){
      System.out.println("YES");
    }else{
      System.out.println("NO");
    }
  }
}
