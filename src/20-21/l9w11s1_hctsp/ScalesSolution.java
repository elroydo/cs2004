package l9w11s1_hctsp;

import java.util.*;

public class ScalesSolution {
	private static String scasol;
	//Creates a new scales solution based on a string parameter
	//The string parameter is checked to see if it contains all zeros and ones
	//Otherwise the random binary string generator is used (n = length of parameter)
	public ScalesSolution(String s) {
		boolean ok = true;
		int n = s.length();
		for(int i=0;i<n;++i) {
			char si = s.charAt(i);
			if (si != '0' && si != '1') ok = false;
		}
		if (ok) {
			scasol = s;
		} else {
			scasol = RandomBinaryString(n);
		}
	}
	
	static String RandomBinaryString(int n) {
		String s = new String();
		//a random binary string of just ones and zeros of length n
		
		for(int i=0;i<n;i++) {
			s = s + CS2004.UI(0,1);
		}
		return(s);
	}
	
	public ScalesSolution(int n) {
		scasol = RandomBinaryString(n);	
	}
	
	//This is the fitness function for the Scales problem
	//This function returns -1 if the number of weights is less than
	//the size of the current solution
	public static double ScalesFitness(ArrayList<Double> weights) {
		//return -1 if the solution length is more than the weights
		if (scasol.length() > weights.size()) return(-1);
		double lhs = 0.0, rhs = 0.0;
		int n = scasol.length();
		
		for(int i=0;i<weights.size();i++) {
			if(scasol.charAt(i)=='0') {
				lhs = lhs + weights.get(i);
			} else {
				rhs = rhs + weights.get(i);
			}
		}
		//Check each element of scasol for a 0 (lhs) and 1 (rhs) add the weight wi
		//to variables lhs and rhs as appropriate
		return(Math.abs(lhs-rhs));
	}
	
	public void SmallChange() {
//		int n = scasol.length(), p = CS2004.UI(0, (n-1));
//		String x = scasol.substring(0, p); //dont follow that p-1 from the ws
//		
//		if(scasol.charAt(p)=='0'){
//			x += '1';
//		} else {
//			x += '0';
//		}
//		scasol = (x += scasol.substring(p+1, n));
		
		int leng = scasol.length();
		int x = CS2004.UI(0, (leng-1));
		String newstr = "";
		
		for(int i=0; i<=(x-1); i++) {
			char thischar = scasol.charAt(i);
			newstr = newstr + thischar;
		}
		
		char characterAtp = scasol.charAt(x);
		if(characterAtp == '0') {
			characterAtp = '1';
			newstr += characterAtp;
		} else {
			characterAtp = '0';
			newstr += characterAtp;
		}
		
		for(int j=(x+1); j<=(leng-1); j++) {
			char characterAfterp = scasol.charAt(j);
			newstr = newstr + characterAfterp;
		}
		
		scasol = newstr;
	}
	
	public String GetSol() {
		return(scasol);
	}
	
	public void SetSol(String sol) {
		scasol = sol;
	}
	
	//Display the string without a new line
	public void print() {
		System.out.print(scasol);
	}
	
	//Display the string with a new line
	public void println() {
		print();
		System.out.println();
	}
}