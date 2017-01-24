import java.util.HashSet;

public class Solution
{
    /* Utility Functions to get max and minimum of two integers */
    static int max(int x, int y) 
    {
        return x > y ? x : y;
    }
 
    static int min(int x, int y) 
    {
        return x < y ? x : y;
    }
 
    /* For a given array arr[], returns the maximum j-i such that
       arr[j] > arr[i] */
    static int maxIndexDiff(int arr[], int n) 
    {
        int maxDiff;
        int i, j;
 
        int RMax[] = new int[n];
        int LMin[] = new int[n];
 
        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            LMin[i] = min(arr[i], LMin[i - 1]);
 
        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = max(arr[j], RMax[j + 1]);
 
        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        i = 0; j = 0; maxDiff = -1;
        
        System.out.println(LMin.toString());
        
        for(int index:LMin){
        	System.out.print(index+" ");
        }
        System.out.println();
        
        for(int index:RMax){
        	System.out.print(index+" ");
        }
        System.out.println();
        
        
        System.out.println(RMax.toString());
        
        
        while (j < n && i < n) 
        {
            if (LMin[i] < RMax[j]) 
            {
                maxDiff = max(maxDiff, j - i);
                j = j + 1;
            } 
            else
                i = i + 1;
        }
 
        return maxDiff;
        
    }
    
  
 
    /* Driver program to test the above functions */
    public static void main(String[] args) 
    {
      
        int arr[] =  {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        int n = arr.length;
        int maxDiff = maxIndexDiff(arr, n);
        System.out.println(maxDiff);
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        Integer a = new Integer(1);
        Integer b = new Integer(2);
        
        set.add(a);
        set.add(b);
        
        b=new Integer(1);
        
        
        System.out.println(set.size());
        
        
    }
}