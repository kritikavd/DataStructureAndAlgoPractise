
public class Solution {
	
	static int getNumberForCharacter(char c){
		
		c=Character.toLowerCase(c);
		 
		if(c>='a' && c<='z' || c>='A' && c<='Z' ){
			c=Character.toLowerCase(c);
			return c-'a';
		}else{
			return -1;
		}
	}
	
	static int [] buildTable(char arr[]){
		
		int [] table = new int['z'-'a'+1];
		for(int i=0;i<arr.length;i++){
			int number = getNumberForCharacter(arr[i]);
			if(number!=-1){
				table[number]++;
			}
		}
		return table;
		
	}
	
	static boolean checkTableFrequency(int [] table){
		boolean isodd = false;
		for(int i:table){
			if(i%2!=0){
				if(isodd){
					return false;
				}
				isodd= true;
			}
			
		}
		return true;
	}
	
	static boolean isPermutationOfPalindrome(String s){
		
		int table[] = buildTable(s.toCharArray());
		char arr[] = s.toCharArray();
		return checkTableFrequency(table);
		
	}
	
	static boolean isPermutationOfPalindromeTwo(String s){
		int bitVector = createBitVector(s);
		if(bitVector == 0 || (bitVector & (bitVector -1) )==0)
			return true;
		return false;
	}
	
	static int createBitVector(String s){
		int bitVector =0;
		for(Character c: s.toCharArray()){
			
			int number = getNumberForCharacter(c);
			if(number!=-1){
				int mask = 1<< number;
			
				if((mask & bitVector) > 0){
					bitVector = bitVector & ~mask;
				} else{
					
					bitVector = bitVector | mask;
				
				}
			}
		}
		
		return bitVector;
	}
	
	public static void main(String args[]){
		
		String check = "Tact Coa";
		System.out.println(isPermutationOfPalindrome(check));
		System.out.println(isPermutationOfPalindromeTwo(check));
		
	}
	

}
