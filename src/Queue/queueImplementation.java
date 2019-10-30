package Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class queueImplementation {
	ArrayList<Integer> queue;
	int head;
	int tail;
	int size;
	int Occupied=0;
	boolean Empty;
	public queueImplementation(int Size) {
		this.queue = new ArrayList<Integer>(Collections.nCopies(Size, 0));
		this.head= 0;
		this.tail =0;
		this.size=Size;
	}
	public void enqueue(int Element)
	{	
		if(isEmpty())
		{
			tail = 0;
			head = 0;
		}
		if(tail!=this.size)
		{
			this.queue.set(tail,Element);
			Occupied++;
			System.out.print(Arrays.toString(this.queue.toArray()));
			tail++;
		}
		else
		{
			System.out.print("Queue is full");
		}
	}
	public void dequeue()
	{
		int Element;
		if(!isEmpty())
		{	
			Element = this.queue.get(head);
			System.out.print(Element);
			this.queue.set(head,-1);
			Occupied--;
			//System.out.print("occupied " + Occupied);
			head++;
		}
		else
		{
			System.out.print("Queue is empty");
		}
	}
	public boolean isEmpty()
	{
		if(tail==head || Occupied == 0)
		{
			Empty = true;
		}
		else
		{
			Empty = false;
		}
		return Empty;
	}
	
	public static void main(String args[])
	{
		queueImplementation queue = new queueImplementation(3);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(4);
		queue.dequeue();
	}
}
