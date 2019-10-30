package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
	ArrayList<Vertex> Vertices=new ArrayList<Vertex>();
	int AdjMat[][];
	Stack TStack=new Stack();
	PriQueue Que=new PriQueue();
	Stack st=new Stack();
	static int NoV;
	int Count = 0;
	
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
{	
	if(Count == 0)
	{System.out.println("-------------------DFS---------------------");}
	Count++;
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
	graph.intialize(H);
	System.out.println("No. of Edges");
	int B=Sd.nextInt();
	graph.addEdges(B);
	Sd.close();

	
//	graph.intialize(6);
//	graph.addEdge(0,1,3);
//	graph.addEdge(1,2,6); 
//	graph.addEdge(1,3,15);
//	graph.addEdge(0,4,4);
//	graph.addEdge(4,3,3);
//	graph.addEdge(2,5,3);
//	graph.addEdge(3,5,2);
//	graph.addEdge(4,2,1);
	
//	graph.intialize(5);
//	graph.addEdge(0,1,1);
//	graph.addEdge(1,2,1); 
//	graph.addEdge(2,3,1);
//	graph.addEdge(3,4,1);
//	graph.addEdge(1, 3, 1);
	graph.Display();
	graph.DFS(0,4);
	String S=graph.BFS(0,4);
	System.out.println(S); 

}
}
