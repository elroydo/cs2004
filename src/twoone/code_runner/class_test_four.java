package twoone.code_runner;

import java.util.ArrayList;
import java.util.Random;

public class class_test_four {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		for(int i=0; i<10; i++) {
			a.add(UIInt(0, 1));
		}
		
		System.out.println(OneMaxFitness(a));
	}
	
	public static double OneMaxFitness(ArrayList<Integer> rep){
		try {
			if(rep == null || rep.isEmpty()) return -1;
			double f = 0;
			for(int i=0;i<rep.size();++i) {
				int bVal = rep.get(i);
				if (bVal == 0 || bVal == 1) {
					f += bVal;
				} else {
					return -2;
				}
			}
			return(f);
		} catch(Exception e) {
			return -2;
		}
	}
	
	public static String RandomBinaryString(int n){
		String binaryString = "";
		if(n<=0) return binaryString;
		for(int i=0; i<n; i++) {
			binaryString = binaryString + UIInt(0, 1);
		}
		return(binaryString);
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
