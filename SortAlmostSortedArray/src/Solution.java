
class Heap{
	int arr[];
	int size;
	int capacity;
	
	Heap(int capacity){
		this.capacity = capacity;
		arr= new int[capacity];
	}
	
	
	Heap(int arr[]){
		this.arr=arr.clone();
		size=capacity=arr.length;
		for(int i=size/2-1;i>=0;i--){
			heapify(i);
		}
	}
	
	/*void heapifyUp(int index){
		
		if(index > 0 && index < size)
		{
			int parent= (index-1)/2;
			if(arr[parent]<arr[index]){
				int temp = arr[parent];
				arr[parent]=arr[index];
				arr[index]=temp;
				
				heapifyUp(parent);
			}
		}
		
	}
	
	void insert(int n){
		if(size!=capacity){
			int index = size;
			arr[index]=n;
			size++;
			heapifyUp(size);
			
		}
	}*/
	
	int extractMin(){
		if(size>0){
			int temp=arr[0];
			arr[0]=arr[size-1];
			size--;
			heapify(0);
			return temp;
		}
		
		return -1;
	}
	
	int replaceMin(int replaceValue){
		
		if(size>0){
			int temp=arr[0];
			arr[0]=replaceValue;
			heapify(0);
			return temp;
		}
		
		return -1;
		
	}
	
	
	void heapify(int i){
		
		int smallest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left < size && arr[left]<arr[smallest]){
			smallest =left;
		}
		
		if(right<size && arr[right]<arr[smallest]){
			smallest = right;
		}
		
		if(smallest!=i){
			int temp= arr[smallest];
			arr[smallest]=arr[i];
			arr[i]=temp;
			
			heapify(smallest);
		}
		
	}
	
}
// sort almost sorted array
public class Solution {

	
	static int[] sortAlmostSorted(int arr[],int n, int k){
		
		int heapArray[]= new int[k+1];
		int result[]=new int[n];
		
		for(int i=0;i<=k && i<n ;i++){
			heapArray[i]=arr[i];
		}
		
		Heap heap = new Heap(heapArray);
		
		
		
		
		int j=0;
		for(int i=k+1;i<n;i++,j++){
			result[j]=heap.replaceMin(arr[i]);
			System.out.print(result[j]+" ");
		}
		
		
		while(j<n){
			result[j]=heap.extractMin();
			System.out.print(result[j]+" ");
			
			j++;
		}
		
		return result;	
	}
	
	public static void main(String args[]){
		int k = 3;
	    int arr[] = {2, 6, 3, 12, 56, 8};
	    
	    int result[] = sortAlmostSorted(arr,arr.length,k);
	    
	   for(int i: result){
	    	System.out.print(i+" ");
	    }
	}
	
	

	
	
	
	
	
}
