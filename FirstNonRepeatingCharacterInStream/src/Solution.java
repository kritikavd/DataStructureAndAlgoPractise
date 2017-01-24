
class Node{
	char val;
	Node next;
	Node prev;
	
	Node(char n){
		val=n;
	}
}



class DoublyLinkedList{
	
	Node head;
	Node tail;
	
	
	
	Node push(char n){
		
		if(head==null)
		{
			head = new Node(n);
			tail=head;
		} else{
			tail.next= new Node(n);
			tail.next.prev=tail;
			tail= tail.next;
		}
		
		return tail;
		
	}
	
	void display(){
		Node curr=head;
		while(curr!=null){
			System.out.print(curr.val+" ");
			curr=curr.next;
		}
		System.out.println();
	}
	
	void deleteNode(Node nodeToDelete){
		
		if(nodeToDelete!=null){
			
			if(nodeToDelete.prev!=null){
				nodeToDelete.prev.next=nodeToDelete.next;
			} else {
				head = nodeToDelete.next;
			}
			
			if(nodeToDelete.next!=null){
			nodeToDelete.next.prev=nodeToDelete.prev;
			} else {
				tail = nodeToDelete.prev;
			}
			nodeToDelete.next=nodeToDelete.prev=null;
		}
	}
	
	
	
}

public class Solution {
	
	public static void main(String args[]){
		
		boolean repeated[] = new boolean [256];
		Node [] pointers = new Node[256];
		
		DoublyLinkedList dll = new DoublyLinkedList();
		String stream = "abcddaefgh";
		
		for(char c: stream.toCharArray()){
			
			if(repeated[c]==false){
				
				if(pointers[c]!=null){
					
					dll.deleteNode(pointers[c]);
					pointers[c]=null;
					repeated[c]=true;
					
				} else {
					pointers[c]= dll.push(c);
					
				}
			}
			
			dll.display();
			
		}
		
	}
	
	
	

}
