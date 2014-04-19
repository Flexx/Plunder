package scripts.plunder.resources;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import org.tribot.api2007.Skills;

import scripts.plunder.utilities.Methods;

public class Data {

	public static int[] sceptre = {9044, 9046,9048,9050};
	public static int[] deadSceptreIDs = {9048,9050};
	public static int lobs = 379;
	public static int[] ringIDs = {2552, 2554, 2556,2558,2560,2562,2564,2566};
	public static int[] antipoison = {175,177,179};
	public static int[] doorIDs = {21281,21282,21283,21284};
	
	public static int[] roomOneUrnIDs = {21264,21269,21259,21268,21259,
		21260,21255,21256, 21265, 21263,21267,21262,21257,21266};
	public static int[] roomOneDoorIDs = {21277,21280,21279,21278};
	
	public static int[] roomTwoUrnIDs = {21256,21265,21269,21260,21255,
		21266,21264,21268,21262,21263,21259,21258,21267};
	public static int[] roomTwoDoorIDs = {21277,21279,21280,21278};
	
	public static int[] roomThreeUrnIDs = {21266,21268, 21262,21255,21259,21258,
		21269,21265,21261,21256,21260,21264,21258,21267};
	public static int[] roomThreeDoorIDs = {21279,21278,21277,21280};
	
	public static int[] roomFourUrnIDs = {21259, 21265,21261,21266,21260,21264,21269,
		21257,21262,21267,21258,21263,21268};
	
	public static int[] gold = {9040, 9028,9036};
	public static int[] stone = {9042,9030,9038};
	public static int vialID = 229;
	
	public static int[] exitDoorIDs = {13438};
	
	public final static int startXP = Skills.SKILLS.THIEVING.getXP();
	public final static int startLevel = Skills.SKILLS.THIEVING.getXP();
	public final static long timeBegan = System.currentTimeMillis();


	public static boolean run;
	public static boolean door1 = true;
	public static boolean door2 = true;
	public static boolean door3 = true;
	public static boolean door4 = true;

	public static boolean roomOneDoor1 = true;
	public static boolean roomOneDoor2 = true;
	public static boolean roomOneDoor3 = true;
	public static boolean roomOneDoor4 = true;
	
	public static boolean roomTwoDoor1 = true;
	public static boolean roomTwoDoor2 = true;
	public static boolean roomTwoDoor3 = true;
	public static boolean roomTwoDoor4 = true;
	
	public static boolean roomThreeDoor1 = true;
	public static boolean roomThreeDoor2 = true;
	public static boolean roomThreeDoor3 = true;
	public static boolean roomThreeDoor4 = true;

	public static Color green1 = new Color(9, 80, 0);
	public static Color green2 = new Color(9, 73, 1);
	public static Color green3 = new Color(0, 255, 0);

	public static Color color1 = new Color(255, 255, 255);
	public static Color color2 = new Color(0, 0, 0, 135);
	public static Color color3 = new Color(0, 0, 0);
	public static Color color4 = new Color(0, 204, 0);

	public static BasicStroke stroke1 = new BasicStroke(1);

	public static Font font1 = new Font("Eras Demi ITC", 1, 27);
	public static Font font2 = new Font("Vani", 0, 13);

	public static Image img1 = Methods.getImage("http://images2.wikia.nocookie.net/__cb20101203185730/runescape/images/thumb/e/ef/Guardian_mummy.png/258px-Guardian_mummy.png");

}
