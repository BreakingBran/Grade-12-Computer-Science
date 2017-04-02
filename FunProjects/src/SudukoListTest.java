/**
 * SudukoListTest
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Apr 1, 2017
 */

import java.util.*;
import java.io.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

/*
 * public class SudukoListTest {
 * 
 * 
 * @Test public void testSetArray() { int sizeOfMatrix = 5; int[] tempArray = new int[sizeOfMatrix];
 * 
 * for (int i = 0; i < sizeOfMatrix; i++) { tempArray[i] = i + 1; }
 * 
 * int[] tempArrayClone = tempArray.clone(); // Establishes four corners SudukoList topLeft = new
 * SudukoList(tempArray, 0, 0, sizeOfMatrix); SudukoList botLeft = new SudukoList(tempArray,
 * sizeOfMatrix - 1, 0, sizeOfMatrix); SudukoList topRight = new SudukoList(tempArray, 0,
 * sizeOfMatrix - 1, sizeOfMatrix); SudukoList botRight = new SudukoList(tempArray, sizeOfMatrix -
 * 1, sizeOfMatrix - 1, sizeOfMatrix); SudukoList[] corners = {topLeft, botLeft, botRight,
 * topRight};
 * 
 * // Checks the corners and makes sure they only have one element in them topLeft.setArray();
 * topRight.setArray();
 * 
 * assertEquals(topLeft.getNonZeroElements(), 1); assertEquals(topRight.getNonZeroElements(), 1);
 * 
 * 
 * for (int i = 0; i < 4; i++) { tempArrayClone = tempArray.clone();
 * assertArrayEquals(corners[i].getsudukoArray(), tempArray); corners[i].setArray();
 * tempArrayClone[i] = 0; System.out.println(Arrays.toString(tempArrayClone));
 * System.out.println(Arrays.toString(corners[i].getsudukoArray()));
 * assertArrayEquals(corners[i].getsudukoArray(), tempArrayClone); // tempArrayModifiable[] }
 * 
 * // Hello if (sizeOfMatrix >= 3) { SudukoList primaryAngelNegativeSlope = new
 * SudukoList(tempArray, 1, 1, sizeOfMatrix); SudukoList primaryAngelPositiveSlope = new
 * SudukoList(tempArray, -2, 1, sizeOfMatrix); }
 * 
 * }
 * 
 * }
 */

public class SudukoListTest {


  @Test
  public void testSetArray() {

    int[] tempArrayClone;
    
    for (int sizeOfMatrixCounter = 0; sizeOfMatrixCounter < 5; sizeOfMatrixCounter++) {

      
      int[] tempArray = new int[sizeOfMatrixCounter];

      for (int i = 0; i < sizeOfMatrixCounter; i++) {
        tempArray[i] = i + 1;
      }
      
      
      SudukoList[][] SudukoMatrix = new SudukoList[sizeOfMatrixCounter][sizeOfMatrixCounter];
      
      for (int row = 0; row < sizeOfMatrixCounter; row++) {
        for (int col = 0; col < sizeOfMatrixCounter; col++) {
          
          SudukoMatrix[row][col] = new SudukoList(tempArray, row, col, sizeOfMatrixCounter);
          assertArrayEquals(SudukoMatrix[row][col].getsudukoArray(), tempArray);
          SudukoMatrix[row][col].setArray();
          //System.out.println(SudukoMatrix[row][col].toString());
          //System.out.println(sizeOfMatrixCounter);
          if (row == 0)
          {
            tempArrayClone = new int[sizeOfMatrixCounter];
            tempArrayClone[col] = col+1;
            assertArrayEquals(SudukoMatrix[row][col].getsudukoArray(), tempArrayClone);
            assertEquals(SudukoMatrix[row][col].getNonZeroElements(), 1);
          }
          else if ( (row == col ) && (row == sizeOfMatrixCounter - 1 - col) ){
            
            assertEquals(SudukoMatrix[row][col].getNonZeroElements(),sizeOfMatrixCounter-3);
          }
          else if ( (row == col ) || (row == sizeOfMatrixCounter - 1 - col) ){
            assertEquals(SudukoMatrix[row][col].getNonZeroElements(),sizeOfMatrixCounter-2);
          }
          
        }
      }
      
      SudukoMatrix = null;

    }
  }
}
