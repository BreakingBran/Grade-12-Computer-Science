/**
 * Fraction
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Mar 27, 2017
 */

import java.util.*;
import java.io.*;

public class Fraction {
  
  private int numerator;
  private int denominator;
  
  public Fraction(int n, int d) {
    this.numerator = n;
    this.denominator = d;
  }
  
  public Fraction(int n) {
    this(n,1);
  }
  
  public String toString(){
    return (this.numerator + "/" + this.denominator);
  }
  
  public int getNumerator() {
    return numerator;
  }
  public int getDenominator() {
    return denominator;
  }
  public void setDenominator(int denominator) {
    this.denominator = denominator;
  }
  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }
  
  public Fraction multiply (Fraction num2)
  {
    int newNumerator = this.numerator * 1;
    Fraction newFraction = new Fraction(newNumerator);
    return newFraction;
  }
  
}
