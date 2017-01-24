import java.util.ArrayList;
import java.util.HashMap;

class Point{
	int r;
	int c;
	
	Point(int r,int c){
		this.r=r;
		this.c=c;
	}
	
	public boolean equals(Point other){
		if(other==null)
			return false;
		if(!(other instanceof Point)){
			return false;
		}
		return (other.r==this.r && other.c==this.c );
	}
	
	public int Hash(){
		return r+c;
	}
}

public class Solution {
	
	
	static boolean findPath(int [][]matrix , HashMap <Point,Boolean> cache, ArrayList<Point> path,int r,int c){
		
		if(matrix == null || matrix.length==0 || r<0 || c<0 || matrix[r][c]==1)
		{
			return false;
		}
		
		if(r==0 && c==0){
			path.add(new Point(0,0));
			return true;
		}
		
		Point p = new Point(r,c);
		if(cache.containsKey(p)){
			System.out.print("helps");
			return cache.get(p);
		}
		
		if(findPath(matrix,cache,path,r-1,c)|| findPath(matrix,cache,path,r,c-1)){
			path.add(p);
			cache.put(p,true);
			return true;
		}
		
		cache.put(p, false);
		return false;
		
	}
	
	public static void main(String args[]){
		
		int matrix[][]= {{0,1,1,0},{0,0,0,0},{0,1,0,1},{0,0,0,0}};
		ArrayList<Point> path= new ArrayList<Point> ();
		
		HashMap<Point,Boolean> map =new HashMap<Point,Boolean>();
		if(findPath(matrix,map,path,3,3)){
			for(Point p:path){
				System.out.print(p.r+" "+p.c);
				System.out.println();
			}
			
		}
	}

}
