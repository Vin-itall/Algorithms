package DijkstrasAlg;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
	ArrayList<Vertex> Vertices=new ArrayList<Vertex>();
	int AdjMat[][];
	Stack TStack=new Stack();
	PriQueue Que=new PriQueue();
	Stack st=new Stack();
	static int NoV;
	
public void intialize(int L)
{	NoV=L;
	for(int i=0;i<L;i++)
	{	String B="";
		if(i<25)
		{ B=Character.toString((char)(i+65));}
		else if(i>25)
		{
			B=Character.toString((char)(i+65))+Character.toString((char)(i+65));;
		}
		Vertex New=new Vertex(i,B);
		Vertices.add(New);
		System.out.println(New.Value+"Added");
	}
	
	 AdjMat=new int[Vertices.size()][Vertices.size()];
	 this.matrix();
}	
public void matrix()
{	
	for(int row=0;row<Vertices.size();row++)
	{
		for(int col=0;col<Vertices.size();col++)
		{
			AdjMat[row][col]=0;
		}
	}
}
public void addEdges(int K)
{ 
	for(int k=0;k<K;k++)
	{
		System.out.println("Input Start Vertex");
		Scanner sb=new Scanner(System.in);
		int S=sb.nextInt();
		
		System.out.println("Input End Vertex");
		Scanner sz=new Scanner(System.in);
		int E=sz.nextInt();
		
		System.out.println("Input Weight");
		Scanner sn=new Scanner(System.in);	
		int W=sn.nextInt();
		
		this.addEdge(S, E, W);
	}
	
}
public void addEdge(int a,int b,int X)
	{		
			AdjMat[a][b]=1*X;
			//AdjMat[b][a]=1; /*For Unidirectional Graph Uncomment*/
	}
public void DFS(int Start,int End)
{Vertex Strt=null;
Vertex Ed=null;
	for(int j=0;j<Vertices.size();j++)
	{
	if(Vertices.get(j).Vid==Start)
	{ Strt=Vertices.get(j);}
	else if(Vertices.get(j).Vid==End)
	{ Ed=Vertices.get(j);}
	}
	Vertex Next=new Vertex(Integer.MIN_VALUE,"");
	TStack.push(Strt);
	if(AdjMat[Strt.Vid][Ed.Vid]>=1)
	{
		TStack.Result+="->"+Strt.Value+"->"+Ed.Value;
		System.out.println(TStack.Result);
		System.out.println("///////Has Path///////");
	}
	else
	{	
		TStack.pop();
		for(int i=0;i<=4;i++)
		{
			if(AdjMat[Strt.Vid][i]>=1)
			{	
				if(!Vertices.get(i).isVisitedD)
				TStack.push(Vertices.get(i));
			}
		}
		int t=TStack.top();
		if(t>=0)
		{
		Next=Vertices.get(t);
		DFS(Next.Vid,Ed.Vid);
		}
		else
		{
			System.out.println("Empty Stack");
		}
		}	
}
public String BFS(int Start,int End)
{	
	System.out.println("-------------------BFS----------------------");
	Vertex Strt=null;
	Vertex Ed=null;
		for(int j=0;j<Vertices.size();j++)
		{
		if(Vertices.get(j).Vid==Start)
		{ Strt=Vertices.get(j);}
		else if(Vertices.get(j).Vid==End)
		{ Ed=Vertices.get(j);}
		}
	Vertex Next=new Vertex(Integer.MIN_VALUE,"");
	Que.enqueue(Strt);
	if(AdjMat[Strt.Vid][Ed.Vid]>=1)
	{
	return "///////Has Path///////";
	}
	Next=Strt;
	while(!Que.isEmpty())
	{
	if(AdjMat[Next.Vid][Ed.Vid]>=1)
	{
	return "///////Has Path///////";
	}
	else
	{
	for(int i=0;i<=4;i++)
	{
	if(AdjMat[Next.Vid][i]>=1)
	{	
		if(!Vertices.get(i).isVisitedB)
		{	Que.enqueue(Vertices.get(i));}
	}
	}
	Que.dequeue();
	Next=Que.First();
	}
	}
	return "////Doesnt Have Path////";
}
public void Dijkstras(int Start,int End)
{
	Vertex Strt=null;
	Vertex Ed=null;
		for(int j=NoV-1;j>=0;j--)
		{
		if(Vertices.get(j).Vid==Start)
		{ Strt=Vertices.get(j);}
		else if(Vertices.get(j).Vid==End)
		{ Ed=Vertices.get(j);}
		st.push(Vertices.get(j));
		}
			Vertex Current=null;
		while(!st.isEmpty())
		{	int inf=Integer.MAX_VALUE;
			Current = st.topV();
			ArrayList<Vertex> Temp=new ArrayList<Vertex>();
			for(int i=NoV-1;i>=0;i--)
			{	Vertex Tempo=Vertices.get(i);
				int Dis=AdjMat[Current.Vid][Tempo.Vid];
				if(Current.Pl==inf)
				{Current.Pl=0;}
			    if(Dis+Current.Pl<Tempo.Pl && Dis!=0)
			    {
			    	Tempo.Parent=Current;
			    	Tempo.Pl=Dis+Current.Pl;
			    	Current.Child=Tempo;
			    	Temp.add(Tempo);
			    }
			    else if(Dis!=0)
			    {
			    	Temp.add(Tempo);
			    }
			}
		
			Vertex Min=null;
			for(int k=0;k<Temp.size();k++)
			{ 
			Vertex Tempo=Temp.get(k);
				if(Tempo.Pl<inf)
				{
					inf=Tempo.Pl;
					Min=Tempo;
				}
			}
			st.pop();
			if(Min!=null)
			{
			//st.show();
				if(Min.Value==st.topV().Value)
				{
					continue;
				}
				else
				{
					st.push(Min);
			    }
			}
		}
		System.out.println("Out");
		Vertex CurrentW=Ed;
		String DjPath=Ed.Value;
		while(CurrentW.Parent!=null)
		{
			DjPath=DjPath+"->"+CurrentW.Parent.Value;
			CurrentW=CurrentW.Parent;
		}
		System.out.print(DjPath);
}

public void Display()
{
	System.out.println("--------------Adjacency Matrix--------------");
	for(int row=0;row<5;row++)
	{
		for(int col=0;col<5;col++)
		{
			System.out.print(" "+AdjMat[row][col]+" ");
		}
		System.out.print("\n");
	}
}
public static void main(String Args[])
{
	Graph graph=new Graph();
	System.out.println("No. of Vertices");
	Scanner Sd=new Scanner(System.in);
 int H=Sd.nextInt();
	//System.out.println("No. of Edges");
	//int B=Sd.nextInt();
	
	graph.intialize(H);
//	graph.addEdges(B);
	Sd.close();
//graph.addEdges();
	
	graph.addEdge(0,1,3);
	graph.addEdge(1,2,6); 
	graph.addEdge(1,3,15);
	graph.addEdge(0,4,4);
	graph.addEdge(4,3,3);
	graph.addEdge(2,5,3);
	graph.addEdge(3,5,2);
	graph.addEdge(4,2,1);
	

		
	
	graph.Display();
/*	System.out.println("-------------------DFS---------------------");
	graph.DFS(0,4);
	String S=graph.BFS(0,4);
	System.out.println(S); */
	graph.Dijkstras(0,5);
}
}
