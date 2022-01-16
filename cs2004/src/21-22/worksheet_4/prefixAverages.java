package worksheet_4;

import java.util.Arrays;

public class prefixAverages {
	public static void main (String args[]) {
		float x[] = { 7, 3, -1, 2, 9, 0, 0.8f, 52, 2.2f, 900};
		
		printArray(prefixAverages1(x));
		printArray(prefixAverages2(x));
	}
	
	public static float[] prefixAverages1(float x[]) {
		int n = x.length;
		float a[] = new float[n];
		
		for (int i = 0; i<n; i++) {
			float s = x[0];
			for (int j = 1; j<n; j++) {
				if (j<=i) s += x[j];
			}
			a[i] = s/(i+1);
		}
		return a;
	}
	
	public static float[] prefixAverages2(float x[]) {
		int n = x.length;
		float a[] = new float[n], s = 0;
		
		for (int i = 0; i<n; i++) {
			s += x[i];
			a[i] = s/(i+1);
		}
		
		return a;
	}
	
	public static void printArray(float a[]) {
		System.out.println(Arrays.toString(a));
	}
}
