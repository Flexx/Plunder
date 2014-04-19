package scripts.plunder.actions;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Camera;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.NPCChat;
import org.tribot.api2007.NPCs;
import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSInterface;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSNPC;
import org.tribot.api2007.types.RSObject;

import scripts.plunder.resources.Areas;
import scripts.plunder.resources.Data;
import scripts.plunder.utilities.Conditions;
import scripts.plunder.utilities.Methods;
import scripts.plunder.utilities.Waiting;

public class Sceptre {

	public static void teleport(){
		RSInterface teleport = Interfaces.get(232,0);
		if(Banking.isBankScreenOpen()){
			Banking.close();
		}else{
			if(teleport == null){
				selectOption();
			}else{
				chooseOption();
			}
		}
	}

	public static void handleChat(){
		RSInterface select = Interfaces.get(232, 0);
		RSInterface gold = Interfaces.get(232, 1);
		RSInterface stone = Interfaces.get(232, 2);

		if(NPCChat.getClickContinueInterface() != null){
			NPCChat.clickContinue(true);
		}

		if(Inventory.getCount(Data.stone) != 0){
			if(select != null){
				if(stone != null){
					stone.click();
					General.sleep(500,700);
				}
			}
		}

	}

	public static void recharge(){
		RSNPC[] mummy = NPCs.findNearest("Guardian mummy");
		if(NPCChat.getName() != null){
			handleChat();
		}else{
			if(Interfaces.get(232, 0) != null){
				handleChat();
			}else{
				Methods.clickNPC(mummy, false);
				Waiting.waitMovement();
				Timing.waitCondition(new Condition() {
					@Override
					public boolean active() {
						return NPCChat.getName() != null;
					}
				}, General.random(1000, 1500));
			}
		}
	}

	public static void chooseOption(){
		RSInterface teleport = Interfaces.get(232, 0);
		RSInterface pyramid = Interfaces.get(232, 1);
		if(teleport != null){
			pyramid.click();
			Timing.waitCondition(new Condition() {
				@Override
				public boolean active() {
					return Conditions.atPyramid();
				}
			}, General.random(5000, 6000));
		}
	}

	public static void selectOption(){
		if(Inventory.getCount(Data.sceptre) != 0){
			RSItem[] sceptre = Inventory.find(Data.sceptre);
			Methods.useItem(sceptre, "Teleport");
			Timing.waitCondition(new Condition() {
				@Override
				public boolean active() {
					return Interfaces.get(232, 0) != null;
				}
			}, General.random(1000, 1500));
		}
	}
}
