
public class Solution {
	
	static int interpolationSearch(int arr[],int l,int h,int x){
		
		if(l<=h && x>=arr[l] && x<=arr[h]){
			int pos = l + (  (int)((x-arr[l]) *  (double)(h-l)/(arr[h]-arr[l])) );
			
			if(arr[pos]==x)
				return pos;
			
			if(arr[pos]> x)
				return interpolationSearch(arr,l,pos-1,x);
			
			else
				return interpolationSearch(arr,pos+1,h,x);
			
		}
		return -1;
	}
	
	public static void main(String args[]){
		
		int arr[] =  {10, 12, 13, 16, 18, 19, 20, 21, 22, 23,
                24, 33, 35, 42, 47};
		int x = 47;
		System.out.println(interpolationSearch(arr, 0, arr.length-1, x));
	}

}
