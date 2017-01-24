

class MyStack{
	
	int capacity ;
	int values[];
	int top1;
	int top2;
	
	MyStack(int size){
		
		capacity=size;
		values= new int[capacity];
		top1=-1;
		top2= capacity;
		
	}
	
	void push1(int n) throws Exception{
		
		if(top1<top2-1){
			top1++;
			values[top1]=n;
			
		} else {
			throw new Exception();
		}
		
	}
	
	void push2(int n) throws Exception{
		
		if(top1<top2-1){
			top2--;
			values[top2]=n;
			
		} else {
			throw new Exception();
		}
		
	}

	int pop1() throws Exception{
		
		if(top1>=0){
			int returnValue= values[top1];
			top1--;
			return returnValue;
		} else {
			throw new Exception();
		}
	
	}
	
int pop2() throws Exception{
		
		if(top2<capacity){
			int returnValue= values[top2];
			top2++;
			return returnValue;
		} else {
			throw new Exception();
		}
	
	}
}
public class Solution {
	
	public static void main(String args[]){
		MyStack mystack = new MyStack(6);
		
		try{
			
			mystack.push1(1);
			mystack.push1(2);
			mystack.push2(3);
			mystack.push2(4);
			
			
			System.out.println(mystack.pop1());
			System.out.println(mystack.pop2());
		} catch(Exception e){
			
		}
		
	}

}
