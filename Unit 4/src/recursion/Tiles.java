/**
 * Tiles
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: May 29, 2017
 */

package recursion;

import java.util.*;
import java.io.*;

import javax.swing.text.html.MinimalHTMLWriter;

public class Tiles {

  private int rows;
  private int cols;

  public static void main(String args[]) throws IOException {

    try {
      Scanner sc = new Scanner(new FileReader("RecursionInput/DATA3.txt"));
      PrintWriter pw = new PrintWriter(new FileWriter("RecursionOutput/OUT3.txt"));

      for (int i = 0; i < 6; i++) {
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int totalSquares = solveTiles(rows, cols);
        System.out.println(totalSquares);
        // pw.println(totalSquares);
      }


//      int rows = sc.nextInt();
//      int cols = sc.nextInt();
//      //int totalSquares = solveTiles(rows, cols);
//      int totalSquares = solveTiles(10, 5);
//      System.out.println(totalSquares);



    } catch (IOException e) {
      System.out.print("Input file or output file could not be found: Program terminated");
    }
  }

  public static int solveTiles(int rows, int cols) throws IOException {
    
    
    int numberOfTiles = 0;
    int rowsMaxSquare;
    int colsMaxSquare;
    int maxSquare;
    // PrintWriter pw = new PrintWriter(new FileWriter("RecursionOutput/Debuging.txt"));
    // pw.println("(row,col)" + rows + " , " + cols);

    if (rows == 1 || cols == 1) {
      numberOfTiles = rows * cols;
      // System.out.println("The number of Tiles is " + numberOfTiles);
    } else if (rows > 1 && cols > 1) {
      //2 to the power of
      rowsMaxSquare = (int) Math.pow(2, (int) (Math.log(rows) / Math.log(2)));
      colsMaxSquare = (int) Math.pow(2,(int) (Math.log(cols) / Math.log(2)));
      maxSquare = Math.min(rowsMaxSquare, colsMaxSquare);
      // System.out.println("The max square is " + maxSquare);
      numberOfTiles += 1;


      numberOfTiles += solveTiles( maxSquare, cols - maxSquare);
      numberOfTiles += solveTiles(rows - maxSquare,cols);
    }

    return numberOfTiles;
  }
}
