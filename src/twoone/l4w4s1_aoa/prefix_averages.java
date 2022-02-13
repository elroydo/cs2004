package twoone.l4w4s1_aoa;

import java.util.Arrays;

public class prefix_averages {
    public static void main(String[] args) {
        double[] x = new double[]{7, 3, -1, 2, 9, 0, 0.8, 52, 2.2, 900};
        
        System.out.println(Arrays.toString(prefix_averages1(x)) + "\n");
        System.out.println(Arrays.toString(prefix_averages2(x)));

    }
    
    public static double[] prefix_averages1(double[] x) {
        double[] a = new double[x.length]; //created an array the size of the x array

        for(int i=0; i<a.length; i++){ 
            double s = x[0]; //first element of x array is assigned to s
            for(int j=1; j<a.length;j++) {
                if(j<=i) {
                    s=s+x[j]; //current value of s plus the element index of j from x
                }
            }
            a[i] = s/(i+1); //assigns value to i index of a
        }
        return a;
    }

    public static double[] prefix_averages2(double[] x) {
        double[] a = new double[x.length]; //created an array the size of the x array
        double s = 0;

        for(int i=0; i<x.length; i++){
            s = s + x[i];  //current value of s plus the element index i from x
            a[i] = s/(i+1); //assigns value to i index of a
        }
        return a;
    }
}
//complete computational complexity and tests -- lab 4