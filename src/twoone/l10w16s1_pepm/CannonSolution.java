package twoone.l10w16s1_pepm;

public class CannonSolution {
	private static double muzzleVelSol, angleSol;
	
	public CannonSolution(double a, double v) {
		if(a>=25 && a<=55) {
			angleSol = a;
		} else {
			angleSol = RandomAngle(); //generate random angle between range
		}
		if(v>=1500 && v<=1650) {
			muzzleVelSol = v;
		} else {
			muzzleVelSol = RandomMuzzleVel(); //generate random muzzlevel within range
		}
	}
	
	public double RandomMuzzleVel() {
		return CS2004.UR(1500, 1650);
	}
	
	public double RandomAngle() {
		return CS2004.UR(25, 55);
	}
	public CannonSolution() {
		muzzleVelSol = RandomMuzzleVel();
		angleSol = RandomAngle();
	}
	
	public static double CannonFitness(double r) {
		double range = Cannon.GetMaxRange(angleSol, muzzleVelSol);
		return Math.abs(range-r);
	}
	public void SmallChange() {
		int flip = CS2004.UI(0, 1);
		if(flip==0) {
			angleSol = RandomAngle();
		} else {
			muzzleVelSol = RandomMuzzleVel();
		}
	}
	public double getAngleSol() {
		return (angleSol);
	}
	public double getMuzzleVelSol() {
		return (muzzleVelSol);
	}
	public void print() {
		System.out.println("Angle: " + angleSol + "\nMuzzle Velocity: " + muzzleVelSol);
	}
	public void println() {
		print();
		System.out.println();
	}
}
