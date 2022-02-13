package twotwo.worksheet_1;

public class RootApproximator {
	public RootApproximator(double aNumber) {
		a = aNumber;
		xold = 1;
		xnew = a;
	}

	public double nextGuess() {
		xold = xnew;
		if(xold != 0) {
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
	
	private double a, xold, xnew;
}
