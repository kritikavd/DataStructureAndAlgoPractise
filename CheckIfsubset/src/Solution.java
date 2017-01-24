import java.util.Arrays;

public class Solution {
	
	
	static boolean isSubset(int arr1[],int arr2[]){

		if(arr2.length > arr1.length)
				return false;

		if(arr2.length == 0)
			return true;

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int i=0,j=0;

while(i<arr1.length && j<arr2.length){
	if(arr1[i]<arr2[j])
		i++;
	else if(arr1[i]==arr2[j]){
		i++;
		j++;
	}
	else
	 return false;
}

if(j!=arr2.length)
	return false;

return true;

}
	
	public static void main(String args[]){
		 int arr1[] = {1, 4, 2};
		    int arr2[] = {1, 4, 4, 2};
		    System.out.println(isSubset(arr1, arr2));
	}

}
