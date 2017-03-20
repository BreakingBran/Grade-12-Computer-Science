import static org.junit.Assert.*;

import org.junit.Test;


public class isDistinctYearTest {

  @Test
  public void test() {
    assertEquals(isDistinctYear.isDistinctYearCheck("1234"),true);
    assertEquals(isDistinctYear.isDistinctYearCheck("1224"),false);
    assertEquals(isDistinctYear.isDistinctYearCheck("1"),true);
    assertEquals(isDistinctYear.isDistinctYearCheck("1001"),false);
    assertEquals(isDistinctYear.isDistinctYearCheck("0123456789"),true);
    assertEquals(isDistinctYear.isDistinctYearCheck("0"),true);
    assertEquals(isDistinctYear.isDistinctYearCheck("000000000"),false);
    assertEquals(isDistinctYear.isDistinctYearCheck("9876543210"),true);
    assertEquals(isDistinctYear.isDistinctYearCheck("11"),false);
    assertEquals(isDistinctYear.isDistinctYearCheck("123"),true);
    assertEquals(isDistinctYear.isDistinctYearCheck("10"),true);
  }

}
