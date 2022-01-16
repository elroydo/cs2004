package l10w16s1_pepm;

public class parameter_estimation_pm {
	public static void main(String[] args) {
		//CannonSolution c = new CannonSolution();
		//double r = Cannon.GetMaxRange(25.0,1650.0);
		//System.out.println(r);
		//ArrayList<Double> xt = Cannon.GetX();
		//ArrayList<Double> yt = Cannon.GetY();
		//System.out.println(xt.size());
		//System.out.println(yt.size());
		
		Cannon c = new Cannon();
		CannonSolution cSol = new CannonSolution(38, 1500);
		System.out.println(cSol.CannonFitness(75000));
		
		cSol.SmallChange();
		for(int i=0;i<10;i++) {
			System.out.println("Iteration " + i + " out of 10");
			long startTime, elapsedTime;
			startTime = System.nanoTime();
			RMHC(50000, 25, 1600, 1000).print();
			System.out.println("Elasped time: " + (elapsedTime = (System.nanoTime()) - startTime));
		}
	}
	
	public static CannonSolution RMHC(double range, double a, double v, int iter) {
		CannonSolution cSol = new CannonSolution(a, v); //set n as the solution size from the length of weights
		double f = cSol.CannonFitness(range);
		for(int i=0;i<iter;i++) { //iterate through number of iter
			CannonSolution newSol = new CannonSolution(cSol.getAngleSol(), cSol.getMuzzleVelSol());
			newSol.SmallChange();
			double f2 = newSol.CannonFitness(range);
			
			if(f2<f) {
				cSol = newSol;
				f = f2;
			}
		}
		System.out.println("Best solution fitness = " + f);
		return (cSol);	
	}
}
