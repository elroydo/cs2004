package twotwo.worksheet_9;

import java.util.ArrayList;

import twotwo.worksheet_8.*;

public class hillClimbing {
    public static void main(String[] args) {
        // ScalesSolution s = new ScalesSolution("11111");

        // for (int i = 0; i<10; i++) {
        //     s.println();
        //     s.SmallChange();
        //     s.println();
        //     System.out.println();
        // }

        // ScalesSolution s1 = new ScalesSolution(10);
        // s1.println();
        // ScalesSolution s2 = new ScalesSolution(s1.GetSol());
        // s2.println();
        
        ArrayList<Double> w = new ArrayList<Double>(), primes = new ArrayList<Double>();
        int n = 1000;

        primes = CS2004.ReadNumberFile("src\\twotwo\\worksheet_8\\Primes.txt");
		w = new ArrayList<Double>();
		
		for(int i=0;i<n;i++ ) {
			w.add(primes.get(i));
		}

        RMHC(w, n, 1000);
    }

    public static ScalesSolution RMHC(ArrayList<Double> weights, int n, int iter) {
        ScalesSolution sol = new ScalesSolution(n);
        double f = sol.ScalesFitness(weights), nF;

        System.out.println("initial fitness="+f);
        for(int i=0; i<iter; i++) {
            f = sol.ScalesFitness(weights);
            String oldSol = sol.GetSol();
            sol.SmallChange();
            nF = sol.ScalesFitness(weights);
            if (nF > f) {
                sol.SetSol(oldSol);;
            }
            System.out.println("iteration: " + i + " current fitness="+f);
        }
        System.out.println("final fitness="+f);
        return(sol);
    }
}
