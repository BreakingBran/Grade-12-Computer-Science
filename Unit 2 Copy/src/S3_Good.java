import java.util.Scanner;


public class S3_Good {

	public static void main(String[] args) {
		
		
		int[] heights = new int[4001];
		int b = 0;
		int t = 0;
		int bn = 0;
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		while(n > 0){
			heights[sc.nextInt()]++;
			n--;
		}

		long startTime = System.nanoTime();
		
		for(int h = 2; h < 5; h++){
			
			int cl = 0;
			
			for(int i = 1; 2*i < h; i++){
				System.out.println(i + " " + h);
				cl += Math.min(heights[i], heights[h-i]);
			}
			
			if(h % 2 != 0){
				cl += (heights[h/2] - (heights[h/2] % 2))/2;
			}
			
			if(cl > b){
				bn = 1;
				b = cl;
			}else if(cl == b){
				bn++;
			}
			
		}
		
		System.out.println(b + " " + bn);
		
		Long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime/1000000000.0 + "s");
		
	}

}
