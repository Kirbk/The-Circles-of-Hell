package engine;

import game.GlobalVars;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public Display(String title, int width, int height, boolean fullscreen) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new Panel());
		setTitle(title);
		setSize(new Dimension(width, height));
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(fullscreen);
		setVisible(true);
	}
}

class Panel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(Entity e : GlobalVars.entities) {
			e.draw((Graphics2D) g);
		}
	}
	
	public Panel() {
		
	}
}
