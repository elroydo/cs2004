package twoone.l2w2s2_daiosa;

import java.util.Random;

public class LinearSum {
	
	public static void main(String[] args) throws InterruptedException {
		RunAlgorithm();
		
	}
	
	public static int sum(int n) {
		int partialSum = 0, test = 0;
		
		for(int i=1;i<=n;i++) {
			partialSum +=i;
		}
		test = (n/2)*(1+n);
		if( test == partialSum)return partialSum;
		return -1;
	}
	
	public static void RunAlgorithm() throws InterruptedException {
		long StartTime, EndTime;
		Random random = new Random();
		
		for (int i=0; i<20;i++) {
			int n = 100000 + random.nextInt(900000);
			
			System.out.println("Testing...");
			StartTime = System.nanoTime();
			System.out.println(sum(n));
			EndTime = System.nanoTime();
			System.out.println("Run time = " + (EndTime-StartTime));
		}
	}
}
