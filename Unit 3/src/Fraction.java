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
  // declares the value of the numerator and denominator
  private int numerator;
  private int denominator;

  public Fraction(int n, int d) {
    // intitalizes the variables
    this.numerator = n;
    this.denominator = d;
  }

  public Fraction(int n) {
    // Another method of initializing, if denom equals 1
    this(n, 1);
  }

  public String toString() {
    //prints out the numerator / denominator
    return ("(" + this.numerator + "/" + this.denominator + ")");
  }

  public int getNumerator() {
    // getter for nume
    return numerator;
  }

  public int getDenominator() {
    // getter for denom
    return denominator;
  }

  public void setDenominator(int denominator) {
    // setter for denom
    this.denominator = denominator;
  }

  public void setNumerator(int numerator) {
    // setter for nume
    this.numerator = numerator;
  }

  public Fraction multiply(Fraction num2) {
    // just multiplies the numerators and denominator of each respective fraction
    // and returns new fraction which is product
    int newNumerator = this.numerator * num2.numerator;
    int newDenominator = this.denominator * num2.denominator;
    Fraction newFraction = new Fraction(newNumerator, newDenominator);
    return newFraction;
  }

  public Fraction divide(Fraction num2) {
    // just multiplies the initial fraction by the recipricol of the second
    int newNumerator = this.numerator * num2.denominator;
    int newDenominator = this.denominator * num2.numerator;
    Fraction newFraction = new Fraction(newNumerator, newDenominator);
    return newFraction;
  }

  public Fraction add(Fraction num2) {
    //sets both fractions to same denominator
    //adds them both, then divides by GCF
    int newNumerator = this.numerator * num2.denominator + this.denominator * num2.numerator;
    int newDenominator = this.denominator * num2.denominator;
    int greatestCommonFactor = GCF(newNumerator, newDenominator);
    newNumerator = newNumerator / greatestCommonFactor;
    newDenominator = newDenominator / greatestCommonFactor;
    Fraction newFraction = new Fraction(newNumerator, newDenominator);
    return newFraction;

  }

  public Fraction subtract(Fraction num2) {
    //Does same as add fnction but subtracts
    int newNumerator = this.numerator * num2.denominator - this.denominator * num2.numerator;
    int newDenominator = this.denominator * num2.denominator;
    int greatestCommonFactor = GCF(newNumerator, newDenominator);
    newNumerator = newNumerator / greatestCommonFactor;
    newDenominator = newDenominator / greatestCommonFactor;
    Fraction newFraction = new Fraction(newNumerator, newDenominator);
    return newFraction;
  }

  public Fraction power(int power) {
    //raises both numerator and denominator to the power
    int newNumerator = (int) Math.pow(this.numerator, power);
    int newDenominator = (int) Math.pow(this.denominator, power);
    Fraction newFraction = new Fraction(newNumerator, newDenominator);
    return newFraction;
  }

  private int GCF(int a, int b) {
    //Finds the greatest common factor of both numbers
    //Copied from Stack Overflow User: BreakingBran
    if (b == 0)
      return Math.abs(a);
    else
      return (GCF(b, a % b));
  }

}
