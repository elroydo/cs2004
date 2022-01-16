package l7w8s1_gtmst;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class graph_traversal_mst {
	public static void main(String[] args) throws IOException {
		double[][] g = {{0, 1, 2}, 
				{1, 0, 3}, 
				{2, 3, 0}}, 
		h = {
				{0, 1, 2, 3, 0}, 
				{1, 0, 6, 5, 0}, 
				{2, 6, 0, 4, 1}, 
				{3, 0, 4, 0, 2}, 
				{0, 5, 1, 2, 0}};
		int mstLoops = 100;
		long[] elapsedTime = new long[mstLoops], nodesLoop = new long[mstLoops];
		
		//run(g);
		//run(h);
		
		for(int i=0; i<mstLoops; i++) {
			int nodes = randomMinMax(100, 500);
			long startTime = 0, endTime = 0;
			double[][] array = randArray(nodes);
			System.out.println("iteration " + (i) + ", nodes = " + nodes);
			//System.out.println("OG\n" + Arrays.deepToString(array).replace("], ", "]\n"));
			//System.out.println("MST\n" + Arrays.deepToString(run(array)).replace("], ", "]\n"));
			startTime = System.nanoTime();
			run(array);
			endTime = System.nanoTime();
			elapsedTime[i] = endTime-startTime;
			nodesLoop[i] = nodes;
			System.out.println(elapsedTime[i]);
			System.out.println();
		}
		write(elapsedTime);
		write(nodesLoop);
	}
	
	public static double[][] run(double[][] array) {
		return MST.PrimsMST(array);
	}
	
	public static double[][] randArray(int n) {
		double[][] intArray = new double[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				int value = random(100);
				intArray[i][j] = value;
				intArray[j][i] = value;
			}
		}
		return intArray;
	}
	
	public static int random(int max) {
		Random random = new Random();
		return random.nextInt(max+1);
	}
	
	public static int randomMinMax(int min, int max) {
		int minVal = min+1, maxVal = max+1;
		Random random = new Random();
		return random.nextInt((maxVal-minVal)+minVal);
	}
	
	public static void printArray(double[][] array) {
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				System.out.print("  |  " + array[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void write(long[] a) throws IOException {
		FileWriter fw = new FileWriter("src/l7w8s1_gtmst/out.txt", true);
		
		fw.write("\n");
		for(int i=0;i<a.length;i++) {
			fw.write(String.valueOf(a[i]) + "\n");
		}
		
		fw.close();
	}
}
