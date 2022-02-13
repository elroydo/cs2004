package twoone.code_runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class class_test_two {
	public static void main(String[] args) {
		
//		for(int i=0; i<3; i++ ) {
//			System.out.println(RandomArray(20, (short) 20, (short) 0));
//		}
		System.out.println(RandomMatrix(10, 3, 500));
		
		PrintMatrix(RandomMatrix(30, 3, 500));
	}
	
	//question 1
	public static ArrayList<Short> RandomArray(int n, short maxVal, short minVal){
		ArrayList<Short> arr = new ArrayList<Short>();
		if(n<=0) return null;
		if(minVal>maxVal) return arr;
		
		for(int i=0; i<n; i++) {
			arr.add(UIRandomShort(maxVal, minVal));
		}
		return arr;
	}
	
	static public short UIRandomShort(int max, int min) {
		Random rand = new Random();
		short x = (short) (rand.nextInt(Math.max(min, max) - Math.min(min, max) + 1) + Math.min(min, max));
		return(x);
	}
	
	//question 2
	public static int[][] RandomMatrix(int n, int lower, int upper){
		try {
			int[][] matrix = new int[n][n];
			if(n<=0 || lower>upper) return null;
			
			for(int i=0; i<n; i++) {
				matrix[i][i] = lower;
				for(int j=0; j<i; j++) {
					int value = UIRandomInt(upper, lower);
					matrix[i][j] = value;
					matrix[j][i] = value;
					
				}
			}
			return matrix;
		} catch (NegativeArraySizeException e) {
		    return null;
		}
	}
	
	static public int UIRandomInt(int upper, int lower) {
		Random rand = new Random();
		return (rand.nextInt(Math.max(lower, upper) - Math.min(lower, upper) + 1) + Math.min(lower, upper));
	}
	
	public static void PrintMatrix(int[][] a) {
		Arrays.stream(a)
        .forEach(
            (row) -> {
                System.out.print("[");
                Arrays.stream(row)
                .forEach((el) -> System.out.print(" " + el + " "));
                System.out.println("]");
            }
        );
	}
}
