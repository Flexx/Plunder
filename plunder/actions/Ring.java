package scripts.plunder.actions;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Equipment;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Equipment.SLOTS;
import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSInterface;
import org.tribot.api2007.types.RSItem;

import scripts.plunder.resources.Areas;
import scripts.plunder.resources.Data;
import scripts.plunder.utilities.Conditions;
import scripts.plunder.utilities.Methods;
import scripts.plunder.utilities.Waiting;

public class Ring {

	public static void teleport(){
		if(canTele()){
			if(selectLocationUp()){
				chooseOption();
			}else{
				operateRing();
			}
		}else{
			if(Banking.isBankScreenOpen()){
				Banking.close();
			}else{
				GameTab.open(TABS.EQUIPMENT);
				if(!Equipment.isEquipped(Data.ringIDs)){
					Methods.stopScript("No ring equipped");
				}
			}
		}
	}

	public static void chooseOption(){
		RSInterface bankOption = Interfaces.get(230,2);
		if(bankOption != null){
			if(bankOption.click()){
				Timing.waitCondition(new Condition() {
					@Override
					public boolean active() {
						return Conditions.atArea(Areas.castlewars);
					}
				}, General.random(4500, 6000));
			}
		}
	}

	public static void equip(){
		RSItem[] ring = Inventory.find(Data.ringIDs);
		if(Banking.isBankScreenOpen()){
			Banking.close();
		}else{
			Methods.useItem(ring, "Wear");
			Timing.waitCondition(new Condition() {
				@Override
				public boolean active() {
					return Conditions.hasRing();
				}
			}, General.random(1000, 1500));
		}
	}

	public static boolean selectLocationUp(){
		return Interfaces.get(230,0) != null;
	}

	public static boolean canTele(){
		return GameTab.getOpen() == TABS.EQUIPMENT && Equipment.isEquipped(Data.ringIDs);
	}

	public static void operateRing(){
		RSItem[] ring = Equipment.find(SLOTS.RING);
		Methods.useItem(ring, "Operate");
		Timing.waitCondition(new Condition() {
			@Override
			public boolean active() {
				return Interfaces.get(230,0) != null;
			}
		}, General.random(1500, 2000));
	}
}
