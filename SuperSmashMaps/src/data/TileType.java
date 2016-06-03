package data;

public enum TileType {

	Primary("res/primaryTile.png", true), Secondary("res/secondaryTile.png", false), Background("res/bg.gif", true),
	Transparent("res/transparent.png", true), Impassable("res/transparent.png", false), Ship("res/spaceship.png", false), MapTex1("res/map 1.png", true), 
	Background2("res/map2BG.png", true), MapTex2("res/map2tex.png", false), Fire("res/flametest.gif", true), PBJT("res/pbjt.gif", true);
	
	String textureName;
	boolean passable;
	
	TileType(String textureName, boolean passable){
		this.textureName = textureName;
		this.passable = passable;
	}
}
