/**
 * DoTheShuffle
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Feb 17, 2017
 */

import java.util.*;
import java.io.*;

public class DoTheShuffle {
	public static void main(String args[]) {
		// create a list with 5 int elements
		// create 4 functions that work with it 
		// TO DO

		Scanner sc = new Scanner(System.in);
		int[] shuffleList = new int[5];
		
		for (int i = 0; i < 5; i++)
		{
			shuffleList[i] = i;
		}
		
		int userInput = 0;
		int numberOfPresses = 0;
		
		while (userInput != 4)
		{
			userInput = sc.nextInt();
			numberOfPresses = sc.nextInt();
			
			switch(userInput){
			case 1:
				button1(shuffleList,numberOfPresses);
			case 2:
				button2(shuffleList,numberOfPresses);
			case 3:
				button3(shuffleList,numberOfPresses);
			}
		
			 
		}
		
		System.out.print(shuffleList);
	}
	public static void button1(int[] shuffleList,int numberOfPresses ) {
		//inputArray.add('H');
	}
	public static void button2(int[] shuffleList,int numberOfPresses) {
		
	}
	public static void button3 (int[] shuffleList,int numberOfPresses)  {
		
	}
	public static void button4 (int[] shuffleList,int numberOfPresses)  {
		
	}
	
}
