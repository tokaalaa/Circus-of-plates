package eg.edu.alexu.csd.oop.game.world;

import java.util.List;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.objects.DynamicEnvironment;
import eg.edu.alexu.csd.oop.game.objects.Shape;

public class StateMiss implements State{

	GameInfo gameinfo = GameInfo.getInstance();

	@Override
	public void doaction(Shape shape, List<Shape> stack, Logger logger) {
		// TODO Auto-generated method stub
		gameinfo.getMovable().remove(shape);
		shape.setVisable(false);
		//shape.setY(0);
		gameinfo.getEnvironment().release(shape, logger);

	}

}
