public class solution {
	static int largestSum(int arr[]){
if(arr.length > 0){
int max_sum =arr[0];
int curr_sum = arr[0];


for(int i=1;i<arr.length;i++){
	curr_sum = Math.max(curr_sum+arr[i],arr[i]);
	max_sum = Math.max(curr_sum,max_sum);
}
return max_sum;
} else {
 	return 0;
}		
}


public static void main(String args[]){
	
	int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
	int max_sum = largestSum(a);
	System.out.println("max sum is"+ max_sum);
	


}
}


