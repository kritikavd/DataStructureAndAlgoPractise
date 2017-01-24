enum HeapType{
	
	MIN,MAX;

}

class Heap{
	
	int array[];
	int size;
	HeapType type;
	int capacity ; 
	
	
	Heap(int capacity,HeapType type){
		
		this.capacity=capacity;
		this.type=type;
		array = new int[capacity];
		size=0;
	}
	
	void heapify(int index ){
		
		int left = 2*index+1;
		int right = left+1;
		
		int max = index;
		if(left<size){
			if( (type== HeapType.MAX && array[left]>array[max]) || (type== HeapType.MIN && array[left]<array[max])){
				max=left;
			}
		}
		
		if(right < size){
			
			if( (type== HeapType.MAX && array[right]>array[max]) || (type== HeapType.MIN && array[right]<array[max])){
		
				max=right;
			}
		}
		
		if(max!=index)
		{
			int temp=array[max];
			array[max]=array[index];
			array[index]=temp;
			heapify(max);
		}
		
	}
	
	void buildHeap(){
		
		for(int i=size/2 -1 ;i>=0;i--){
			heapify(i);
		}
	}
	
	int peekroot(){
		
		if(size>0)
		return array[0];
		
		return -1;
	}
	
	int extractRoot(){
		
		int returnValue=-1;
		if(size > 0){
			int temp = array[0];
			returnValue=array[0];
			array[0]= array[size-1];
			array[size-1]= temp;
			size--;
			heapify(0);
		}
		
		return returnValue;
	}
	
	void heapifyUp(int index){
		
		if(index > 0){
			
			int parent = (index-1)/2;
			if((type==HeapType.MAX && array[parent] < array[index])||(type == HeapType.MIN && array[parent]> array[index]) ){
				int temp = array[index];
				array[index]= array[parent];
				array[parent]= temp;
				heapifyUp(parent);
			}
			
		}
	}
	
	void insert(int n){
		
		if(capacity == size){
			System.out.println("Memory full");
			return;
		}
		
		size++;
		array[size-1]=n;
		heapifyUp(size-1);
	}
	
	void display(){
		
		for(int i=0;i<size;i++){
			System.out.print(array[i]);
		}
		System.out.println();
	}
}

class HeapsForMedian{
	
	Heap maxHeap ;
	Heap minHeap;
	
	HeapsForMedian(){
		maxHeap = new Heap(10,HeapType.MAX);
		minHeap = new Heap(10,HeapType.MIN);
		
	}
	
	void insert(int n){
	
			if(n < maxHeap.peekroot()){
				maxHeap.insert(n);
			} else {
				minHeap.insert(n);
			}
			
			if(maxHeap.size > minHeap.size +1)
				minHeap.insert(maxHeap.extractRoot());

			if(minHeap.size > maxHeap.size){
				maxHeap.insert(minHeap.extractRoot());
			}
			
	}
	
	int getMedian(){
		
		int median = maxHeap.extractRoot();
		
		if(maxHeap.size<minHeap.size){
			maxHeap.insert(minHeap.extractRoot());
		}
		
		return median;
	}
}
public class Solution {
	
	public static void main(String args[]){
		HeapsForMedian heaps = new HeapsForMedian();
		heaps.insert(1);
		
		heaps.insert(3);
		
		heaps.insert(4);
		heaps.insert(2);
		

		System.out.println(heaps.getMedian());
	}

	
}
