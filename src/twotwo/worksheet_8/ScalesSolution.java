package twotwo.worksheet_8;

import java.util.*;

public class ScalesSolution {
	private String scasol;
	// Creates a new scales solution based on a string parameter
	// The string parameter is checked to see if it contains all zeros and ones
	// Otherwise the random binary string generator is used (n = length of
	// parameter)
	public ScalesSolution(String s) {
		boolean ok = true;
		int n = s.length();
		for (int i = 0; i < n; ++i) {
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
		for (int i = 0; i < n; i++) {
			s += CS2004.UI(0, 1);
		}
		return (s);
	}

	public ScalesSolution(int n) {
		scasol = RandomBinaryString(n);
	}

	// This is the fitness function for the Scales problem
	// This function returns -1 if the number of weights is less than
	// the size of the current solution
	public double ScalesFitness(ArrayList<Double> weights) {
		if (scasol.length() > weights.size())
			return (-1);
		double lhs = 0.0, rhs = 0.0;
		int n = scasol.length();

		for (int i = 0; i < n; i++) {
			if (scasol.charAt(i) == '0') lhs += weights.get(i);
			rhs += weights.get(i);
		}
		return (Math.abs(lhs - rhs));
	}

	public void SmallChange() {
		int n = scasol.length();
		int p = CS2004.UI(0, n-1);
		String x = "";
		char y = Switch(scasol.charAt(p));

		if (p == 0) {
			x = y + scasol.substring(p+1, n);
		} else if (p == n) {
			x = scasol.substring(0, n-1) + y;
		} else {
			x = scasol.substring(0, p) + y + scasol.substring(p+1, n);
		}
		
		scasol = x;
	}

	public String Switch(String s) {
		if (s == "1") return "0";
		return "1";
	}

	public char Switch(char c) {
		if (c == '1') return '0';
		return '1';
	}

	public Character Switch(Character c) {
		if (c == '1') return '0';
		return '1';
	}

	public String GetSol() {
		return(scasol);
	}

	public void SetSol(String sol) {
		scasol = sol;
	}

	// Display the string without a new line
	public void print() {
		System.out.print(scasol);
	}

	// Display the string with a new line
	public void println() {
		print();
		System.out.println();
	}
}