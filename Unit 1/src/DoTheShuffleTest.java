import static org.junit.Assert.*;

import org.junit.Test;


public class DoTheShuffleTest {

  @Test
  public void test() {
    char[] shuffleList = {'A','B','C','D','E'};
    char[] button1Result = {'B','C','D','E','A'};
    DoTheShuffle.button1(shuffleList,1);
    assertArrayEquals( button1Result, shuffleList);
   
  }

}
