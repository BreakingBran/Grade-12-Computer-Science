/**
 * DoTheShuffle
 * @author: Lance Pereira
 * @course: ICS4U1
 * @date: Feb 17, 2017
 */

import java.util.*;
import java.io.*;
//import java.util.Arrays.*;

public class DoTheShuffle {
	public static void main(String args[]) {
		// create a list with 5 int elements
		// create 4 functions that work with it 
		// TO DO

		Scanner sc = new Scanner(System.in);
		char[] shuffleList = {'A','B','C','D','E'};
		
		//System.out.print(shuffleList[0]);
		
		int userInput = 0;
		int numberOfPresses = 0;
		
		while (userInput != 4)
		{
			userInput = sc.nextInt();
			numberOfPresses = sc.nextInt();
			
			if (userInput == 1){
				button1(shuffleList,numberOfPresses);
			}else if (userInput == 2){
			  button2(shuffleList,numberOfPresses);
			}else if (userInput == 3){
			    button3(shuffleList,numberOfPresses);}
			 
		}
		for (int i = 0; i < 5; i++){
			System.out.print(shuffleList[i]);
			System.out.print(' ');
		}
	}
	public static void button1(char[] shuffleList,int numberOfPresses ) {
		for (int j = 0; j < numberOfPresses; j++){
			char[] tempArray = Arrays.copyOfRange(shuffleList, 1, 5);
			shuffleList[4] = shuffleList[0];
			for (int i = 0; i < shuffleList.length-1; i++){
				shuffleList[i] = tempArray[i];
			}
			//System.out.println(shuffleList);
		}
		
	}
	public static void button2(char[] shuffleList,int numberOfPresses) {
		for (int j = 0; j < numberOfPresses; j++){
			char[] tempArray = Arrays.copyOfRange(shuffleList, 0, 4);
			shuffleList[0] = shuffleList[4];
			for (int i = 0; i < shuffleList.length-1; i++){
				shuffleList[i+1] = tempArray[i];
			}
			//System.out.println(shuffleList);
		}
	}
	public static void button3 (char[] shuffleList,int numberOfPresses)  {
		for (int j = 0; j < numberOfPresses; j++){
			char first = shuffleList[0];
			char second = shuffleList[1];
			shuffleList[0] = second;
			shuffleList[1] = first;
			//System.out.println(shuffleList);
		}
	}
}
	

