import java.util.ArrayList;

class Node{
	
	int val;
	Node next;
	Node arbit;
	
	Node( int data){
		this.val=data;
	}
}



public class Solution {
	
	
	
	static void display(Node head){
		while(head!=null){
			System.out.print(head.val+" ,");
			System.out.print(head.arbit.val+" ");
			head=head.next;
		}
		System.out.println("--------");
	}

	
	static Node copyList(Node head){
		
		Node head2=null;
		Node head1=head;
		
		while(head!=null){

					Node  newNode= new Node(head.val);
						if(head2==null){
								head2=newNode;
						}

							newNode.next=head.next;
							head.next=newNode;

							head = newNode.next;
		}

		head=head1;
			while(head!=null && head.next!=null){
					head.next.arbit= head.arbit.next;
					head=head.next.next;
		}
		head=head1;
		
	while(head!=null && head.next!=null){

		Node original = head;
		Node cloned = head.next;
		original.next=  cloned.next;
		cloned.next = cloned.next==null?null:cloned.next.next;
		
		head = original.next;
	}
	
	return head2;

	}
	
	public static void main(String args[]){
		
		Node node1= new Node(1);
		Node node2 = new Node(2);
		Node node3= new Node(3);
		Node node4 = new Node(4);
		Node node5= new Node(5);
		
		node1.next=node2;
		node1.arbit=node3;
		
		node2.next=node3;
		node2.arbit=node1;
		
		node3.next=node4;
		node3.arbit=node5;
		
		node4.next=node5;
		node4.arbit=node3;
		
		node5.next=null;
		node5.arbit=node2;
		
		display(node1);
		
		Node cloned = copyList(node1);
		
		System.out.println("aftre cloning");
		
		
		ArrayList<Node> arraylist = new ArrayList<Node>();
		
		arraylist.size();
		
		arraylist.isEmpty();
		
		
		
		
		display(node1);
		display(cloned);
				
				
		
		
	}
}
