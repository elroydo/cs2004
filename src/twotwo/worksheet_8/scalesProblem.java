package twotwo.worksheet_8;

import java.util.ArrayList;

public class scalesProblem {
	public static void main(String[] args) {
//		for (int i = 0; i<10; i++) {
//			double x = CS2004.UR(-1, 1);
//			System.out.println(x);
//		}
//		
//		ScalesSolution s = new ScalesSolution("10101");
//		s.println();
//		s = new ScalesSolution("10101x");
//		s.println();
		
		ArrayList<Double> weights = new ArrayList<Double>(), primeNumbers = new ArrayList<Double>();
		
		weights.add(1.0);
		weights.add(2.0);
		weights.add(3.0);
		weights.add(4.0);
		weights.add(10.0);
		
		primeNumbers = CS2004.ReadNumberFile("src\\twotwo\\worksheet_8\\Primes.txt");
		weights = new ArrayList<Double>();
		
		for(int i=0;i<10;i++ ) {
			weights.add(primeNumbers.get(i));
		}
		
		while(true) {
			double f = fitnessTest(weights);
			System.out.println(f);
			if(f==0) break;
		}
	}
	
	public static double fitnessTest(ArrayList<Double> w) {
		ScalesSolution s = new ScalesSolution(ScalesSolution.RandomBinaryString(w.size()));
		return s.ScalesFitness(w);
	}
}
