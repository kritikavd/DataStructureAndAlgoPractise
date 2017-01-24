import java.util.HashSet;

class Node{
	
	Node next;
	int data;
	
	Node(int data){
		this.data=data;
	}
}
public class Solution {

	static void removeDuplicates(Node head){
		HashSet<Integer> hashSet = new HashSet<Integer>();
		Node previous = null;
		while(head!=null){
			if(hashSet.contains(head.data)){
				previous.next=head.next;
			} else {
				hashSet.add(head.data);
				previous = head;
			}
			head=head.next;
		}
	}
	
	static void removeDuplicatesWithoutHashSet(Node head){
		
		Node curr = head;
		Node fast = curr;

		while(curr!=null){
			fast=curr;
			while(fast.next!=null){
				if(fast.next.data==curr.data){
						fast.next= fast.next.next;
					} else {
							fast=fast.next;
					}
			}
			curr=curr.next;
		}
	}
	
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
	
	public static void main(String args[]){
		
		Node head = new Node (1);
		head = addToList(head,2);
		head = addToList(head,2);
		head = addToList(head,3);
		head = addToList(head,4);
		
		display(head);
		removeDuplicates(head);
		display(head);
	}
}
