package medianOfSortedArraySameSize;

public class Solution {
	
	static int getMedian(int arr[]){
		int n = arr.length;
		if(arr.length % 2==0){
			return (arr[n/2]+arr[n/2-1])/2;
		} else {
			return arr[n/2];
		}	
	}
	
	
	static int getkth(int s[], int start1, int m, int l[],int start2, int n, int k){
        // let m <= n
        if (m > n) 
            return getkth(l, start2,n, s,start1, m, k);
        if (m == 0)
            return l[k - 1];
        if (k == 1)
            return Math.min(s[start1], l[start2]);

        int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
        if (s[i - 1] > l[j - 1])
            return getkth(s, start1,m, l, start2+j, n - j, k - j);
        else
            return getkth(s ,start1+ i, m - i, l,start2, n, k - i);
        
    }
    
    double findMedianSortedArrays(int A[], int m, int B[], int n) {
        int l = (m + n + 1) /2 ;
        int r = (m + n + 2) /2;
        return (getkth(A,0, m ,B, 0,n, l) + getkth(A,0, m, B,0, n, r)) / 2.0;
    }
	
	static int getMedianMerged(int arr1[],int arr2[],int n,int l1,int h1,int l2,int h2){
		
		if(n<=0){
			return -1;
		} 
		
		if(n==1){
			return (arr1[l1]+arr2[l2])/2;
		}
		
		if(n==2){
			return (((Math.max(arr1[l1],arr2[l2])+Math.min(arr1[h1], arr2[h2])))/2);
		}
		
		int m1= getMedian(arr1);
		int m2 = getMedian (arr2);
		
		if(m1 == m2){
			return m1;
		}
		if(m1<m2){
			if(n%2==0){
				return getMedianMerged(arr1,arr2,n/2+1,l1+n/2-1,h1,l2,h2-(n/2-1));
				
			} else {
				return getMedianMerged(arr1,arr2,n/2+1,l1+n/2,h1,l2,h2-n/2);
			}
		} else{
			
			if(n%2==0){
				return getMedianMerged(arr1,arr2,n/2+1,l1,h1-(n/2-1),l2+(n/2-1),h2);
				
			} else {
				return getMedianMerged(arr1,arr2,n/2+1,l1,h1-n/2,l2+n/2,h2);
			}
			
		}
	}
	
	public static void main (String args[]){
		
		int ar1[] = {1, 2, 3, 6};
	    int ar2[] = {4, 6, 8, 10};
	    int n1 = 4;
	    int n2 = 4;
	    if (n1 == n2)
	        System.out.println("Median is"+ getMedianMerged(ar1, ar2, n1,0,n1-1,0,n1-1));
	    else
	        System.out.println("Doesn't work for arrays of unequal size");
	   
	}
	
}
