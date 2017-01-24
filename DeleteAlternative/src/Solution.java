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
	
	static void deleteAlternative(Node head){
		
		while(head!=null && head.next !=null){
			head.next=head.next.next;
			head=head.next;
		}
		
	}
	
	public static void main(String args[]){
		
		Node head= new Node (1);
		head= addToList(head,2);
		head=addToList(head,10);
		
		
		Node head2= new Node (1);
		 head2= addToList(head2,3);
		
		deleteAlternative(head);
		deleteAlternative(head2);
		display(head);
		display(head2);
	}
	
	

}
