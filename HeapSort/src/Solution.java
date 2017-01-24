
public class Solution {
	
	static void heapify(int arr[],int n, int i){
		
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left < n && arr[left]>arr[largest]){
			largest =left;
		} 
		
		if(right < n && arr[right] > arr[largest]){
			largest = right;
		}
		
		if(largest != i){
			int temp = arr[largest];
			arr[largest]=arr[i];
			arr[i]=temp;
			
			heapify(arr,n,largest);
		}
	}
	static void buildHeap(int arr[],int n){
		
		for(int i = n/2-1 ;i>=0;i--){
			heapify(arr,n,i);
		}
		
	}
	static void heapSort(int arr[],int n){
		
		buildHeap(arr,n);
		
		for(int i=n-1;i>=0;i--){
			int temp = arr[i];
			arr[i]=arr[0];
			arr[0]=temp;
			
			heapify(arr,i,0);
			
		}
	}
	
	
	public static void main(String args[]){
		int arr[]={8,6,5,4,3,2};
		
		heapSort(arr,arr.length);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

}
