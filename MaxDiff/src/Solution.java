
public class Solution {
	static int greatestDifference(int arr[]){

		if(arr.length < 2){
			return 0;
	}
		int max_diff=arr[1]-arr[0];
		int min_element = arr[0];

		for(int i=1;i<arr.length;i++){

			if(arr[i]-min_element > max_diff){
				max_diff = arr[i]-min_element;
	}

	if(min_element> arr[i]){
		min_element = arr[i];
	}
	}

	return max_diff;

	}
	
	public static void main(String args[]){
		
		  int arr[] = {80, 2, 6, 3, 100};
		int max_diff=greatestDifference(arr);
		System.out.println("max diff is "+max_diff);
	}
}
