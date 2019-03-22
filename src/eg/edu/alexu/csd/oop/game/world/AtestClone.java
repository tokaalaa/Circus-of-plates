package eg.edu.alexu.csd.oop.game.world;

import java.awt.Point;
import java.util.ArrayList;

public class AtestClone implements Cloneable{
	String t;
	ArrayList<Point> a = new ArrayList<Point>();
	public void setString(String s) {
		s = "change";
		Point pt1 = new Point(500, 100);
		a.add(pt1);
	}
	public Point getobject() {
		Point pt1 = new Point(100, 100);
	      Point pt2 = pt1;
	 
	 a.add(pt1);
	 return a.get(0);
	}
	@SuppressWarnings("unchecked")
	public AtestClone clone() {
		AtestClone clone = null;
	      try {
	         clone = (AtestClone) super.clone();
	         clone.a = (ArrayList<Point>) this.a.clone();
	      } catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	      }
	      
	      return clone;
	   }
}
