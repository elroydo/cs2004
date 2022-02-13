package twotwo.worksheet_1;

public class Numeric {
	public static void main(String args[]) {
		RootApproximator rA = new RootApproximator(9);
		System.out.println(rA.getRoot());
	}
	
	public static boolean approxEqual(double x, double y) {
		final double EPSILON = 1E-10;
		if(Math.abs(x-y)<EPSILON) {
			return true;
		}
		return false;
	}
}
