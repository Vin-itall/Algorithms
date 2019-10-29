package Huffmans;

import java.util.Comparator;

public class Node{
	Character C;
	int frequency;
	Node left;
	Node right;
	Node parent;
	boolean isLeft;
	boolean isRight;
	boolean isParent;
	public Node(char Ch,int f) {
		C=Ch;
		frequency = f;
		left=null;
		right=null;
		parent = null;
		isLeft =false;
		isRight = false;
		isParent = false;
	}
	
	
	public Node(int f)
	{
		C=null;
		frequency = f;
		left=null;
		right=null;
		parent = null;
		isLeft = false;
		isRight = false;
		isParent = false;
	}
	  public static Comparator<Node> frequencyComp = new Comparator<Node>() {

			public int compare(Node s1, Node s2) {
			   Integer	f1 = s1.frequency;
			   Integer f2 = s2.frequency;

			   //ascending order
			   return f1.compareTo(f2);

			   //descending order
			   //return StudentName2.compareTo(StudentName1);
		    }};
}