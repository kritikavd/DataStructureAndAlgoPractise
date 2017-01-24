
public class Solution {
	
	
	static int multiplyUtil(int a,int b){
		int small = (a<b)?a:b;
		int big = (a>b)?a:b;
		return multiply(small,big);
	}
	
	static int multiply(int s,int b){
		if(s==0)
			return 0;
		if(s==1)
			return b;
		int small= s>> 1;
		int result = multiply(small,b);
		
		if(s %2 ==1){
			return result*2+ b;
		} else {
			return result*2;
		}
	}
	
	public static void main(String args[]){
		
		int a= 5;
		int b = 12;
		
		System.out.println(multiplyUtil(a,b));
	}
	
	

}
