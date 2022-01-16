package worksheet_2;

import java.util.concurrent.TimeUnit;

public class LinearSummation {
	public static void main(String args[]) {
		timeTest();
	}

	public static int sum(int n) {
		int partialSum = 0;
		for (int i = 1; i <= n; i++) {
			partialSum += i;
		}
		return (partialSum);
	}
	
	public static boolean gaussTest(int n, int a) {
		int gauss;
		gauss = (a/2)*(1+a);
		if (n==gauss) return true;
		return false;
	}
	
	//the fuck.
	public static int geoSum(int a, int n) {
		int r, geoSum = 0;
		for (int i=0; i<n; i++) {
			geoSum += (int) (a*(Math.pow(a, i)));
		}
		return geoSum;
	}
	
	public static void timeTest() {
		long startTime, endTime;
		double elapsedTime;
		
		startTime = System.nanoTime();
		
		int n = 100;
		System.out.println(gaussTest(sum(n), n));
		System.out.println(geoSum(2, 5));
		
		endTime = System.nanoTime();
		
		elapsedTime = (endTime - startTime)/1_000_000_000;
		long convert = TimeUnit.SECONDS.convert((long) elapsedTime, TimeUnit.NANOSECONDS);
		
		System.out.println("timetaken: " + elapsedTime+"s" + "\nconverteded: "+ convert + "s");
	}
}
