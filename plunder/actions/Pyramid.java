package scripts.plunder.actions;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.ChooseOption;
import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSObject;

import scripts.plunder.resources.Areas;
import scripts.plunder.resources.Data;
import scripts.plunder.utilities.Conditions;
import scripts.plunder.utilities.Methods;
import scripts.plunder.utilities.Waiting;
import scripts.plunder.resources.Tiles;

public class Pyramid {

	public static void enter(){
		if(ChooseOption.isOpen()){
			if(ChooseOption.isOptionValid("Search")){
				chooseOption();
			}else{
				ChooseOption.close();
			}
		}else{
			clickDoor();
		}
	}

	public static void chooseDoor(){
		if(Data.door1 == true){
			Walking.blindWalkTo(Tiles.doorOneTile);
			Waiting.waitMovement();
			enter();
			return;
		}
		
		if(Data.door3 == true){
			Walking.blindWalkTo(Tiles.doorThreeTile);
			Waiting.waitMovement();
			enter();
			return;
		}

		if(Data.door2 == true){
			Walking.blindWalkTo(Tiles.doorTwoTile);
			Waiting.waitMovement();
			enter();
			return;
		}
		
		if(Data.door4 == true){
			Walking.blindWalkTo(Tiles.doorFourTile);
			Waiting.waitMovement();
			enter();
			return;
		}

		if(Data.door1 == false && Data.door2 == false && Data.door3 == false && Data.door4 == false){
			Methods.resetDoors();
		}
	}

	public static void chooseOption(){
		ChooseOption.select("Search");
		Waiting.waitMovement();
		Timing.waitCondition(new Condition() {
			@Override
			public boolean active() {
				return Conditions.atPyramid();
			}
		}, General.random(5000, 6000));
	}

	public static void markDoor(){
		if(Conditions.nearTile(Tiles.doorOneTile, 5)){
			Data.door1 = false;
		}

		if(Conditions.nearTile(Tiles.doorTwoTile, 5)){
			Data.door2 = false;
		}

		if(Conditions.nearTile(Tiles.doorThreeTile, 5)){
			Data.door3 = false;
		}

		if(Conditions.nearTile(Tiles.doorFourTile, 5)){
			Data.door4 = false;
		}
	}

	public static void clickDoor(){
		RSObject[] door = Objects.findNearest(30, Data.doorIDs);
		markDoor();
		Methods.clickObject(door, true);
		Timing.waitCondition(new Condition() {
			@Override
			public boolean active() {
				return ChooseOption.isOpen();
			}
		}, General.random(300, 500));
	}
}
