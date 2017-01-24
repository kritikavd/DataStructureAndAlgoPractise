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
	
	
	static Node KThFromLast(Node head,int k){
		
		int size = 0;
		Node curr=head;
		while(curr!=null){
			size++;
			curr=curr.next;
		}

		curr=head;
		for(int i=1;i<=size-k;i++){
			curr=curr.next;
		}
		return curr;

	}
	
	static Node kThFromLastTwo(Node head,int k){

		Node curr = head;
		Node fast=head;
		int i=1;

		for( i=1;i<=k && fast!=null ;i++){
		fast=fast.next;
		}

		if(i!=k && fast==null){

			System.out.println("k cannot be greater than the length of the LL");
			return new Node (-1);

		}

		while(fast!=null){
		fast=fast.next;
		curr=curr.next;
		}

		return curr;
	}
	
	public static void main(String args[]){
		
		Node head= new Node (1);
		head= addToList(head,2);
		head=addToList(head,3);
		head= addToList(head,4);
		head= addToList(head,5);
		
		System.out.println(KThFromLast(head,2).data);
		System.out.println(kThFromLastTwo(head,2).data);
		
	}

}
