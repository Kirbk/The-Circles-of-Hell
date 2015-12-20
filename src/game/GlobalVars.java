package game;

import java.util.ArrayList;

import engine.Display;
import engine.Entity;

public class GlobalVars {
	public static Display display;
	
	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	public static ArrayList<Integer> keys = new ArrayList<Integer>();
	
	public static void clearEntities() {
		entities.clear();
		
		entities.add(Main.player);
	}
}
