package eg.edu.alexu.csd.oop.game.world;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
public class aaaa {
	 
	 
	  
	    public static void main(String[] arguments) {
	    	/**
	    	AtestClone original = new AtestClone();
	    	original.setString(original.t);
	    	AtestClone copy = (AtestClone) original.clone();
	    	Point p = copy.getobject();
	    	
	    	p.x = 200;
	    	System.out.println(original.a);
	    	System.out.println(copy.a);*/
	    	//test pointers
	      Point pt1, pt2;
	      pt1 = new Point(100, 100);
	      pt2 = pt1;
	 ArrayList<Point> a = new ArrayList<Point>();
	 a.add(pt1);
	
	ArrayList<Point> a2 = new ArrayList<Point> ();
	 
	 a.add(pt2);
	 java.util.Iterator<Point> iterator = a.iterator();
	 while(iterator.hasNext())
	 {
	     //Add the object clones
	     a2.add((Point) iterator.next().clone()); 
	 }
	 Point p3 = a2.get(0);
	 p3.x = 300;
	      test(a.get(0));
	    // pt2.y = 200;
	      System.out.println(a);
	      System.out.println(a2);
	     System.out.println("Point1: " + pt1.x + ", " + pt1.y);
	    System.out.println("Point2: " + pt2.x + ", " + pt2.y);
	    System.out.println("Point3: " + p3.x + ", " + p3.y);
	   }
	public static void test(Point p) {
		Point pt1 = p;
		pt1.x = 500;
		
	}
}
