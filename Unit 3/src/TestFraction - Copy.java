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

    Fraction f1 = new Fraction(3, 4);
    //System.out.println(f1);

    Fraction f2 = new Fraction(1, 2);

    // Subtract f2 by f1
    Fraction f3 = f2.subtract(f1);
    System.out.println(f2.toString() + " - " + f1.toString() + " = " + f3);

    // Add f2 by f1
    Fraction f4 = f2.add(f1);
    System.out.println(f2 + " + " + f1 + " = " + f4);

    // Multiply f2 by f1
    Fraction f5 = f2.multiply(f1);
    System.out.println(f2 + " x " + f1 + " = " + f5);

    // Divide f2 by f1
    Fraction f6 = f2.divide(f1);
    System.out.println(f2 + " / " + f1 + " = " + f6);

    // Place f2 to the power 2
    Fraction f7 = f2.power(2);
    System.out.println(f2 + "^2 " + " = " + f7);


  }
}
