package twotwo.worksheet_7;

import java.util.Random;

public class graphTraversal {

	public static void main(String[] args) {
		double y[][] = {
				{0, 1, 2}, 
				{1, 0, 3}, 
				{2, 3, 0}};
		double z[][] = {
				{0, 1, 2, 3, 0}, 
				{1, 0, 6, 0, 5}, 
				{2, 6, 0, 4, 1},
				{3, 0, 4, 0, 2},
				{0, 5, 1, 2, 0}};
		
		//printArray(MST.PrimsMST(g));
		//printArray(MST.PrimsMST(h));
		
		run();
	}
	
	public static void run() {
		int nodes = 0, mstLoops = 1000;
		double g[][], mst[][];
		long startTime, endTime, avg = 0;
		
		for (int i = 0; i<mstLoops; i++) {
			nodes = randomMinMax(100, 500);
			startTime = System.nanoTime();
			mst = MST.PrimsMST(g = randomArray(nodes));
			System.out.println("Iteration: " + (i+1) + " Nodes: " + nodes);
			endTime = System.nanoTime();
			avg += endTime-startTime;
			System.out.println("Average tt: " + (avg/(i+1)));
		}
	}
	
	public static double[][] randomArray(int n) {
		double r[][] = new double[n][n];
		
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<i; j++) {
				int value = random(100);
				r[i][j] = value;
				r[j][i] = value;
			}
		}
		return r;
	}
	
	public static int randomMinMax(int min, int max) {
		int minVal = min+1, maxVal = max+1;
		Random random = new Random();
		return random.nextInt((maxVal-minVal)+minVal);
	}
	
	public static int random(int max) {
		Random random = new Random();
		return random.nextInt(max+1);
	}
	
	public static void printArray(double array[][]) {
		for (int i = 0; i<array.length; i++) {
			for (int j = 0; j<array[i].length;j++) {
				System.out.print(" | " + array[i][j]);
			}
			System.out.println();
		}
	}
}
