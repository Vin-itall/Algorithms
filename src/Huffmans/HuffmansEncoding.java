package Huffmans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class HuffmansEncoding {

	static TreeMap<Character,Integer> Frequency(String S)
	{
		TreeMap<Character,Integer> frequencyTable = new TreeMap<Character,Integer>();
		for(int i = 0; i<S.length(); i++)
		{
			char c = S.charAt(i);
			Integer val = frequencyTable.get(c);
			if(val != null)
			{
				frequencyTable.put(c,new  Integer(val+1));
			}
			else
			{
				frequencyTable.put(c,1);
			}
		}
		
		return frequencyTable;
	}
	
	static void findCodes(Node Current,ArrayList<Node> TreeNodes,TreeMap<Character,Integer> ft)
	{
		HashMap<Character,String> codeTable = new HashMap<Character,String>();
		while(!TreeNodes.isEmpty())
		{
			Node T = TreeNodes.get(0);
			Node X =T;
			String Code = "";
			StringBuilder Reverse = new StringBuilder();
			do 
			{
				if(T.isLeft)
				{
					Code = Code + "0";
				}
				else if(T.isRight)
				{
					Code = Code + "1";
				}
				System.out.println(T.frequency);
				T=T.parent;
			}while(T.frequency!=Current.frequency);
			Reverse = Reverse.append(Code);
			Code = Reverse.reverse().toString();
			codeTable.put(X.C,Code);
			TreeNodes.remove(0);
		}
		codeTable.forEach((k,v)->System.out.println(k + ":" + v));
	}
	
	static void mergePatternTree(TreeMap<Character,Integer> ft)
	{
		ArrayList<Node> PrimaryNodes = new ArrayList<Node>();
		ArrayList<Node> TreeNodes = new ArrayList<Node>();
		Node Current = null;
		ft.forEach((k,v)->PrimaryNodes.add(new Node(k,v)));
		Collections.sort(PrimaryNodes,Node.frequencyComp);
		while(PrimaryNodes.size() > 1)
		{	
			Node temp1 = PrimaryNodes.get(0);
			Node temp2 = PrimaryNodes.get(1);
			PrimaryNodes.remove(0);
			PrimaryNodes.remove(0);
			if(Current == null || (Current.frequency>temp1.frequency && Current.frequency>temp2.frequency))
			{
				Node P = new Node(temp1.frequency + temp2.frequency);
				P.left = temp1;
				temp1.isLeft=true;
				P.right = temp2;
				temp2.isRight =true;
				temp1.parent = P;
				temp2.parent = P;
				Current = P;
				PrimaryNodes.add(P);
				if(temp1.C!=null)
				{
					TreeNodes.add(temp1);
				}
				if(temp2.C!=null)
				{
					TreeNodes.add(temp2);
				}
			}
			else if(temp1.frequency <= Current.frequency && temp2.frequency >= Current.frequency )
			{
				Node P = new Node(temp1.frequency + temp2.frequency);
				P.left = temp2;
				temp2.isLeft = true;
				P.right = temp1;
				temp1.isRight = true;
				Current = P;
				temp1.parent = P;
				temp2.parent = P;
				PrimaryNodes.add(P);
				if(temp1.C!=null)
				{
					TreeNodes.add(temp1);
				}
				if(temp2.C!=null)
				{
					TreeNodes.add(temp2);
				}
			}
			Collections.sort(PrimaryNodes,Node.frequencyComp);
		}
		findCodes(Current,TreeNodes,ft);
	}
	
	public static void main(String Args[])
	{
		String message = "GO GO GOPHERS";
		TreeMap<Character,Integer> ft = new TreeMap<Character,Integer>();
		ft = Frequency(message);
		mergePatternTree(ft);
	}
}
