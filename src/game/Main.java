package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import engine.Display;
import engine.Entity;
import game.entities.Player;

public class Main {
	Player player = new Player();
	
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
				 if(k.getKeyCode() == KeyEvent.VK_W) {
					 player.dy = player.MOVE_SPEED;
				 }
			}

			@Override
			public void keyReleased(KeyEvent k) {
				
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
