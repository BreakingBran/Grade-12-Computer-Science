/**
 * TestFraction
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Mar 27, 2017
 */

import java.util.*;
import java.io.*;

public class TestFraction {
  
  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);

    Fraction f1 = new Fraction(3,4);
    System.out.println(f1);
    
    Fraction f2 = new Fraction(1,2);
    
    Fraction f3 =  f2.subtract(f1);
    System.out.println(f3);


  }
}
