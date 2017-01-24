
public class Solution {
	
	
	static int minDistance(int arr[],int x,int y){

		int min =Integer.MAX_VALUE;
		int prev =-1;
		for(int i=0;i<arr.length;i++){

			if(arr[i] == x || arr[i]== y){

					if(prev==-1){
							prev = i;
					} else {
								if(arr[i]!=arr[prev]){
										min=Math.min(min,i-prev);
								} else {
											prev =i;
								}

							}
			}

		}

		return min;

	}
	
	public static void main(String args[]){
		 int arr[]={2, 5, 3, 5, 4, 4, 2, 3};
		 int x = 3, y = 2;
		 
		 System.out.println(minDistance(arr, x, y));
	}
}
