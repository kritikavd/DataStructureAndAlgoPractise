package insertRemoveRandomBigO1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class Solution {
    
    ArrayList<Integer> array;
    HashMap<Integer,LinkedHashSet<Integer>> map;

   /** Initialize your data structure here. */
   public Solution() {
       
       array = new ArrayList<Integer>();
       map = new HashMap<Integer,LinkedHashSet<Integer>>();
      
   }
   
   /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
   public boolean insert(int val) {
       LinkedHashSet<Integer> set;
       boolean alreadyExists;
       if(map.containsKey(val)){
           alreadyExists = true;
           set = map.get(val);
       } else {
           alreadyExists = false;
          set = new LinkedHashSet<Integer>();
          map.put(val,set);
       }
       
       set.add(array.size());
       array.add(val);
       return (!alreadyExists);
       
   }
   
   /** Removes a value from the collection. Returns true if the collection contained the specified element. */
   public boolean remove(int val) {
       
       if(!map.containsKey(val)){
           return false;
       }else{
          
    	   LinkedHashSet<Integer> set = map.get(val);
           int indexOfValue = set.iterator().next();
           
           if(array.get(indexOfValue)==array.get(array.size()-1)){
        		   
        		   set.remove(array.size()-1);
        		   if(set.size()==0){
        			   map.remove(val);
        		   } 
        		   
        		   array.remove(array.size()-1);
           } else {
        	   
        	   array.set(indexOfValue,array.get(array.size()-1));
        	   
        	   LinkedHashSet<Integer> set2= map.get(array.get(array.size()-1));
               set2.remove(array.size()-1);
               set2.add(indexOfValue);
               
               set.remove(indexOfValue);
               if(set.size()==0)
            	   map.remove(val); 
               array.remove(array.size()-1);
        	   
           }
           
           return true;
       }
   }
   
   /** Get a random element from the collection. */
   public int getRandom() {
       
       int index = (int) (Math.random()* array.size());
       return array.get(index);
   }
   
   public static void main(String args[]){
	   Solution obj = new Solution();
	 
	   System.out.println(obj.insert(-1));
	   System.out.println(obj.remove(-2));
	   System.out.println(obj.insert(-2));
	   System.out.println(obj.getRandom());
	   System.out.println(obj.remove(-1));
	   System.out.println(obj.insert(-2)); 
	   System.out.println(obj.getRandom());
	
	
	   
   }
}


 

