package scripts.plunder.actions;

import org.tribot.api.General;
import org.tribot.api2007.Game;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Options;

import scripts.plunder.resources.Areas;
import scripts.plunder.resources.Data;
import scripts.plunder.utilities.Conditions;

public class TombSolver {

	public static void completeRoom(){
		Inventory.drop(Data.vialID, 9026, 9032, 9036);
		if(Tomb.getRoom() == 1){
			if(Conditions.atArea(Areas.roomOneTrap)){
				Tomb.solve(1);
			}else{
				if(Conditions.lessThanLevel(31)){
					Tomb.loot(1);
				}
				if(Conditions.greaterThanLevel(31)){
					Tomb.hop(1);
				}
			}
		}

		if(Tomb.getRoom() == 2){
			if(Conditions.atArea(Areas.roomTwoTrap)){
				Tomb.solve(2);
			}else{
				if(Conditions.lessThanLevel(41)){
					Tomb.loot(2);
				}
				if(Conditions.greaterThanLevel(41)){
					Tomb.hop(2);
				}
			}
		}

		if(Tomb.getRoom() == 3){
			if(Conditions.atArea(Areas.roomThreeTrap)){
				Tomb.solve(3);
			}else{
				if(Conditions.lessThanLevel(51) || !Conditions.timeToHop()){
					Tomb.loot(3);
				}
				if(Conditions.greaterThanLevel(51) && Conditions.timeToHop()){
					Tomb.hop(3);
				}
			}
		}

		if(Tomb.getRoom() == 4){
			if(Conditions.atArea(Areas.roomFourTrap)){
				Tomb.solve(4);
			}else{
				Tomb.loot(4);	
			}
		}
	}

}
