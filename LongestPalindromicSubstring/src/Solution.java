


public class Solution {

	static int maxLenghtPalindrome(String s){

			int opt[][] = new int[s.length()][s.length()];

				for(int i=0;i<s.length();i++)
				{
						opt[i][i] = 1;
				}

				for(int j=0;j<s.length();j++){
						for(int i = j-1;i>=0 ;i--){
								if(s.charAt(i)==s.charAt(j)){
										opt[i][j]= opt[i+1][j-1]+2;
			
								} else {
										opt[i][j] = Math.max(opt[i+1][j],opt[i][j-1]);

								}
						}

				}

					return opt[0][s.length()-1];


	}
	
	public static void main(String args[]){
		System.out.println(maxLenghtPalindrome("geeksskeeg"));
	}
}
