


class TreeNode{

	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int v){
		val=v;
	}

	void insert(int v){
		if(v<= val){
			if(left==null)
			{
				left = new TreeNode(v);
			} else {
					left.insert(v);
			}
		} else {

			if(right == null){
					right = new TreeNode(v);
			} else {
					right.insert(v);
			}

		}
}

Boolean find(int v){

	if(this.val ==v)
		return true;
	if(v<=this.val && left!=null ){
		return left.find(v);
	} else if( v > this.val && right!=null){
	return right.find(v);
	}
		return false;
}

void display(){

	if(left!=null)
		left.display();

	System.out.print(val+" ");

	if(right!=null)
		right.display();

}


}

public class Solution {
	
	
	static TreeNode delete(TreeNode root , int key){

		if(root==null)
			return root;

		if(root.val == key){

			if(root.left == null){
				return root.right;
			} else if( root.right == null){
					return root.left;
			} else {

					TreeNode curr = root.right;
						while(curr.left!=null){
												curr=curr.left;
						}
					root.val = curr.val;
					root.right = delete(root.right,curr.val);

			}
		}else if (key < root.val){
									root.left = delete(root.left,key);
		} else {
									root.right = delete(root.right,key);
		}
		return root;

	}
	
	
	public static void main(String args[]){
		
		TreeNode root = new TreeNode(10);
		root.insert(2);
		root.insert(1);
		root.insert(12);
		root.insert(3);
		root.insert(14);
		
		root.display();
		System.out.println(root.find(3));
		System.out.println(root.find(6));
		delete(root, 2);
		delete(root, 6);
		
		root.display();
		

	}

}
