package twoone.l1w2s1_fwtjpe;

public class Numeric {
	public static void main(String args[]) {
		System.out.println(approxEqual(1.45324, 1.4532));
	}
	
	public static boolean approxEqual(double x, double y) {
		final double EPSILON = 1E-10;
		
		if(Math.abs(x-y)<EPSILON) {
			return true;
		}
		return false;
	}
}
