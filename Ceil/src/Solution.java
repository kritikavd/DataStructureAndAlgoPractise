
public class Solution {
	
	static int findCiel(int arr[],int l,int h,int x){
		if(x<=arr[l])
			return l;
		
		if(x>arr[h])
			return -1;
		
		int mid = l+(h-l)/2;
		
		if(x==arr[mid])
			return mid;
		
		if(x<arr[mid]){
			
			if(mid-1>=l && arr[mid-1]<x){
				return mid;
			}
			else{
				return findCiel(arr,l,mid-1,x);
			}
		} else{
			if(mid+1 <=h && arr[mid+1]>=x){
				return mid+1;
			}
			return findCiel(arr,mid+1,h,x);
			
		}
	}
	
	public static void main(String args[]){
		
		int arr[] = {1, 2, 8, 10, 10, 12, 19};
		System.out.println(findCiel(arr,0,6,7));
		
	}

}
