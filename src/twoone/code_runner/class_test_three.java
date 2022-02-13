package twoone.code_runner;

import java.util.ArrayList;
import java.util.Random;

public class class_test_three {
	public static void main(String[] args) {
		ArrayList<Double> weights = new ArrayList<Double>();
		ArrayList<Boolean> scale = new ArrayList<Boolean>();
		
		//System.out.println(weights = RandomWeights(10, 0, 100));
		//System.out.println(scale = RandomScale(weights.size()));
		
		for(int i=0; i<10; i++) {
			weights = RandomWeights(10, 0, 100);
			scale = RandomScale(weights.size());
			System.out.println(ScalesFitness(scale, weights));
		}
	}
	
	//question 1
	public static double ScalesFitness(ArrayList<Boolean> rep, ArrayList<Double> weights) {
		if(rep == null || weights == null || rep.size() == 0 || weights.size() == 0 || rep.size()>weights.size()) return -100;
		double lhs = 0.0, rhs = 0.0;
		
		for(int i=0; i<weights.size(); i++) {
			if(rep.get(i)==false) {
				lhs = lhs + weights.get(i);
			} else {
				rhs = rhs + weights.get(i);
			}
		}
		return(Math.abs(lhs-rhs));
	}
	
	public static ArrayList<Double> RandomWeights(int n, double min, double max) {
		ArrayList<Double> aW = new ArrayList<Double>();
		for(int i=0; i<n; i++) {
			aW.add(URDouble(min, max));
		}
		return aW;
	}

	public static ArrayList<Boolean> RandomScale(int n) {
		ArrayList<Boolean> aS = new ArrayList<Boolean>();
		for(int i=0; i<n; i++) {
			int flip = UIInt(0, 1);
			if(flip==0) aS.add(false);
			if(flip==1) aS.add(true);
		}
		return aS;
	}
	
	//question 2
	public static String RandomBinaryString(int n){
		String binaryString = "";
		if(n<=0) return binaryString;
		for(int i=0; i<n; i++) {
			binaryString = binaryString + UIInt(0, 1);
		}
		return(binaryString);
	}
	
	static public double URDouble(double a, double b) {
		Random rand = new Random();
		return((b-a)*rand.nextDouble()+a);
	}
	
	static public int UIInt(int aa,int bb) {
		Random rand = new Random();
		int a = Math.min(aa,bb);
		int b = Math.max(aa,bb);
		int d = b - a + 1;
		int x = rand.nextInt(d) + a;
		return(x);
	}
}
