package data;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import data.StateManager.GameState;

public class MouseInput implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		//Main Menu
		if(StateManager.gameState == GameState.MAINMENU)
		{
			//Play
			if(mx>650 && mx<(650+167) && my>135 && my<(135+100))
			{
				if(MainMenu.sfxOn)
					MainMenu.sfx1.play();
				StateManager.game = null;
				StateManager.characterSelect = null;
				StateManager.gameState = GameState.CHARACTERSELECT;
			}
			//Settings
			if(mx>637 && mx<(637+200) && my>240 && my<(240+100))
			{
				if(MainMenu.sfxOn)
					MainMenu.sfx1.play();
				MainMenu.music.stop();
				MainMenu.music.close();
				StateManager.settings = null;
				StateManager.gameState = GameState.SETTINGS;
			}
			//Exit
			if(mx>650 && mx<(650+167) && my>345 && my<(345+100))
			{
				if(MainMenu.sfxOn)
					MainMenu.sfx1.play();
				StateManager.gameState = GameState.EXIT;
			}
		}
		//Settings
		else if(StateManager.gameState == GameState.SETTINGS)
		{
			//Music
			if(MainMenu.musicOn==true)
			{
				if(mx>585 && mx<685 && my>148 && my<245)
				{
					MainMenu.music.stop();
					MainMenu.music.close();
					MainMenu.musicOn = false;
				}
				
			}
			else
			{
				if(mx>585 && mx<685 && my>148 && my<245)
				{
					MainMenu.musicOn = true;
					MainMenu.music = new AudioPlayer("res/menuMusic.wav");
					MainMenu.music.play();					
				}
			}
			//SFX
			if(mx>585 && mx<685 && my>281 && my<378)
			{
				MainMenu.sfxOn = !MainMenu.sfxOn;
			}
			//Back
			if(mx>820 && mx<880 && my>15 && my<50)
			{
				if(MainMenu.sfxOn)
					MainMenu.sfx1.play();
				MainMenu.music.stop();
				MainMenu.music.close();
				MainMenu.music = new AudioPlayer("res/sciFi.wav");
				StateManager.gameState = GameState.MAINMENU;
				if(MainMenu.musicOn)
					MainMenu.music.play();
			}
		}
		
		else if(StateManager.gameState == GameState.CHARACTERSELECT)
		{
			if(CharacterSelect.playerOneChar == null)
			{
				if(mx>75 && mx<368 && my>100 && my<399)
				{	
					CharacterSelect.playerOneChar = "Mario";
				}
				else if(mx>520 && mx<815 && my>100 && my<399)
				{
					CharacterSelect.playerOneChar = "Luigi";
				}
			}
			else if(CharacterSelect.playerTwoChar == null)
			{
				if(mx>75 && mx<368 && my>100 && my<399)
				{	
					CharacterSelect.playerTwoChar = "Mario";
				}
				else if(mx>520 && mx<815 && my>100 && my<399)
				{
					CharacterSelect.playerTwoChar = "Luigi";
				}
			}
			else
			{
				if(mx>380 && mx <510 && my>400 && my<435)
				{
					if(MainMenu.sfxOn)
						MainMenu.sfx1.play();
					StateManager.mapSelect = null;
					StateManager.gameState = GameState.MAPSELECT;
					StateManager.characterSelect = null;
				}
			}
			if(mx>830 && mx<890 && my>400 && my<435)
			{
				if(MainMenu.sfxOn)
					MainMenu.sfx1.play();
				MainMenu.music.stop();
				MainMenu.music.close();
				MainMenu.music = new AudioPlayer("res/sciFi.wav");
				StateManager.gameState = GameState.MAINMENU;
				StateManager.characterSelect = null;
				CharacterSelect.playerTwoChar = null;
				CharacterSelect.playerOneChar = null;
				if(MainMenu.musicOn)
					MainMenu.music.play();
			}
		}
		
		else if(StateManager.gameState == GameState.MAPSELECT)
		{
			if(MapSelect.mapName == null)
			{
				if(mx>75 && mx<368 && my>100 && my<399)
				{	
					MapSelect.mapName = "Freefall";
				}
				else if(mx>520 && mx<815 && my>100 && my<399)
				{
					MapSelect.mapName = "Hellfire";
				}
			}
			else
			{
				if(mx>75 && mx<368 && my>100 && my<399)
				{	
					MapSelect.mapName = "Freefall";
				}
				else if(mx>520 && mx<815 && my>100 && my<399)
				{
					MapSelect.mapName = "Hellfire";
				}
				if(mx>380 && mx <510 && my>400 && my<435)
				{
					if(MainMenu.sfxOn)
						MainMenu.sfx1.play();
					MainMenu.music.stop();
					MainMenu.music.close();
					StateManager.mapSelect = null;
					StateManager.game = null;
					StateManager.game2 = null;
					if(MapSelect.mapName.equals("Freefall"))
						StateManager.gameState = GameState.GAME;
					else if (MapSelect.mapName.equals("Hellfire"))
						StateManager.gameState = GameState.GAME2;
					StateManager.characterSelect = null;
					StateManager.mapSelect = null;
					MapSelect.mapName = null;
				}
			}
			if(mx>830 && mx<890 && my>400 && my<435)
			{
				if(MainMenu.sfxOn)
					MainMenu.sfx1.play();
				StateManager.characterSelect = null;
				CharacterSelect.playerTwoChar = null;
				CharacterSelect.playerOneChar = null;
				StateManager.gameState = GameState.CHARACTERSELECT;
				MapSelect.mapName = null;
			}
		}

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
