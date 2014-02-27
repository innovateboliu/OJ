import java.util.Map;
import java.util.TreeMap;


public class MaxPointsInLine {
	public static class Point {
		int x;
		  int y;
		   Point() { x = 0; y = 0; }
		  Point(int a, int b) { x = a; y = b; }
	}
	public static void main(String[] args) {
		MaxPointsInLine o = new MaxPointsInLine();
//		System.out.println((int)((double)2/3 * 100));
		System.out.println(o.maxPoints(new Point[] {new Point(1, 1), new Point(1, 1), new Point(2, 2), new Point(2, 2)}));
	}
	
	public class Slope implements Comparable<Slope>{
		int x; 
		int y;
		public Slope(int x, int y) {
			if(y<0){
		          x *= -1;
		          y *= -1;
		      }
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Slope o) {
			return this.x * o.y - this.y * o.x;
		}
	}
	public int maxPoints(Point[] points) {
		if (points.length == 0) {
			return 0;
		} 
        int len = points.length;
        int totalMax = 1;
        for (int i = 0; i < len; i++) {
        	int max = 1;
        	Map<Slope, Integer> map = new TreeMap<Slope, Integer>();
        	Point anchor = points[i];
        	int num_same_point = 0;
        	for (int j = 0; j < len && j != i; j++) {
        		Point pnt = points[j];
        		if (points[i].x==pnt.x && points[i].y==pnt.y){
                    num_same_point++;
                    continue;
                }
        		Slope slope = new Slope(pnt.x - anchor.x, pnt.y - anchor.y);
        		if (map.containsKey(slope)) {
        			map.put(slope, map.get(slope) + 1);
        		} else {
        			map.put(slope, 2);
        		}
        		max = Math.max(max, map.get(slope));
        	}
        	totalMax = Math.max(max + num_same_point, totalMax);
        }
        return totalMax;
    }
}
