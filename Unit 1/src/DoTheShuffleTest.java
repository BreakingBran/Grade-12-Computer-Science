import static org.junit.Assert.*;

import org.junit.Test;


public class DoTheShuffleTest {

  @Test
  public void test() {

    // Button 1 pushes first element to end of array
    char[] shuffleList = {'A', 'B', 'C', 'D', 'E'};
    char[] button1Result = {'B', 'C', 'D', 'E', 'A'};
    DoTheShuffle.button1(shuffleList, 1);
    assertArrayEquals(button1Result, shuffleList);

    shuffleList = new char[] {'A', 'B', 'C', 'D', 'E'};
    button1Result = new char[] { 'C', 'D', 'E', 'A', 'B'};
    DoTheShuffle.button1(shuffleList, 2);
    assertArrayEquals(button1Result, shuffleList);

    // Button 2 pushes last element to beginning of array
    shuffleList = new char[] {'A', 'B', 'C', 'D', 'E'};
    char[] button2Result = {'E', 'A', 'B', 'C', 'D'};
    DoTheShuffle.button2(shuffleList, 1);
    assertArrayEquals(button2Result, shuffleList);
    
    shuffleList = new char[] {'A', 'B', 'C', 'D', 'E'};
    button2Result = new char[] { 'D', 'E', 'A', 'B','C'};
    DoTheShuffle.button1(shuffleList, 2);
    assertArrayEquals(button1Result, shuffleList);


    // Button 3 switch first two elements of array
    shuffleList = new char[] {'A', 'B', 'C', 'D', 'E'};
    char[] button3Result = {'B', 'A', 'C', 'D', 'E'};
    DoTheShuffle.button3(shuffleList, 1);
    assertArrayEquals(button3Result, shuffleList);
    
    shuffleList = new char[] {'A', 'B', 'C', 'D', 'E'};
    button3Result = new char[] { 'A', 'B', 'C', 'D','E'};
    DoTheShuffle.button1(shuffleList, 2);
    assertArrayEquals(button1Result, shuffleList);


  }

}
