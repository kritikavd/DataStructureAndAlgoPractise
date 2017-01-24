
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
	
	int numberOfStacks = 3;
	int values[];
	int capacity;
	int size[];
	
	MyStack(int capacity){
		this.capacity=capacity;
		size= new int[numberOfStacks];
		values= new int[capacity*numberOfStacks];
	}
	
	boolean isFull(int stackNumber){
		return (size[stackNumber]== capacity);
	}
	
	boolean isEmpty(int stackNumber){
		return (size[stackNumber]==0);
	}
	
	int getTopIndex(int stackNumber){
		int offset = stackNumber * capacity;
		return offset+size[stackNumber]-1;
	}
	
	void push(int n,int stackNumber) throws FullStackException{
		
		if(!isFull(stackNumber)){
			
			size[stackNumber]++;
			int topIndex = getTopIndex(stackNumber);
			values[topIndex]=n;
			
		} else {
			throw new FullStackException("stack is full");
		}
		
	}
	
	int pop(int stackNumber) throws EmptyStackException{
		
		if(!isEmpty(stackNumber)){
			int topIndex = getTopIndex(stackNumber);
			int returnElement = values[topIndex];
			values[topIndex]=0;
			size[stackNumber]--;
			return returnElement;
		} else {
			throw new EmptyStackException("stack is empty");
		}
	}
	
}


public class Solution {

	
}
