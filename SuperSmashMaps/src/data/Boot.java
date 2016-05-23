package data;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Boot extends Canvas implements Runnable{ //Main class for Running
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7669774831421332541L;
	public static final int WIDTH = 900, HEIGHT = 450; //Default
	
	private boolean running = false; //is Running?
	private Thread thread;
	
	MapRepository repo = new MapRepository();
	int[][] map1 = (int[][]) repo.getStorage().get(0);
	TileGrid m = new TileGrid(map1);
	//mapPixelXCoords = new int[]{150, 740, 740, 150};//Rahul - Map 2 X coords {150,740,740,150}
    //mapPixelYCoords = new int[]{300, 300, 450, 450};//Rahul - Map 2 Y coords {300, 300, 450, 450}
	//World world = new World(m);	
	Player playa = new Player(100, 100, ObjectID.Player);
	
	public synchronized void start(){
		if(running) //Safety precaution
			return;		
		running = true;
		this.addMouseListener(new MouseInput());
		thread = new Thread(this);	//Uses call in Window constructor to start thread
		thread.start();
	}
	
	public void run()	//game loop
	{
		long lastTime = System.nanoTime();
		double amountOfTicks = 25.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " UPDATES: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	//ticks = updates
	private void tick()
	{
		playa.tick();
	}
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();	//loads upto 3 buffers if time allows
		if(bs == null){									//only displays top buffer
			this.createBufferStrategy(2);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		//--------------Draw Here--------------\\
		g.setColor(Color.black);
		StateManager.update(g);
		//world.update(g);
		//drawTile(g, mapTex);
		g.setColor(Color.white);
		//--------------------------------------\\
		g.dispose();
		bs.show();
		
	}
	
	public static void main(String[] args)
	{
		new Window(WIDTH, HEIGHT, "Super Smash", new Boot()); //Calls Window constructor (sets up window and displays)
	}
}
