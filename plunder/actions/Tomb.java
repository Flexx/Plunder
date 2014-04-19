package scripts.plunder.actions;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.input.Keyboard;
import org.tribot.api.input.Mouse;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.ChooseOption;
import org.tribot.api2007.Game;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.NPCs;
import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.Projection;
import org.tribot.api2007.Walking;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.types.RSInterface;
import org.tribot.api2007.types.RSNPC;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;

import scripts.plunder.resources.Areas;
import scripts.plunder.resources.Data;
import scripts.plunder.resources.Tiles;
import scripts.plunder.utilities.Conditions;
import scripts.plunder.utilities.Methods;
import scripts.plunder.utilities.Waiting;

public class Tomb {

	public static int getRoom(){
		RSInterface level = Interfaces.get(428, 1);
		if(level != null){
			if(level.getText().contains("Room 1")){
				return 1;
			}

			if(level.getText().contains("Room 2")){
				return 2;
			}

			if(level.getText().contains("Room 3")){
				return 3;
			}

			if(level.getText().contains("Room 4")){
				return 4;
			}

			if(level.getText().contains("Room 5")){
				return 5;
			}
		}
		return 0;
	}

	public static void hop(int a){
		if(a == 1){
			chooseDoor(1);
			General.sleep(800,1200);
			Timing.waitCondition(new Condition() {
				@Override
				public boolean active() {
					return Player.getAnimation() == -1;
				}
			}, General.random(1500, 2700));
		}

		if(a == 2){
			chooseDoor(2);
			General.sleep(800,1200);
			Timing.waitCondition(new Condition() {
				@Override
				public boolean active() {
					return Player.getAnimation() == -1;
				}
			}, General.random(1500, 2700));
		}
		
		if(a == 3){
			chooseDoor(3);
			General.sleep(800,1200);
			Timing.waitCondition(new Condition() {
				@Override
				public boolean active() {
					return Player.getAnimation() == -1;
				}
			}, General.random(1500, 2700));
		}

	}

	public static void markDoor(){
		if(Conditions.nearTile(Tiles.roomOneDoorOneTile, 2)){
			Data.roomOneDoor1 = false;
		}

		if(Conditions.nearTile(Tiles.roomOneDoorTwoTile, 2)){
			Data.roomOneDoor2 = false;
		}

		if(Conditions.nearTile(Tiles.roomOneDoorThreeTile, 2)){
			Data.roomOneDoor3 = false;
		}

		if(Conditions.nearTile(Tiles.roomOneDoorFourTile, 2)){
			Data.roomOneDoor4 = false;
		}

		if(Conditions.nearTile(Tiles.roomTwoDoorOneTile, 2)){
			Data.roomTwoDoor1 = false;
		}

		if(Conditions.nearTile(Tiles.roomTwoDoorTwoTile, 2)){
			Data.roomTwoDoor2 = false;
		}

		if(Conditions.nearTile(Tiles.roomTwoDoorThreeTile, 2)){
			Data.roomTwoDoor3 = false;
		}

		if(Conditions.nearTile(Tiles.roomTwoDoorFourTile, 2)){
			Data.roomTwoDoor4 = false;
		}
		
		if(Conditions.nearTile(Tiles.roomThreeDoorOneTile, 2)){
			Data.roomThreeDoor1 = false;
		}

		if(Conditions.nearTile(Tiles.roomThreeDoorTwoTile, 1)){
			Data.roomThreeDoor2 = false;
		}

		if(Conditions.nearTile(Tiles.roomThreeDoorThreeTile, 1)){
			Data.roomThreeDoor3 = false;
		}

		if(Conditions.nearTile(Tiles.roomThreeDoorFourTile, 2)){
			Data.roomThreeDoor4 = false;
		}
	}

