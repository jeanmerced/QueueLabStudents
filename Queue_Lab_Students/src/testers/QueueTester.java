package testers;

import classes.ArrayQueue;
import classes.SLLQueue;

public class QueueTester {
	
	public static void main(String[] args) {
		SLLQueue<Integer> q = new SLLQueue<>();
		//ArrayQueue<Integer> q = new ArrayQueue<>();
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
		
		System.out.println("Testing methods with empty queue");
		System.out.print("First: " + q.first() + " ");
		System.out.println("Dequeue: " + q.dequeue());
		
		System.out.println("Testing enqueue method");
		
		for(int i = 0; i < a.length; i++) {
			System.out.print("Enqueue: " + a[i] + " ");
			q.enqueue(a[i]);
			System.out.println("First: " + q.first());
		}
		
		System.out.println("Testing dequeue methods");
		
		for(int i = 0; i < a.length; i++) {
			System.out.print("First: " + q.first() + " ");
			System.out.println("Dequeue: " + q.dequeue());
		}
	}

}
