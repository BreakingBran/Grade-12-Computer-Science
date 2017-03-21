import static org.junit.Assert.*;

import org.junit.Test;


public class GPSTest {

  @Test
  public void test() {

    for (int j = 0; j < 100; j++) {
      if ((j == 65)) {
        for (int i = 65; i < 91; i++) {
          assertEquals(GPS.charToIndexValue(i), i - 65);
        }
        j = 90;
      } else if (j == 32) {
        assertEquals(GPS.charToIndexValue(32), 32 - 6);
      } else if (j == 32) {
        assertEquals(GPS.charToIndexValue(45), 45 - 18);
      } else if (j == 32) {
        assertEquals(GPS.charToIndexValue(46), 46 - 18);
      } 
    }
  }

}
