/**
 * SudukoList
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Mar 31, 2017
 */

import java.util.*;
//import java.io.*;

class SudukoList {
  
  private int[] sudukoArray;
  private boolean lastElementLeft = false;
  private int row;
  private int col;
  private  int sizeOfMatrix;
  private int nonZeroElements;
  private boolean primaryAngleTLtoBR;
  private boolean primaryAngleBLtoTR;
  //private int[] tempArray;
  private int indexOfLastElement;
  
  public SudukoList(int[] tempArray ,int Urow, int Ucol, int SizeOfMatrix) {
    this.sudukoArray = tempArray.clone();
    this.row = Urow;
    this.col = Ucol;
    this.sizeOfMatrix = SizeOfMatrix;
    //this.sizeOfMatrix = SizeOfMatrix;
    setNonZeroElements(sizeOfMatrix);
  }

 
  public void setsudukoArrayValue(int index, int value) {
    //Only subtracts 1 from nonzero elements if element set to 0 was not already 0
    if (this.sudukoArray[index] != 0){
      setNonZeroElements(getNonZeroElements() - 1);
    }
    //Sets element to 0
    this.sudukoArray[index] = value;
    //Makes sure that this never happens
    if (getNonZeroElements() < 0){
      throw new IllegalStateException("There should never be an array with no numbers");
    }
    else if (getNonZeroElements() == 1)
    {
      for (int i = 0; i < this.sizeOfMatrix; i++)
      {
        if (sudukoArray[i] != 0){
          setIndexOfLastElement(i);
          break;
        }
      }
    }
    /*if (getNonZeroElements() == 1)
    {
      this.setLastElementLeft();
    }*/
    
  }

  public int getsudukoArrayValue(int index) {
    return sudukoArray[index];
  }
  
  public int[] getsudukoArray() {
    return sudukoArray;
  }
  
  /**
   *  
   * When arrays in Suduko matrix are being initialized, this determines which 
   * numbers in the 3rd level array to switch off.
   * Example: SizeOfMatrix = 4, sets the row 0, col 0 matrix to [1,0,0,0]
   * and sets row 1, col 0 to [0,2,3,4] \n
   * ->Also
   */
  public void setArray() {
    // Populates first row with only value that coresponds to it's colunm
    if (row == 0) {
      if (col == 0){this.primaryAngleTLtoBR = true;}
      if (col == sizeOfMatrix-1){this.primaryAngleBLtoTR = true;}
      this.sudukoArray = new int[sizeOfMatrix];
      this.sudukoArray[col] = col + 1;
      setNonZeroElements(1);
      setLastElementLeft();
    } else {
      // If not first row, populates element with copy of 1-n list

      // erases 1st element if on primary diagnol going down
      if ((row == col)) {
        // This takes care of the primary angle top left to bottom right
        this.sudukoArray[0] = 0;
        this.setPrimaryAngleTLtoBR(true);
        setNonZeroElements(getNonZeroElements() - 1);
      }

      // erases last element if on primary diagnol going up
      if (row + col == sizeOfMatrix - 1) {
        // This takes care of primary angle top right to bottom left
        this.sudukoArray[sizeOfMatrix - 1] = 0;
        this.setPrimaryAngleBLtoTR(true);
        setNonZeroElements(getNonZeroElements() - 1);
      }

      // erases the element that coresponds to col number
      this.sudukoArray[col] = 0;
      setNonZeroElements(getNonZeroElements() - 1);
    }


  }

  public String toString() {
    return Arrays.toString(sudukoArray);
  }

  public int getNonZeroElements() {
    return nonZeroElements;
  }

  private void setNonZeroElements(int nonZeroElements) {
    this.nonZeroElements = nonZeroElements;
  }

  public boolean isPrimaryAngleTLtoBR() {
    return primaryAngleTLtoBR;
  }

  public void setPrimaryAngleTLtoBR(boolean primaryAngleTLtoBR) {
    this.primaryAngleTLtoBR = primaryAngleTLtoBR;
  }

  public boolean isPrimaryAngleBLtoTR() {
    return primaryAngleBLtoTR;
  }

  public void setPrimaryAngleBLtoTR(boolean primaryAngleBLtoTR) {
    this.primaryAngleBLtoTR = primaryAngleBLtoTR;
  }

  public boolean isLastElementLeft() {
    return lastElementLeft;
  }

  public void setLastElementLeft() {
    this.lastElementLeft = true;
  }

  public int getValueOfLastElement() {
    return sudukoArray[indexOfLastElement];
  }

  public void setIndexOfLastElement(int indexOfLastElement) {
    this.indexOfLastElement = indexOfLastElement;
  }
  
}
