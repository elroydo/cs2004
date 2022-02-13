package twoone.coderunner_task_two_question_two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class travelling_salesmen_problem {
	public static void main(String args[]) {
		double[][] read = TSP.ReadArrayFile("src\\twoone\\coderunner_task_two_question_two\\TSP_48.txt", " ");
		int n = read.length;

		System.out.println(n);
		ArrayList<Integer> randArrRoute = TSPSolution.RandomRoute(n);

		for (int i = 0; i < 10; i++) {
			System.out.println(RMHC(randArrRoute, 1000));
		}
	}

	public static ArrayList<Integer> RMHC(ArrayList<Integer> route, int iter) {
		double[][] read = TSP.ReadArrayFile("src\\twoone\\coderunner_task_two_question_two\\TSP_48.txt", " ");
		int n = route.size();
		double endF = 0;
		for(int i =0; i < iter; i++) {
			double oldF = TSPSolution.TSPFitness(n, route, read);
			ArrayList<Integer> oldR = (ArrayList<Integer>)route.clone();
			TSPSolution.SetRoute(route);
			ArrayList<Integer> newR = TSPSolution.Swap(route);
			double newF = TSPSolution.TSPFitness(n, newR, read);
			if(newF < oldF) {
				route = (ArrayList<Integer>)newR.clone();
			} else {
				TSPSolution.SetRoute(oldR);
			}
			endF = oldF;
		}
		System.out.println("optRoute: " + route + "\nendFitness: " + endF);
		return route;
	}
}

class TSPSolution {
	public static ArrayList<Integer> tour;
	
	public static ArrayList<Integer> RandomRoute(int n) {
		ArrayList<Integer> randArr = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			randArr.add(i);
		}
		Collections.shuffle(randArr);
		return randArr;
	}

	public static ArrayList<Integer> RandPerm(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	public static double TSPFitness(int cities, ArrayList<Integer> tour, double[][] read) {
		double s = 0;
		for (int i = 0; i < cities - 1; i++) {
			int a = tour.get(i);
			int b = tour.get(i + 1);
			s = s + read[a][b];
		}
		int endC = tour.size() - 1;
		int startC = tour.get(0);
		s = s + read[endC][startC];
		return s;
	}

	public static ArrayList<Integer> Swap(ArrayList<Integer> arr) {
		ArrayList<Integer> copyArr = (ArrayList<Integer>)arr.clone();
		int i = 0, j = 0;
		while (i == j) {
			i = CS2004.UI(1, copyArr.size() - 1);
			j = CS2004.UI(1, copyArr.size() - 1);
		}
		int hold = copyArr.get(i);
		copyArr.set(i, copyArr.get(j));
		copyArr.set(j, hold);
		return copyArr;
	}
	
	public static void SwapTwo() {
		int n = tour.size();
		
		int rand1 = CS2004.UI(0, n-1);
		int rand2 = CS2004.UI(0, n-1);
		if (rand1 == rand2)
		{
			if (rand1 >= 0 && rand1 != n-1) {
				rand1 = rand1 + 1;
			} else {
				rand1 = rand1 - 1;
			}
		}
		int temp1 = tour.get(rand1);
		int temp2 = tour.get(rand2);
		tour.set(rand1, temp2);
		tour.set(rand2, temp1);
	}
	
	public static void SetTour(ArrayList<Integer> arr) {
		tour = (ArrayList<Integer>) arr.clone();
	}
	
	public static ArrayList<Integer> GetTour() {
		ArrayList<Integer> t = (ArrayList<Integer>) tour.clone();
		return t;
	}
	
	public static ArrayList<Integer> SetRoute(ArrayList<Integer> route) {
		ArrayList<Integer> thisRoute = route;
		return thisRoute;
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