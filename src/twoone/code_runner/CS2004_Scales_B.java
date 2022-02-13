package twoone.code_runner;

import java.util.ArrayList;

class CS2004_Scales_B {
	public static ArrayList<Short> RunScales(int iterations, ArrayList<Double> weights) {
		try {
			if (weights == null) return null;
			if (weights.isEmpty()) return new ArrayList<Short>();
			if (iterations < 1) return null;
			ScalesSolution sol = new ScalesSolution(weights.size());
			double ef = 0;
			for (int i = 0; i < iterations; i++) {
				double of = sol.ScalesFitness(weights);
				String oldSol = sol.GetSol();
				sol.SmallChange();
				double nf = sol.ScalesFitness(weights);
				if (nf > of) {
					sol.SetSol(oldSol);
					;
				}
				ef = of;
			}
			System.out.println("Best solution fitness = " + ef);
			sol.println();
			return sol.returnArray();
		} catch (Exception e) {
			return null;
		}
	}
}

class ScalesSolution {
	private static String scasol;

	public ScalesSolution(String s) {
		boolean ok = true;
		int n = s.length();
		for (int i = 0; i < n; ++i) {
			char si = s.charAt(i);
			if (si != '0' && si != '1')
				ok = false;
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
			s = s + CS2004.UI(0, 1);
		}
		return (s);
	}

	public ScalesSolution(int n) {
		scasol = RandomBinaryString(n);
	}

	public double ScalesFitness(ArrayList<Double> weights) {
		if (scasol.length() > weights.size())
			return (-1);
		double lhs = 0.0, rhs = 0.0;
		int n = scasol.length();

		for (int i = 0; i < weights.size(); i++) {
			if (scasol.charAt(i) == '1') {
				lhs = lhs + weights.get(i);
			} else {
				rhs = rhs + weights.get(i);
			}
		}
		return (Math.abs(lhs - rhs));
	}

	public void SmallChange() {
		int leng = scasol.length();
		int x = CS2004.UI(0, (leng - 1));
		String newstr = "";

		for (int i = 0; i <= (x - 1); i++) {
			char thischar = scasol.charAt(i);
			newstr = newstr + thischar;
		}

		char characterAtp = scasol.charAt(x);
		if (characterAtp == '0') {
			characterAtp = '1';
			newstr += characterAtp;
		} else {
			characterAtp = '0';
			newstr += characterAtp;
		}

		for (int j = (x + 1); j <= (leng - 1); j++) {
			char characterAfterp = scasol.charAt(j);
			newstr = newstr + characterAfterp;
		}

		scasol = newstr;
	}

	public String GetSol() {
		return (scasol);
	}

	public void SetSol(String sol) {
		scasol = sol;
	}

	public void print() {
		System.out.print(scasol);
	}

	public void println() {
		print();
		System.out.println();
	}

	public ArrayList<Short> returnArray() {
		ArrayList<Short> arrShort = new ArrayList<Short>();
		for (int i = 0; i < scasol.length(); i++) {
			String str = Character.toString(scasol.charAt(i));
			arrShort.add(Short.valueOf(str));
		}
		return arrShort;
	}
}
