package twoone.l11w18s1_asgaattsp;

import java.util.ArrayList;

public class simple_genetic_algorithm_sp {
	public static void main(String[] args) {
		//Read in the weights
		//Make sure you change the filename as appropriate!
		//This will only work if "c:\temp\1000 Primes.txt" exists!
		ArrayList<Double> w = CS2004.ReadNumberFile("src\\twoone\\l8w10s1_fftsp\\1000 Primes.txt");
		//Set the weights
		ScalesChrome.SetWeights(w);
		//Run 10 repeats
		for(int i=0;i<10;++i) {
			//Reset the fitness count
			ScalesChrome.ClearFC();
			//The following parameters are not very good!
			//These are the ones you should try and optimise!
			int popsize = 1000;
			double mrate = 0.99;
			double crate = 0.03;
			//You will not need to change the following
			SimpleGeneticAlgorithm ga = new SimpleGeneticAlgorithm(popsize, 1000, 1000, mrate, crate);
			//Run the GA for 10,000 function calls
			double f = ga.RunSGA(10000, false).GetFitness();
			System.out.println(f);
		}
	}
}
