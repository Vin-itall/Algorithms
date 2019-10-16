package Leveshtein;

public class LeveshteinDistanceCalculator {
	
	int Distance;
	
	public int leveshteinDistance(String S, String T, int lengthS, int lengthT)
	{
		if(lengthS == 0) return lengthT;
		if(lengthT == 0) return lengthS;
		if(S.charAt(lengthS-1) == T.charAt(lengthT-1))
			return leveshteinDistance(S,T,lengthS-1,lengthT-1);
		
		return 1 + Math.min(Math.min(leveshteinDistance(S,T,lengthS-1,lengthT-1),leveshteinDistance(S,T,lengthS,lengthT-1)),leveshteinDistance(S,T,lengthS-1,lengthT));
	}
	
	public static void main(String Args[])
	{
		LeveshteinDistanceCalculator ld = new LeveshteinDistanceCalculator();
		String S ="book";
		String T ="back";
		int lengthS = S.length();
		int lengthT = T.length();
		int distance = ld.leveshteinDistance(S,T,lengthS,lengthT);
		System.out.print(distance);
	}
	
}
