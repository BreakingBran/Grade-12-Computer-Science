/**
 * GPS
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Feb 25, 2017
 */

import java.util.*;
import java.io.*;
import java.lang.Math;

public class GPS
{
  public static void main(String args[])
  {
    //parse string and look at each indivizual character
    //each character corosponds to row and colunm value
    // determine diffirence between row and colunm and add to toal turns

    Scanner sc = new Scanner(System.in);

    int[][] matrix = new int[30][2];
    int asciiValue1;
    int asciiValue2;
    int[] prevCharRowCol;
    int[] currentCharRowCol;
    int diffInCols;
    int diffInRows;
    int counter = 0;
    int moves = 0;
    
    for (int rowValueInex =0; rowValueInex < 5; rowValueInex++ )
    {
      for (int colValueInex =0; colValueInex < 6; colValueInex++ )
      {
        matrix[counter][0] = rowValueInex;
        matrix[counter][1] = colValueInex;
        counter++;
      }
    }
    matrix[29][0] = 4;
    matrix[29][1] = 5;

    String name = sc.nextLine();
    
    diffInCols = matrix[charToIndexValue((int) name.charAt(0))][1];
    diffInRows = matrix[charToIndexValue((int) name.charAt(0))][0];
    moves += (diffInCols + diffInRows);
   
    for (int i = 1; i < name.length(); i++)
    {
      asciiValue1 = (int) name.charAt(i-1);
      prevCharRowCol = matrix[charToIndexValue(asciiValue1)];
      asciiValue2 = (int) name.charAt(i);
      currentCharRowCol = matrix[charToIndexValue(asciiValue2)];
      
      diffInCols = Math.abs(currentCharRowCol[1] - prevCharRowCol[1]);
      diffInRows = Math.abs(currentCharRowCol[0] - prevCharRowCol[0]);
      moves += (diffInCols + diffInRows);
      
      if (i == name.length()-1)
      {
        diffInCols =  Math.abs(5 - currentCharRowCol[1]);
        diffInRows = Math.abs(4 - currentCharRowCol[0]);
        moves += (diffInCols + diffInRows);
      }

    }
    sc.close();
    System.out.println(moves);
  }

  public static int charToIndexValue(int AsciiLetter)
  {
    int indexValue = -1;
    if ((AsciiLetter >= 65) && (AsciiLetter <= 90))
    {
      indexValue = AsciiLetter-65;
    }else if (AsciiLetter == 32)
    {
      indexValue = AsciiLetter-6;
    }else if (AsciiLetter == 45)
    {
      indexValue = AsciiLetter-18;
    }else if (AsciiLetter == 46)
    {
      indexValue = AsciiLetter-18;
    }
    return indexValue;
  }
}