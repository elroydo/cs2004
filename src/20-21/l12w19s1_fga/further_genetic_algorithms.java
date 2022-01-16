package l12w19s1_fga;

public class further_genetic_algorithms {
	public static void main(String[] args) {
		for(int i=0;i<10;++i) {
			//Reset the fitness count
			OneMaxChrome.ClearFC();
			//The following parameters are not very good!
			//These are the ones you should try and optimise!
			int n = 1000;	
			int popsize = 100;
			double mrate = (double) 1/n;
			double crate = 0.40;		
			//You will not need to change the following
			SimpleGeneticAlgorithm ga = new SimpleGeneticAlgorithm(popsize,10,n,mrate,crate);
			//Run the GA for 10,000 function calls
			double f = ga.RunSGA(10000, false).GetFitness();
			
			System.out.println(f);
		}
	}
}
