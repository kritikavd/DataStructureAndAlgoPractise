



public class Solution {
	
	
	static boolean match(char arr1[],char arr2[],int i,int j){

		if( i ==arr1.length  && j == arr2.length){
			return true;
	}

	if(i== arr1.length && j!=arr2.length){
		return false;
	}

	if(i == arr1.length-1  && ( arr1[i] == '*' || arr1[i] == '?' ) && j==arr2.length){
			return true;
	}

	if(i<arr1.length && j== arr2.length){
		return false;
	} 

	if(arr1[i] ==arr2[j] || arr1[i]== '?'){
		return  match(arr1,arr2,i+1,j+1);
	}

	if(arr1[i]=='*'){

		return ( match(arr1,arr2,i+1,j) || match(arr1,arr2,i,j+1));

	}

		return false;

	}
	
	public static void main(String args[]){
		
		String s1="*?c*d";
		String s2 ="abcd";
		
		System.out.println(match(s1.toCharArray(),s2.toCharArray(),0,0));
		/*match("g*ks", "geeks"); // Yes
	    test("ge?ks*", "geeksforgeeks"); // Yes
	    test("g*k", "gee");  // No because 'k' is not in second
	    test("*pqrs", "pqrst"); // No because 't' is not in first
	    test("abc*bcd", "abcdhghgbcd"); // Yes
	    test("abc*c?d", "abcd"); // No because second must have 2
	                             // instances of 'c'
	    test("*c*d", "abcd"); // Yes
	    test("*?c*d", "abcd"); // Yess
	    */
	}

}
