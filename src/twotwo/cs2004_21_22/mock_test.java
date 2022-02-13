package twotwo.cs2004_21_22;

import java.util.ArrayList;
import java.util.Collections;


public class mock_test {
	public static void main(String[] args) {
		ArrayList<Double> a = new ArrayList<Double>();
		
		a.add(1.1);
		a.add(2.2);
		a.add(3.3);
		
		System.out.println(Hello());
		System.out.println(ArrayMax(a));
	}
	
	public static String Hello() {
		String x = "Hello M!";
		return x;
	}
	
	public static double ArrayMax(ArrayList<Double> array) {
		if(array.isEmpty()) {
			return Double.MIN_VALUE;
		}

		return Collections.max(array);
	}
}
