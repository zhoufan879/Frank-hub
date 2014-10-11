package frank.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	private static Queue<String> q = new LinkedList<String>();
	
	public static void main(String[] args) {
		
		add();
		display();
		
		System.out.println(q.poll());
		display();

		System.out.println(q.element());
		display();

		System.out.println(q.peek());
		display();
	}
	
	public static void add( ){
		q.add("a");
		q.add("b");
		q.add("c");
		q.add("d");
		q.add("e");
		
	}
	
	public static void display(){
		for (String string : q) {
			System.out.print(string + " ");
		}		
		System.out.println();
	}

}
