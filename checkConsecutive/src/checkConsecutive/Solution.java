package checkConsecutive;

public class Solution {
	
	
	static boolean checkConsecutive(int arr[]){

		if(arr.length == 0 || arr.length == 1)
			return true;

		int max = arr[0];
		int min = arr[0];

		for(int i=1;i<arr.length;i++){
			if(arr[i]>max){
			max=arr[i];
		}
		if(arr[i]<min){
			min=arr[i];
		}
		}

		if(arr.length != max-min +1)
			return false;

		boolean visited[]=  new boolean[arr.length];

		for(int i=0;i<arr.length;i++){
			if(visited[arr[i]-min]== true)
				return false;

			visited[arr[i]-min]= true;

		}

			return true;
		}
	
	public static void main(String args[]){
		
		
		int arr[]={83, 78, 80, 81, 79, 82,80};
		System.out.println(checkConsecutive(arr));
		
		
	}
}
