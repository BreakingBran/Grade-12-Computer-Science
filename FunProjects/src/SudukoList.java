/**
 * SudukoList
 * 
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Mar 31, 2017
 */

import java.util.*;
import java.io.*;

class SudukoList {
  
  private int[] sudukoArray;
  private boolean lastElementLeft = false;
  private int row;
  private int col;
  private  int sizeOfMatrix;
  private int nonZeroElements;
  private boolean primaryAngleTLtoBR;
  private boolean primaryAngleBLtoTR;
  private int[] tempArray;
  
  public SudukoList(int[] tempArray ,int Urow, int Ucol, int SizeOfMatrix) {
    this.sudukoArray = tempArray;
    this.row = Urow;
    this.col = Ucol;
    this.sizeOfMatrix = SizeOfMatrix;
    //this.sizeOfMatrix = SizeOfMatrix;
    setNonZeroElements(sizeOfMatrix);
  }

  public void setsudukoArrayValue(int index, int value) {
    this.sudukoArray[index] = value;
    setNonZeroElements(getNonZeroElements() - 1);
    if (getNonZeroElements() == 1)
    {
      this.setLastElementLeft(true);
    }
    
  }

  public int getsudukoArrayValue(int index) {
    return sudukoArray[index];
  }
  
  public int[] getsudukoArray() {
    return sudukoArray;
  }
  
  public void setArray() {
    // Populates first row with only value that coresponds to it's colunm
    if (row == 0) {
      this.sudukoArray = new int[sizeOfMatrix];
      this.sudukoArray[col] = col + 1;
      setNonZeroElements(1);
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

  public void setLastElementLeft(boolean lastElementLeft) {
    this.lastElementLeft = lastElementLeft;
  }
  
}
