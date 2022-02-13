package twoone.l14w21s1_ttsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class heuristic_search_methods_ttsp {
	public static void main(String args[]) {
		double[][] read = TSP.ReadArrayFile("src\\twoone\\l14w21s1_ttsp\\TSP_48.txt", " ");
		int n = read.length;
		double total = 0;
		
		System.out.println(n);
		ArrayList<Integer> randArrRoute = TSPSolution.RandomRoute(n);
		//RMHC(randArrRoute, 1000);
		
		for (int i = 0; i < 10; i++) {
			double f1 = SimpleHillClimbing.SimpleHillClimbing(n, randArrRoute, read, 1000);
			System.out.println(f1);
		}
	}

//	public static ArrayList<Integer> RMHC(ArrayList<Integer> route, int iter) {
//		double[][] read = TSP.ReadArrayFile("src\\l14w21s1_ttsp\\TSP_48.txt", " ");
//		int n = route.size();
//		double endF = 0;
//		for(int i =0; i < iter; i++) {
//			double oldF = TSPSolution.TSPFitness(n, route, read);
//			ArrayList<Integer> oldR = (ArrayList<Integer>)route.clone();
//			SetRoute(route);
//			ArrayList<Integer> newR = TSPSolution.Swap(route);
//			double newF = TSPSolution.TSPFitness(n, newR, read);
//			if(newF < oldF) {
//				route = (ArrayList<Integer>)newR.clone();
//			} else {
//				SetRoute(oldR);
//			}
//			endF = oldF;
//		}
//		System.out.println("optRoute: " + route + "\nendFitness: " + endF);
//		return route;
//	}
//	
//	public static ArrayList<Integer> SetRoute(ArrayList<Integer> route) {
//		ArrayList<Integer> thisRoute = route;
//		return thisRoute;
//	}
}

class SimpleHillClimbing {	
	public static double SimpleHillClimbing(int cities, ArrayList<Integer> T, double d [][], int iter) {
		double OriginalFitness; double NewFitness;
		ArrayList<Integer> OriginalList; 
		ArrayList<Integer> NewList;
		ArrayList<Integer> RandPerm = TSPSolution.RandomRoute(cities);
		TSPSolution.SetTour(RandPerm);
	
		for (int i = 1; i <= iter; i++) {
			OriginalList = TSPSolution.GetTour();
			OriginalFitness = TSPSolution.TSPFitness(cities, OriginalList, d);
			
			TSPSolution.Swap();
			
			NewList = TSPSolution.GetTour();
			NewFitness = TSPSolution.TSPFitness(cities, NewList, d);
			
			if (NewFitness > OriginalFitness) {
				TSPSolution.SetTour(OriginalList);
			} 
		}
		
		return(TSPSolution.TSPFitness(cities, TSPSolution.GetTour(), d));
	}	
}

class TSPSolution {
	public static ArrayList<Integer> T;
	
	public static ArrayList<Integer> RandomRoute(int n) {
		ArrayList<Integer> P = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			 	P.add(i);
			}
		
		for (int i = 0; i < n; i++) {
			int rand1 = CS2004.UI(0, n-1);
			int rand2 = CS2004.UI(0, n-1);
			int temp1 = P.get(rand1);
			int temp2 = P.get(rand2);
			P.set(rand1, temp2);
			P.set(rand2, temp1);
		}
		return P;
	}

	public static double TSPFitness(int N, ArrayList<Integer> T, double d [][]) {
		double s = 0;
		for (int i = 0; i < N - 1; i++) 
		{
			int a = T.get(i);
			int b = T.get(i + 1);
			s = s + d[a][b];
		}
		int end_city = T.get(N-1);
		int start_city = T.get(0);
		
		s = s + d[end_city][start_city];
		
		return s;
	}
	
	public static void Swap() {
		int n = T.size();
		
		int rand1 = CS2004.UI(0, n-1);
		int rand2 = CS2004.UI(0, n-1);
		if (rand1 == rand2) {
			if (rand1 >= 0 && rand1 != n-1) {
				rand1 = rand1 + 1;
			} else {
				rand1 = rand1 - 1;
			}
		}
		int temp1 = T.get(rand1);
		int temp2 = T.get(rand2);
		T.set(rand1, temp2);
		T.set(rand2, temp1);
	
	}
	
	public static void SetTour(ArrayList<Integer> x) {
		T = (ArrayList<Integer>) x.clone();
	}
	
	public static ArrayList<Integer> GetTour() {
		ArrayList<Integer> x = (ArrayList<Integer>) T.clone();
		return x;
	}
}

class CS2004 {
	static private Random rand;

	static public int UI(int aa, int bb) {
		int a = Math.min(aa, bb);
		int b = Math.max(aa, bb);
		if (rand == null) {
			rand = new Random();
			rand.setSeed(System.nanoTime());
		}
		int d = b - a + 1;
		int x = rand.nextInt(d) + a;
		return (x);
	}

	static public double UR(double a, double b) {
		if (rand == null) {
			rand = new Random();
			rand.setSeed(System.nanoTime());
		}
		return ((b - a) * rand.nextDouble() + a);
	}
}