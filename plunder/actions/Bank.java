package scripts.plunder.actions;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Banking;
import org.tribot.api2007.ChooseOption;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSObject;

import scripts.plunder.resources.Data;
import scripts.plunder.utilities.Conditions;
import scripts.plunder.utilities.Waiting;
import scripts.plunder.utilities.Methods;

public class Bank {

	public static void doBank(){
		if(Banking.isBankScreenOpen()){
			if(Conditions.needStaffRefresh()){
				if(Conditions.hasRing()){
					resupply(true);
				}else{
					withdrawRing();
				}
			}else{
				if(Conditions.hasRing()){
					resupply(false);
				}else{
					withdrawRing();
				}
			}
		}else{
			clickBank();
		}
	}

	public static void withdrawRing(){
		RSItem[] ring = Banking.find(2552);
		if(Inventory.getCount(Data.ringIDs) != 0){
			Banking.close();
		}
		Banking.depositAllExcept(Data.sceptre);
		if(Conditions.bankItemValid(ring)){
			Methods.withdraw(ring, true, 1);
		}else{
			Methods.stopScript("Out of rings");
		}
	}

	public static void resupply(boolean a){
		RSItem[] lobs = Banking.find(Data.lobs);
		RSItem[] anti = Banking.find(Data.antipoison);
		Banking.depositAllExcept(9046,9048,9044, 9040, Data.lobs, 175);
		if(!a){
			if(Conditions.bankItemValid(lobs)){
				int i = Inventory.getCount(Data.lobs);
				Methods.withdraw(lobs, true, 20 - i);
			}else{
				Methods.stopScript("Out of lobs");
			}

			if(Conditions.bankItemValid(anti)){
				int i = Inventory.getCount(Data.antipoison);
				Methods.withdraw(anti, true, 6 - i);
			}else{
				Methods.stopScript("No antipoisons");
			}
		}else{
			staffBank();
		}
	}

	public static void staffBank(){
		RSItem[] stone = Banking.find(Data.stone);
		RSItem[] lobs = Banking.find(Data.lobs);
		RSItem[] anti = Banking.find(Data.antipoison);
		
		if(Inventory.getCount(Data.stone) == 12 && Inventory.getCount(Data.antipoison) == 5 && Inventory.getCount(Data.lobs) == 9){
			Banking.close();
		}else{
			Banking.depositAllExcept(Data.sceptre);
		}

		if(Inventory.getCount(Data.stone) == 0){
			if(Conditions.bankItemValid(stone)){
				if(stone[0].getStack() >= 6){
					Methods.withdraw(stone, true, 12);
				}else{
					if(stone[0].getStack() < 6){
						Methods.stopScript("Out of ornaments");
					}
				}
			}
		}

		if(Inventory.getCount(Data.lobs) != 9){
			if(Conditions.bankItemValid(lobs)){
				int i = Inventory.getCount(Data.antipoison);
				Methods.withdraw(lobs, true, 9 - i);
			}else{
				Methods.stopScript("No lobs");
			}
		}

		if(Inventory.getCount(Data.antipoison) != 5){
			if(Conditions.bankItemValid(anti)){
				int i = Inventory.getCount(Data.antipoison);
				Methods.withdraw(anti, true, 5 - i);
			}else{
				Methods.stopScript("No anti-p");
			}
		}
	}

	public static void clickBank(){
		RSObject[] bank = Objects.findNearest(20, "Bank chest");
		if(ChooseOption.isOpen()){
			if(ChooseOption.isOptionValid("Use")){
				ChooseOption.select("Use");
				Waiting.waitMovement();
				Timing.waitCondition(new Condition() {
					@Override
					public boolean active() {
						return Banking.isBankScreenOpen();
					}
				}, General.random(2000, 2500));

			}else{
				ChooseOption.close();
			}
		}else{
			Methods.clickObject(bank, true);
		}
	}
}
