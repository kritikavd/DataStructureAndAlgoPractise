package nextGreatest;
import java.util.Stack;



public class Solution {
	
	static void nextGreatest(int ar[]){
		Stack<Integer> stack = new Stack<Integer>();
		
		int k =0;
		for(int i=0;i<ar.length;i++){
			while(!stack.isEmpty() && ar[i]>stack.peek().intValue()){
				
				int v=	stack.pop();
				System.out.println("next big for "+v +"  is  "+ar[i]);
			}
			stack.push(ar[i]);
		}
		
		while(!stack.isEmpty()){
			
			int v=stack.pop();
			System.out.println("next big for "+v +"  is  "+-1);
				
		}
		
	}
	
	public static void main(String args[]){
		int arr[]={1,2,3,4,5,6,9};
		int arr2[]={8,6,1,3,7,0,2};
		
		nextGreatest(arr);
		nextGreatest(arr2);
		
		
		
	}

}
