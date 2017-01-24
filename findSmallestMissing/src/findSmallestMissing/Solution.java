package findSmallestMissing;

public class Solution {
	
	static int findMissing(int arr[],int l,int h){
	if(l==h){
			if(l!=arr[l])
				return l;
			else
				return -1;

	}
	if(l!=arr[l]){
			return l;
	}

	int mid = l+(h-l)/2;

	if(mid == arr[mid])
		return findMissing(arr,mid+1,h);

	else 
		return findMissing(arr,l,mid);

	}
	
	public static void main(String args[]){
		
		int arr[] = {0, 1,2, 3, 4,5,6, 8};
		
		System.out.println(findMissing(arr,0,7));
		
		
	}
	
}
