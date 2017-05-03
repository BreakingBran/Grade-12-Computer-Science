/**
 * SudukoSolver
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Mar 10, 2017
 */

import java.io.IOException;
import java.util.*;


public class SudukoSolver { // BEGINING OF MAIN FUNCTION
  

  public static void main(String args[]) throws IOException{
    // create a n by n matrix
    // populate first row with sorted array of 1-n
    // populate rest of matrix with numbers that can go there
    // Go through the matrix and find the smallest matrix greater than 1 and discard the 1st non 0
    // element in it

    // Just for timing

    // Stuff not necessary for solve class
    Scanner sc = new Scanner(System.in);
    int sizeOfMatrix = sc.nextInt();
    SudukoList[][] sudukoMatrix = solve(sc,sizeOfMatrix);

    // Stuff Necessary For solve class
    long startTime = System.nanoTime();
    
    printSusukoMatrix(sizeOfMatrix, sudukoMatrix);
    concludingPrintsToConsole(sudukoMatrix, sizeOfMatrix, startTime);
    sc.close();
  }
  
  public static SudukoList[][] solve(Scanner sc, int sizeOfMatrix) {

    // Gets size of matrix and creates a n by n matrix
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
      }
    }

    int[] rowCol = new int[2];
    int eliminationRow;
    int eliminationCol;
    boolean safeToRemove;
    long hardLimit = 10000;
    boolean isNonZeroIndex;

    /*
     * While the matrix is not solved and the hardlimit of 100 moves is not reached main loop for
     * removing matrix and solving matrix
     */
    while (!isSolved(sudukoMatrix, sizeOfMatrix) && hardLimit > 0) {

      /**
       * So we need to find a way to delete the single list elements before linearlly doing anything
       * else
       */

      // array of two ints [row,col] with best row and col to remove
      rowCol = bestPosition(sudukoMatrix, sizeOfMatrix);
      eliminationRow = rowCol[0];
      eliminationCol = rowCol[1];

      for (int i = 0; i < sizeOfMatrix; i++) {
        safeToRemove =
            matrixElementSafeToRemove(eliminationRow, eliminationCol, i, sizeOfMatrix, sudukoMatrix);
        isNonZeroIndex = sudukoMatrix[eliminationRow][eliminationCol].getsudukoArrayValue(i) != 0;
        if (!isNonZeroIndex) {
          continue;
        }
        /*
         * System.out.println("Safe to remove: " + safeToRemove);
         * System.out.println("Non-zero Elements: " +
         * sudukoMatrix[eliminationRow][eliminationCol].getNonZeroElements());
         * System.out.println("row: " + eliminationRow); System.out.println("col: " +
         * eliminationCol); System.out.println("index: " + i); System.out.println("index value: " +
         * sudukoMatrix[eliminationRow][eliminationCol].getsudukoArrayValue(i) + "\n");
         */
        if (safeToRemove && sudukoMatrix[eliminationRow][eliminationCol].getNonZeroElements() > 1) {
          // System.out.println("I ran");
          sudukoMatrix[eliminationRow][eliminationCol].setsudukoArrayValue(i, 0);
        } else if (sudukoMatrix[eliminationRow][eliminationCol].getNonZeroElements() == 1) {
          // System.out.println("I deleted");
          removeFromMatrix(eliminationRow, eliminationCol, i, sudukoMatrix, sizeOfMatrix);
        }
      }
      hardLimit--;
      //printSusukoMatrix(sizeOfMatrix,sudukoMatrix);
    }

    // System.out.println(Arrays.deepToString(sudukoMatrix));
    return sudukoMatrix;
  }

  public static void concludingPrintsToConsole(SudukoList[][] sudukoMatrix, int sizeOfMatrix,
      long startTime) {
    boolean isSolved = checkIfCorrect(sudukoMatrix, sizeOfMatrix);
    long endTime = System.nanoTime();
    long duration = (endTime - startTime); // divide by 1000000 to get seconds.
    System.out.println("That took " + duration / (1000000000)
        + " seconds and the matrix is Solved: " + isSolved);

    // END OF THE MAIN FUNCTION
    // TODO Auto-generated method stub

  }

  public static void printSusukoMatrix(int sizeOfMatrix, SudukoList[][] sudukoMatrix) {
    // TODO Auto-generated method stub
    for (int row = 0; row < sizeOfMatrix; row++) {
      for (int col = 0; col < sizeOfMatrix; col++) {
        if (sudukoMatrix[row][col].getValueOfLastIndex() != -1) {
          System.out.print(sudukoMatrix[row][col].getValueOfLastElement() + " ");
        } else {
          System.out.print(sizeOfMatrix + 1 + " ");
        }
      }
      System.out.println("");
    }
    System.out.println("");

  }



  /**
   * This determines if the chosen index in the (row,col) of the suduko matrix is safe to remove by
   * checking if another value that is equal to it exists in the row and colunm that it exists in if
   * on primary diagnols, it also checks those
   * 
   * @param row int row index that is being considred to remove
   * @param col int col index that is being considred to remove
   * @param indexInArray int of the index in the array being considred to be removed
   * @param sizeOfMatrix
   * @param sudukoMatrix
   * @return if it is safe or not to remove the variable
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

        if (sudukoMatrix[row][checkColOrRow].getsudukoArrayValue(indexInArray) == indexInArray + 1
            && checkColOrRow != col) {
          isSafeRow = true;
        }
        if (sudukoMatrix[checkColOrRow][col].getsudukoArrayValue(indexInArray) == indexInArray + 1) {
          isSafeCol = true;
        }

        if ((sudukoMatrix[checkColOrRow][checkColOrRow].getsudukoArrayValue(indexInArray) == indexInArray + 1)
            && checkColOrRow != row) {
          isSafeDiagTLBR = true;
        }


        if ((sudukoMatrix[checkColOrRow][sizeOfMatrix - 1 - checkColOrRow]
            .getsudukoArrayValue(indexInArray) == indexInArray + 1) && checkColOrRow != row) {
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

  /**
   * Checks to see if the matrix is solved by looping through all the elements in the array looking
   * for an element that has more than 1 non-zero element in it.
   * 
   * @param sudukoMatrix is the nxn matrix where all the values are stored
   * @param sizeOfMatrix is the size of n
   * @return if the matrix is solved or not
   */
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
      col = 0;
      row++;
    }
    return isSolved;
  }

  /**
   * Finds best position in nxn matrix to remove. Does this by finding element in matrix with
   * shortest amount of elements that is not the last possible element possible in the array
   * 
   * @param sudukoMatrix is the nxn matrix where all the values are stored
   * @param sizeOfMatrix is the size of n
   * @return returns an array of two ints where the first element is the row to remove and second
   *         element is the colunm to remove
   */
  public static int[] bestPosition(SudukoList[][] sudukoMatrix, int sizeOfMatrix) {
    int[] rowCol = new int[2];
    int minLowestNonZeroElements = sizeOfMatrix + 1;
    int nonZeroElements;
    // int index;

    // Row starts at 1 because nothing from row 1 should ever be removed
    for (int row = 1; row < sizeOfMatrix; row++) {
      for (int col = 0; col < sizeOfMatrix; col++) {
        // Checks to see if it is the lowest number of possible elements and that it is not solved
        // yet
        nonZeroElements = sudukoMatrix[row][col].getNonZeroElements();
        if (nonZeroElements < minLowestNonZeroElements
            && !sudukoMatrix[row][col].isLastElementLeft()) {
          minLowestNonZeroElements = sudukoMatrix[row][col].getNonZeroElements();
          rowCol[0] = row;
          rowCol[1] = col;
        }

      }
    }
    return rowCol;
  }

  /**
   * Deletes selected index from all arrays in same colunm, row and diagnol if on primary diagnol
   * 
   * @param row
   * @param col
   * @param index
   * @param sudukoMatrix
   * @param sizeOfMatrix
   */
  public static void removeFromMatrix(int row, int col, int index, SudukoList[][] sudukoMatrix,
      int sizeOfMatrix) {
    // Removes values in rows and colunms and diagnols
    for (int i = 0; i < sizeOfMatrix; i++) { // FIXX THIS IT IS BROOKEN AS FUCK
      if (i != row) {
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

  public static boolean checkIfCorrect(SudukoList[][] sudukoMatrix, int sizeOfMatrix) {
    /*
     * boolean isRowCorrect = true; boolean isColCorrect = true; boolean isDiagUDCorrect = true;
     * boolean isDiagDUCorrect = true;
     */
    boolean isCorrect = true;
    int[] rowFrequency = new int[sizeOfMatrix];
    int[] colFrequency = new int[sizeOfMatrix];
    int[] DiagUPFrequency = new int[sizeOfMatrix];
    int[] DiagDUFrequency = new int[sizeOfMatrix];
    for (int row = 0; row < sizeOfMatrix; row++) {
      for (int col = 0; col < sizeOfMatrix; col++) {
        // This checks row by row for proper frequency
        rowFrequency[sudukoMatrix[row][col].getValueOfLastIndex()] += 1;

        // this checks col by colunm for proper frequency
        colFrequency[sudukoMatrix[col][row].getValueOfLastIndex()] += 1;

        // Checks if any value frequency greater than 1, if true, returns matrix is false
        if (rowFrequency[sudukoMatrix[row][col].getValueOfLastIndex()] > 1
            || colFrequency[sudukoMatrix[col][row].getValueOfLastIndex()] > 1) {
          isCorrect = false;
          break;
        }

      }
      // does frequency anlaysis on primary angle top left to bottom right
      for (int i = 0; i < sizeOfMatrix; i++) {
        if (rowFrequency[i] != 1 || colFrequency[i] != 1) {
          isCorrect = false;
          break;
        }
      }
      rowFrequency = new int[sizeOfMatrix];
      colFrequency = new int[sizeOfMatrix];
      DiagUPFrequency[sudukoMatrix[row][row].getValueOfLastIndex()] += 1;
      DiagDUFrequency[sudukoMatrix[row][sizeOfMatrix - 1 - row].getValueOfLastIndex()] += 1;

    }
    for (int i = 0; i < sizeOfMatrix; i++) {
      if (DiagUPFrequency[i] != 1 || DiagDUFrequency[i] != 1) {
        isCorrect = false;
      }
    }

    return isCorrect;
  }
}
