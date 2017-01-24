package maxsumwithnoadjacent;

public class Solution {
	
	static int maxSum ( int arr[]){
		
		int maxsum[]=new int[arr.length];
		
		maxsum[0]=arr[0];
		maxsum[1]=Math.max(arr[0],arr[1]);
		int maxsumvalue = Math.max(maxsum[0],maxsum[1]);


		for(int i=2;i<arr.length;i++){


		maxsum[i]=Math.max(arr[i]+maxsum[i-2],arr[i-1]);
		maxsumvalue= Math.max(maxsumvalue,maxsum[i]);
		}


		return maxsumvalue;
		}
	public static void main(String[] args)
    {
	
    int arr[] = new int[]{5, 5, 10, 100, 10, 5};
    System.out.println(maxSum(arr));
    }

}
