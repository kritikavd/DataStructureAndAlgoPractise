package countWords;

public class Solution {
	
	static boolean isSpace(char a){
		return (a==' '|| a=='\t' || a=='\n');
	}
	static int countWords(char arr[]){
		
		int i=0,words =0;
		
		while(i<arr.length){
			
			while(i<arr.length && isSpace(arr[i]) ){
				i++;
			}
			
			if(i!=arr.length){
				words++;
				
				while(i<arr.length && !isSpace(arr[i])  ){
					i++;
				}
			}
			
		}
		return words;
	}
	
	
	public static void main(String args[]){
		
		String str = "One two          three\n  four\nfive  ";
		System.out.println(countWords(str.toCharArray()));
	}

}
