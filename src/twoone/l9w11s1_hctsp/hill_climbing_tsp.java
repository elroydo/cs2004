package twoone.l9w11s1_hctsp;

import java.util.ArrayList;

public class hill_climbing_tsp {
	public static void main(String[] args) {
		ArrayList<Double> tPrimeNumbers = CS2004.ReadNumberFile("src\\twoone\\l8w10s1_fftsp\\1000 Primes.txt"), weights = new ArrayList<Double>();
		
		//exercise 9.3 small change method (refer to ScalesSoluton.java)
		ScalesSolution s = new ScalesSolution("11111");
		s.println();
		s.SmallChange();
		s.println();
		
		//exercise 9.4 hill climbing method
		ScalesSolution s1 = new ScalesSolution(10);
		s1.println();
		ScalesSolution s2 = new ScalesSolution(s1.GetSol());
		s2.println();
		
		for(int i=0;i<1000;i++ ) {
			weights.add(tPrimeNumbers.get(i));
		}
		
		for(int i=0;i<10;i++) {
			long startTime, elapsedTime;
			startTime = System.nanoTime();
			RMHC(weights, 1000);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("Elasped time: " + elapsedTime);
		}
		
	}
	
	public static ScalesSolution RMHC(ArrayList<Double> weights, int iter) {
		ScalesSolution sol = new ScalesSolution(weights.size()); //set n as the solution size from the length of weights
		double ef = 0;
		for(int i=0;i<iter;i++) { //iterate through number of iter
			double of = sol.ScalesFitness(weights);
			String oldSol = sol.GetSol();
			sol.SmallChange();
			double nf = sol.ScalesFitness(weights);
			if(nf>of) {
				sol.SetSol(oldSol);;
			}
			ef = of;
//			System.out.println("iteration: " + i);
//			System.out.println("oldfitness = " + of);
//			System.out.println("newfitness = " + nf);
		}
		sol.println();
		System.out.println("Best solution fitness = " + ef);
		return (sol);	
	}
}
