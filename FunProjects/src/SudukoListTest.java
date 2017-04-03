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
