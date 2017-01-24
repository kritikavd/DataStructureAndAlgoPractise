

// check for common ancestor in binary tree ( without the parent pointers ) 

class Node{
	Node left;
	Node right;
	int n;
	
	Node(int n){
		this.n=n;
	}
}

class Result {
	
	Node ancestor;
	boolean isAncestor;
	
	Result(Node ancestor,boolean isAncestor){
		this.ancestor=ancestor;
		this.isAncestor=isAncestor;
	}
}


public class Solution {

	static Node commonAncestor(Node root,Node p,Node q){
				Result result = commonAncestorUtil(root,p,q);
				if(result.isAncestor==true){
					return result.ancestor;
				}
				
				return null;
	}
	static Result commonAncestorUtil(Node root,Node p,Node q){
		if(root==null)
			return new Result(null,false);
		
		if(p==root && q==root)
			return new Result(root,true);
		
		Result leftSide = commonAncestorUtil(root.left ,p,q);
		if(leftSide.isAncestor){
			return leftSide;
		}
		
		Result rightSide = commonAncestorUtil(root.right,p,q);
		if(rightSide.isAncestor){
			return rightSide;
		}
		
		if(leftSide.ancestor!=null && rightSide.ancestor!=null)
			return new Result(root,true);
		else if(root==p || root ==q){
			boolean isances= leftSide.ancestor!=null || rightSide.ancestor!=null;
			return new Result(root,isances);
		} else {
			return new Result(leftSide.ancestor!=null?leftSide.ancestor:rightSide.ancestor,false);
		}
	}
	
	public static void main(String args[]){
		Node root = new Node(3);
		root.left=new Node (1);
		root.right=new Node(5);
		root.right.right= new Node (8);
		
		Node newNode = new Node (2);
		System.out.println(commonAncestor(root,root.right,root.right.right).n);
		
		
		
	}
}
