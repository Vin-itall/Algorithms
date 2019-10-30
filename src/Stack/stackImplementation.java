package Stack;
import java.util.ArrayList;
import java.util.Arrays;

public class stackImplementation {
	int[] Stack;
	int Top=-1;
	public stackImplementation(int Size)
	{
		Stack = new int[Size];
	}
	public void push(int Element)
	{
		if(Top!=this.Stack.length-1)
		{
			Top++;
			this.Stack[Top]=Element;
			System.out.println(Arrays.toString(this.Stack));
		}
		else
		{
			System.out.println("Stack is full");
		}
	}
	public int pop()
	{
		int Element;
		if(Top!=-1)
		{
			Element = this.Stack[Top];
			this.Stack[Top]=-1;
			Top--;
			//System.out.println(Arrays.toString(this.Stack));
		}
		else
		{
			Element =-1;
			System.out.println("Stack is empty");
		}
		return Element;
	}
	
	public static void main(String args[])
	{
		stackImplementation Stack= new stackImplementation(3);
		Stack.push(3);
		Stack.push(4);
		Stack.push(5);
		Stack.push(6);
		System.out.println(Stack.pop());
		System.out.println(Stack.pop());
		System.out.println(Stack.pop());
		System.out.println(Stack.pop());
		Stack.push(6);
		Stack.push(7);
		Stack.push(8);
	}
}
