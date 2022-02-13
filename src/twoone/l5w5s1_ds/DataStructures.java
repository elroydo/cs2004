package twoone.l5w5s1_ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.Collection;
import java.util.Iterator;

public class DataStructures {
    public static void main(String args[]) {
        System.out.println("test");

        ArrayList<Data> arraylist = new ArrayList<Data>();

        arraylist.add(new Data("Fred", 21));
        arraylist.add(new Data("Jo", 43));
        arraylist.add(new Data("Zoe", 37));

        arraylinked_5_2_1(arraylist);
        arrayconsiderations_5_2_2();
        stacks_5_3(arraylist);
        queues_5_4(arraylist);
    }

    public static void arraylinked_5_2_1(ArrayList<Data> arraylist){
        LinkedList<Data> linkedlist = new LinkedList<Data>();

        System.out.println("arraylists and linkedlists");

        linkedlist.add(new Data("Fred", 21));
        linkedlist.add(new Data("Jo", 43));
        linkedlist.add(new Data("Zoe", 37));

        PrintCollection(arraylist);
        PrintCollection(linkedlist);
        System.out.println();
    }

    public static void arrayconsiderations_5_2_2() {
        ArrayList<Data> arrayA = new ArrayList<Data>();
        ArrayList<Data> arrayB = new ArrayList<Data>();
        ArrayList<Data> arrayC = new ArrayList<Data>();
        ArrayList<Data> arrayD = new ArrayList<Data>();

        System.out.println("arraylist considerations");

        arrayA.add(new Data("Fred", 21));
        arrayA.add(new Data("Jo", 43));
        arrayA.add(new Data("Zoe", 37));

        System.out.println("Assign array A to B:");

        PrintCollection(arrayA);
        arrayB = arrayA; //contnets are not copied, instead only points at the content to array A; sharing the same data
        PrintCollection(arrayB);
        arrayA.remove(1);
        PrintCollection(arrayB);
        System.out.println();

        arrayC.add(new Data("Fred", 21));
        arrayC.add(new Data("Jo", 43));
        arrayC.add(new Data("Zoe", 37));

        System.out.println("Clone array C to D:");

        PrintCollection(arrayC);
		arrayD = (ArrayList<Data>)arrayC.clone(); //actually copied all of the data from array C
		arrayC.remove(1);
		PrintCollection(arrayC);	
		PrintCollection(arrayD);
		System.out.println();

    }

    public static void stacks_5_3(ArrayList<Data> x) {
        Stack<Data> stack = new Stack<Data>();

        System.out.println("stacks");

        stack.addAll(x);
        PrintCollection(stack);

        while(stack.isEmpty() == false) {
            stack.pop().Print();
        }

        System.out.println("\nstack size = " + stack.size() + "\n");
    }

    public static void queues_5_4(ArrayList<Data> x) {
        ArrayBlockingQueue<Data> queue = new ArrayBlockingQueue<Data>(10);

        System.out.println("queues");

        queue.addAll(x);
        PrintCollection(queue);
        
        while(queue.isEmpty() == false) {
	        queue.poll().Print();
        }

        System.out.println("\nqueue size = " + queue.size() + "\n");

        for(int i=0;i<10;++i) {
            queue.add(new Data("Test:"+String.valueOf(i),i));
        }
        PrintCollection(queue);
    }

    public static void PrintCollection(Collection<Data> c) {
        for (Iterator<Data> iter = c.iterator(); iter.hasNext();) {
            Data x = (Data)iter.next();
            x.Print();
        }
        System.out.println();
    }
}