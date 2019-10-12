package DijkstrasAlg;
import java.util.*;
public class PriQueue {
private ArrayList<Vertex> Priqueue=new ArrayList<Vertex>();
public void enqueue(Vertex A)
{
	Priqueue.add(A);
	A.isVisitedB=true;
	System.out.println(A.Value+"Added");
}
public void dequeue()
{
	Vertex A=Priqueue.get(0);
	Priqueue.remove(0);
	System.out.println(A.Value+"Removed");
	
}
public Vertex First()
{
	Vertex A=Priqueue.get(0);
	return A;
}
public boolean isEmpty()
{
	if(Priqueue.size()==0)
	{
		return true;
	}
return false;
}
}
