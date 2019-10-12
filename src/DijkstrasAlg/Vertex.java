package DijkstrasAlg;
/*
 * Following is the vertex class for graphs
 * Each vertex can have the following ID,Value(Data),isVisitedD/isVisitedB flags(For not getting into infinite loops)
 * isVisitedD/isVisitedB flags are separately implemented to enable the simultaneous checking of BFS and DFS without have a "resetflags" method
 */
public class Vertex {
int Vid;
String Value;
boolean isVisitedD,isVisitedB;
int Pl;
Vertex Parent;
Vertex Child;
public Vertex(int a,String A)
{	
	Pl=Integer.MAX_VALUE;
	Vertex Parent=null;
	Vertex Child=null;
	Vid=a;
	Value=A;
	isVisitedD=false;
	isVisitedB=false;
}
}
