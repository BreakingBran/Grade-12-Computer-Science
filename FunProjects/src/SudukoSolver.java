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
    
   while(!isSolved(sudukoMatrix,sizeOfMatrix))
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
  
  public static boolean matrixElementSafeRemove(int row, int col, int indexInArray, int sizeOfMatrix, SudukoList[][] sudukoMatrix) {
    //Checks to see if there are other instances of the numbers in the row col or primary diagnols, if it lies on one
    boolean isSafe = true;
    int checkColOrRow = 0;
    //Checks the Row
    if (sudukoMatrix[row][col].getNonZeroElements() > 1){
      while ((checkColOrRow < sizeOfMatrix) && isSafe){
      
      if (sudukoMatrix[row][checkColOrRow].getsudukoArrayValue(indexInArray) == 0 || sudukoMatrix[checkColOrRow][col].getsudukoArrayValue(indexInArray) == 0){
        isSafe = false;       
      }
      if (sudukoMatrix[row][checkColOrRow].isPrimaryAngleTLtoBR()){
        if ((sudukoMatrix[checkColOrRow][checkColOrRow].getsudukoArrayValue(indexInArray) == 0)){
          isSafe = false;   
        }        
      }
      if (sudukoMatrix[row][checkColOrRow].isPrimaryAngleBLtoTR()){
        if ((sudukoMatrix[checkColOrRow][sizeOfMatrix-1-checkColOrRow].getsudukoArrayValue(indexInArray) == 0)){
          isSafe = false;   
        }
      }
      checkColOrRow++;
    }
    }
    else
      isSafe = false;
    return isSafe;
  }
  
  public static boolean isSolved(SudukoList[][] sudukoMatrix, int sizeOfMatrix)
  {
    //Checks to see if any element in the array has more than one element
    boolean isSolved = true;
    int row = 0;
    int col = 0;
    
    while(isSolved && row < sizeOfMatrix){
      while(isSolved && col < sizeOfMatrix){
        if (!sudukoMatrix[row][col].isLastElementLeft()){
          isSolved = false;
        }
        col++;
      }
      row++;
    }
    return isSolved;
  }
}



