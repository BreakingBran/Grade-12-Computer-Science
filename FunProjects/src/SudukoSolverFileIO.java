/**
 * SudukoSolver
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Mar 10, 2017
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class SudukoSolverFileIO extends SudukoSolver {

  public static void main(String args[]) throws IOException {
    // create a n by n matrix
    // populate first row with sorted array of 1-n
    // populate rest of matrix with numbers that can go there
    // Go through the matrix and find the smallest matrix greater than 1 and discard the 1st non 0
    // element in it

    // Just for timing

    Scanner sc = new Scanner(new FileReader("Suduko IO/SudukoInput.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("Suduko IO/SudukoOutput.txt"));

    // Gets size of matrix and creates a n by n matrix
    int startInterval = sc.nextInt();
    int endInterval = sc.nextInt();

    for (int interval = startInterval; interval < endInterval; interval++) {

      long startTime = System.nanoTime();

      int sizeOfMatrix = interval;
      SudukoList[][] sudukoMatrix = solve(sc, sizeOfMatrix);
      printSusukoMatrix(sizeOfMatrix, sudukoMatrix, pw);
      concludingPrintsToConsole(sudukoMatrix, sizeOfMatrix, startTime, pw);      
    }
    sc.close();
    pw.close();
  }

  private static void concludingPrintsToConsole(SudukoList[][] sudukoMatrix, int sizeOfMatrix,
      long startTime, PrintWriter pw) {
      boolean isSolved = checkIfCorrect(sudukoMatrix, sizeOfMatrix);
      long endTime = System.nanoTime();
      long duration = (endTime - startTime); // divide by 1000000 to get seconds.
      pw.println("That took " + duration / (1000000000)
          + " seconds for a " + sizeOfMatrix + "x" + sizeOfMatrix + " and the matrix is Solved: " + isSolved);
      pw.println("");
      pw.println("#########################################");
      pw.println("");

      // END OF THE MAIN FUNCTION
      // TODO Auto-generated method stub    
  }

  private static void printSusukoMatrix(int sizeOfMatrix, SudukoList[][] sudukoMatrix,
      PrintWriter pw) {
    for (int row = 0; row < sizeOfMatrix; row++) {
      for (int col = 0; col < sizeOfMatrix; col++) {
        if (sudukoMatrix[row][col].getValueOfLastIndex() != -1) {
          pw.print(sudukoMatrix[row][col].getValueOfLastElement() + " ");
        } else {
          pw.print(sizeOfMatrix + 1 + " ");
        }
      }
      pw.println("");
    }
    pw.println("");

  }


}
