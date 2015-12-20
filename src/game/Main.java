package game;

import engine.Display;
import engine.Entity;
import game.entities.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
	public static Player player = new Player(); 
	
	public Main() {
		GlobalVars.display = new Display("Version 0.1", 640, 480, false);
		
		init();
		loop();
	}
	
	public void init() {
		GlobalVars.entities.add(player); //Player should always be 0th entity
	}
	
	public void loop() {
		long lastLoopTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
		
		while(true) {
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			double delta = updateLength / ((double) OPTIMAL_TIME);
			
			update(delta);
			GlobalVars.display.repaint();
			
			try {
				Thread.sleep((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update(double delta) {
		//DELTA-DETERMINED
		for(Entity e : GlobalVars.entities) {
			e.move(delta);
		}
		
		//NOT DELTA-DETERMINED
		GlobalVars.display.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent k) {
				if(!GlobalVars.keys.contains(k.getKeyCode())) {
					GlobalVars.keys.add(k.getKeyCode());
				}
			}

			@Override
			public void keyReleased(KeyEvent k) {
				if(GlobalVars.keys.contains(k.getKeyCode())) {
					GlobalVars.keys.remove((Object) k.getKeyCode());
				}
			}

			@Override
			public void keyTyped(KeyEvent k) {
				
			}
		});
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
