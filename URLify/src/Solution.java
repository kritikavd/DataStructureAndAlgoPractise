
public class Solution {
	
	static void replacespaces(char arr[],int truelen){
		
		int curr= truelen-1;
		
		int cntspaces = 0;
		int index = truelen-1;
		while(index>=0){
			
			if(arr[index]==' ')
				cntspaces++;
			index--;
		}
		
		int p = truelen+2*cntspaces-1;
		while(curr>=0){
			
			if(arr[curr]==' '){
				arr[p]='0';
				arr[p-1]='2';
				arr[p-2]='%';
				p=p-3;
				
			} else {
				arr[p]=arr[curr];
				p=p-1;
			}
			curr--;
		}
		System.out.println("p is at "+p);
		System.out.println("curr is at "+curr);
		
	}
	
	public static void main(String args[]){
		
		String s="this is the string         ";
		
		char arr[] =s.toCharArray();
		
		replacespaces(arr,18);
		s=new String (arr);
		System.out.println(s);
		
		
		
		
	}

}
