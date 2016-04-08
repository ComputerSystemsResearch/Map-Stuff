package data;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected int x, y;
	protected int velX = 0, velY = 0;
	protected ObjectID id;
	protected boolean falling = true;
	protected boolean jumping = false;
	
	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public GameObject(int x, int y, ObjectID id)
	{
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void render(Graphics g);
	public abstract void tick();
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int getVelX() {
		return velX;
	}
	public int getVelY() {
		return velY;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public  ObjectID getID() {
		return id;
	}
}
