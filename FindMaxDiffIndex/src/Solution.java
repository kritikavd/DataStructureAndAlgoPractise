import javax.print.attribute.standard.PrinterLocation;

/*
 * 
 * Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
 */
public class Solution {

	static int findMaxDiffIndex(int arr[]){

		int arrLeft[] = new int[arr.length];
		int arrRight[] = new int[arr.length];

		if(arr.length == 0 || arr.length == 1)
			return  0;

		arrLeft[0]=arr[0];

		for(int i=1;i<arr.length;i++){
			arrLeft[i]=Math.min(arrLeft[i-1],arr[i]);
		}

		arrRight[arr.length-1] = arr[arr.length-1];

		for(int i=arr.length-2;i>=0;i--){
			arrRight[i]=Math.max(arr[i],arrRight[i+1]);
		}

		int i=0,j=0;

		int maxDiff=-1;
		while(i<arr.length && j<arr.length){

				if(arrLeft[i]<arrRight[j]){
						maxDiff=Math.max(maxDiff,j-i);
						j++;
		
				} else {
					i++;
				}
		}
		return maxDiff ;  
	}
	
	public static void main(String args[]){
		
		int arr[]={6, 5, 4, 3, 2, 1};
		System.out.println(findMaxDiffIndex(arr));
	}
}
