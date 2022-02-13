package twoone.l8w10s1_fftsp;

import java.util.ArrayList;

public class fitness_functions_tsp {
	public static void main(String[] args) {
		ArrayList<Double> weights = new ArrayList<Double>(), tPrimeNumbers = new ArrayList<Double>();
		boolean optima = false;
		
		//exercise 8.2 preliminaries
		//ScalesSolution s = new ScalesSolution("10101");
		//s = new ScalesSolution("10101x");
		//s.println();
		
		//exercise 8.3 cs2004 class
		//for(int i=0;i<10;++i) {
			//int x = CS2004.UI(0, 1);
			//System.out.println(x);
		//}
		
		//exercise 8.4 the ScalesSolution class
		weights.add(1.0);
		weights.add(2.0);
		weights.add(3.0);
		weights.add(4.0);
		weights.add(10.0);
		
		while(!optima) {
			double f = fitnessTest(weights);
			System.out.println(f);
			if(f==0) break;
		}
		System.out.println();
		
		//exercise 8.5 reading in data
		tPrimeNumbers = CS2004.ReadNumberFile("src\\twoone\\l8w10s1_fftsp\\1000 Primes.txt");
		weights = new ArrayList<Double>();
		
		for(int i=0;i<100;i++ ) {
			weights.add(tPrimeNumbers.get(i));
		}
		
		while(!optima) {
			double f = fitnessTest(weights);
			System.out.println(f);
			if(f==0) break;
		}
	}
	
	public static double fitnessTest(ArrayList<Double> w) {
		ScalesSolution s = new ScalesSolution(ScalesSolution.RandomBinaryString(w.size()));
		//s = new ScalesSolution("10101x");
		//s.println();
		return ScalesSolution.ScalesFitness(w);
	}
	
	
}
