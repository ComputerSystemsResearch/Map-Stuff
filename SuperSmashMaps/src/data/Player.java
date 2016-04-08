package data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends GameObject{
	
	private int width = 20, height = 40;
	private int gravity = 1;
	private final int MAX_SPEED = 8;
	
	public Player(int x, int y, ObjectID id) {
		super(x, y, id);

	}

	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}

	public void tick() {
		x+=velX;
		y+=velY;
		
		if(falling || jumping)
		{
			velY+=gravity;
			
			if(velY >= MAX_SPEED)
				velY = MAX_SPEED;
		}
		
	}
	

}
