package twotwo.worksheet_2;

public class ArrayMaxExercise {
	public static void main(String args[]) {
		double arr[] = { 1, 2, 3, 0, 5, 6 };
		
		ArrayMax(arr);
	}
	
	public static double ArrayMax(double array[]) {
		int n = array.length;
		double currentMax = array[0], currentMin = array[0];
		
		for(int i=1; i<=n-1; i++) {
			if(array[i]>currentMax) {
				currentMax = array[i];
			} else {
				currentMin = array[i];
			}
		}
		
		System.out.println("max = " + currentMax + "\n" + "min = " + currentMin);

		return currentMin;
	}
}