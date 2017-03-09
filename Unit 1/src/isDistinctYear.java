/**
 * isDistinctYear
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Feb 13, 2017
 */

import java.util.*;
//import java.io.*;

public class isDistinctYear
{

  public static void main(String args[])
  {
    // Get start year
    // Check if year is distinct
    // output the next year that is distinct

    Scanner sc = new Scanner(System.in);
    boolean isDistinct = false;

    System.out.print("What year do you want to start: ");

    int year = sc.nextInt();
    //firstYear somewhat reduntant, holds userInput of year, does not get modified
    int firstYear = year;
    //need to find year that is distinct after given userYear
    year++;

    //checks to see if year distinct, if not adds 1 to year and continues
    while ((isDistinct == false) && (year < 100001))
    {

      isDistinct = isDistinctYearCheck(Integer.toString(year));
      //System.out.println("the year: " + year + " is " + isDistinct);
      
      //if Distinct year not found adds 1 to year
      if (!isDistinct)
      {
        year += 1;
      }


    }

    if (isDistinct == true)
    {
      System.out.println(year);
    }else
    {
      System.out.println("There were no distinct years between " + firstYear + " and 100001" );
    }
    
    sc.close();

  }

  public static boolean isDistinctYearCheck(String year)
  {
    //Does frequency analysis of input given
    //If frequency of any character > 1, returns False
    boolean isThisYearDistinct = true;
    
    //creates Java version of dictionary, with characters as keys
    Hashtable<Character, Integer> numbers = new Hashtable<Character, Integer>();

    //assigns values to Hashtable and sets each key to value 0
    // wasteful to redeine but its late at night and I have an english essay to finish
    for (int i = 0; i < 10; i++)
    {
      char intKey = (char)(i + '0'); //The 0 is added b/c (char)takes ascii # and makes value
      numbers.put(intKey,0);
      //System.out.println("The number is " + i + " and its value is: " + numbers.get(intKey));
    }

    //loops through characters of String year, does frequency analysis, could have 
    //been while loop, but why waste the extra time writing
    for (int i = 0; i < year.length(); i++)
    {
      char numberInYear = year.charAt(i);
      //System.out.println(numberInYear);
      numbers.put(numberInYear,numbers.get(numberInYear)+1);
      //System.out.println("The number is " + numberInYear + " : " + numbers.get(numberInYear));
      
      //sets boolean to False if value > 1
      if (numbers.get(numberInYear) > 1)
      {
        isThisYearDistinct = false;
      }

    }

    if (isThisYearDistinct)
    {
      return true;
    }else
    {
      return false;
    }
  }


}

