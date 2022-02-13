package twoone.l15_ttsp_gh;

import java.util.ArrayList;

public class mixture {

	public static void main(String args[]) {
		int N = 48;
		double d [][] = TSP.ReadArrayFile("src\\twoone\\l15_ttsp_gh\\TSP_48.txt", " ");
		
		ArrayList<Integer> RandPerm = ScalesSolutions.RandPerm(N);
		ScalesSolutions.SetValue(RandPerm); 
		
		ScalesSolutions.Swap();
		ArrayList<Integer> T1 = ScalesSolutions.GetT();
		
		double x = ScalesSolutions.GetFitness(N, RandPerm, d);
		
		// 10000 for initial testing
		int iter = 10000;
		double OPT = OptimalSolution(N, d);
		System.out.println(OPT);
		
		// Simple Hill Climbing Algorithm
		for (int i = 0; i < 10; i++) {
			double f1 = SimpleHillClimbing.SimpleHillClimbing(N, RandPerm, d, iter);
			System.out.println(f1);
		}
	}
	
	public static double OptimalSolution(int N, double d [][]) {
		ArrayList<Integer> OPT = TSP.ReadIntegerFile("src\\twoone\\l15_ttsp_gh\\TSP_48_OPT.txt");
		double OPTDistance = ScalesSolutions.GetFitness(N, OPT, d);
		return OPTDistance;
	}
}