	public static void chooseDoor(int a){
		if(a == 1){
			RSObject[] door = Objects.findNearest(15, Data.roomOneDoorIDs);
			if(Data.roomOneDoor1 == true){
				if(Player.getPosition().distanceTo(Tiles.roomOneDoorOneTile) != 0){
					Walking.walkTo(Tiles.roomOneDoorOneTile);
				}
				Waiting.waitMovement();
				clickDoor(findDoor(door));
				return;
			}

			if(Data.roomOneDoor2 == true){
				if(Player.getPosition().distanceTo(Tiles.roomOneDoorTwoTile) != 0){
					Walking.walkTo(Tiles.roomOneDoorTwoTile);
				}
				Waiting.waitMovement();
				clickDoor(findDoor(door));
				return;
			}

			if(Data.roomOneDoor3 == true){
				if(Player.getPosition().distanceTo(Tiles.roomOneDoorThreeTile) != 0){
					Walking.walkTo(Tiles.roomOneDoorThreeTile);
				}
				Waiting.waitMovement();
				clickDoor(findDoor(door));
				return;
			}

			if(Data.roomOneDoor4 == true){
				if(Player.getPosition().distanceTo(Tiles.roomOneDoorFourTile) != 0){
					Walking.walkTo(Tiles.roomOneDoorFourTile);
				}
				Waiting.waitMovement();
				clickDoor(findDoor(door));
				return;
			}

			if(Data.roomOneDoor1 == false && Data.roomOneDoor2 == false && Data.roomOneDoor3 == false && Data.roomOneDoor4 == false){
				Methods.resetDoors();
			}
		}

		if(a == 2){
			RSObject[] door = Objects.findNearest(15, Data.roomTwoDoorIDs);
			if(Data.roomTwoDoor1 == true){
				if(Player.getPosition().distanceTo(Tiles.roomTwoDoorOneTile) != 0){
					Walking.walkTo(Tiles.roomTwoDoorOneTile);
				}
				Waiting.waitMovement();
				clickDoor(findDoor(door));
				return;
			}

			if(Data.roomTwoDoor2 == true){
				if(Player.getPosition().distanceTo(Tiles.roomTwoDoorTwoTile) != 0){
					Walking.walkTo(Tiles.roomTwoDoorTwoTile);
				}
				Waiting.waitMovement();
				clickDoor(findDoor(door));
				return;
			}

			if(Data.roomTwoDoor3 == true){
				if(Player.getPosition().distanceTo(Tiles.roomTwoDoorThreeTile) != 0){
					Walking.walkTo(Tiles.roomTwoDoorThreeTile);
				}
				Waiting.waitMovement();
				clickDoor(findDoor(door));
				return;
			}

			if(Data.roomTwoDoor4 == true){
				if(Player.getPosition().distanceTo(Tiles.roomTwoDoorFourTile) != 0){
					Walking.walkTo(Tiles.roomTwoDoorFourTile);
				}
				Waiting.waitMovement();
				clickDoor(findDoor(door));
				return;
			}

			if(Data.roomTwoDoor1 == false && Data.roomTwoDoor2 == false && Data.roomTwoDoor3 == false && Data.roomTwoDoor4 == false){
				Methods.resetDoors();
			}
		}
		
		if(a == 3){
			RSObject[] door = Objects.findNearest(15, Data.roomThreeDoorIDs);
			if(Data.roomThreeDoor1 == true){
				if(Player.getPosition().distanceTo(Tiles.roomThreeDoorOneTile) != 0){
					Walking.walkTo(Tiles.roomThreeDoorOneTile);
				}
				Waiting.waitMovement();
				clickDoor(findDoor(door));
				return;
			}

			if(Data.roomThreeDoor2 == true){
				if(Player.getPosition().distanceTo(Tiles.roomThreeDoorTwoTile) != 0){
					Walking.walkTo(Tiles.roomThreeDoorTwoTile);
				}
				Waiting.waitMovement();
				clickDoor(findDoor(door));
				return;
			}

			if(Data.roomThreeDoor3 == true){
				General.println("HE");
				if(Player.getPosition().distanceTo(Tiles.roomThreeDoorThreeTile) != 0){
					Walking.walkTo(Tiles.roomThreeDoorThreeTile);
				}
				Waiting.waitMovement();
				clickDoor(findDoor(door));
				return;
			}

			if(Data.roomThreeDoor4 == true){
				if(Player.getPosition().distanceTo(Tiles.roomThreeDoorFourTile) != 0){
					Walking.walkTo(Tiles.roomThreeDoorFourTile);
				}
				Waiting.waitMovement();
				clickDoor(findDoor(door));
				return;
			}

			if(Data.roomThreeDoor1 == false && Data.roomThreeDoor2 == false && Data.roomThreeDoor3 == false && Data.roomThreeDoor4 == false){
				Methods.resetDoors();
			}
		}
	}

