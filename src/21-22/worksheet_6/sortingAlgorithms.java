package worksheet_6;

import java.util.ArrayList;
import java.util.Random;

public class sortingAlgorithms {
	public static void main(String[] args) {
		long startTime, endTime;

		for (int i = 0; i < 25; i++) {
			ArrayList<Integer> array = randomArray((i+1)*1000);
			System.out.println("Iteration sequence " + (i + 1));
			System.out.println("Sort A:");
			startTime = System.nanoTime();
			ThreeSorts.SortA(array);
			endTime = System.nanoTime();
			System.out.println(endTime-startTime);
			System.out.println("Sort B:");
			startTime = System.nanoTime();
			ThreeSorts.SortB(array);
			endTime = System.nanoTime();
			System.out.println(endTime-startTime);
			System.out.println("Sort C:");
			startTime = System.nanoTime();
			ThreeSorts.SortC(array);
			endTime = System.nanoTime();
			System.out.println(endTime-startTime);
		}
	}

	public static ArrayList<Integer> randomArray(int n) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			array.add(random());
		}
		return array;
	}

	public static int random() {
		Random random = new Random();
		return random.nextInt(256);
	}

	// rubbish
	public static int randomAppendix() {
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		return Math.abs(rand.nextInt() % 256);
	}

	public static void printArray(ArrayList<Integer> array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i) + " ");
		}
	}
}
