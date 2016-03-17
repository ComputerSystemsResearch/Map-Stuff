package data;

public enum TileType {

	Primary("res/primaryTile.png", true), Secondary("res/secondaryTile.png", false), Background("res/bg.gif", true), Transparent("res/transparent.png", true), Ship("res/spaceship.png", false);
	
	String textureName;
	boolean passable;
	
	TileType(String textureName, boolean passable){
		this.textureName = textureName;
		this.passable = passable;
	}
}
