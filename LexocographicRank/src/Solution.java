
public class Solution {

	static int findFact(int n){
		
		if(n==0 || n==1){
			return 1;
		}
		int fact[]= new int[n+1];
		fact[0]=1;
		fact[1]=1;
		
		for(int i=2;i<n+1;i++){
			fact[i]=fact[i-1]*i;
		}
		
		return fact[n];
		
	}
	static int findRank(String s){
		
		
		char arr [] = s.toCharArray();
		int sum=0;
		for(int i=0;i<arr.length;i++){
			
			
			sum += (arr[i]-'a') * findFact(arr.length-(i+1));
		}
		return sum;
		
	}
	
	public static void main(String args){
		
		String s="bca";
		
		System.out.println(findRank(s));
	}
}
