package data;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class MainMenu {
	
	public static final int WIDTH = 900, HEIGHT = 450; //Default

	private Image menuBG;
	private Image okay;
	public MainMenu()
	{
		this.menuBG = new ImageIcon(getClass().getClassLoader().getResource("res/menuBG.png")).getImage();
		this.okay = new ImageIcon(getClass().getClassLoader().getResource("res/okay.gif")).getImage();
	}
	public void update(Graphics g) 
	{
		g.drawImage(menuBG, 0, 0, WIDTH, HEIGHT, null);	
		g.drawImage(okay, 30, 140, 200, 200, null);	
	}

}
