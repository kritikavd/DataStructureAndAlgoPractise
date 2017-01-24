import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*class ValueComparator implements Comparator<String>{
	
	
	public HashMap<String,Integer> map = new HashMap<String,Integer>();
	
	ValueComparator(HashMap<String,Integer> map1){
		map.putAll(map1);
	}
	@Override
	public int compare(String s1,String s2){
		if(map.get(s1) >= map.get(s2)){
			return -1;
		} else {
			return 1;
		}
	}
}*/

class ValueComparator implements Comparator<String>{
	 
	HashMap<String, Integer> map = new HashMap<String, Integer>();
 
	public ValueComparator(HashMap<String, Integer> map){
		this.map.putAll(map);
	}
 
	@Override
	public int compare(String s1, String s2) {
		if(map.get(s1) >= map.get(s2)){
			return -1;
		}else{
			return 1;
		}	
	}
}


public class Solution {
	
//	public static void main(String args[]){
//		
//		
//		HashMap<String,Integer> map = new HashMap<String,Integer>();
//		map.put("c",70);
//		map.put("a", 10);
//		map.put("b", 30);
//
//		TreeMap<String, Integer> tm = sortMapByValue(map);
//		for(Map.Entry<String,Integer> entry: tm.entrySet()){
//			System.out.println(entry.getKey()+ "-"+entry.getValue());
//		
//		}
//		
//		System.out.println(tm);
//		
//	}
//	
//	public static TreeMap<String,Integer> sortMapByValue(HashMap<String,Integer> map){
//		
//		ValueComparator vc = new ValueComparator(map);
//		
//		TreeMap<String,Integer> result = new TreeMap<String,Integer>(vc);
//		result.putAll(map);
//		return result;
//		
//	}
	
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 10);
		map.put("b", 30);
		map.put("c", 50);
		map.put("d", 40);
		map.put("e", 20);
		System.out.println(map);
 
		TreeMap<String, Integer> sortedMap = sortMapByValue(map);  
		System.out.println(sortedMap);
	}
 
	public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map){
		Comparator<String> comparator = new ValueComparator(map);
		//TreeMap is a map sorted by its keys. 
		//The comparator is used to sort the TreeMap by keys. 
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);
		return result;
	}
	
	

}
