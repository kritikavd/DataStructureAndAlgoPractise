
public class Solution {
	
	static void printDuplicates(String s){
		char arr[]  = s.toCharArray();
		boolean map[]= new boolean[128];
		
		for(char c: arr){
			if(map[c]==false){
				map[c]=true;
			} else{
				System.out.println("Duplicate"+c);
			}
		}
	}
	
	static void printDuplicatesSecond(String s){
		char arr[] = s.toCharArray();
		int vector = 0;
		
		for(char c: arr){
			int i = c-'a';
			int val = 1 << i;
			if((val & vector) > 0){
				System.out.println("Duplicates "+ c);
			} else{
				vector = vector | val;
			}
		}
	}
	
	public static void main(String args[]){
		String withDuplicates ="abcdessaaamnit";
		String without = "abcdefgh";
		printDuplicates(withDuplicates);
		printDuplicates(without);
		printDuplicatesSecond(withDuplicates);
		printDuplicatesSecond(without);
	}

}
