import static org.junit.Assert.*;

import org.junit.Test;


public class ProblemJ2_2005Test {

  @Test
  public void test() {
    assertEquals(ProblemJ2_2005.findrsa(10, 0),1);
    assertEquals(ProblemJ2_2005.findrsa(0, 0),0);
    assertEquals(ProblemJ2_2005.findrsa(10, 1),2);
    assertEquals(ProblemJ2_2005.findrsa(5, 0),0);
    assertEquals(ProblemJ2_2005.findrsa(12, 0),0);
    assertEquals(ProblemJ2_2005.findrsa(1, 0),0);
    assertEquals(ProblemJ2_2005.findrsa(1, 1),1);
    assertEquals(ProblemJ2_2005.findrsa(15, 0),1);
  }

}
