package scripts.plunder.utilities;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Player;

public class Waiting {
	
	public static void waitMovement(){
		General.sleep(300,500);
		while(Player.isMoving()){
			General.sleep(100,200);
		}
	}

}
