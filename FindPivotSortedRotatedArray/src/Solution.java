
public class Solution {
	
	static int binarySearchRotated(int arr[],int l,int h,int target){
		
		if(l<=h){
			
			int mid=l+(h-l)/2;
			if(arr[mid]==target){
				return mid;
			}
			
			if(arr[mid]>=arr[l]){
				// l to mid is sorted 
				if(target >= arr[l] && target <= arr[mid] ){
					return binarySearchRotated(arr,l,mid-1,target);
				} else{
					return binarySearchRotated(arr,mid+1,h,target);
				} 
			} else{
				if(target >=arr[mid] && target <= arr[h]){
					return binarySearchRotated(arr,mid+1,h,target);
				}else{
					return binarySearchRotated(arr,l,mid-1,target);
				}
			}
		}
		return -1;
		
	}
	
	public static void main(String args[]){
		

		   int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		   int index = binarySearchRotated(arr1,0,8,3);
		   System.out.println("found at "+index);
	}
}
