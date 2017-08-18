import java.util.Scanner;
import java.lang.Math;

/**
 * NailedIt
 * @author: Lance Pereira
 * @course: CS135
 * @date: Aug 17, 2017
 */

public class NailedIt {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//holds the value of total number of boards and a 
		//dict holding frequency of heights
		
		//System.out.print("How many boards: ");
		int totalBoards = sc.nextInt();;
		int[] boardsHeightDict = new int[2000];
		
		//populate the height dictionary with values
		
		for (int i = 0; i < totalBoards; i++) {
			int heightIndex = sc.nextInt() - 1;
			boardsHeightDict[heightIndex] = boardsHeightDict[heightIndex] + 1;
		}
		
		solve(totalBoards,boardsHeightDict);
		
	}
	
	
	public static void solve(int totalBoards, int[] boardsHeightDict) {
		
		int longestFence = 0;
		int totalLongestFences = 0;
		
		for (int k = 4000; k > 1; k--) {
			
			int fenceLength = 0,formerIndex,laterIndex;
			
			
			//halfk is the index + 1 that we need to start at
			int halfK = k/2;
			//even tells us if we start at 1 index or 2
			boolean even = (k%2 == 0);
			
			if (even) {
				//the -1 is because arrays are 0 indexed
				fenceLength += boardsHeightDict[halfK-1]/2;
				formerIndex = halfK-1;
				laterIndex =  halfK+1;
			}else {
				//example k = 9, halfK = 4, so former = 4
				//and latter = 5
				formerIndex = halfK;
				laterIndex =  halfK+1;
			}
			
			//while the indexes are still in bounds
			while( formerIndex > 0 && laterIndex < 2001) {
				
				//adds the total possible ways to make fence with those two heights
				fenceLength += Math.min(boardsHeightDict[formerIndex-1], boardsHeightDict[laterIndex-1]);
				formerIndex -= 1;
				laterIndex += 1;
			}
			
			if(fenceLength > longestFence) {
				totalLongestFences = 1;
				longestFence = fenceLength;
			}else if (fenceLength == longestFence) {
				totalLongestFences += 1;
			}
			
		}
		
	//System.out.println("The longest fence is: " + longestFence + "\n" + "The total ways to make it: " + totalLongestFences);
	System.out.println(longestFence + " " + totalLongestFences);
	}

}
