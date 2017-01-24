

class StartAndEnd{
	int start;
	int end;
	
	StartAndEnd(int start,int end){
		this.start=start;
		this.end=end;
	}
}
public class Solution {
	
	
	static StartAndEnd findStartEndUnsortedSubArray(int arr[],int l,int h){
		
		if(l==-1){
			System.out.println("array size is < 0");
			return new StartAndEnd(-1,-1);
		}
		
		if(l==h){
			System.out.println("already Sorted");
			return new StartAndEnd(-1,-1);
		}
		
		int start = l;
		int end = l;
		
		for(int i=l+1;i<=h;i++){
			
			if(arr[i]<arr[i-1]){
				System.out.println("arr[i] "+arr[i]+"arr[i-1] "+arr[i-1]);
				start = i-1;
				break;
			}
		}
		
		if(start ==l){
			System.out.println("array is already sorted");
			return new StartAndEnd(-1,-1);
		}
		
		for(int i=h;i>l;i--){
			if(arr[i-1]> arr[i]){
				end=i;
				break;
			}
		}
		
		System.out.println("start "+start+"end "+end);
		
		
		int min = start;
		int max= start;
		
		for(int i=start;i<=end;i++){
			
			if(arr[i]<arr[min]){
				min = i;
				
			}
			if(arr[i]>arr[max]){
				max= i;
			}
		}
		
		
		System.out.println("min "+min +"max "+max);
		for(int i=l;i<start;i++){
			if(arr[i]>arr[min]){
				start = i;
				break;
				
			}
		}
		
		for(int i=h;i>end;i--){
			if(arr[i]<arr[max]){
				end = i;
				break;
			}
		}
		
			return new StartAndEnd(start,end);	
		
	}

	public static void main(String args[]){
		 int arr[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		 int arr2[] = {0, 1, 3, 5, 6};
		
		  StartAndEnd startAndEnd = findStartEndUnsortedSubArray(arr, 0,10);
		  StartAndEnd startAndEnd2 = findStartEndUnsortedSubArray(arr2, 0,4);
		  
		  System.out.println(startAndEnd.start + " "+startAndEnd.end);
		  System.out.println(startAndEnd2.start + " "+startAndEnd2.end);
		 
	}
}
