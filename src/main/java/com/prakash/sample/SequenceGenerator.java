package com.prakash.sample;

public class SequenceGenerator {
	
	private static String[] ALPHABETS = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", 
			                             "k", "l", "m", "n" , "o", "p", "q", "r", "s", "t", 
			                             "u", "v", "w", "x", "y", "z" };
	
	public static void main(String[] argv)
	{
		
		for (int i=0;i<=26*10;i++)
		{
			System.out.println(String.format("Sequence for %d is %s, %s", i, getAlphaSequence(i), getAlphaSequence2(i)));
		}

	}
	
	
	private static String getAlphaSequence(int nbr)
	{
		
		if (nbr <= 0) return null;
		
		if ( nbr <= ALPHABETS.length ) return ALPHABETS[nbr-1];
		
		int div = nbr / ALPHABETS.length;
		int rem = nbr % ALPHABETS.length;
		
		StringBuilder seq = new StringBuilder();

		
		if (rem > 0)
		{
			for (int i=0;i<div;i++)
			{
				seq.append(ALPHABETS[0]);
			}
			seq.append(ALPHABETS[rem-1]);
		}
		else
		{
			for (int i=0;i<div-1;i++)
			{
				seq.append(ALPHABETS[0]);
			}
			seq.append(ALPHABETS[ALPHABETS.length -1]);
		}
				
		return seq.toString();
	}
	
	private static String getAlphaSequence2(int nbr)
	{
		int MAX_SEQ = 26;
		
		if (nbr <= 0) return null;
		
		if ( nbr <= MAX_SEQ ) return  NbrToChar(nbr);
		
		int div = nbr / MAX_SEQ;
		int rem = nbr % MAX_SEQ;
		
		StringBuilder seq = new StringBuilder();

		
		if (rem > 0)
		{
			for (int i=0;i<div;i++)
			{
				seq.append(NbrToChar(1));
			}
			seq.append(NbrToChar(rem));
		}
		else
		{
			for (int i=0;i<div-1;i++)
			{
				seq.append(NbrToChar(1));
			}
			seq.append(NbrToChar(MAX_SEQ));
		}
				
		return seq.toString();
	}
	
	private static String NbrToChar(int nbr)
	{
		int CHAR_BASE = 97;
		
		return String.valueOf((char)(CHAR_BASE + nbr -1));
	}
}
