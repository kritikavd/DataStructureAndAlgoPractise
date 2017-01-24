

class Node{
	int val;
	Node next;
	
	Node(int k){
		val = k;
	}
}


public class Solution {

	
	static Node reverseAlternate(Node head, int k){

		if(head==null || head.next == null){
			return head;
		}

		Node curr = head;
		Node prev = null;
		Node next=null;
		int i=0;

		while(curr!=null && i<k){

			next = curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
			i++;
	} 

		head .next = curr;
		head = prev;

		while(curr!=null && i<2*k){
		
			prev = curr;
			curr=curr.next;
			i++;
		
	}

	if(curr!=null){

		prev.next = reverseAlternate(curr,k);

	}

	return head;

	}
	
	
	static Node insert(Node head, int k){
		if(head==null)
			return new Node(k);
		
		Node newNode = new Node(k);
		newNode.next=head;
		head=newNode;
		return head;
	}
	
	static void display(Node head){
		while(head !=null){
			System.out.print(head.val+" ");
			head=head.next;
		}
	}
	
	public static void main(String args[]){
		
		Node head = null;
		head = insert(head,16);
		head = insert(head,15);
		head = insert(head,14);
		head = insert(head,12);
		head = insert(head,10);
		head = insert(head,1);
		head = insert(head,2);
		head = insert(head,3);
		head = insert(head,4);
		head = insert(head,5);
		head = insert(head,6);
		head = insert(head,7);
		head = insert(head,8);
		head = insert(head,9);
		head = insert(head,0);
		
		display(head);
		System.out.println();
		head = reverseAlternate( head, 3);
		
		display(head);
		
		
	}
	
	

}
