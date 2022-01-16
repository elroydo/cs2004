package worksheet_5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class dataStructures {

	public static void main(String[] args) {
		ArrayList<Data> array = new ArrayList<Data>();

		System.out.println("array lists");
		array.add(new Data("cuck", 33));
		array.add(new Data("evelyn", 22));
		array.add(1, new Data("caspian", 44)); // in-between prior data
		PrintCollection(array);

		linkedLists(array);
		considerations(array);

		array.add(new Data("evelyn", 22));
		array.add(new Data("caspian", 44));

		stacks(array);
		queues(array);
	}

	public static void linkedLists(ArrayList<Data> a) {
		System.out.println("linked lists");
		LinkedList<Data> ll = new LinkedList<Data>();

		ll.add(new Data("cuck", 33));
		ll.add(new Data("evelyn", 22));
		ll.add(new Data("caspian", 44));

		PrintCollection(ll); // no differences really, at least not yet
	}

	@SuppressWarnings("unchecked")
	public static void considerations(ArrayList<Data> array) {
		System.out.println("\nconsiderations");
		ArrayList<Data> a = array;
		ArrayList<Data> b = new ArrayList<Data>();
		ArrayList<Data> c = new ArrayList<Data>();
		ArrayList<Data> d = new ArrayList<Data>();

		PrintCollection(array); // print main array
		b = a; // assign values from a to b
		c = a; // pointer assignment
		a.remove(1); // remove data from a at index 1
		PrintCollection(b); // print array b which has been affected...
		d = (ArrayList<Data>) c.clone(); // copy all elements
		PrintCollection(d);
		c.remove(1); // remove data from index
		PrintCollection(c);
		PrintCollection(d);
	}

	public static void stacks(ArrayList<Data> array) {
		System.out.println("\nstacks");
		Stack<Data> x = new Stack<Data>();

		for (int i = 0; i < array.size(); i++) {
			x.add(array.get(i));
		}

		while (x.isEmpty() == false) {
			x.pop().Print();
		}
		System.out.println("\nstack size: " + x.size());
	}

	public static void queues(ArrayList<Data> array) {
		System.out.println("\nqueues");
		ArrayBlockingQueue<Data> x = new ArrayBlockingQueue<Data>(10);

		for (int i = 0; i < array.size(); i++) {
			x.add(array.get(i));
		}

		PrintCollection(x);

		while (x.isEmpty() == false) {
			x.poll().Print();
		}
		System.out.println("\n");
		for (int i = 0; i < 10; ++i) {
			x.add(new Data("Test:" + String.valueOf(i), i));
		}
		PrintCollection(x);

	}

	public static void PrintCollection(Collection<Data> c) {
		for (Iterator<Data> iter = c.iterator(); iter.hasNext();) {
			Data x = (Data) iter.next();
			x.Print();
		}
		System.out.println();
	}

}
