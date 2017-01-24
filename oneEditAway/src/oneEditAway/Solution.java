package oneEditAway;

public class Solution {
	
	static boolean  oneReplacementAway(String s1,String s2){
		
		int i=0,j=0;
		boolean different = false;
		while(i<s1.length() && j< s2.length()){
			
			if(s1.charAt(i) != s2.charAt(j)){
				if(different){
					return false;
				}
				different=true;
			} 
			
			i++;
			j++;
		}
		return true;
	}
	
	static boolean oneInsertAway(String small,String large){
		int i=0;
		int j=0;
		while(i<small.length() && j<large.length()){
			if(small.charAt(i)!=large.charAt(j)){
				if(i!=j)
					return false;
				
				j++;
			} else {
				i++;
				j++;
			}
			
		}
		return true;
	}
	
	static boolean checkOneEditAway ( String s1,String s2){
		
		if(s1.length()==s2.length()){
			return oneReplacementAway(s1,s2);
		}
		if(s1.length()+1==s2.length()){
			return oneInsertAway(s1,s2);
		}
		if(s2.length()+1==s1.length()){
			return oneInsertAway(s2,s1);
		}
		
		return false;
	}
	
	public static void main(String args[]){
		
		String s="pale";
		String s2 ="bale";
		String s3 = "ale";
		String s4 ="pales";
		String s5="fales";
		System.out.println(checkOneEditAway(s,s2));
		System.out.println(checkOneEditAway(s,s3));
		System.out.println(checkOneEditAway(s,s4));
		System.out.println(checkOneEditAway(s,s5));
		
	}

}
