package data;

import java.awt.Graphics;

public class StateManager {

	public static enum GameState
	{
		MAINMENU, GAME, SETTINGS, EXIT
	}
	
	public static GameState gameState = GameState.MAINMENU;
	public static MainMenu mainMenu;
	public static World game;
	public static Settings settings;
	
	public static void update(Graphics gee)
	{
		switch(gameState)
		{
		case MAINMENU:
			if (mainMenu == null)
				mainMenu = new MainMenu();
			mainMenu.update(gee);
			break;
		case GAME:
			
			break;
		case SETTINGS:
			
			break;
		case EXIT:
			System.exit(0);
			
			break;
		}
	}
}
