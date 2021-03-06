package data;

import java.awt.Graphics;

public class World2 {

	private TileGrid grid;
	private Tile bg;
	private Tile mapTex;
	private Tile fiyah;
	private AudioPlayer gameMusic;
	
	public static final int WIDTH = 900, HEIGHT = 450; //Default

	public World2(TileGrid g)
	{
		grid = g;
		bg = new Tile(0, 0, WIDTH, HEIGHT, TileType.Background2);
		mapTex = new Tile(0, 0, WIDTH, HEIGHT+10, TileType.MapTex2);
		fiyah = new Tile(0, 350, WIDTH, HEIGHT-200, TileType.Fire);
		gameMusic = new AudioPlayer("res/gameMusic.wav");
		if(MainMenu.musicOn == true)
			gameMusic.play();
	}
	
	public void update(Graphics g)
	{
		drawTile(g, bg);
		drawTile(g, fiyah);
		drawMap(g, grid);
		drawTile(g, mapTex);
		
	}
	
	public void drawMap(Graphics g, TileGrid t)
	{
		for(int i = 0; i<t.getMap().length; i++){
			for(int j = 0; j<t.getMap()[i].length; j++){
				Tile a = t.getMap()[i][j];
				g.drawImage(a.getImage(), a.getX(), a.getY(), a.getWidth(), a.getHeight(), null);
			}
		}
	}
	public void drawTile(Graphics g, Tile t)
	{
		g.drawImage(t.getImage(),t.getX(), t.getY(), t.getWidth(), t.getHeight(), null);
	}
}
