import java.util.Stack;

public class Solution {
	
	
	static boolean isNumber(char c){
		if(c >= '0' && c <='9'){
			return true;
		} else 
		{
			return false;
		}
	}
	
	static int performOperation(int a,int b,char op){
		
		switch(op){
		
		case '+':
			return a+b;
			
		case '-':
			return a-b;
			
			
		case '*':
			return a*b;
			
		case '/':
			return a/b;
			
		default:
			System.out.println("invalid operation");
			return -1;
		
		}
	}
	
	
	static int EvaluatePostfix(String postFix){
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<postFix.length();i++){
			
			char sc = postFix.charAt(i);
			
			if(isNumber(sc)){
				stack.push(sc-'0');
			} else {
				if(!stack.isEmpty()){
					int op1 = stack.pop();
					int op2;
					if(!stack.isEmpty()){
						op2 = stack.pop();
						stack.push(performOperation(op2,op1,sc));
					}else{
						System.out.println("invalid exp 1");
					}
					
					
				} else{
					System.out.println("invalid exp 2");
				}
			}
		}
		
		System.out.println(stack.size());
		
		if(stack.size()==1){
			return stack.pop();
		} else {
			System.out.println("invalid exp 3");
			return -1;
		}
		
	}
	
	public static void main(String args[]){
		String exp = "231*+9-";
		
		System.out.println(EvaluatePostfix(exp));
	}

}
