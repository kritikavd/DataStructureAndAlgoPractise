import java.util.LinkedList;

public class Solution {
	

	
	static int[] maximumSlidindWindow(int arr[],int w){
			
		if(w>=arr.length){
			
			int max=-1;
			for(int j=0;j<arr.length;j++){
				max=Math.max(max, arr[j]);
			}
			return new int[]{max};
		}
		
		int max[]= new int[(arr.length-w+1)];
		
		LinkedList<Integer> deque= new LinkedList<Integer>();
		int i=0;
		
		for(i=0;i<w;i++){
			
			
			while(!deque.isEmpty() && arr[i]>=arr[deque.getLast()]){
				System.out.println("removing "+deque.removeLast());
			}
			System.out.println("adding at last "+i);
			deque.addLast(i);
		}
		
		for(int j=0;j<deque.size();j++){
			
			System.out.print(deque.get(j));
		}
		
		System.out.println();
		
		for(i=w;i<arr.length;i++){
			
			max[i-w]= arr[deque.getFirst()];
			
			while(!deque.isEmpty() && arr[i]>=arr[deque.getLast()]){
				deque.removeLast();
			}
			
			while(!deque.isEmpty() && deque.getFirst() <= i-w ){
				deque.removeFirst();
			}
			
			
			deque.addLast(i);
		}
		
		max[arr.length-w]= arr[deque.getFirst()]; 
		return max;
		
	}
	
	public static void main(String args[]){
		int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		int k = 3;
		int result[] = maximumSlidindWindow(arr, k);
		
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]+" ");
		}
		System.out.println();
	}

}
