package twoone.l6w6s1_sa;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class sorting_algorithms {
	public static void main(String[] args) throws IOException {
		run();
	}

	public static ArrayList<Integer> randArray(int n) {
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		
		for(int i=0; i<n;i++) {
			intArray.add(random());
		}
		return intArray;
	}
	
	public static int random() {
		Random random = new Random();
		return random.nextInt(256);
	}
	
	public static int randomAppendix() {
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		return random.nextInt() % 256;
	}
	
	public static void printArray(ArrayList<Integer> array) {
		for(int i=0;i<array.size();i++) {
			System.out.println(array.get(i));
		}
	}
	
	public static void run() throws IOException {
		long StartTime, EndTime, ElapsedTime = 0;
		ArrayList<Integer> res = new ArrayList<Integer>();
		long[] a = new long[50], b = new long[50], c = new long[50];
		
		for(int i=0;i<50;i++) {
			System.out.println("Iteration sequence " + (i+1));
			ArrayList<Integer> intArray = randArray((i+1)*1000);
			StartTime = System.nanoTime();
			res = three_sorts.SortA(intArray);
			EndTime = System.nanoTime();
			a[i] = EndTime-StartTime;
			System.out.println("sortA Run time = " + (EndTime-StartTime));
			StartTime = System.nanoTime();
			res = three_sorts.SortB(intArray);
			EndTime = System.nanoTime();
			b[i] = EndTime-StartTime;
			System.out.println("sortB Run time = " + (EndTime-StartTime));
			StartTime = System.nanoTime();
			res = three_sorts.SortC(intArray);
			EndTime = System.nanoTime();
			c[i] = EndTime-StartTime;
			
			System.out.println("sortC Run time = " + (EndTime-StartTime) + "\n");
			
		}
		System.out.println("end");
		
		write(a);
		write(b);
		write(c);
	}
	
	public static void write(long[] a) throws IOException {
		FileWriter fw = new FileWriter("src/twoone/l6w6s1_sa/out.txt", true);
		
		fw.write("\n");
		for(int i=0;i<a.length;i++) {
			fw.write(String.valueOf(a[i]) + "\n");
		}
		
		fw.close();
	}
}
