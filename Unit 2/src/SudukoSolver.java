/**
 * SudukoSolver
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Mar 10, 2017
 */

import java.util.*;
import java.io.*;

public class SudukoSolver {

  public static void main(String args[]) {
    // create a n by n matrix
    // populate first row with sorted array of 1-n
    // populate rest of matrix with numbers that can go there
    // Go through the matrix and find the smallest matrix greater than 1 and discard the 1st non 0 element in it

    long startTime = System.nanoTime();
    Scanner sc = new Scanner(System.in);
    int sizeOfMatrix = sc.nextInt();

    SudukoList[][] sudukoMatrix = new SudukoList[sizeOfMatrix][sizeOfMatrix];

    // Creates array of numbers from 1 to n, n = 5, tempArray = [1,2,3,4,5]
    int[] tempArray = new int[sizeOfMatrix];

    for (int i = 0; i < sizeOfMatrix; i++) {
      tempArray[i] = i + 1;
    }
 
    //Populates the matrix with all the variables that can go in a certain space
    for (int row = 0; row<sizeOfMatrix; row++)
    {
      for (int col = 0; col <sizeOfMatrix; col++)
      {
        sudukoMatrix[row][col] = new SudukoList(tempArray,row,col,sizeOfMatrix);
        sudukoMatrix[row][col].setArray();

      }
    }
    
    //System.out.println(Arrays.deepToString(sudukoMatrix));
    
    int eliminationRow = sizeOfMatrix/2;
    int eliminationCol = sizeOfMatrix/2;
    boolean matrixSolved = false;
    
    while(!matrixSolved)
    {
      for (int i = 0; i < sizeOfMatrix; i++)
      {
        if ((sudukoMatrix[eliminationRow][eliminationCol].getsudukoArrayValue(i) != 0) && (matrixElementSafeRemove(eliminationRow,eliminationCol,i,sizeOfMatrix, sudukoMatrix)))
          {
            sudukoMatrix[eliminationRow][eliminationCol].setsudukoArrayValue(i,0);
          };
      }
      
    }

    
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);  //divide by 1000000 to get seconds.
    System.out.println("That took " + duration/(1000000000) + " seconds");
  }

  public static boolean matrixElementSafeRemove(int row, int col, int index, int sizeOfMatrix, SudukoList[][] sudukoMatrix) {
    boolean isSafe = false;
    
    //Checks the Row
    for (int i = 0; i < sizeOfMatrix ; i++){
      if i 
      sudukoMatrix[row][i] 
    }
    
    return isSafe;
  }
}


class SudukoList {
  private int[] sudukoArray;
  private boolean lastElementLeft = false;
  private int row;
  private int col;
  private int sizeOfMatrix;
  private int nonZeroElements;
  private boolean primaryAngleTLtoBR;
  private boolean primaryAngleBLtoTR;


  public SudukoList(int[] tempArray, int Urow, int Ucol, int userSizeOfMatrix) {
    sudukoArray = tempArray.clone();
    row = Urow;
    col = Ucol;
    sizeOfMatrix = userSizeOfMatrix;
    nonZeroElements = sizeOfMatrix;
  }

  public void setsudukoArrayValue(int index, int value) {
    sudukoArray[index] = value;
    nonZeroElements--;
    
  }

  public int getsudukoArrayValue(int index) {
    return sudukoArray[index];
  }

  public void setArray() {
    // Populates first row with only value that coresponds to it's colunm
    if (row == 0) {
      sudukoArray = new int[sizeOfMatrix];
      sudukoArray[col] = col + 1;
      nonZeroElements = 1;
    } else {
      // If not first row, populates element with copy of 1-n list

      // erases 1st element if on primary diagnol going down
      if ((row == col)) {
        // This takes care of the primary angle top left to bottom right
        sudukoArray[0] = 0;
        primaryAngleTLtoBR = true;
        nonZeroElements --;
      }

      // erases last element if on primary diagnol going up
      if (row + col == sizeOfMatrix - 1) {
        // This takes care of primary angle top right to bottom left
        sudukoArray[sizeOfMatrix - 1] = 0;
        primaryAngleBLtoTR = true;
        nonZeroElements --;
      }

      // erases the element that coresponds to col number
      sudukoArray[col] = 0;
      nonZeroElements --;
    }


  }

  public String toString() {
    return Arrays.toString(sudukoArray);
  }
}
