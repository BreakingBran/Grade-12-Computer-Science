/**
 * isDistinctYear
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Feb 13, 2017
 */

import java.util.*;
import java.io.*;

public class isDistinctYearWithArrays
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
		int firstYear = year;


		while ((isDistinct == false) && (year < 1000000001))
		{

			isDistinct = isDistinctYearCheck(Integer.toString(year));
			//System.out.println("the year: " + year + " is " + isDistinct);
			if (isDistinct == false){
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
		
		
	}

	public static boolean isDistinctYearCheck(String year)
	{

		boolean isThisYearDistinct = true;
		
		int[] digits = new int[10];
		
		/*for (int i = 0; i < 10; i++)
		{
			char intKey = (char)(i + '0'); //The 0 is added b/c (char)takes ascii # and makes value
			numbers.put(intKey,0);
			//System.out.println("The number is " + i + " and its value is: " + numbers.get(intKey));
		}
		*/
		
		for (int i = 0; i < year.length(); i++)
		{
			char numberInYear = year.charAt(i);
			//System.out.println(numberInYear);
			int num = Character.getNumericValue(numberInYear);
			digits[num] ++;
			//System.out.println("The number is " + numberInYear + " : " + numbers.get(numberInYear));
			if (digits[num] > 1)
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
