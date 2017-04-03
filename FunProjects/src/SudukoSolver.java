/**
 * SudukoSolver
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Mar 10, 2017
 */

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class SudukoSolver {

  public static void main(String args[]) {
    // create a n by n matrix
    // populate first row with sorted array of 1-n
    // populate rest of matrix with numbers that can go there
    // Go through the matrix and find the smallest matrix greater than 1 and discard the 1st non 0
    // element in it

    long startTime = System.nanoTime();
    Scanner sc = new Scanner(System.in);
    int sizeOfMatrix = sc.nextInt();

    SudukoList[][] sudukoMatrix = new SudukoList[sizeOfMatrix][sizeOfMatrix];


    // Creates array of numbers from 1 to n, n = 5, tempArray = [1,2,3,4,5]
    int[] tempArray = new int[sizeOfMatrix];

    for (int i = 0; i < sizeOfMatrix; i++) {
      tempArray[i] = i + 1;
    }


    // Populates the matrix with all the variables that can go in a certain space
    for (int row = 0; row < sizeOfMatrix; row++) {
      for (int col = 0; col < sizeOfMatrix; col++) {
        sudukoMatrix[row][col] = new SudukoList(tempArray, row, col, sizeOfMatrix);
        sudukoMatrix[row][col].setArray();
        // System.out.println(sudukoMatrix[row][col].toString());

      }
    }

    // System.out.println(Arrays.deepToString(sudukoMatrix));

    int[] rowCol = new int[2];
    int eliminationRow;
    int eliminationCol;
    boolean safeToRemove;
    int hardLimit = 100;

    // System.out.println(Arrays.deepToString(sudukoMatrix));

    while (!isSolved(sudukoMatrix, sizeOfMatrix) && hardLimit > 0) {
      rowCol = bestPosition(sudukoMatrix, sizeOfMatrix);
      eliminationRow = rowCol[0];
      eliminationCol = rowCol[1];

      for (int i = 0; i < sizeOfMatrix; i++) {
        safeToRemove =
            matrixElementSafeToRemove(eliminationRow, eliminationCol, i, sizeOfMatrix, sudukoMatrix);
        System.out.println("Safe to remove: " + safeToRemove);
        System.out.println("Non-zero Elements: "
            + sudukoMatrix[eliminationRow][eliminationCol].getNonZeroElements());
        System.out.println("index: " + i);
        System.out.println("index value: "
            + sudukoMatrix[eliminationRow][eliminationCol].getsudukoArrayValue(i) + "\n");
        if (safeToRemove && sudukoMatrix[eliminationRow][eliminationCol].getNonZeroElements() > 1) {
          System.out.println("I ran");
          sudukoMatrix[eliminationRow][eliminationCol].setsudukoArrayValue(i, 0);
        } else if (sudukoMatrix[eliminationRow][eliminationCol].getNonZeroElements() == 1) {
          removeFromMatrix(eliminationRow, eliminationCol, i, sudukoMatrix, sizeOfMatrix);
        }
      }
      hardLimit--;
    }

    System.out.println(Arrays.deepToString(sudukoMatrix));

    long endTime = System.nanoTime();
    long duration = (endTime - startTime); // divide by 1000000 to get seconds.
    System.out.println("That took " + duration / (1000000000) + " seconds");

  }


  /**
   * This is nice
   * 
   * @param row
   * @param col
   * @param indexInArray
   * @param sizeOfMatrix
   * @param sudukoMatrix
   * @return
   */

  public static boolean matrixElementSafeToRemove(int row, int col, int indexInArray,
      int sizeOfMatrix, SudukoList[][] sudukoMatrix) {
    // Checks to see if there are other instances of the numbers in the row col or primary diagnols,
    // if it lies on one
    boolean isSafe = false;
    boolean isSafeRow = false;
    boolean isSafeCol = false;
    boolean isSafeDiagTLBR = false;
    boolean isSafeDiagBLTR = false;

    int checkColOrRow = 0;
    // Checks the Row
    if (sudukoMatrix[row][col].getNonZeroElements() > 1) {
      while ((checkColOrRow < sizeOfMatrix) && !isSafe) {

        if (sudukoMatrix[row][checkColOrRow].getsudukoArrayValue(indexInArray) == indexInArray
            && checkColOrRow != col) {
          isSafeRow = true;
        }
        if (sudukoMatrix[checkColOrRow][col].getsudukoArrayValue(indexInArray) == indexInArray) {
          isSafeCol = true;
        }

        if ((sudukoMatrix[checkColOrRow][checkColOrRow].getsudukoArrayValue(indexInArray) == indexInArray)
            && checkColOrRow != row) {
          isSafeDiagTLBR = true;
        }


        if ((sudukoMatrix[checkColOrRow][sizeOfMatrix - 1 - checkColOrRow]
            .getsudukoArrayValue(indexInArray) == indexInArray) && checkColOrRow != row) {
          isSafeDiagBLTR = true;

        }

        checkColOrRow++;

        isSafe = (isSafeRow && isSafeCol);

        if (sudukoMatrix[row][col].isPrimaryAngleTLtoBR()) {
          // System.out.println(isSafe);
          // System.out.println(isSafeDiagTLBR);

          isSafe = (isSafe && isSafeDiagTLBR);

          // System.out.println(isSafe);
        }

        if (sudukoMatrix[row][col].isPrimaryAngleBLtoTR()) {
          isSafe = (isSafe && isSafeDiagBLTR);
        }

      }
    }

    return isSafe;
  }

  public static boolean isSolved(SudukoList[][] sudukoMatrix, int sizeOfMatrix) {
    // Checks to see if any element in the array has more than one element
    boolean isSolved = true;
    int row = 0;
    int col = 0;

    while (isSolved && row < sizeOfMatrix) {
      while (isSolved && col < sizeOfMatrix) {
        if (!sudukoMatrix[row][col].isLastElementLeft()) {
          isSolved = false;
        }
        col++;
      }
      row++;
    }
    return isSolved;
  }

  public static int[] bestPosition(SudukoList[][] sudukoMatrix, int sizeOfMatrix) {
    int[] rowCol = new int[2];
    int minLowestNonZeroElements = sizeOfMatrix + 1;
    int nonZeroElements;
    int index;

    for (int row = 0; row < sizeOfMatrix; row++) {
      for (int col = 0; col < sizeOfMatrix; col++) {
        // Checks to see if it is the lowest number of possible elements and that it is not solved
        // yet
        nonZeroElements = sudukoMatrix[row][col].getNonZeroElements();
        if (nonZeroElements < minLowestNonZeroElements
            && !sudukoMatrix[row][col].isLastElementLeft() && nonZeroElements > 1) {
          rowCol[0] = row;
          rowCol[1] = col;
        }

      }
    }
    return rowCol;
  }

  public static void removeFromMatrix(int row, int col, int index, SudukoList[][] sudukoMatrix,
      int sizeOfMatrix) {
    // Removes values in rows and colunms and diagnols
    for (int i = 0; i < sizeOfMatrix; i++) {
      if (i != row && i != col) {
        sudukoMatrix[i][col].setsudukoArrayValue(index, 0);
      }
      if (i != col) {
        sudukoMatrix[row][i].setsudukoArrayValue(index, 0);
      }
      if (sudukoMatrix[row][col].isPrimaryAngleTLtoBR() && i != row) {
        sudukoMatrix[i][i].setsudukoArrayValue(index, 0);
      }
      if (sudukoMatrix[row][col].isPrimaryAngleBLtoTR() && i != row) {
        sudukoMatrix[i][sizeOfMatrix - 1 - i].setsudukoArrayValue(index, 0);
      }
    }
    sudukoMatrix[row][col].setLastElementLeft();
  }
}
