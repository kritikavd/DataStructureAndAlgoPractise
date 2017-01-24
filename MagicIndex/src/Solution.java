
public class Solution {
	
	static int magicIndex(int arr[],int l,int h){
		//no duplicates
		
		if(l<=h){
			int mid = l+(h-l)/2;
			
			if(arr[mid]==mid)
				return mid;
			
			if(arr[mid]<mid){
				//search right
				return magicIndex(arr,mid+1,h);
				
			 } else {
				 return magicIndex(arr,l,mid-1);
				 
			 }
		}
		return -1;
	}
	
	static int magicIndexWithDuplicates(int arr[],int l,int h){
		
		if(l<=h){
			int mid = l+(h-l)/2;
			
			if(arr[mid]==mid)
				return mid;
			
			if(arr[mid]<mid){
				
				int leftIndex = Math.min(arr[mid],mid-1);
				int left = magicIndex(arr,l,leftIndex); 
				if(left>=0){
					return  left;
				}
				return magicIndex(arr,mid+1,h);
				
			} else {
				int rightIndex= Math.max(arr[mid],mid+1);
				int right = magicIndex(arr,rightIndex,h);
				if(right>=0){
					return right;
				} else {
					return magicIndex(arr,l,mid-1);
				}
			}
		}
		return -1;
	}
	
	public static void main(String args[]){
		
		int arr1[] = {-40,-20,-1,1,2,3,5,7,9,12,13};
		int arr2[]={-10,-5,2,2,2,3,4,7,9,12,13};
		
		System.out.println(magicIndex(arr1,0,arr1.length-1));
		System.out.println(magicIndex(arr2,0,arr2.length-1));
		
		
	}

}
