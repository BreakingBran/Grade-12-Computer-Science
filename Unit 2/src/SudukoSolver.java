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
    

    Scanner sc = new Scanner(System.in);
    int sizeOfMatrix = sc.nextInt();
    long startTime = System.nanoTime();
    
    //Creates array of numbers from 1 to n, n = 5, tempArray = [1,2,3,4,5]
    int[] tempArray = new int[sizeOfMatrix];
    for (int i = 0; i < sizeOfMatrix; i++)
    {
      tempArray[i] = i+1;
    }
    
    // Initializes a matrix that is three dimensional
    int[][][] sudukoMatrix = new int[sizeOfMatrix][sizeOfMatrix][];
    
//    //Creates the array that will be used to fill first row
//    int[] firstRowValues = new int[sizeOfMatrix];
//    
//    for (int i = 0; i < sizeOfMatrix ; i++)
//    {
//      firstRowValues = 
//      sudukoMatrix[0][1] = 
//    }
    
    //Populates the matrix with all the variables that can go in a certain space
    for (int row = 0; row<sizeOfMatrix; row++)
    {
      for (int col = 0; col <sizeOfMatrix; col++)
      {
        sudukoMatrix[row][col] = tempArray;
        if (row == 0)
        {
          sudukoMatrix[0][col] = new int[sizeOfMatrix];
          sudukoMatrix[0][col][col] = col+1;
        }
        
        else if ((row == col))
        {
          //This takes care of the primary angle top left to bottom right
          sudukoMatrix[row][col][0] = 0;
        }
        else if (sizeOfMatrix + row == sizeOfMatrix - col)
        {
          //This takes care of primary angle top right to bottom left
          sudukoMatrix[row][col][sizeOfMatrix-1] = 0;
        }
        else
        {
        sudukoMatrix[row][col][col] = 0;
        }
        //System.out.println(Arrays.deepToString(sudukoMatrix));
      }
    }
    
    System.out.println(Arrays.deepToString(sudukoMatrix));
    
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
    System.out.println("That took " + duration + " nanoseconds");
  }
}