	public static void loot(int a){
		if(a == 1){
			RSObject[] urn = Objects.findNearest(15, Data.roomOneUrnIDs);
			lootUrn(findUrn(urn, Areas.roomOneLoot));
			Waiting.waitMovement();
		}

		if(a == 2){
			RSObject[] urn = Objects.findNearest(15, Data.roomTwoUrnIDs);
			lootUrn(findUrn(urn, Areas.roomTwoLoot));
			Waiting.waitMovement();
		}
		
		if(a == 3){
			RSObject[] urn = Objects.findNearest(15, Data.roomThreeUrnIDs);
			lootUrn(findUrn(urn, Areas.roomThreeLoot));
			Waiting.waitMovement();
		}
		
		if(a == 4){
			RSObject[] urn = Objects.findNearest(15, Data.roomFourUrnIDs);
			lootUrn(findUrn(urn, Areas.roomFourLoot));
			Waiting.waitMovement();
		}
	}

	public static void leave(){
		RSObject[] door = Objects.findNearest(15, Data.exitDoorIDs);
		RSInterface confirm = Interfaces.get(210, 1);
		RSInterface yes = Interfaces.get(228,1);
		if(confirm != null){
			confirm.click();
			Timing.waitCondition(new Condition() {
				@Override
				public boolean active() {
					return Interfaces.get(228,1) != null;
				}
			}, General.random(800, 900));
		}
		if(yes != null){
			yes.click();
			Timing.waitCondition(new Condition() {
				@Override
				public boolean active() {
					return Conditions.atArea(Areas.town);
				}
			}, General.random(5000, 6000));
		}
		if(confirm == null && yes == null){
			Methods.clickObject(door, false);
		}
	}

	public static RSObject findUrn(RSObject[] urn, RSArea area) {
		RSObject[] urns = Objects.sortByDistance(Player.getPosition(), urn);
		for (RSObject x : urns) {
			if (x.getModel() != null && x.getModel().getIndexCount() % 2 != 1 && area.contains(x.getPosition())){
				return x;
			}
		}
		return null;
	}

	public static void lootUrn(RSObject urn) {
		if (urn != null) {
			if(urn.isOnScreen()){
				urn.hover();
				Mouse.click(3);
				if(ChooseOption.isOpen()){
					if(ChooseOption.isOptionValid("Search Urn")){
						ChooseOption.select("Search Urn");
						General.sleep(100,400);
					}else{
						ChooseOption.close();
					}
				}
			}else{
				Walking.walkTo(urn.getPosition());
			}
		}else{
			Tomb.leave();
		}
	}

	public static RSObject findDoor(RSObject[] door) {
		RSObject[] urns = Objects.sortByDistance(Player.getPosition(), door);
		for (RSObject x : urns) {
			if(x.getModel() != null && x.getModel().getIndexCount() % 2 != 1){
				return x;
			}
		}
		return null;
	}

	public static void clickDoor(RSObject door) {
		if (door != null) {
			if(door.isOnScreen()){
				door.click();
			}else{
				Walking.walkTo(door.getPosition());
			}
		}else{
			Methods.resetDoors();
		}
	}

	public static void solveTrap(RSTile trapTile, final RSArea ax){
		RSObject[] trap = Objects.getAt(trapTile);
		if(ChooseOption.isOpen()){
			if(ChooseOption.isOptionValid("Pass")){
				ChooseOption.select("Pass");
				Timing.waitCondition(new Condition() {
					@Override
					public boolean active() {
						return ax.contains(Player.getPosition()) || Player.getAnimation() == 846;
					}
				}, General.random(9000, 10000));
				Waiting.waitMovement();
			}else{
				ChooseOption.close();
			}
		}else{
			Methods.clickObject(trap, true);
		}
	}

	public static void solve(int a){
		if(a == 1){
			solveTrap(Tiles.roomOneTrapTile, Areas.roomOneLoot);
		}

		if(a == 2){
			solveTrap(Tiles.roomTwoTrapTile, Areas.roomTwoLoot);
		}
		
		if(a == 3){
			solveTrap(Tiles.roomThreeTrapTile, Areas.roomThreeLoot);
		}
		
		if(a == 4){
			solveTrap(Tiles.roomFourTrapTile, Areas.roomFourLoot);
		}
	}
}
