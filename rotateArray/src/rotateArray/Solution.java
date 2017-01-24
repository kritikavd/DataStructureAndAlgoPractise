package rotateArray;

public class Solution {

	
	static void rotateByone(int arr[]){

		int temp = arr[0];
		for(int i=0;i<arr.length-1;i++){
			arr[i]=arr[i+1];
		}
		arr[arr.length-1]=temp;
	} 
	
	static void reverse(int arr[],int l,int h){
		
		while(l<h){
			int temp= arr[l];
			arr[l]=arr[h];
			arr[h]=temp;
			l++;
			h--;
		}
	}

	static void rotateArray(int arr[],int d){


		d=d%arr.length;

		int n = arr.length;
		reverse(arr,0,d-1);
		reverse(arr,d,n-1);
		reverse(arr,0,n-1);
	}
		static void rotateByD(int arr[],int d){

			d=d%arr.length;
			for(int i=0;i<d;i++){
					rotateByone(arr);
			}
		}
		
		public static void main (String args[]){
			
			int [] arr={1,2,4,5,6,7,8};
			//rotateByD(arr,3);
			rotateArray(arr,3);
			for(int i=0;i<arr.length;i++){
				System.out.print(arr[i]+" ");
			}
		}
}
