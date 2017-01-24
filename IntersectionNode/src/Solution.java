
// Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
  
  class Result{
	  ListNode resultNode;
	  int len;
	  
	  Result(ListNode listNode,int len){
		  this.len=len;
		  resultNode=listNode;
	  }
  }
 
 public class Solution {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA==null || headB==null)
            return null;
            
        ListNode tailA=null,tailB=null;
        Result resA= getTailAndLength(headA,tailA);
        Result resB = getTailAndLength(headB,tailB);
        
        tailA=resA.resultNode;
        tailB=resB.resultNode;
        
        int lenA= resA.len;
        int lenB= resB.len;
        
        if(tailA!=null){
            System.out.println(tailA.val+" ");
        }
        
        if(tailB!=null){
            System.out.println(tailB.val+" ");
        }
        
        
        if(tailA!=tailB){
            return null;
        }
            
            
        ListNode small = lenA<lenB?headA:headB;
        ListNode big = lenA>lenB?headA:headB;
        
        int diff=Math.abs(lenA-lenB);
        
        while(big!=null && diff>0){
            diff--;
            big=big.next;
        }
        
        while(big!=small){
            big=big.next;
            small=small.next;
        }
        
        return small;
        
        
    }
    
    public static Result getTailAndLength(ListNode head,ListNode tail){
        
        if(head==null)
            return new Result(null,0);
        
        int cnt = 1;
        while(head.next!=null){
            cnt++;
            head=head.next;
        }
        
        Result result = new Result(head,cnt);
       
        return result;
        
    }
    
    public static void main(String args[]){
    	
    	ListNode a= new ListNode(1);
    	ListNode b = new ListNode(2);
    	ListNode in= getIntersectionNode(a, b);
    	
    	//System.out.println(in.val);
    	
    }
    
 }