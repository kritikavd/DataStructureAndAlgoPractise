
public class Solution {
	
	static int findEquillibrium(int arr[]){
		
		int sum =0;
		for(int i=0;i<arr.length;i++){
			sum+=arr[i];
		}
		
		int leftSum =0;
		for(int i=0;i<arr.length;i++){
			
			sum = sum-arr[i];
			if(sum==leftSum){
				return i;
			}
			leftSum=leftSum+arr[i];
		}
		
		return -1;
		
	}

	public static void main(String args[]){
		int arr[] = {-7, 1, 5, 2, -4, 3, 0};
		
		System.out.println(findEquillibrium(arr));
	}
}
