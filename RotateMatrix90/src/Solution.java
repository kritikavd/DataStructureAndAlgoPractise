
public class Solution {
	
	
	static void rotateMatrix(int arr[][]){
		
		int rows = arr.length;
		if(rows == 0){
			System.out.println("invalid matrix");
			return;
		}
		
		int cols = arr[0].length;
		
		if(rows !=cols ){
			System.out.println("invalid matrix : not a square matrix");
			return;
		}
		for(int layer = 0;layer < rows/2;layer++){
			int first=layer;
			int last = rows-layer-1;
			
			
			//careful i should be < last not <=last
			for(int i=first; i<last;i++){
				int offset = i-first;
				
				int top = arr[first][i];
				
				arr[first][i]= arr[last-offset][first];
				
				arr[last-offset][first]=arr[last][last-offset];
				
				arr[last][last-offset]= arr[i][last];
				
				arr[i][last]= top;
			}
		}
	}
	
	static void display(int arr[][]){
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	public static void main(String args[]){
		
		int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
		display(arr);
		rotateMatrix(arr);
		display(arr);
	
		
	}
}
