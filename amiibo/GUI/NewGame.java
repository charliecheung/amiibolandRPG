package amiibo.GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import data.*;

public class NewGame extends JFrame implements KeyListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int currentText = 0;
	int finalText = 10;
	JLabel text = new JLabel();
	JLabel background = new JLabel(new ImageIcon("src/resources/UI/Start Menu Selected/NewGame.png"));
	JLabel male = new JLabel(new ImageIcon("src/resources/UI/New Game/male.png"));
	JLabel female = new JLabel(new ImageIcon("src/resources/UI/New Game/female.png"));
	Font font = new Font("Roboto Condensed", Font.BOLD, 35);
	SavedData savedData;
	Dialogue temp;
	LinkedList textBox;
	int lines;
	PlaySound music;
	String name = "";
	String gender = "Male";
	boolean shift = false;
	boolean userTyping = false;
	boolean userGender = false;
	int genderSelection = 0;
    PlaySound toggle = new PlaySound();
    PlaySound selected = new PlaySound();
	
	public NewGame(SavedData savedData, PlaySound song) throws FileNotFoundException, UnsupportedEncodingException
	{
        toggle.menuToggle();
        selected.startMenuSelected();
		this.savedData = savedData;
		this.textBox = this.savedData.readDialogue("src/resources/dialogue/newGame/intro.txt");
		this.lines = textBox.getLength();
		this.temp = textBox.getHead();
		setResizable(false);												//Set to not be able to resize game
		setTitle("Amiibo Land");												//Display version number
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);						//Set default close operation
		background.setLayout(new BorderLayout());							//Set background image
		add(background);													//Add background image
		addKeyListener(this);												//Enable keyboard
		pack();																//Get frame size
		temp = textBox.getHead();											//Get first text
		printText();												//Print first text
		
		music = song;
	}
	
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();	
		
		if ((key == KeyEvent.VK_SHIFT))
		{
			shift = true;
			toggle.playSound();
		}
	}
	
	public void keyReleased(KeyEvent e) 
	{
		int key = e.getKeyCode();											//Get user input
			
		if (((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_SPACE) && (temp.text.equals("done") == false)) && (userTyping == false) && (userGender == false))			//If right or spacebar go next
		{
			try {
				chatDialogue();
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			toggle.playSound();
		}	
		
		else if ((((key >= KeyEvent.VK_A) && (key <= KeyEvent.VK_Z)) || ((key >= KeyEvent.VK_0) && (key <= KeyEvent.VK_9))) && (userTyping == true) && (userGender == false))
		{
			if (name.length() <= 15)
			{
				if ((key >= 65) && (shift == false))
				{
					//play sound
					char letter = (char) (key + 32);
					name = name + letter;
				}
				
				else
				{
					char letter = (char) key;
					name = name + letter;
				}

			}
			else
			{
				//play fail sound
			}
			printText();
		}
		
		else if ((key == KeyEvent.VK_SHIFT) && (userTyping == true) && (userGender == false))
		{
			shift = false;
			toggle.playSound();
		}
		
		else if ((key == KeyEvent.VK_BACK_SPACE) && (userTyping == true && (userGender == false)))
		{
			if (name.length() > 0)
			{
				name = name.substring(0, name.length() - 1);
			}
			else
			{
				//Play Fail sound
			}
			printText();
			toggle.playSound();
		}
		
		else if ((key == KeyEvent.VK_SPACE) && (userTyping == true) && (userGender == false))
		{
			if (name.length() <= 15)
			{
				name = name + " ";
			}
			else
			{
				//Play Fail sound
			}
			printText();
		}
		
		else if ((key == KeyEvent.VK_ENTER) && (userTyping == true) && (userGender == false) && (name.length() > 0))
		{
			userTyping = false;
			try {
				chatDialogue();
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			selected.playSound();
		}
		
		else if ((key == KeyEvent.VK_RIGHT) && (userGender == true))
		{
			genderSelection = 1;
			printText();
			toggle.playSound();
		}
		
		else if ((key == KeyEvent.VK_LEFT) && (userGender == true))
		{
			genderSelection = 0;
			printText();
			toggle.playSound();
		}
		
		else if ((key == KeyEvent.VK_ENTER) && (userGender == true))
		{
			userGender = false;
			if (genderSelection == 0)
			{
				gender = "Male";
			}
			else
			{
				gender = "Female";
			}
			userGender = false;
			try {
				chatDialogue();
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			selected.playSound();
		}
	}
	
	public void printText()
	{
		background.remove(text);
		
		if (userTyping == true)
		{
			text = new JLabel("<html>" + temp.text + "<br>" + name + "<html>");		//New dialogue box
		}
		
		else if (userGender == true)
		{
			if (genderSelection == 1)
			{
				text = new JLabel("<html>" + temp.text + "<br> Male  (Female)" + "  " + "<html>");							//New dialogue box
			}
			else
			{
				text = new JLabel("<html>" + temp.text + "<br>(Male) Female" + "  " + "<html>");							//New dialogue box
			}
		}
		
		else if ((temp.text.equals("Great NAME! Lets begin your journey!") && (userTyping == false)))
		{
			text = new JLabel("<html>" + temp.text.substring(0, 6) + name + temp.text.substring(10, temp.text.length()) + "<html>");							//New dialogue box
			System.out.println(text.getText() + "123");
		}

		else
		{
			text = new JLabel("<html>" + temp.text + "<br>" + "  " + "<html>");							//New dialogue box
		}
		
		text.setFont(font);										//Set font type
		text.setForeground(Color.WHITE);						//Set font color
		text.setLayout(null);									//Position text whereever I want
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setVerticalAlignment(JLabel.CENTER);
		background.add(text);
		setVisible(true);
	}
	
	public void chatDialogue() throws FileNotFoundException, UnsupportedEncodingException
	{
		background.remove(text);								//Clear prev text
		temp = temp.next;								//Next
		if (temp.text.equals("done"))						//Check if done
		{
			//Stop music
			music.stopSound();
			//Load Game
			savedData.newGame(name, gender);
			try {
				AmiiboLandGameFrame game = new AmiiboLandGameFrame(savedData, savedData.savedGameFile[1]);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose();
		}
		
		else if (temp.text.equals("What is your name?"))
		{
			userTyping = true;
			printText();
		}
		
		else if (temp.text.equals("And are you a boy or a girl?"))
		{
			userGender = true;
			printText();
		}
		
		else
		{
			printText();
		}
		System.out.println(temp.text);
	}
	
	public void keyTyped(KeyEvent e) 
	{
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
	}
}
