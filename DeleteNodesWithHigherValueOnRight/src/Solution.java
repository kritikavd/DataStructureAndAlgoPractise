
class Node{
	
	int val;
	Node next;
	
	Node( int data){
		this.val=data;
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
			System.out.print(head.val+" ");
			head=head.next;
		}
		System.out.println();
	}
	
	static Node reverseList(Node head){

		Node prev = null;
		Node curr = head;

		while(curr!=null){
			Node next = curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
	}

	return prev;
	}

	static Node removeNodesWithHigherValue(Node head){

	if(head ==null || head.next == null)
		return head;

	head = reverseList(head);
	int max = head.val;

	Node curr=head;

	while(curr !=null && curr.next!=null){

		if(curr.next.val < max){
			curr.next = curr.next.next;
		} else {
			max=curr.next.val;
			curr=curr.next;
		}

	}

	head = reverseList(head);
	return head;

	}
	
	public static void main(String args[]){
		
	
		
		
		
			Node head = null;	
	
		
		head= addToList(head,12);
		head= addToList(head,15);
		head= addToList(head,10);
		head= addToList(head,11);
		head= addToList(head,5);
		head= addToList(head,6);
		head= addToList(head,2);
		head= addToList(head,3);
		
		
		head = removeNodesWithHigherValue(head);
		
		display(head);
	}	

}
