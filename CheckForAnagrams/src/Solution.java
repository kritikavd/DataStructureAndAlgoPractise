import java.util.Scanner;

public class Solution {

	static boolean checkForAnagrams(String s1,String s2){
		if(s1.length()!=s2.length())
			return false;
		
		int arr[] = new int[128];
		char arr1[] = s1.toCharArray();
		char arr2[] = s2.toCharArray();
		
		for(char c : arr1){
			arr[c]++;
		}
		
		for(char c: arr2){
			arr[c]--;
		}
		
		for(int i: arr){
			if(i!=0)
				return false;
		}
		return true;
	}
	
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
	 String s1 = 	sc.next();
	 String s2 = sc.next();
		System.out.println(checkForAnagrams(s1, s2));
	}
}
