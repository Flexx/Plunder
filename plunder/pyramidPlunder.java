package scripts.plunder;

import java.awt.*;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.input.Mouse;
import org.tribot.api2007.Camera;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Login;
import org.tribot.api2007.Player;
import org.tribot.api2007.Skills;
import org.tribot.api2007.Walking;
import org.tribot.api2007.Skills.SKILLS;
import org.tribot.api2007.types.RSArea;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.MessageListening07;
import org.tribot.script.interfaces.Painting;

import scripts.plunder.actions.Bank;
import scripts.plunder.actions.Food;
import scripts.plunder.actions.Lobby;
import scripts.plunder.actions.Pyramid;
import scripts.plunder.actions.Ring;
import scripts.plunder.actions.Sceptre;
import scripts.plunder.actions.Tomb;
import scripts.plunder.actions.TombSolver;
import scripts.plunder.resources.Areas;
import scripts.plunder.resources.Data;
import scripts.plunder.utilities.Conditions;
import scripts.plunder.utilities.Methods;

@ScriptManifest(authors = {"Flexx"}, version = 1.0, category = "Thieving", name = "Pyramid Plunder", description = "Plunders!")
public class pyramidPlunder extends Script implements Painting, MessageListening07 {

	private boolean onStart(){
		Data.run = true;
		Mouse.setSpeed(General.random(127, 134));
		Camera.setCameraAngle(100);
		Walking.setWalkingTimeout(General.random(2000,4000));
		return true;
	}

	@Override
	public void run() {
		if(onStart()){
			while(Data.run){
				if(Conditions.atPyramid()){
					if(Skills.SKILLS.HITPOINTS.getCurrentLevel() <= Skills.SKILLS.HITPOINTS.getActualLevel() / 2 + 2){
						Food.eat();
					}else{
						if(Conditions.isPoisoned()){
							Food.drinkAnti();
						}else{
							if(Conditions.canPlunder()){
								if(Lobby.isMummy()){
									if(Conditions.needStaffRefresh()){
										Sceptre.recharge();
									}else{
										Lobby.interactMummy();
									}
								}else{
									Lobby.exit();
								}
							}else{
								Ring.teleport();
							}
						}
					}
				}

				if(Conditions.atArea(Areas.town)){
					if(Skills.SKILLS.HITPOINTS.getCurrentLevel() <= Skills.SKILLS.HITPOINTS.getActualLevel() / 2 + 2){
						Food.eat();
					}else{
						if(Conditions.isPoisoned()){
							Food.drinkAnti();
						}else{
							if(Conditions.canPlunder()){
								Pyramid.enter();
							}else{
								Ring.teleport();
							}
						}
					}
				}

				if(Conditions.atArea(Areas.castlewars)){
					if(!Conditions.hasRing()){
						if(Inventory.getCount(Data.ringIDs) == 0){
							Bank.doBank();
						}else{
							Ring.equip();
						}
					}else{
						if(Conditions.needStaffRefresh()){
							if(Conditions.readyToResetStaff()){
								Sceptre.teleport();
							}else{
								Bank.doBank();
							}
						}else{
							if(Conditions.readyToTele()){
								Sceptre.teleport();
							}else{
								Bank.doBank();
							}
						}
					}
				}

				if(Conditions.atTomb() && !Conditions.atArea(Areas.castlewars)){
					if(!Conditions.canPlunder()){
						Ring.teleport();
					}else{
						if(Skills.SKILLS.HITPOINTS.getCurrentLevel() <= Skills.SKILLS.HITPOINTS.getActualLevel() / 2 - 1){
							Food.eat();
						}else{
							if(Conditions.isPoisoned()){
								Food.drinkAnti();
							}else{
								TombSolver.completeRoom();
							}
						}
					}
				}
			}
		}
	}

	public void onPaint(Graphics g1) {
		long time = System.currentTimeMillis() - Data.timeBegan;
		int xpGained = Skills.SKILLS.THIEVING.getXP() - Data.startXP;
		int xpPerHour = (int) ((xpGained) / ((System.currentTimeMillis() - Data.timeBegan) / 3600000.0D));
		int currLevel = Skills.SKILLS.THIEVING.getActualLevel();
		int gained = currLevel - Data.startLevel;

		Graphics2D g = (Graphics2D)g1;
		g.setFont(Data.font1);
		g.setColor(Data.color1);
		g.drawString("fPlunder", 17, 366);
		g.setColor(Data.color2);
		g.fillRect(11, 373, 293, 81);
		g.setColor(Data.color3);
		g.setStroke(Data.stroke1);
		g.drawRect(11, 373, 293, 81);
		g.setFont(Data.font2);
		g.setColor(Data.color4);
		g.drawString("Time ran: " + Timing.msToString(time), 17, 388);
		g.drawString("XP gained: " + xpGained, 17, 405);
		g.drawString("XP /h: " + xpPerHour, 16, 422);
	}


	@Override
	public void clanMessageReceived(String arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void personalMessageReceived(String arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void playerMessageReceived(String arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void serverMessageReceived(String arg0) {
		if(arg0.contains("already") || arg0.contains("This door")){
			Tomb.markDoor();
		}
	}

	@Override
	public void tradeRequestReceived(String arg0) {
		// TODO Auto-generated method stub

	}


}