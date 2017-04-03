/**
 * SudukoSolverTest
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Apr 2, 2017
 */

import java.util.*;
import java.io.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class SudukoSolverTest {

  int sizeOfMatrix = 5;
  SudukoList[][] sudukoMatrix = new SudukoList[sizeOfMatrix][sizeOfMatrix];

  @Test
  public void testmatrixElementSafeRemove() {

    for (int sizeOfMatrixCounter = 1; sizeOfMatrixCounter < 5; sizeOfMatrixCounter++) {
      int[] tempArray = new int[sizeOfMatrix];

      for (int i = 0; i < sizeOfMatrix; i++) {
        tempArray[i] = i + 1;
      }

      for (int row = 0; row < sizeOfMatrix; row++) {
        for (int col = 0; col < sizeOfMatrix; col++) {
          sudukoMatrix[row][col] = new SudukoList(tempArray, row, col, sizeOfMatrix);
          sudukoMatrix[row][col].setArray();

        }

      }
      for (int col = 0; col < sizeOfMatrix; col++) {
        assertEquals(SudukoSolver.matrixElementSafeToRemove(0, col, 0, sizeOfMatrix, sudukoMatrix),
            false);
        

        assertEquals(SudukoSolver.isSolved(sudukoMatrix, sizeOfMatrixCounter), false);
      }
    }
  }
}
