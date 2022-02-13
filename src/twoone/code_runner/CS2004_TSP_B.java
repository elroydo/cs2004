package twoone.code_runner;

import java.util.ArrayList;
import java.util.Collections;

class CS2004_TSP_B {
	public static ArrayList<Integer> RunTSP(int iterations, float distances[][]) {
		try {
			if (distances == null)
				return new ArrayList<Integer>();
			if (distances.length == 0)
				return null;
			if (iterations < 0)
				return null;
			ArrayList<Integer> tour = new ArrayList<Integer>(TSPSolution.RandomRoute(distances.length)), tempTour = new ArrayList<Integer>(tour);
			int f = TSPSolution.TSPFitness(tour, distances);
			for(int i=0;i<iterations;i++) {
				tempTour = TSPSolution.SwapTwo(tempTour);
				int nf = TSPSolution.TSPFitness(tempTour, distances);
				if(nf<f) {
					tour = (ArrayList<Integer>) tempTour.clone();
					f = nf;
				}
			}
			return tour;
		} catch (Exception e) {
			return null;
		}
	}
}

class TSPSolution {
	public static ArrayList<Integer> RandomRoute(int n) {
		ArrayList<Integer> randArr = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			randArr.add(i);
		}
		Collections.shuffle(randArr);
		return randArr;
	}

	public static int TSPFitness(ArrayList<Integer> tour, float[][] distances) {
		int f = 0, n = tour.size(), sCity = tour.get(0), eCity = (n-1);
		for (int i = 0; i < (n - 1); i++) {
			int fone = tour.get(i);
			int ttwo = tour.get(+1);
			f += distances[fone][ttwo];
		}
		f += distances[eCity][sCity];
		return f;
	}

	public static ArrayList<Integer> SwapTwo(ArrayList<Integer> arr) {
		int i = 0, j = 0, n = arr.size();

		while (i == j) {
			i = CS2004.UI(0, n - 1);
			j = CS2004.UI(0, n - 1);
		}
		int temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
		return arr;
	}
}