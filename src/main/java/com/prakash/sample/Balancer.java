package com.prakash.sample;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Hello world!
 *
 */
public class Balancer 
{
	
	static Map<String, String> pair = new HashMap<>();
	static
	{
		pair.put("{", "}");
        pair.put("[", "]");
        pair.put("(", ")");
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        //String input = "aaa{bbbbbb[ccc(ddd)dd]www}";
        //String input = "{{{}}}[[[[[[";
        //String input = "{{{}}}[[[[[[";
        String input = "{{{}}}[[[[[[([][]())]]]]]]";
        
        System.out.println(String.format("Balanced String %s = %s", input, isBalanced(input)));            
        System.out.println(String.format("Balanced String %s = %s", input, isBalanced2(input))); 
    }

	private static boolean isBalanced(String input) {

		StringBuilder unmatched = new StringBuilder();
        for(int i=0;i<input.length();i++)
        {
        	String ch = String.valueOf(input.charAt(i));
        	if(pair.containsKey((ch)))
        	{
        		unmatched.append(ch);
        	}
        	else if(pair.containsValue(ch))
        	{
        		if (unmatched.length() < 1) return false;
        		
        		String lastOpen = unmatched.substring(unmatched.length()-1);
        		if (pair.get(lastOpen).equals(ch))
        		{
        			unmatched.setLength(unmatched.length()-1);
        		}
        		else
        		{
        			return false;
        		}
        		
        	}        	      	
        }
        
        if (unmatched.length()>0)
        {
        	return false;
        }
        else
        	return true;
	}
	
	
	private static boolean isBalanced2(String input)
	{
		Stack<String> unmatched = new Stack<>();
		
		
		
		input.chars().forEach(i -> {
			
			//solve this int to char to String
			
			char ch = (char) i;
			
			if (pair.containsKey(String.valueOf(ch)))
			{
			  unmatched.push(String.valueOf(ch));	
			}
			else if (pair.containsValue(String.valueOf(ch)))
			{
			  String last = unmatched.pop();	
			  if (!pair.get(last).equals(String.valueOf(ch)))
			  {
				 unmatched.push("invalid");
				 return;
			  }
			}
		});
		
		return unmatched.size() == 0;
		
	}
}
