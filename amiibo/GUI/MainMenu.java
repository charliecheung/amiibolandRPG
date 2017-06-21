package amiibo.GUI;
import data.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public class MainMenu extends JFrame implements KeyListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7763091029093426955L;
	int menuSelected = 0;
	boolean isPaused = false;
	JLabel currentIMG = new JLabel(new ImageIcon("src/resources/UI/Main menu/Continue.png"));
	String version = "0.3 Alpha";
	SavedData savedData;
	PlaySound toggle = new PlaySound();
	PlaySound music = new PlaySound();
	PlaySound select = new PlaySound();
	
	
	public void initializeMenu() throws InterruptedException, MalformedURLException 
	{	

		savedData = new SavedData();
		setResizable(false);
		setTitle("Amiibo Land: Version " + version);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//Set default close operation
		addKeyListener(this);    
		add(currentIMG);
		pack();
		setVisible(true);
		
		toggle.menuToggle();
		select.gameSelected();
		music.setSong("Shake It Off");
	}
	
	public void startNewGame() throws FileNotFoundException, UnsupportedEncodingException
	{
		NewGame newGame = new NewGame(savedData, music);
		dispose();
	}
	
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
		if ((key == KeyEvent.VK_UP || key == KeyEvent.VK_W) && (isPaused == false))
		{
			changeSelection(-1);
			toggle.playSound();
		}	
		
		else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S)
		{
			changeSelection(1);
			toggle.playSound();
		}	
	}
	
	public void changeSelection(int increment)
	{
		menuSelected = menuSelected + increment;
		
		if (menuSelected > 2)
		{
			menuSelected = 0;
		}
		
		else if (menuSelected < 0)
		{
			menuSelected = 2;
		}

		if (menuSelected == 0)
		{
			remove(currentIMG);
			currentIMG = new JLabel(new ImageIcon("src/resources/UI/Main menu/Continue.png"));
			add(currentIMG);
            revalidate();
			repaint();
		}
		
		else if (menuSelected == 1)
		{
			remove(currentIMG);
			currentIMG = new JLabel(new ImageIcon("src/resources/UI/Main menu/New Game.png"));
			add(currentIMG);
            revalidate();
			repaint();
		}
		
		else if (menuSelected == 2)
		{
			remove(currentIMG);
			currentIMG = new JLabel(new ImageIcon("src/resources/UI/Main menu/Quit.png"));
			add(currentIMG);
            revalidate();
			repaint();
		}
	}
	
	
	public void keyReleased(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
		if (((key == KeyEvent.VK_ENTER) || (key == KeyEvent.VK_SPACE)) && (menuSelected == 0))
		{
			select.playSound();
			music.stopSound();
			dispose();
			//Load Game
			savedData.loadGame();
			try {
				@SuppressWarnings("unused")
				AmiiboLandGameFrame game = new AmiiboLandGameFrame(savedData, savedData.savedGameFile[1]);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (((key == KeyEvent.VK_ENTER) || (key == KeyEvent.VK_SPACE)) && (menuSelected == 1))
		{
			select.playSound();
			//Create New Save Game
			try {
				startNewGame();
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (((key == KeyEvent.VK_ENTER) || (key == KeyEvent.VK_SPACE)) && (menuSelected == 2))
		{
			setVisible(false);
			dispose();
			System.exit(0);
		}		
	}
	
	public void keyTyped(KeyEvent e) 
	{
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		repaint();
	}
}
