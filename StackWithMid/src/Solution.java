
class Node{
	int data;
	Node next;
	Node prev;
	
	Node(int n){
		data=n;
	}
}

class MyStack{
	
	Node head;
	Node mid;
	int size=0;
	
	void push(int n){
		if(head==null){
			head=new Node(n);
			mid=head;
			size++;
			return ;
		}
		
		Node newNode = new Node(n);
		newNode.next=head;
		head.prev=newNode;
		head=newNode;
		
		size++;
		if(size%2!=0)
			mid=mid.prev;
	}
	
	int pop(){
		if(head==null)
			return -1;
		
		Node newHead = head.next;
		int value=head.data;
		head.next=null;
		if(newHead!=null){
		newHead.prev=null;
		}
		head=newHead;
		size--;
		if(size%2==0){
			mid=mid.next;
		}
		return value;
	}
	
	
	int getMiddle(){
		if(mid==null)
			return -1;
		
		return mid.data;
	}
	
	int deleteMid(){
		
		if(mid==null){
			return -1;
		}
		
		if(mid==head){
			int value= head.data;
			mid=head=null;
			size--;
			return value;
		}
		
		Node newMid;
		if(size%2==0){
			
			 newMid = mid.prev;
			
		} else {
			 newMid = mid.next;
		}
		
		int value= mid.data;
		if(mid.prev!=null){
			mid.prev.next=mid.next;
		}
		if(mid.next!=null){
			mid.next.prev=mid.prev;
		}
		
		mid=newMid;
		size--;
		return value;
	}
	
}
public class Solution {
	
	public static void main(String args[]){
		
		MyStack s= new MyStack();
		
		System.out.println("curr mid "+s.getMiddle());
		s.push(1);
		System.out.println("curr mid "+s.getMiddle());
		s.push(2);
		System.out.println("curr mid "+s.getMiddle());
		s.push(3);
		System.out.println("curr mid "+s.getMiddle());
		s.push(4);
		System.out.println("curr mid "+s.getMiddle());
		s.pop();
		System.out.println("curr mid "+s.getMiddle());
		s.pop();
		System.out.println("curr mid "+s.getMiddle());
		s.pop();
		System.out.println("curr mid "+s.getMiddle());
		s.pop();
		System.out.println("curr mid "+s.getMiddle());
		
		
		
	}

}
