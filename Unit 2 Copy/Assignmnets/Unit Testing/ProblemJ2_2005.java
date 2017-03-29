import java.util.*;

public class ProblemJ2_2005 {

	public static void main(String[] args)
	{
		try
		{
		Scanner sc = new Scanner (System.in);
		
		//ask user for first input and assign to lownum
		System.out.println("Enter lower limit of range");
		int lownum = sc.nextInt();
		
		//check that lownum is less than 1000
		//if it's not, keep asking user for new input
		while (lownum >=1000)
			{
			System.out.println("You must enter a number less than 1000.");
			lownum = sc.nextInt();
			}
		
		//ask user for second input and assign to highnum
		System.out.println("Enter upper limit of range");
		int highnum = sc.nextInt();	
		
		//check that highnum is less than 1000
		//if it's not, keep asking user for new input
		while (lownum >=1000)
		{
		System.out.println("You must enter a number less than 1000.");
		highnum = sc.nextInt();
		}
		
		//close scanner object
		sc.close();
		
		//create int to track total number of RSA numbers in range given
		int countrsa = 0;

		//for every number in the range, use the subprogram findrsa to check for RSA numbers and add one to countrsa if it finds one
		for (int currentnuminrange = lownum; currentnuminrange <= highnum; currentnuminrange++)
			{
			countrsa = findrsa(currentnuminrange, countrsa);
            }
		//print the number of RSA numbers in given range
		System.out.printf ("The number of RSA numbers between %d and %d is %d", lownum, highnum, countrsa);
		}
		
		//catch input errors and terminate program
		catch (InputMismatchException exception)
		{
			System.out.println ("You must enter a valid number.\n---Program Terminated---");
		}
	}

	private static int findrsa(int currentnuminrange, int countrsa) {
    	//create an int to count the number of factors the number has
		int countfactors = 0;
    	
		//divide the number by every number from 1 up to itself
		//if the remainder is 0, increase countfactors by 1
		for (int trackfactors = 1; trackfactors <= currentnuminrange; trackfactors++)
    	{
    		if (currentnuminrange%trackfactors == 0)
    		{
    			countfactors++;
    		}
    	}
    	
		//if the number has exactly 4 factors in the end, add one to countrsa
		if (countfactors == 4)
    	{
    		countrsa++;
    	}
		
    	//return the new countrsa
		return countrsa;
	}

}


