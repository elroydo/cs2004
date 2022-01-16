package code_runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class mock_test {
	public static void main(String[] args) {
		double[] values = {2.2, 3.3, 42.4, 5.5, 6.6};
		ArrayList<Double> array = new ArrayList<Double>();
		
		for(int i=0;i<values.length;i++) {
			array.add(values[i]);
		}



		System.out.println(DoCalculation(1.5, 24.2, 3.1));
		System.out.println(ArrayMax(array));
	}
	
	public static double DoCalculation(double a, double b, double c){
		double x = 0;
		return x = (100.3*(a+b))-c;
	}
	
	public static double ArrayMax(ArrayList<Double> array) {
		double max = 0;
		
		if(!array.isEmpty()) {
			for(int i=0; i<array.size(); i++) {
				if(array.get(i)>max) {
					max = array.get(i);
				}
			}
			return max;
		}
		return Double.MIN_VALUE;
		
		/*
		if(array != null || !array.isEmpty()) {
			for(Double x: array) {
				if(x == null) {
					
				}
			}
		}
		*/
	}
}
