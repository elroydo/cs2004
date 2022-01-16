package code_runner;

import java.util.ArrayList;

public class class_test_one {
	public static void main(String[] args) {
		ArrayList<Float> array = null;
		float[] values = {7, 3, -1, 2, 9, 0, 0.8f, 52, 2.2f, 900};
		
		//for(int i=0;i<values.length;i++) {
		//	array.add(values[i]);
		//}
		//array.add(null);
		
		System.out.println(PrefixAverage(array));
	}
	
	public static ArrayList<Float> PrefixAverage(ArrayList<Float> X){
		ArrayList<Float> a = new ArrayList<Float>();
		float s = 0;
		
		if(X == null || X.isEmpty()) return null; 

		for(Float x: X) {
			if(x == null) {
				return null;
			}
		}
		
		for(int i=0; i<X.size(); i++){
            s = s + X.get(i);
            a.add(s/(i+1)); 
        }
		return a;
	}
}
