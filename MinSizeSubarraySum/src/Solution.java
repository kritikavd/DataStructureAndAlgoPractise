
public class Solution {
	
static int minSubArrayLen(int s, int[] nums) {
        
        if(nums==null || nums.length ==0 ){
            return 0;
        }
        
        int min_length = Integer.MAX_VALUE;

        
        int start = 0;
        int end = 0;
        int curr_sum = 0;
       // for(int i=0;i<nums.length;i++){
        while(end<nums.length){
           
            while(end < nums.length && curr_sum < s ){
                 
                curr_sum+=nums[end];
                end++;
               
            }
            
             System.out.println("min_length"+ min_length);
             System.out.println("cuur_sum"+ curr_sum);
             System.out.println("end index"+end);
           
          
            if(curr_sum<s){
            	
                return (min_length== Integer.MAX_VALUE?0:min_length);
            } 
            
            while(curr_sum >=s){
                curr_sum=curr_sum-nums[start];
                start++;
            }
            
            int curr_len = end-start+1;
            if(curr_len < min_length){
                min_length = curr_len;
            }
            
          
        
        }
        
        return min_length;
        
    }

	public static void main(String args[]){
		
		int nums[] = {10,5,13,4,8,4,5,11,14,9,16,10,20,8};
		System.out.println(minSubArrayLen(80, nums));
	}

}
