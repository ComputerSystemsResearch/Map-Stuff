package data;

import java.awt.Graphics;

public class StateManager {
	
	public static MapRepository repo = new MapRepository();
	public static int[][] map1 = (int[][]) repo.getStorage().get(0);
	public static TileGrid m = new TileGrid(map1);

	public static enum GameState
	{
		MAINMENU, GAME, SETTINGS, EXIT, CHARACTERSELECT, GAME2, MAPSELECT
	}
	
	public static GameState gameState = GameState.MAINMENU;
	public static MainMenu mainMenu;
	public static World game;
	public static Settings settings;
	public static CharacterSelect characterSelect;
	public static World2 game2;
	public static MapSelect mapSelect;
	
	public static void update(Graphics gee)
	{
		switch(gameState)
		{
		case MAINMENU:
			if (mainMenu == null)
				mainMenu = new MainMenu();
			mainMenu.update(gee);
			break;
		case CHARACTERSELECT:
			if(characterSelect == null)
				characterSelect = new CharacterSelect();
			characterSelect.update(gee);
			break;
		case GAME:
			if(game == null)
				game = new World(m);
			game.update(gee);
			break;
		case GAME2:
			if(game2 == null)
				game2 = new World2(m);
			game2.update(gee);
			break;
		case MAPSELECT:
			if(mapSelect == null)
				mapSelect = new MapSelect();
			mapSelect.update(gee);
			break;
		case SETTINGS:
			if(settings == null)
				settings = new Settings();
			settings.update(gee);
			break;
		case EXIT:
			System.exit(0);
			break;
		}
	}
}
