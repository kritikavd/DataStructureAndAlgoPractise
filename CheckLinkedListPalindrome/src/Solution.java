import java.util.Stack;

class Node{
	
	int data;
	Node next;
	
	Node( int data){
		this.data=data;
	}
}

public class Solution {
	
	
	static Node addToList(Node head,int d){
		if(head==null){
			return new Node(d);
		} else {
			Node curr = head;
			while(head.next!=null){
				head=head.next;
			}
			head.next = new Node(d);
			return curr;
		}
	}
	static void display(Node head){
		while(head!=null){
			System.out.print(head.data+" ");
			head=head.next;
		}
		System.out.println();
	}
	
	static boolean isPalindrome(Node a){
		
		Node slow = a;
		Node fast = a;
		Stack<Integer> stack = new Stack<Integer>();
		while(fast!=null && fast.next!=null){
			stack.push(slow.data);
			slow=slow.next;
			fast=fast.next.next;
			
		}
		
		if(fast!=null){
			slow=slow.next;
		}
		
		while(slow!=null){
			
			Integer popped= stack.pop();
			
			if(popped.intValue() != slow.data){
				return false;
			}
			slow=slow.next;
		}
		return true;
		
		
	}
	
	public static void main(String args[]){
		
		Node head= new Node (1);
		head= addToList(head,2);
		head=addToList(head,10);
		head= addToList(head,1);
		head= addToList(head,10);
		head= addToList(head,2);
		head= addToList(head,1);
		
		boolean ispalindrome  = isPalindrome(head);
		System.out.println(ispalindrome);
	}

}
