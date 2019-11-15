package Trees;
import java.util.*;

public class BinaryTree {
	Node Root = new Node(null);
	int leftDepth =0; 
	int rightDepth = 0;
	ArrayList<Node> inorderL = new ArrayList<Node>();
	ArrayList<Node> preorderL = new ArrayList<Node>();
	ArrayList<Node> postorderL = new ArrayList<Node>();
	
	public void insertNode(int x)
	{
		int Count = 0;
		Node Current = Root;
		if(Root.Value==null)
		{
			Root.Value = x;
		}
		else
		{
			Node Next = new Node(null);
			while(Next.Value == null)
			{
				if(x > Current.Value)
				{
					if(Count==0)
					{
							rightDepth++;
							Count++;
					}
					if(Current.Right != null)
					{	
						Current = Current.Right;
					}
					else
					{
						Next.Value = x;
						Next.Parent = Current;
						Current.Right = Next;
					}
				}
				else if(x < Current.Value)
				{
					if(Count==0)
					{
							leftDepth++;
							Count++;
					}
					if(Current.Left != null)
					{	
						Current = Current.Left;
					}
					else
					{
						Next.Value = x;
						Next.Parent = Current;
						Current.Left = Next;
					}
				}
			}	
			System.out.println("Left Depth = " + leftDepth +" Right Depth = " + rightDepth);
		}
	}
	
	//inorder is (Left,Root,Right)
	public void inorderTraversal(Node n)
	{
		if(n == null)
			return;
		inorderTraversal(n.Left);
		inorderL.add(n);
		inorderTraversal(n.Right);
		
	}
	
	//postorder is (Left,Right,Root)
	public void postorderTraversal(Node n)
	{
		if(n == null)
			return;
		postorderTraversal(n.Left);
		postorderTraversal(n.Right);
		postorderL.add(n);
	}
	
	//preorder is (Root,Left,Right)
	public void preorderTraversal(Node n)
	{	
		if(n == null)
			return;
		preorderL.add(n);
		preorderTraversal(n.Left);
		preorderTraversal(n.Right);
		
	}
	
	public static void main(String args[])
	{
		BinaryTree BT = new BinaryTree();
		BT.insertNode(20);
		BT.insertNode(22);
		BT.insertNode(10);
		BT.insertNode(12);
		BT.inorderTraversal(BT.Root);
		BT.postorderTraversal(BT.Root);
		BT.preorderTraversal(BT.Root);
		for(Node node : BT.preorderL)
		{
			System.out.print(node.Value+" ");
		}
	}
}
