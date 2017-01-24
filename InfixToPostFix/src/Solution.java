import java.util.Stack;

public class Solution {
	
	
	static boolean isOperand(char x){
		if(x>='a' && x<='z' || x>='A' && x<='Z'){
			return true;
		}
		return false;
	}
	
	static int prec(char op){
		
		int pre= -1;
		switch(op){
		
		case '+':
		case '-':
			pre = 1;
			break;
			
		case '*':
		case '/':
			pre= 2;
			break;
		
		case '^':
			pre = 3;
			break;
		
		}
		return pre;
	}

	static String toPostFix(String infix){
		
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<infix.length();i++){
			
			char currChar = infix.charAt(i);
			if(isOperand(currChar)){
				sb.append(currChar);
			} else if (currChar=='('){
				stack.push(currChar);
			} else if(currChar ==')'){
				while(!stack.isEmpty() && stack.peek()!='('){
					sb.append(stack.pop());
				}
				if(stack.isEmpty())
					return "Invalid String";
				
				else{
					stack.pop();
				}
			} else {
				while(!stack.isEmpty() && prec(currChar)<=prec(stack.peek())){
					sb.append(stack.pop());
				}
				
				stack.push(currChar);
			}
			
		}
		
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}
	
	
	public static void main(String args[]){
		String string1="";
		String string2="a+b*c+d";
		String string3 = "a+b/c*(k+c)";
		
		System.out.println(toPostFix(string1));
		System.out.println(toPostFix(string2));
		System.out.println(toPostFix(string3));
		
	}
}
