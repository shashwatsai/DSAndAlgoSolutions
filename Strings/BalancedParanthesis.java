import java.util.*;

public class BalancedParanthesis{

	private static boolean areParenthesisBalanced(char [] exp){
		Stack<Character> stack = new Stack<>();

		for(char ch : exp){
			if(ch == '{' || ch == '(' || ch == '['){
				stack.push(ch);
			}

			if(ch == '}' || ch == ')' || ch == ']'){
				if(stack.isEmpty())
					return false;
				else if(!isMatchingPair(stack.pop(), ch))
					return false;
			}
		}

		if(stack.isEmpty())
			return true;
		else
			return false;
	}	

	private static boolean isMatchingPair(Character a, Character b){
		if( a == '{' && b == '}'){
			return true;
		}
		else if( a == '(' && b == ')'){
			return true;
		}else if(a == '[' && b == ']'){
			return true;
		}

		return false;
	}

	public static void main(String [] args){
		char exp[] = {'{','(',')','}','[',']'}; 
		if (areParenthesisBalanced(exp)) 
			System.out.println("Balanced "); 
		else
			System.out.println("Not Balanced ");   
	}
}