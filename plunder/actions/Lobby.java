package scripts.plunder.actions;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.NPCChat;
import org.tribot.api2007.ChooseOption;
import org.tribot.api2007.NPCs;
import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSInterface;
import org.tribot.api2007.types.RSNPC;
import org.tribot.api2007.types.RSObject;

import scripts.plunder.resources.Areas;
import scripts.plunder.resources.Data;
import scripts.plunder.resources.Tiles;
import scripts.plunder.utilities.Conditions;
import scripts.plunder.utilities.Methods;
import scripts.plunder.utilities.Waiting;

public class Lobby {

	public static boolean isMummy(){
		return NPCs.findNearest("Guardian mummy").length != 0;
	}

	public static void interactMummy(){
		if(NPCChat.getName() != null){
			handleChat();
		}else{
			RSNPC[] mummy = NPCs.findNearest("Guardian mummy");
			if(ChooseOption.isOpen()){
				chooseOption();
			}else{
				Methods.clickNPC(mummy, true);
			}
		}
	}
	
	public static void chooseOption(){
		if(ChooseOption.isOptionValid("Start")){
			if(ChooseOption.select("Start")){
				Waiting.waitMovement();
				Timing.waitCondition(new Condition() {
					@Override
					public boolean active() {
						return NPCChat.getName() != null;
					}
				}, General.random(1200, 1800));
			}
		}else{
			ChooseOption.close();
		}
	}

	public static void handleChat(){
		if(NPCChat.getClickContinueInterface() != null){
			NPCChat.clickContinue(true);
		}

		if(Interfaces.get(230,0) != null){
			NPCChat.selectOption("I know", true);
			Timing.waitCondition(new Condition() {
				@Override
				public boolean active() {
					return Conditions.atArea(Areas.roomOneTrap);
				}
			}, General.random(2300, 2500));
		}
	}

	public static void selectOption(){
		ChooseOption.select("Leave");
	}

	public static void clickDoor(){
		RSObject[] door = Objects.findNearest(20, "Tomb Door");
		Methods.clickObject(door, true);
		Timing.waitCondition(new Condition() {
			@Override
			public boolean active() {
				return ChooseOption.isOpen();
			}
		}, General.random(600, 800));
	}

	public static void exit(){
		if(ChooseOption.isOpen()){
			if(ChooseOption.isOptionValid("Leave")){
				selectOption();
				Timing.waitCondition(new Condition() {
					@Override
					public boolean active() {
						return Conditions.atArea(Areas.town);
					}
				}, General.random(6000, 7000));
				if(Conditions.atArea(Areas.town)){
					Pyramid.chooseDoor();
				}
			}else{
				ChooseOption.close();
			}
		}else{
			clickDoor();
		}
	}
}
