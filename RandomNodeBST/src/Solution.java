import java.util.Random;

class Tree{
	
	Node root;
	
	void insert(int d){
		if(root==null){
			root=new Node(d);
		} else {
			root.insertNode(d);
		}
	}
	
	Node getRandomNode(){
		
		if(root==null)
			return null;
		
		Random random = new Random();
		int index = random.nextInt(root.size);
		return (root.getNodeAt(index));
				
	}
}



class Node{
	
	Node left;
	Node right;
	int data;
	int size;
	
	Node (int data){
		this.data=data;
		size=1;
	}
	
	
	void insertNode(int d){
		if(d<=this.data){
			if(left==null){
					left=new Node(d);
				} else {
					left.insertNode(d);
				}
		} else {
			if(right==null){
				right=new Node(d);
				
			} else {
				right.insertNode(d);
			}
		}
		d++;
	}
	
	Node getNodeAt(int i){
		
		int leftSize= (left==null)?0:left.size;
		if(i<leftSize){
			return left.getNodeAt(i);
		} else if(i==leftSize){
			return this;
		}else{
			return right.getNodeAt(i-leftSize+1); 
		}
	}
	
}




public class Solution {
	public static void main(String args[]){
		Tree root = new Tree();
		root.insert(10);
		root.insert(2);
		root.insert(4);
		root.insert(12);
		System.out.println(root.getRandomNode().data);
	}
}
