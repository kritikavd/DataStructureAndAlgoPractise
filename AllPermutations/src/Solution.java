import java.util.ArrayList;

public class Solution {
	
	static ArrayList<String> allPermutations(String str){
		
		ArrayList<String> permutations = new ArrayList<String>();
		if(str.length() == 0){
			permutations.add("");
			return permutations;
			
		}
		
		char first =str.charAt(0);
		String remaining = str.substring(1);
		
		ArrayList<String> perms = allPermutations(remaining);
		
		for(String perm : perms){
		
			for(int index =0 ;index <=perm.length();index++){
				String permone = insert(perm,first,index);
				permutations.add(permone);
			}
		}
		
		return permutations;
		
	}
	
	static String insert(String remaining,char chr,int index){
		
		String first= remaining.substring(0,index);
		String last = remaining.substring(index);
		return first+chr+last;
	}
	
	public static void main(String args[]){
		String s="abc";
		ArrayList<String> permutations = allPermutations(s);
		for(String permutation : permutations){
			System.out.println(permutation);
		}
	}

	
}
