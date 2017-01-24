import java.util.Stack;

class StackWithMin extends Stack<Integer>{
	
	Stack<Integer> minStack = new Stack<Integer>();
	
	
	void push(int n){
		if(!minStack.isEmpty()){
			if(n<=minStack.peek().intValue()){
				minStack.push(n);
			}
		}
		super.push(n);
		
	}
	
	public Integer pop(){
		
		Integer val = super.pop();
		if(!minStack.isEmpty()){
			if(val.intValue()==minStack.peek().intValue()){
				minStack.pop();
			}
		}
		return val;
	}
	
	
	public Integer min(){
		if(!minStack.isEmpty()){
			return minStack.peek();
		}
		return Integer.MAX_VALUE;
	}
	
	
	
	
}

public class Solution {

}
