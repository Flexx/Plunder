package scripts.plunder.actions;

import org.tribot.api.General;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSItem;

import scripts.plunder.resources.Data;
import scripts.plunder.utilities.Methods;

public class Food {

	public static void eat(){
		RSItem[] lob = Inventory.find(Data.lobs);
		if(Player.getAnimation() == -1){
			Methods.useItem(lob, "Eat");
			General.sleep(600,1000);
		}
	}

	public static void drinkAnti(){
		RSItem[] anti = Inventory.find(Data.antipoison);
		if(Player.getAnimation() == -1){
			Methods.useItem(anti, "Drink");
			General.sleep(600,1000);
		}
	}
}
