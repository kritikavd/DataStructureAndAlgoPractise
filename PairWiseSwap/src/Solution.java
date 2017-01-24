
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
	
	static Node pairWiseSwap(Node head){
		
		if(head==null || head.next==null)
			return head;
		
		Node newHead = head.next;
		Node curr= head;
		while(curr!=null && curr.next!=null){
			Node nextNode = curr.next.next;
			
			curr.next.next = curr;
			curr.next =(nextNode==null || nextNode.next==null)?nextNode:nextNode.next;
			curr=nextNode;
		}
		
		return newHead;
		
		
	}
	
	public static void main(String args[]){
		
		Node head= new Node (1);
		head= addToList(head,2);
		head=addToList(head,10);
		head= addToList(head,1);
		head= addToList(head,10);
		head= addToList(head,2);
		head= addToList(head,1);
		
		head = pairWiseSwap(head);
		display(head);
	}
	

}
