package eg.edu.alexu.csd.oop.game.world;

import java.util.List;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.objects.DynamicEnvironment;
import eg.edu.alexu.csd.oop.game.objects.Shape;

public class StateCatchpoint implements State {

	private GameInfo gameinfo = GameInfo.getInstance();


	@Override
	public void doaction(Shape shape, List<Shape> stack,Logger logger) {
		// TODO Auto-generated method stub
	//	stack.add(shape);
		gameinfo.getMovable().remove(shape);
		//shape.setY(0);
		//shape.setMovable(true);
		gameinfo.getEnvironment().release(shape, logger);
		new ObserverView(gameinfo , stack, logger);
		new ObserverPoints(gameinfo, logger);
		new ObserverLevel(gameinfo, logger);
		new ObserverTime(gameinfo, logger);
		gameinfo.notifyAllObservers();
		shape.setState(this);
	}

}
