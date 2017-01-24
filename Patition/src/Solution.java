class Node{
	
	Node next;
	int data;
	
	Node(int data){
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
	
	static Node partition(Node node,int x){
		
		Node head = node;
		Node tail = node;
		
		while(node!=null){
			Node next = node.next;
			if(node.data < x){
				node.next=head;
				head=node;
			} else{
				tail.next=node;
				tail=node;
			}
			node=next;
		}
		
		tail.next=null;
		return head;
		
	}
	
	public static void main(String args[]){
		
		Node head= new Node (3);
		head= addToList(head,5);
		head=addToList(head,8);
		head= addToList(head,5);
		head= addToList(head,10);
		head= addToList(head,2);
		head= addToList(head,1);
		
		head = partition(head,5);
		display(head);
	}

}
