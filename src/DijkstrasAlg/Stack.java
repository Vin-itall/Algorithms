package DijkstrasAlg;
import java.util.*;
public class Stack {
protected String Result=" ";
private ArrayList<Vertex> stack =new ArrayList<Vertex>(10);
public void push(Vertex A)
{
	stack.add(A);
	A.isVisitedD=true;
	System.out.println(A.Value+"Pushed");	
}
public void pushv(Vertex A)
{
	stack.add(A);
//	A.isVisitedD=true;
	System.out.println(A.Value+"Pushed");	
}
public void pop()
{	if(!isEmpty())
	{
	int W=stack.size();
	Vertex X=stack.get(W-1);
	Result+="->"+X.Value;
	stack.remove(W-1);
	System.out.println(X.Value+"Popped");	
	}
	else
	{
		stack.remove(0);
	}
}
public int top()
{
	if(!isEmpty())
	{	int W=stack.size();
	Vertex X=stack.get(W-1);
	return X.Vid;
	}
	else
	{
		return -1;
	}
}
public Vertex topV()
{
	if(!isEmpty())
	{	int W=stack.size();
	Vertex X=stack.get(W-1);
	return X;
	}
	else
	{
		return null;
	}
}
public void show()
{
	String tot="";
for(int i=0;i<stack.size();i++)
{
	tot=tot+stack.get(i).Value;
}
System.out.print(tot);
}
public boolean isEmpty()
{
	if(stack.size()==0)
	{
		return true;
	}
	return false;
}
}
