
class FullStackException extends Exception{
	
	 public FullStackException(String message) {
	        super(message);
	    }
}

class EmptyStackException extends Exception{
	
	 public EmptyStackException(String message) {
	        super(message);
	    }
}

class MyStack{
	
	int capacity;
	int top=-1;
	int values[];
	
	MyStack(int capacity){
		this.capacity = capacity;
		values = new int[capacity];
	}
	
	void push(int n) throws FullStackException{
		if(!isStackFull()){
			values[++top]=n;
		} else {
			throw new FullStackException("Stack is full");
		}
		
	}
	
	int pop() throws EmptyStackException{
		if(!isStackEmpty()){
			int topElement = values[top];
			values[top--]=0;
			return topElement;
		} else {
			throw new EmptyStackException("Stack is empty");
		}
	}
	
	boolean isStackFull(){
		return top==capacity-1;
	}
	
	boolean isStackEmpty(){
		return top==-1;
	}
	
	
}

public class Solution {
		
	public static void main(String args[]){
		
		MyStack mystack = new MyStack(5);
		
		try{
			mystack.push(1);
			mystack.push(2);
			mystack.push(3);
			
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			System.out.println(mystack.pop());
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
