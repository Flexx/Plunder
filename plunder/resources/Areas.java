package scripts.plunder.resources;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

public class Areas {

	public final static RSArea town = 
			new RSArea(new RSTile(3306, 2807, 0), new RSTile(3277, 2780, 0));
	
	public final static RSArea castlewars = 
			new RSArea(new RSTile(2446, 3099, 0), new RSTile(2436, 3078, 0));
	
	public final static RSArea room1 = 
			new RSArea(new RSTile(1920, 4477, 0), new RSTile(1934, 4462, 0));
	
	public final static RSArea roomOneLoot = 
			new RSArea(new RSTile(1923, 4471, 0), new RSTile(1932, 4463, 0));
	
	public final static RSArea roomOneTrap = 
			new RSArea(new RSTile(1925, 4477, 0), new RSTile(1928, 4472, 3));
	
	public final static RSArea roomTwoTrap = 
			new RSArea(new RSTile(1953, 4477, 0), new RSTile(1956, 4475, 3));
	
	public final static RSArea roomTwoLoot = 
			new RSArea(new RSTile(1945, 4472, 0), new RSTile(1959, 4464, 0));
	
	public final static RSArea roomThreeTrap = 
			new RSArea(new RSTile(1975, 4467, 0), new RSTile(1978, 4471, 0));
	
	public final static RSArea roomThreeLoot = 
			new RSArea(new RSTile(1979, 4464, 0), new RSTile(1969, 4454, 0));
	
	public final static RSArea roomFourTrap = 
			new RSArea(new RSTile(1925, 4452, 0), new RSTile(1929, 4453, 0));
	
	public final static RSArea roomFourLoot = 
			new RSArea(new RSTile(1932, 4448, 0), new RSTile(1942, 4458, 0));
}
