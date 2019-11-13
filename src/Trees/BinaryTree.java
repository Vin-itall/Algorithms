package Trees;

public class BinaryTree {
	Node Root = new Node(null);
	
	public void insertNode(int x)
	{
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
		}
	}

	
	
	public static void main(String args[])
	{
		BinaryTree BT = new BinaryTree();
		BT.insertNode(20);
		BT.insertNode(22);
		BT.insertNode(10);
		BT.insertNode(12);
	}
}
