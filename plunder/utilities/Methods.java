package scripts.plunder.utilities;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.input.Keyboard;
import org.tribot.api.input.Mouse;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Banking;
import org.tribot.api2007.ChooseOption;
import org.tribot.api2007.Game;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.Skills;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSInterface;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSNPC;
import org.tribot.api2007.types.RSObject;

import scripts.plunder.resources.Data;

public class Methods {

	public static void clickObject(RSObject[] a, boolean right){
		if(a.length > 0){
			if(a[0].isOnScreen()){
				if(right){
					a[0].hover();
					Mouse.click(3);
				}else{
					Clicking.click(a[0]);
				}
			}else{
				Walking.blindWalkTo(a[0].getPosition());
			}
		}
	}

	public static void clickNPC(RSNPC[] a, boolean right){
		if(a.length > 0){
			if(a[0].isOnScreen()){
				if(right){
					a[0].hover();
					Mouse.click(3);
				}else{
					Clicking.click(a[0]);
				}
			}else{
				Walking.blindWalkTo(a[0].getPosition());
			}
		}
	}

	public static void withdraw(final RSItem[] a, boolean b, int c){
		if(a.length > 0){
			if(!b){
				a[0].click("Withdraw-All");
				Timing.waitCondition(new Condition() {
					@Override
					public boolean active() {
						return Inventory.getCount(a[0].getID()) > 0;
					}
				}, General.random(1000, 1200));
			}else{
				a[0].click("Withdraw-X");
				General.sleep(700,900);
				Keyboard.typeSend(Integer.toString(c));
				Timing.waitCondition(new Condition() {
					@Override
					public boolean active() {
						return Inventory.getCount(a[0].getID()) > 0;
					}
				}, General.random(1000, 1200));
			}
		}
	}
	
	public static  Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch(IOException e) {
            return null;
        }
    }

	public static void resetDoors(){
		Data.door2 = true;
		Data.door3 = true;
		Data.door4 = true;
		Data.door1 = true;
		
		Data.roomOneDoor1 = true;
		Data.roomOneDoor2 = true;
		Data.roomOneDoor3 = true;
		Data.roomOneDoor4 = true;
		
		Data.roomTwoDoor1 = true;
		Data.roomTwoDoor2 = true;
		Data.roomTwoDoor3 = true;
		Data.roomTwoDoor4 = true;
		
		Data.roomThreeDoor1 = true;
		Data.roomThreeDoor2 = true;
		Data.roomThreeDoor3 = true;
		Data.roomThreeDoor4 = true;
		
	}

	public static void stopScript(String a){
		General.println(a);
		Data.run = false;
	}

	public static void useItem(RSItem[] a, String text){
		if(a.length > 0){
			a[0].click(text);
		}
	}
}
