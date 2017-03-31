import static org.junit.Assert.*;
import java.io.*;
//import java.util.*;
import org.junit.Test;


public class FractionTest {

  Fraction f1 = new Fraction(3, 4);
  // System.out.println(f1);

  Fraction f2 = new Fraction(1, 2);

  @Test
  public void testMultiply() {
    // Multiply f2 by f1
    Fraction f5 = f2.multiply(f1);
    assertEquals(f5.toString(), "(3/8)");
  }

  @Test
  public void testDivide() {
    // Divide f2 by f1
    Fraction f6 = f2.divide(f1);
    assertEquals(f6.toString(), "(4/6)");
  }

  @Test
  public void testAdd() {
    // Add f2 by f1
    Fraction f4 = f2.add(f1);
    assertEquals(f4.toString(), "(5/4)");
  }

  @Test
  public void testSubtract() {
    // Subtract f2 by f1
    Fraction f3 = f2.subtract(f1);
    assertEquals(f3.toString(), "(-1/4)");
  }

  @Test
  public void testPower() {
    // Place f2 to the power 2
    Fraction f7 = f2.power(2);
    assertEquals(f7.toString(), "(1/4)");
  }

}
