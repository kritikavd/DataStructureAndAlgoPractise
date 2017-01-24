import java.util.HashMap;

class Node{
	Node left;
	Node right;
	int data;
	
	Node(int d){
		this.data=d;
	}
}
public class Solution {

	static int countPathsUtil(Node root,int target, HashMap<Integer,Integer> map,int runningSum){
		
		if(root==null)
			return 0;
		
		
		int numberOfPathsWithSum =0;
		runningSum+=root.data;
		if(runningSum==target){
			numberOfPathsWithSum++;
		}
		
		numberOfPathsWithSum=numberOfPathsWithSum+map.getOrDefault(runningSum-target, 0);
		map.put(runningSum, map.getOrDefault(runningSum, 0)+1);
		numberOfPathsWithSum=numberOfPathsWithSum+countPathsUtil(root.left,target,map,runningSum);
		numberOfPathsWithSum=numberOfPathsWithSum+countPathsUtil(root.right,target,map,runningSum);
		int mapValue = map.getOrDefault(runningSum,0);
		mapValue=mapValue-1;
		if(mapValue==0)
			map.remove(runningSum);
		else
			map.put(runningSum, mapValue);
			
		return numberOfPathsWithSum;
	}
	
	static int countPaths(Node root,int targetSum){
		
		if(root==null)
			return 0;
		
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		return countPathsUtil(root,targetSum, map,0);
	}
	
	public static void main(String args[]){
		Node root= new Node(10);
		Node five = new Node(5);
		Node three = new Node(3);
		Node one = new Node(1);
		Node three_again = new Node(3);
		Node minus_two = new Node(-2);
		Node two = new Node(2);
		Node minus_three = new Node(-3);
		Node eleven = new Node(11);
		
		root.left=five;
		root.right=minus_three;
		five.left=three;
		five.right=one;
		minus_three.right=eleven;
		three.left=three_again;
		three.right=minus_two;
		one.right=two;
		
		
		System.out.println(countPaths(root,8));
		
		
		
	}
	
	
	
	
}
