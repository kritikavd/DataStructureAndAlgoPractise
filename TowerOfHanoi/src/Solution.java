import java.util.Stack;

public class Solution {
	
	static void moveDisks(Stack<Integer> a, Stack<Integer> b , Stack<Integer> c,int n){
		
		if(n <=0)
			return ;
		if(n==1){
			//System.out.println(arg0);
			int aValue = a.pop().intValue();
			if(!(c.isEmpty()) && c.peek().intValue() < aValue ){
				System.out.println("Error");
				
				return;
			}
			c.push(aValue);
			
		} else {
			
			moveDisks(a,c,b,n-1);
			int aValue = a.pop().intValue();
			if(!(c.isEmpty()) && c.peek().intValue() < aValue ){
				System.out.println("Error");
				return;
			}
			c.push(aValue);
			moveDisks(b,a,c,n-1);
			
		}
	}
	
	public static void main(String args[]){
		
		Stack<Integer> a = new Stack<Integer> ();
		Stack<Integer> b = new Stack<Integer>();
		Stack<Integer> c= new Stack<Integer>();
		
		for(int i=5;i>=0;i--){
			a.push(i);
		}
		
		moveDisks(a,b,c,6);
		
	System.out.print(c.pop());
		
		
		
	}

}
