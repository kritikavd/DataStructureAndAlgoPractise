
class Node {
	int data;
	Node left;
	Node right;
}


public class Solution {
	
	static Integer last_printed ;
	static boolean checkBST (Node root,Integer min,Integer max){
		
		if(root==null)
			return true;
		
		if(min !=null && root.data <=min.intValue() || max!=null && root.data > max.intValue()){
			return false;
		}
		
		if(!checkBST(root.left,min,root.data)){
			return false;
		}
		
		if(!checkBST(root.right,root.data,max)){
			return false;
		}
		return true;
		
	}
	
	static boolean checkBSTTwo(Node root){
		if(root==null)
			return true;
		
		if(!checkBSTTwo(root.left))
			return false;
		
		if(null!=last_printed && last_printed.intValue()>=root.data){
			return false;
		}
		
		if(!checkBSTTwo(root.right))
			return false;
		
		return true;
	}
	
	
	

}
