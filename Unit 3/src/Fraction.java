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
    this(n, 1);
  }

  public String toString() {
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

  public Fraction multiply(Fraction num2) {
    int newNumerator = this.numerator * num2.numerator;
    int newDenominator = this.denominator * num2.denominator;
    Fraction newFraction = new Fraction(newNumerator, newDenominator);
    return newFraction;
  }

  public Fraction divide(Fraction num2) {
    int newNumerator = this.numerator * num2.denominator;
    int newDenominator = this.denominator * num2.numerator;
    Fraction newFraction = new Fraction(newNumerator, newDenominator);
    return newFraction;
  }

  public Fraction add(Fraction num2) {
    int newNumerator = this.numerator * num2.denominator + this.denominator * num2.numerator;
    int newDenominator = this.denominator * num2.denominator;
    int greatestCommonFactor = GCF(newNumerator,newDenominator);
    newNumerator = newNumerator/greatestCommonFactor;
    newDenominator = newDenominator/greatestCommonFactor;
    Fraction newFraction = new Fraction(newNumerator, newDenominator);
    return newFraction;

  }
  
  public Fraction subtract (Fraction num2) {
    int newNumerator = this.numerator * num2.denominator - this.denominator * num2.numerator;
    int newDenominator = this.denominator * num2.denominator;
    int greatestCommonFactor = GCF(newNumerator,newDenominator);
    newNumerator = newNumerator/greatestCommonFactor;
    newDenominator = newDenominator/greatestCommonFactor;
    Fraction newFraction = new Fraction(newNumerator, newDenominator);
    return newFraction;
  }
  
  public Fraction power (int power) {
    int newNumerator = (int) Math.pow(this.numerator, power);
    int newDenominator = (int) Math.pow(this.denominator,power);
    Fraction newFraction = new Fraction(newNumerator, newDenominator);
    return newFraction;
  }

  private int GCF(int a, int b) {
    if (b == 0)
      return Math.abs(a);
    else
      return (GCF(b, a % b));
  }

}
