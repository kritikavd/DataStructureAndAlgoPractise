import java.util.Stack;

class MyQueue<T>{
	
	Stack<T> oldStack;
	Stack<T> newStack;
	
	 MyQueue(){
		oldStack=new Stack<T>();
		newStack= new Stack<T>();
	}
	 
	void add(T item){
		newStack.push(item);
	}
	
	void shiftStacks(){
		
		if(oldStack.isEmpty()){
			while(!newStack.isEmpty()){
				oldStack.push(newStack.pop());
			}
		}
	}
	
	T remove(){	
		shiftStacks();
		return (oldStack.pop());
	}
	
	
}


public class Solution {

	public static void main(String args[]){
		
		MyQueue<Integer> myq=new MyQueue<Integer>();
		
		myq.add(1);
		myq.add(2);
		myq.add(3);
		
		
		System.out.println(myq.remove());
		System.out.println(myq.remove());
		System.out.println(myq.remove());
		System.out.println(myq.remove());
		
		
		
	}
}
