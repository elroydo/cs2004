package l1w2s1_fwtjpe;

public class RootApproximator {
	public static void main(String[] args) {
		RootApproximator x = new RootApproximator(20);
		
		int val = (int)x.getRoot();
		System.out.println(val);
	}
	
	public RootApproximator(double aNumber) {
		a = aNumber;
		xold = 1;
		xnew = a;
	}
	
	public double nextGuess() {
		xold = xnew;
		if(xold!=0) {
			xnew = (xold + a/xold)/2;
		}
		return xnew;
	}
	
	public double getRoot() {
		while(!Numeric.approxEqual(xnew, xold)) {
			nextGuess();
		}
		return xnew;
	}
	
	private double a;
	private double xold;
	private double xnew;
}
