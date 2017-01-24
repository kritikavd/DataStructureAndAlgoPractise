
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
public class Solution {
	
	

	static  ArrayList<ArrayList<Integer>> findSubsets (int arr[],int index){

	ArrayList<ArrayList<Integer>> powerSet= new ArrayList<ArrayList<Integer>>();
	if(index == arr.length){
				
		ArrayList<Integer> set = new ArrayList<Integer>();
				powerSet.add(set);
				return powerSet;
	}

	ArrayList<ArrayList<Integer>> returned = findSubsets(arr,index+1);
	powerSet.addAll(returned);
	
	for(ArrayList<Integer> list :returned){
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.addAll(list);
			list.add(arr[index]);
			powerSet.add(list2);
			
	}
		//powerSet.addAll(returned);
		return powerSet;
	}
	
	static ArrayList<ArrayList<Integer>> findSubset(ArrayList<Integer> set){

		ArrayList<ArrayList<Integer>> powerSet = new ArrayList<ArrayList<Integer>>();

			int max = 1<<set.size();
			for(int i=0;i<max;i++){
				powerSet.add(convertToSet(i,set));
		}
		return powerSet;


		}

		static ArrayList<Integer> convertToSet(int n,ArrayList<Integer> set){
		ArrayList<Integer> returned = new ArrayList<Integer>();
		int index=0;
		for(int k = n; k>0;k = k >> 1){
				
				if((k & 1) == 1){
					returned.add(set.get(index));

		}
		index++; 

		}
		return returned;

		}


	
	
	
	public static void main(String args[]){
		
		int arr[]={1,2,3};
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		arrlist.add(1);
		arrlist.add(2);
		arrlist.add(3);
		
		//ArrayList l = (ArrayList) Arrays.asList(arr);
		
		
		ArrayList<ArrayList<Integer>> returned = findSubsets(arr, 0);
		ArrayList<ArrayList<Integer>> returned2 = findSubset(arrlist);
		for(ArrayList<Integer> list :returned2){
			for(Integer i : list){
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
	}
	

}
