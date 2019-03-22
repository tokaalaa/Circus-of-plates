package eg.edu.alexu.csd.oop.game.pools;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.objects.Shape;

public abstract class ShapesPool {
	private ArrayList<GameObject> freeList;
	private ArrayList<GameObject> usedList;
	private ArrayList<GameObject> savedFreeList;
	private ArrayList<GameObject> savedUsedList;
	private static final int size = 10;
	public ShapesPool() {
	usedList = new ArrayList<GameObject>();
	} 

	public GameObject acquire(Logger logger) {
	if (!freeList.isEmpty())
	{
		GameObject object = freeList.remove(0);
		((Shape) object).setVisable(true);
		usedList.add(object);
		String name = ((Shape) object).getType();
		name = name.substring(0, name.length()-4);
		logger.info("the shape " + name + " is added in the view");
		return usedList.get(usedList.size() - 1);
	} else {
		logger.error("No available object to return so return null");
		return null; // No available object to return!
	}
	}
	public void release(GameObject object, Logger logger) {
	if (usedList.remove(object)) {
		freeList.add(object);
		String name = ((Shape) object).getType();
		name = name.substring(0, name.length()-4);
		logger.info("the shape " + name + " is released in the view");
	} else {
		logger.error("no such object in the pool");
	}

	}
	public void setFreeList(ArrayList<GameObject> freeList) {
		this.freeList = freeList;
	}
	public void setUsedList(ArrayList<GameObject> usedList) {
		this.usedList = usedList;
	}
	public int getSize() {
		return size;
	}
	public void saveLists() {
		savedFreeList = new ArrayList<GameObject>();
		savedUsedList = new ArrayList<GameObject>();
		for (int i = 0; i < freeList.size(); i++) {
			savedFreeList.add((GameObject) ((Shape) freeList.get(i)).clone());
		}
		for (int i = 0; i < usedList.size(); i++) {
			savedUsedList.add((GameObject) ((Shape) usedList.get(i)).clone());
		}
	}
	public ArrayList<GameObject> getSavedFreeList(){
		return savedFreeList;
	}
	public ArrayList<GameObject> getSavedUsedList(){
		return savedUsedList;
	}
}
