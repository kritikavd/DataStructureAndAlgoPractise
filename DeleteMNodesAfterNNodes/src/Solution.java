
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
	
	
	static void deleteMNodesAfterNNodes(Node head,int m,int n){
		
		while(head!=null){
			
			for(int i=0;i<m-1 && head!=null;i++){
				head=head.next;
			}
			if(head==null)
				return;
			
			for(int i =0 ;head.next!=null && i<n;i++){
				head.next=head.next.next;
			}
			head=head.next;
		}
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
		
		
	
		
		display(head);
		
		deleteMNodesAfterNNodes( head,3,2);
		display(head);
	}	

}
