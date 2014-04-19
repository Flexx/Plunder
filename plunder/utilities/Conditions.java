package scripts.plunder.utilities;

import org.tribot.api.Screen;
import org.tribot.api2007.ChooseOption;
import org.tribot.api2007.Equipment;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.Skills;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSTile;

import scripts.plunder.resources.Areas;
import scripts.plunder.resources.Data;

public class Conditions {
	
	public static boolean optionValid(String option){
		return ChooseOption.isOpen() && ChooseOption.isOptionValid(option);
	}
	
	public static boolean atArea(RSArea a){
		return a.contains(Player.getPosition());
	}
	
	public static boolean canPlunder(){
		return Inventory.getCount(Data.lobs) != 0 && Inventory.getCount(Data.antipoison) != 0 && Inventory.getCount(Data.sceptre) != 0;
	}
	
	public static boolean needStaffRefresh(){
		if(Conditions.atPyramid()){
			if(Inventory.getCount(9050) > 0){
				return true;
			}
		}
		
		if(Conditions.atArea(Areas.castlewars)){
			if(Inventory.getCount(9048) > 0){
				return true;
			}
		}
		return false;
	}
	
	public static boolean nearTile(RSTile a, int b){
		return Player.getPosition().distanceTo(a) <= b;
	}
	
	public static boolean hasRing(){
		return Equipment.isEquipped(Data.ringIDs);
	}
	
	public static boolean timeToHop(){
		return Screen.getColourAt(405,289).equals(Data.green3);
	}
	
	public static boolean atPyramid(){
		return Player.getPosition().getPlane() != 0;
	}
	
	public static boolean isPoisoned(){
		return Screen.getColourAt(554,69).equals(Data.green1) && Screen.getColourAt(561,67).equals(Data.green2);
	}
	
	public static boolean atTomb(){
		return Player.getPosition().getPlane() == 0 && !atArea(Areas.town);
	}
	
	public static boolean lessThanLevel(int a){
		return Skills.SKILLS.THIEVING.getCurrentLevel() < a;
	}
	
	public static boolean bankItemValid(RSItem[] a){
		return a.length != 0;
	}
	
	public static boolean greaterThanLevel(int a){
		return Skills.SKILLS.THIEVING.getCurrentLevel() >= a;
	}
	
	public static boolean readyToTele(){
		return Inventory.getCount(Data.lobs) > 1 && Inventory.getCount(Data.antipoison) > 0 && Inventory.getCount(Data.sceptre) > 0;
	}
	
	public static boolean readyToResetStaff(){
		return Inventory.getCount(Data.stone) == 12 && Inventory.getCount(Data.lobs) == 9 && Inventory.getCount(Data.antipoison) == 5;
	}
	
}
