package amiibo.GUI;

import items.Inventory;
import items.Item;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;

import data.*;

/**
  * 
  * Last Updated: April 10th, 2014
  * This class contains the GUI component of MazeBoard. Handles all the GUI components of the game
  * Will paint the maze to the screen and paint the character to the maze depending on the player
  * movement choice, by looping through an array. 
  */
public class AmiiboLandGameMapGUI extends JPanel implements ActionListener, KeyListener
{    

    /**
	 * 
	 */
	static final long serialVersionUID = 1L;
	// Instance variables of the class.
    Image playerSprite;
	int code;
    int pixelSize = 32;
    String mapString;
    Image toDraw;
    private Image npcDraw;
    
    /*Important data*/
    AmiiboLandGameMap mapDraw = new AmiiboLandGameMap();
	AmiiboLandGameImageDecipher imageDecipher= new AmiiboLandGameImageDecipher();
    AmiiboLandGameNPC npcInfo = new AmiiboLandGameNPC();
    AmiiboLandGameItems items = new AmiiboLandGameItems();
    AmiiboLandGameNPCImage npcDeciphor = new AmiiboLandGameNPCImage();
    Player playerMove;
    Movement moveOption = new Movement();
    String playerOrientation;
    SavedData savedData;
    String[] save;
    UserMenu userMenu = new UserMenu();
    
    /*Battle*/
    Battle battle = new Battle(null, null);
    int currentBattleMenuSelected = 0;
    int currentAmiiboFighting = 0;
    ImageIcon physicalAttackMenu = new ImageIcon("src/resources/ui/battle/Physical Selected.png");
    ImageIcon specialAttackMenu = new ImageIcon("src/resources/ui/battle/Special.png");
    ImageIcon fleeMenu = new ImageIcon("src/resources/ui/battle/flee.png");
    ImageIcon itemBattleMenu = new ImageIcon("src/resources/ui/battle/items.png");
    
    /*Sounds*/
    PlaySound toggle = new PlaySound();
    PlaySound selected = new PlaySound();
    PlaySound dialogueSound = new PlaySound();
    PlaySound music = new PlaySound();
    
    /*These booleans are used to freeze user in case one action is being done*/
    boolean inBattle = false;
    boolean inPause = false;
    public boolean inDialogue = false;
    boolean inMenu = false;
    boolean inChangeParty = false;
    boolean listUpdated = false;
    boolean useItem = false;
    
    /*Start Menu*/
    int menuSelected = 0;
	JLabel currentMenu = new JLabel(new ImageIcon("src/resources/UI/Start menu/Collection.png"));
	JLabel collectionMenu = new JLabel(new ImageIcon("src/resources/UI/Start menu/Collection.png"));
	JLabel partyMenu = new JLabel(new ImageIcon("src/resources/UI/Start menu/Party.png"));
	JLabel itemMenu = new JLabel(new ImageIcon("src/resources/UI/Start menu/Items.png"));
	JLabel scanMenu = new JLabel(new ImageIcon("src/resources/UI/Start menu/Scan.png"));
	JLabel saveMenu = new JLabel(new ImageIcon("src/resources/UI/Start menu/Save.png"));
	JLabel quitMenu = new JLabel(new ImageIcon("src/resources/UI/Start menu/Quit.png"));
	
	/*Collection Menu*/
	ImageIcon collectionMenuSelected = new ImageIcon("src/resources/UI/Collection/Collection Menu.png");
	
	/*Party Menu*/
	ImageIcon partyMenuSelected = new ImageIcon("src/resources/UI/Party/AmiiboSelectionScreen.png");
	ImageIcon partyAmiiboUnselected = new ImageIcon("src/resources/UI/Party/unselected.png");
	ImageIcon partyAmiiboSelected = new ImageIcon("src/resources/UI/Party/selected.png");
	ImageIcon partyAmiiboHighlighted = new ImageIcon("src/resources/UI/Party/Current Highlight.png");
	ImageIcon swapAmiiboUnselected = new ImageIcon("src/resources/UI/Party/swapUnselected.png");
	ImageIcon swapAmiiboSelected = new ImageIcon("src/resources/UI/Party/swapSelected.png");
    int amiiboHighlighted = 0;
    int prevAmiiboHighlighted = 0;
	CollectionList partyList;
	
	/*Items Menu*/
	ImageIcon itemMenuSelected = new ImageIcon("src/resources/UI/Items/Item Menu.png");
	int itemHighlighted = 0;
	int prevItemHighlighted = 0;
	int amiiboToUseItem = 0;
	int prevAmiiboToUseItem = 0;
	boolean useItemMenu = false;
	Inventory inventory;
	Item currentItem;
	
	/*Collection Menu*/
	Image menuSelectedIMG = collectionMenuSelected.getImage();
	AmiiboCollection currentAmiiboIcon;
	CollectionList collectionList;
	
	/*Scan Menu*/
	ImageIcon scanMenuScreen = new ImageIcon("src/resources/UI/Scan/Scan Menu.png");
	ImageIcon scanUnselected = new ImageIcon("src/resources/UI/Scan/Scan Unselected.png");
	ImageIcon howUnselected = new ImageIcon("src/resources/UI/Scan/HowTo Unselected.png");
	ImageIcon backUnselected = new ImageIcon("src/resources/UI/Scan/Back Unselected.png");
	ImageIcon scanSelected = new ImageIcon("src/resources/UI/Scan/Scan Selected.png");
	ImageIcon howSelected = new ImageIcon("src/resources/UI/Scan/HowTo Selected.png");
	ImageIcon backSelected = new ImageIcon("src/resources/UI/Scan/Back Selected.png");
	int scanButtonSelected = 0;
	boolean successfulScan = false;
	boolean scanAttempted = false;
	
	/*Set Party Menu*/
	ImageIcon setPartyMenu = new ImageIcon("src/resources/UI/Party/AmiiboSelectionScreen.png");
	ImageIcon selectButtonSelected = new ImageIcon("src/resources/UI/Select Party/Selected.png");
	ImageIcon selectButtonUnselected = new ImageIcon("src/resources/UI/Select Party/Unselected.png");
    int amiiboSelected = 0;
    int collectionAmiiboHighlighted = 0;
    int prevCollectionAmiiboHighlighted = 0;
    int currentHighlightCount = 0;
	
	
	/*Interaction Bar*/
	JLabel dialogueMenu = new JLabel(new ImageIcon("src/resources/UI/Interaction/Interaction Bar.png"));
	public Dialogue dialogue = new Dialogue("", null, null);
	public LinkedList linkedList = new LinkedList(dialogue);
	public Dialogue current = linkedList.getHead();
	Font font = new Font("Roboto Condensed", Font.BOLD, 40);
	Font fontMenuTitle = new Font("Roboto Condensed", Font.BOLD, 55);
	Font fontCollection = new Font("Roboto Condensed", Font.BOLD, 32);
	Font fontStats = new Font("Roboto Condensed", Font.BOLD, 20);
	Font fontItems = new Font("Roboto Condensed", Font.BOLD, 30);
	Font fontQuantity = new Font("Roboto Condensed", Font.BOLD, 36);
	Font fontBattle = new Font("Roboto Condensed", Font.BOLD, 26);
    int currentStringLength = 0;
	
	/**
	  * default constructor of the class. Will create a new timer and start the timer.
	  * the timer delay is set to 1/10 of a second. So the action will be performed ever 10th of a second.
	  * The constructor will also add a keyListener
	  * for the keys that the user uses for the movement of the character. 
	  * The constructor will also create new instances of MazeBoard and Move.
	 * @throws FileNotFoundException 
	 * @throws MalformedURLException 
	  */ 
	public AmiiboLandGameMapGUI(SavedData save, String choice,Timer gameTime) throws FileNotFoundException, MalformedURLException
    {
	    savedData = save;
	    System.out.println(savedData.savedGameFile[0]);
		Timer timer = new Timer(0, this);
        timer.start();
        
        //sets the key listener for the keypad, so user may use arrow keys and AWSD keys to move in GUI.
    	addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setLayout(null);
        mapDraw = new AmiiboLandGameMap(choice,gameTime);
        npcInfo = new AmiiboLandGameNPC(choice);
        playerMove = new Player(save.savedGameFile[2]);
        collectionList = new CollectionList(savedData);
        currentAmiiboIcon = collectionList.getHead();
        
        selected.startMenuSelected();
        toggle.menuToggle();
        dialogueSound.dialogue();
        music.setSong(savedData.savedGameFile[1]);
        music.loopSound();

    	inventory = new Inventory(savedData);
    }
	
	public AmiiboLandGameMapGUI(SavedData save, String choice,Timer gameTime, int x, int y) throws FileNotFoundException, MalformedURLException
    {
	    savedData = save;
		Timer timer = new Timer(0, this);
        timer.start();
        
        //sets the key listener for the keypad, so user may use arrow keys and AWSD keys to move in GUI.
    	addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setLayout(null);
        mapDraw = new AmiiboLandGameMap(choice,gameTime);
        npcInfo = new AmiiboLandGameNPC(choice);
        playerMove = new Player(save.savedGameFile[2]);
        collectionList = new CollectionList(savedData);
        currentAmiiboIcon = collectionList.getHead();
        
        selected.startMenuSelected();
        toggle.menuToggle();
        dialogueSound.dialogue();
        music.setSong(savedData.savedGameFile[1]);
        music.loopSound();
        
    	inventory = new Inventory(savedData);
    }

    /** 
	  * This method will paint the maze elements to the frame of the game.
	  * Method will also open the appropriate image icons of and print them onto the maze.
	  * will also print the character to the screen depending on the position of the player.
	  */
	public void paint(Graphics RenderGame)
	{
		ImageIcon img;
		//The following numbers will be for the the orientation.
		if (savedData.savedGameFile[0].split(",")[1].equals("Male"))
		{
			if((moveOption.getOrientation().equals("down")) && (moveOption.getIsMoving()==true))
			{	
				img = new ImageIcon("src/resources/characters/player/male/frontWalking.gif");
	        	playerSprite = img.getImage();
			}
			
			else if((moveOption.getOrientation().equals("right")) && (moveOption.getIsMoving()==true))
			{
				img = new ImageIcon("src/resources/characters/player/male/rightWalking.gif");
	        	playerSprite = img.getImage();	
			}
			else if((moveOption.getOrientation().equals("left)")) && (moveOption.getIsMoving()==true))
			{
				img = new ImageIcon("src/resources/characters/player/male/LeftWalking.gif");
	        	playerSprite = img.getImage();
			}
			else if((moveOption.getOrientation().equals("up")) && (moveOption.getIsMoving()==true))
			{
				img = new ImageIcon("src/resources/characters/player/male/backWalking.gif");
	        	playerSprite = img.getImage();
			}
			else if(moveOption.getOrientation().equals("right"))
			{
				img = new ImageIcon("src/resources/characters/player/male/rightStanding.png");
	        	playerSprite = img.getImage();	
			}
			else if(moveOption.getOrientation().equals("left"))
			{
				img = new ImageIcon("src/resources/characters/player/male/leftStanding.png");
	        	playerSprite = img.getImage();	
			}
			else if(moveOption.getOrientation().equals("up"))
			{
				img = new ImageIcon("src/resources/characters/player/male/backStanding.png");
	        	playerSprite = img.getImage();	
			}
			else 
			{
				img = new ImageIcon("src/resources/characters/player/male/frontStanding.png");
	        	playerSprite = img.getImage();	
			}
		}
		
		else
		{
			if((moveOption.getOrientation().equals("down")) && (moveOption.getIsMoving()==true))
			{	
				img = new ImageIcon("src/resources/characters/player/female/frontWalking.gif");
	        	playerSprite = img.getImage();
			}
			
			else if((moveOption.getOrientation().equals("right")) && (moveOption.getIsMoving()==true))
			{
				img = new ImageIcon("src/resources/characters/player/female/rightWalking.gif");
	        	playerSprite = img.getImage();	
			}
			else if((moveOption.getOrientation().equals("left)")) && (moveOption.getIsMoving()==true))
			{
				img = new ImageIcon("src/resources/characters/player/female/LeftWalking.gif");
	        	playerSprite = img.getImage();
			}
			else if((moveOption.getOrientation().equals("up")) && (moveOption.getIsMoving()==true))
			{
				img = new ImageIcon("src/resources/characters/player/female/backWalking.gif");
	        	playerSprite = img.getImage();
			}
			else if(moveOption.getOrientation().equals("right"))
			{
				img = new ImageIcon("src/resources/characters/player/female/rightStanding.png");
	        	playerSprite = img.getImage();	
			}
			else if(moveOption.getOrientation().equals("left"))
			{
				img = new ImageIcon("src/resources/characters/player/female/leftStanding.png");
	        	playerSprite = img.getImage();	
			}
			else if(moveOption.getOrientation().equals("up"))
			{
				img = new ImageIcon("src/resources/characters/player/female/backStanding.png");
	        	playerSprite = img.getImage();	
			}
			else 
			{
				img = new ImageIcon("src/resources/characters/player/female/frontStanding.png");
	        	playerSprite = img.getImage();	
			}
		}
		
		
        super.paint(RenderGame);
        
        // This nested for loop will loop through the the 2D array and check each element of the array to see which icon variable to use to draw 
		// the canvas of the maze. 21 rows by 21 columns.
        // BABESKI
        for(int mazeRows = 0; mazeRows <mapDraw.getHeight(); mazeRows++)
		{
			for(int mazeColumns = 0; mazeColumns < mapDraw.getWidth(); mazeColumns++)
			{
                // This branch will check which icon it should print to the frame.
				// The appropriate icon will be determined by using the getMapElement of the MazeBoard class.
				// The array is read, and if the position in the array is equal to the specific character,
				// it will be replaced with the appropriate imported image, in the appropriate pixel size.
				mapString = mapDraw.getMapElement(mazeRows, mazeColumns);
				toDraw = imageDecipher.GetImage(mapString);
				RenderGame.drawImage(toDraw,mazeColumns*pixelSize,mazeRows*pixelSize,null);
			}
		}
        
        //BABESKI
        // This for loop will handle the printing of all the NPC's to the current map
        for(int NPCYPosition = 0; NPCYPosition < npcInfo.getMaxY(); NPCYPosition ++ )
        {
			String elementInfo = npcInfo.getElementType(NPCYPosition);
			int NPCXPosition = 1;
			String stringXCoord = npcInfo.getXPosition(NPCYPosition,NPCXPosition);
			String stringYCoord = npcInfo.getYPosition(NPCYPosition,NPCXPosition+1);
			int intXCoord =  Integer.parseInt(stringXCoord);
			int intYCoord =  Integer.parseInt(stringYCoord);
			npcDraw = npcDeciphor.GetImage(elementInfo);
			RenderGame.drawImage(npcDraw,intXCoord*pixelSize,intYCoord*pixelSize,null);
        	 
        }
        
        // This for loop will handle the printing of all the Items to the current map
        for(int i = 0; i < savedData.linesOfItems; i++)
        {
        	//System.out.println("Checking items");
        	String[] temp = savedData.savedItems[i].split(",");
        	if (temp[0].equals(mapDraw.getlevel()))
        	{
        		int xCoord = Integer.parseInt(temp[3]);
        		int yCoord = Integer.parseInt(temp[2]);
        		//System.out.println("Found item at: " + xCoord + "," + yCoord);
    			RenderGame.drawImage(items.getImage(Integer.parseInt(temp[4])),yCoord*pixelSize,xCoord*pixelSize,null);
        	}
        	 
        }
        // This prints the character to the screen based on the player position.
        RenderGame.drawImage(playerSprite,playerMove.getXPosition()*pixelSize,playerMove.getYPosition()*pixelSize,null);
       
        userMenu.printStartMenu(this, RenderGame);
		userMenu.printCollection(this, RenderGame);
		userMenu.printScan(this, RenderGame);
		userMenu.printParty(this, RenderGame);
		userMenu.printBattle(this, RenderGame);
		userMenu.printItem(this, RenderGame);
        userMenu.printDialogue(this, RenderGame);
    }
	
	/** 
	  * This method will repaint the maze every time the user has performed a movement action
	  */
	public void actionPerformed(ActionEvent e)
    {
        repaint();
    }
    
    /**
	  * This method handles the user input from the keyboard. The user uses the arrow key to move on the maze
	  * After a user presses a key. The appropriate methods from the other classes will be called.
	  * The calculations of the new character position will also be calculated from the moveCalc method from the Move class.
	  * This method also handles the collision detection of the game so that the player cannot move through walls.
	  * will also detect if the player has collected a treasure, and check for end of game status.
	  */
	public void keyPressed(KeyEvent e)
    {
		// depending on the code we will then pass in the code to another method to determine the orientation of the moving sprite.
        code = e.getKeyCode();

		
        // Handles the up key
		if((code == KeyEvent.VK_UP || code == KeyEvent.VK_W) && (inPause == false && inBattle == false && inDialogue == false && inChangeParty == false && useItem == false))
        {
            moveOption.moveUp(savedData, mapDraw,npcInfo,items, playerMove, this);
            moveOption.setIsMoving("move");
        }
		
		// Handles the down key
		else if((code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) && (inPause == false && inBattle == false && inDialogue == false && inChangeParty == false && useItem == false))
        {
            moveOption.moveDown(savedData, mapDraw, npcInfo,items, playerMove, this);
            moveOption.setIsMoving("move");
        }
        
		// Handles the right key
        else if((code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) && (inPause == false && inBattle == false && inDialogue == false && inChangeParty == false && useItem == false))
        {
            moveOption.moveRight(savedData, mapDraw, npcInfo,items, playerMove, this);
            moveOption.setIsMoving("move");
        }
        
		// Handles the left key
		else if((code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) && (inPause == false && inBattle == false && inDialogue == false && inChangeParty == false && useItem == false))
        {
            moveOption.moveLeft(savedData, mapDraw, npcInfo,items, playerMove, this);
            moveOption.setIsMoving("move");
        }
		
		// Handles the space bar key
		else if((code == KeyEvent.VK_SPACE) && (inPause == false && inBattle == false) && (inDialogue == false && inChangeParty == false && useItem == false))
		{
			//Gotta pass in the player orientation to see which way the player facing so that we can check that position to see what in front of the player.
			playerOrientation = moveOption.getOrientation();
			try {
				linkedList = moveOption.interaction(mapDraw,playerMove,npcInfo,items, playerOrientation, savedData);
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try
			{
				current = linkedList.getHead();
			}
			catch (NullPointerException e1)
			{
				System.out.println("Blank text from dialogue");
			}
			
			if (current.text.equals("done"))
			{
				current.text = "";
				inDialogue = false;
			}
			
			else
			{
				updateAmiiboList();
				inDialogue = true;
			}
			repaint();
		}
		
		else if ((code == KeyEvent.VK_SPACE) && (inDialogue == true) && (inChangeParty == false))
		{
			current = current.next;
			currentStringLength = 0;
			
			if (current.text.equals("done"))
			{
				remove(dialogueMenu);
				current.text = "";
				inDialogue = false;
			}
		}
		
		//Handles the Enter key command
		else if((code == KeyEvent.VK_ENTER) && (inBattle == false) && (inDialogue == false) && (inMenu == false) && inChangeParty == false)
		{
			if (inPause == false)
			{
				selected.playSound();
				menuSelected = 0;
				inPause = true;
			}
			
			else
			{
				selected.playSound();
				inPause = false;
				remove(currentMenu);
				revalidate();
				repaint();
			}
		}
		
		/*Exit Menu*/
		else if (((code == KeyEvent.VK_BACK_SPACE) || (code == KeyEvent.VK_ENTER)) && (inMenu == true))
		{
			if (useItemMenu == false)
			{
				selected.playSound();
				inMenu = false;
				savedData.resetToggle();
				useItemMenu = false;
			}
			else if (useItemMenu == true)
			{
				selected.playSound();
				useItemMenu = false;
			}
		}
		
		/*Move Up+Down on the Main menu*/
		else if ((code == KeyEvent.VK_UP) && (inPause == true) && (inMenu == false))
		{
			toggle.playSound();
			changeMenuButton(0, -1, 0, 5);
		}
		
		else if ((code == KeyEvent.VK_DOWN) && (inPause == true) && (inMenu == false))
		{
			toggle.playSound();
			changeMenuButton(0, 1, 0, 5);
		}
		
		/*Select Menu*/
		else if ((code == KeyEvent.VK_SPACE) && (inPause == true) && (inMenu == false))
		{
			if ((menuSelected == 0) || (menuSelected == 1) || (menuSelected == 2) || (menuSelected == 3))
			{
				selected.playSound();
				inMenu = true;
				scanAttempted = false;
				currentItem = inventory.getHead();
			}
			
			else if (menuSelected == 4)
			{
				selected.playSound();
				inPause = false;
				try 
				{
					dialogue.saving(this);
					savedData.savedGameFile[1] = mapDraw.getlevel();
					savedData.savedGameFile[2] = playerMove.getXPosition() + "," + playerMove.getYPosition();
					savedData.saveGame();
				} 
				
				catch (FileNotFoundException e1) 
				{
					e1.printStackTrace();
				} 
				
				catch (UnsupportedEncodingException e1) 
				{
					e1.printStackTrace();
				}
			}
		}
		
		/*Cycle through Amiibo in Collection*/
		else if ((code == KeyEvent.VK_RIGHT) && (inMenu == true) && (menuSelected == 0))
		{
			if (currentAmiiboIcon.next != null)
			{
				toggle.playSound();
				if (currentAmiiboIcon.next != null)
				{
					if (currentAmiiboIcon.next.next != null)
					{
						if (currentAmiiboIcon.next.next.next != null)
						{
							currentAmiiboIcon = currentAmiiboIcon.next;
						}
					}
				}
			}
		}
		
		else if ((code == KeyEvent.VK_LEFT) && (inMenu == true) && (menuSelected == 0))
		{
			if ((currentAmiiboIcon != collectionList.getHead()) && (currentAmiiboIcon.prev != null))
			{
				toggle.playSound();
				currentAmiiboIcon = currentAmiiboIcon.prev;
			}
		}
		
		/*Cycle through Amiibo in Party*/
		else if ((code == KeyEvent.VK_RIGHT) && (inMenu == true) && (menuSelected == 1))
		{
			toggle.playSound();
			changeSelectedAmiibo("Right");
		}
		
		else if ((code == KeyEvent.VK_LEFT) && (inMenu == true) && (menuSelected == 1))
		{
			toggle.playSound();
			changeSelectedAmiibo("Left");
		}
		
		else if ((code == KeyEvent.VK_DOWN) && (inMenu == true) && (menuSelected == 1))
		{
			toggle.playSound();
			changeSelectedAmiibo("Down");
		}
		
		else if ((code == KeyEvent.VK_UP) && (inMenu == true) && (menuSelected == 1))
		{
			toggle.playSound();
			changeSelectedAmiibo("Up");
		}
		
		/*Select Amiibo in party*/
		else if ((code == KeyEvent.VK_SPACE) && (inMenu == true) && (menuSelected == 1))
		{
			selected.playSound();
			selectAmiibo();
		}
		
		/*Move Up+Down in Scan Amiibo Screen*/
		else if ((code == KeyEvent.VK_DOWN) && (inMenu == true) && (menuSelected == 3))
		{
			toggle.playSound();
			changeMenuButton(1, 1, 0, 2);
			scanAttempted = false;
		}
		
		else if ((code == KeyEvent.VK_UP) && (inMenu == true) && (menuSelected == 3))
		{
			toggle.playSound();
			changeMenuButton(1, -1, 0, 2);
			scanAttempted = false;
		}
		
		else if ((code == KeyEvent.VK_SPACE) && (inMenu == true) && (menuSelected == 3) && (scanButtonSelected == 1))
		{
			selected.playSound();
			successfulScan = savedData.scanAmiibo();
	        collectionList = new CollectionList(savedData);
	        currentAmiiboIcon = collectionList.getHead();
			scanAttempted = true;
		}
		
		else if ((code == KeyEvent.VK_SPACE) && (inMenu == true) && (menuSelected == 3) && (scanButtonSelected == 2))
		{
			selected.playSound();
			inMenu = false;
			scanButtonSelected = 0;
		}
		
		/*Set Party Menu*/
		else if ((code == KeyEvent.VK_RIGHT) && (inChangeParty == true))
		{
			toggle.playSound();
			
			if ((collectionAmiiboHighlighted == 2) && (currentAmiiboIcon.next != null))
			{
				if (currentAmiiboIcon.next.next != null)
				{
					if (currentAmiiboIcon.next.next.next != null)
					{
						currentAmiiboIcon = currentAmiiboIcon.next;
					}
				}
			}
			
			changePartyMenu("Right");
		}
		
		else if ((code == KeyEvent.VK_LEFT) && (inChangeParty == true))
		{
			toggle.playSound();
			
			if ((collectionAmiiboHighlighted == 0) && (currentAmiiboIcon.prev != null))
			{
				currentAmiiboIcon = currentAmiiboIcon.prev;
			}
			
			changePartyMenu("Left");
		}
		
		else if ((code == KeyEvent.VK_DOWN) && (inChangeParty == true))
		{
			toggle.playSound();
			changePartyMenu("Down");
		}
		
		else if ((code == KeyEvent.VK_UP) && (inChangeParty == true))
		{
			toggle.playSound();
			changePartyMenu("Up");
		}
		
		else if ((code == KeyEvent.VK_SPACE) && (inChangeParty == true))
		{
			selected.playSound();
			changePartyMenu("Space");
		}

		else if ((code == KeyEvent.VK_BACK_SPACE) && (inChangeParty == true))
		{
			inChangeParty = false;
			savedData.resetToggle();
			current = current.next;
			currentHighlightCount = 0;
			collectionAmiiboHighlighted = 0;
		}
		
		/*Set Item Menu*/
		else if ((code == KeyEvent.VK_RIGHT) && (inMenu == true) && (menuSelected == 2))
		{
			toggle.playSound();
			changeItemMenu("Right");
		}
		
		else if ((code == KeyEvent.VK_LEFT) && (inMenu == true) && (menuSelected == 2))
		{
			toggle.playSound();
			changeItemMenu("Left");
		}
		
		else if ((code == KeyEvent.VK_DOWN) && (inMenu == true) && (menuSelected == 2))
		{
			toggle.playSound();
			changeItemMenu("Down");
		}
		
		else if ((code == KeyEvent.VK_UP) && (inMenu == true) && (menuSelected == 2))
		{
			toggle.playSound();
			changeItemMenu("Up");
		}
		
		else if (((code == KeyEvent.VK_SPACE) || (code == KeyEvent.VK_ENTER)) && (inMenu == true) && (menuSelected == 2))
		{
			selected.playSound();
			changeItemMenu("Select");
		}

		else if ((code == KeyEvent.VK_BACK_SPACE) && (inMenu == true) && (menuSelected == 2))
		{
			selected.playSound();
			changeItemMenu("Back");
		}
		
		/*Move Up+Down in Battle Screen*/
		else if ((code == KeyEvent.VK_DOWN) && (inBattle == true) && (inDialogue == false))
		{
			toggle.playSound();
			setBattleMenu("Down");
		}
		
		else if ((code == KeyEvent.VK_UP) && (inBattle == true) && (inDialogue == false))
		{
			toggle.playSound();
			setBattleMenu("Up");
		}
		
		else if ((code == KeyEvent.VK_SPACE) && (inBattle == true) && (inDialogue == false))
		{
			toggle.playSound();
			setBattleMenu("Select");
		}
    }
	
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
    }
    
    public void updateAmiiboList()
    {
        collectionList = new CollectionList(savedData);
        currentAmiiboIcon = collectionList.getHead();
    }
    
    public void setBattleMenu(String direction)
    {
    	if (direction.equals("Up"))
    	{
    		currentBattleMenuSelected--;
    		if (currentBattleMenuSelected < 0)
    		{
    			currentBattleMenuSelected = 3;
    		}
    	}
    	else if (direction.equals("Down"))
    	{
    		currentBattleMenuSelected++;
    		if (currentBattleMenuSelected > 3)
    		{
    			currentBattleMenuSelected = 0;
    		}
    	}
    	else if ((direction.equals("Select")) && (currentBattleMenuSelected == 0))
    	{
    		//Physical Attack
    	}
    	else if ((direction.equals("Select")) && (currentBattleMenuSelected == 1))
    	{
    		//Special Attack
    	}
    	else if ((direction.equals("Select")) && (currentBattleMenuSelected == 2))
    	{
    		Boolean doneFight = battle.flee(this);
    		if (doneFight == true)
    		{
    			inBattle = false;
    		}
    	}
    	else if ((direction.equals("Select")) && (currentBattleMenuSelected == 3))
    	{
    		//Item
    	}
    }
    
    public void changeItemMenu(String direction)
    {
    	//Item Menu
		
    	if (inDialogue == false)
    	{
			if (direction.equals("Left") && (itemHighlighted != 3) && (useItemMenu == false))
			{
				itemHighlighted--;
				if (itemHighlighted < 0)
				{
					itemHighlighted = 0;
	
					if (currentItem.prev != null)
					{
						currentItem = currentItem.prev;
					}
				}
			}
			
			else if (direction.equals("Right") && (itemHighlighted != 3) && (useItemMenu == false))
			{
				itemHighlighted++;
				if (itemHighlighted > 2)
				{
					itemHighlighted = 2;
					
					if (currentItem.next != null)
					{
						currentItem = currentItem.next;
					}
				}
			}
			
			else if (direction.equals("Up") && (useItemMenu == false))
			{
				itemHighlighted = prevItemHighlighted;
			}
			
			else if (direction.equals("Select") && (useItemMenu == false))
			{
				if (itemHighlighted == 0)
				{
					useItemMenu = true;
				}
				else if (itemHighlighted == 1)
				{
					useItemMenu = true;
				}
				else if (itemHighlighted == 2)
				{
					useItemMenu = true;
				}
				else
				{
					//Play fail sound
				}
			}
			
			else if (direction.equals("Back") && (useItemMenu == true))
			{
				useItemMenu = false;
			}
			
			//Select Amiibo to use on
			else if (direction.equals("Left") && (amiiboToUseItem != 3) && (useItemMenu == true))
			{
				amiiboToUseItem--;
				if (amiiboToUseItem < 0)
				{
					amiiboToUseItem = 0;
				}
			}
			
			else if (direction.equals("Right") && (amiiboToUseItem != 3) && (useItemMenu == true))
			{
				amiiboToUseItem++;
				if (amiiboToUseItem > 2)
				{
					amiiboToUseItem = 2;
				}
			}
			
			else if (direction.equals("Select") && (useItemMenu == true))
			{
				if (amiiboToUseItem == 0)
				{
					if (itemHighlighted == 0)
					{
						currentItem.use(this, savedData.party.firstSlot);
					}
					else if (itemHighlighted == 1)
					{
						currentItem.next.use(this, savedData.party.firstSlot);
					}
					else if (itemHighlighted == 2)
					{
						currentItem.next.next.use(this, savedData.party.firstSlot);
				}
				
				else if (amiiboToUseItem == 1)
				{
					if (itemHighlighted == 0)
					{
						currentItem.use(this, savedData.party.secondSlot);
					}
					else if (itemHighlighted == 1)
					{
						currentItem.next.use(this, savedData.party.secondSlot);
					}
					else if (itemHighlighted == 2)
					{
						currentItem.next.next.use(this, savedData.party.secondSlot);
					}
				}
				
				else if (amiiboToUseItem == 2)
				{
					if (itemHighlighted == 0)
					{
						currentItem.use(this, savedData.party.thirdSlot);
					}
					else if (itemHighlighted == 1)
					{
						currentItem.next.use(this, savedData.party.thirdSlot);
					}
					else if (itemHighlighted == 2)
					{
						currentItem.next.next.use(this, savedData.party.thirdSlot);
					}
				}
				useItemMenu = false;		
				}
			}
    	}
    }
	
	public void changePartyMenu(String direction)
	{
		if (direction.equals("Down"))
		{
			if (collectionAmiiboHighlighted != 3)
			{
				prevCollectionAmiiboHighlighted = collectionAmiiboHighlighted;
			}
			collectionAmiiboHighlighted = 3;
		}
		
		else if (direction.equals("Left") && (collectionAmiiboHighlighted != 3))
		{
			collectionAmiiboHighlighted--;
			if (collectionAmiiboHighlighted < 0)
			{
				collectionAmiiboHighlighted = 0;
			}
		}
		
		else if (direction.equals("Right") && (collectionAmiiboHighlighted != 3))
		{
			collectionAmiiboHighlighted++;
			if (collectionAmiiboHighlighted > 2)
			{
				collectionAmiiboHighlighted = 2;
			}
		}
		
		else if (direction.equals("Up"))
		{
			collectionAmiiboHighlighted = prevCollectionAmiiboHighlighted;
		}
		
		else if ((direction.equals("Space")) && (collectionAmiiboHighlighted != 3))
		{
			if ((currentAmiiboIcon != null) && (collectionAmiiboHighlighted == 0) && ((currentHighlightCount < 3) || (savedData.dataAmiibo[Integer.parseInt(currentAmiiboIcon.index)].toggleSelection == 1)))
			{
				savedData.dataAmiibo[Integer.parseInt(currentAmiiboIcon.index)].toggleSelection();
				
				//Set Counts
				if (savedData.dataAmiibo[Integer.parseInt(currentAmiiboIcon.index)].toggleSelection == 1)
				{
					currentHighlightCount++;
				}
				else
				{
					currentHighlightCount--;
				}
			}
			
			else if ((currentAmiiboIcon.next != null) && (collectionAmiiboHighlighted == 1) && ((currentHighlightCount < 3) || (savedData.dataAmiibo[Integer.parseInt(currentAmiiboIcon.next.index)].toggleSelection == 1)))
			{
				savedData.dataAmiibo[Integer.parseInt(currentAmiiboIcon.next.index)].toggleSelection();
				
				//Set Counts
				if (savedData.dataAmiibo[Integer.parseInt(currentAmiiboIcon.next.index)].toggleSelection == 1)
				{
					currentHighlightCount++;
				}
				else
				{
					currentHighlightCount--;
				}
			}
			
			else if ((currentAmiiboIcon.next.next != null) && (collectionAmiiboHighlighted == 2) && ((currentHighlightCount < 3) || (savedData.dataAmiibo[Integer.parseInt(currentAmiiboIcon.next.next.index)].toggleSelection == 1)))
			{
				savedData.dataAmiibo[Integer.parseInt(currentAmiiboIcon.next.next.index)].toggleSelection();
				
				//Set Counts
				if (savedData.dataAmiibo[Integer.parseInt(currentAmiiboIcon.next.next.index)].toggleSelection == 1)
				{
					currentHighlightCount++;
				}
				else
				{
					currentHighlightCount--;
				}
			}
		}
		
		else if ((direction.equals("Space")) && (collectionAmiiboHighlighted == 3) && (currentHighlightCount > 0))
		{
			int index = 0;
			Amiibo[] tempAmiibo = new Amiibo[3];
			
			for (int i = 0; i < 49; i++)
			{
				if (savedData.dataAmiibo[i].toggleSelection == 1)
				{
					tempAmiibo[index] = savedData.dataAmiibo[i];
					index++;
				}
				if (index == 3)
				{
					i = 49;
				}
			}
			
			savedData.resetToggle();
			savedData.party = new Party(tempAmiibo[0], tempAmiibo[1], tempAmiibo[2]);
			listUpdated = false;
			inChangeParty = false;
			current = current.next;
			currentHighlightCount = 0;
			collectionAmiiboHighlighted = 0;
		}
	}

	public void changeSelectedAmiibo(String direction)
	{
		if (direction.equals("Down"))
		{
			if (amiiboHighlighted != 3)
			{
				prevAmiiboHighlighted = amiiboHighlighted;
			}
			amiiboHighlighted = 3;
		}
		
		else if (direction.equals("Left") && (amiiboHighlighted != 3))
		{
			amiiboHighlighted--;
			if ((amiiboHighlighted < 0) && (savedData.party.thirdSlot != savedData.party.blankAmiibo))
			{
				amiiboHighlighted = 2;
			}
			else if ((amiiboHighlighted < 0) && (savedData.party.secondSlot != savedData.party.blankAmiibo))
			{
				amiiboHighlighted = 1;
			}
			else if ((amiiboHighlighted < 0) && (savedData.party.firstSlot != savedData.party.blankAmiibo))
			{
				amiiboHighlighted = 0;
			}
			prevAmiiboHighlighted = amiiboHighlighted;
		}
		
		else if (direction.equals("Right") && (amiiboHighlighted != 3))
		{
			if ((amiiboHighlighted == 0) && (savedData.party.secondSlot != savedData.party.blankAmiibo))
			{
				amiiboHighlighted = 1;
			}
			else if ((amiiboHighlighted == 0) && (savedData.party.secondSlot == savedData.party.blankAmiibo))
			{
				amiiboHighlighted = 0;
			}
			else if ((amiiboHighlighted == 1) && (savedData.party.thirdSlot != savedData.party.blankAmiibo))
			{
				amiiboHighlighted = 2;
			}
			else if ((amiiboHighlighted == 1) && (savedData.party.thirdSlot == savedData.party.blankAmiibo))
			{
				amiiboHighlighted = 0;
			}
			else if (amiiboHighlighted == 2)
			{
				amiiboHighlighted = 0;
			}
			prevAmiiboHighlighted = amiiboHighlighted;
		}
		
		else if (direction.equals("Up"))
		{
			amiiboHighlighted = prevAmiiboHighlighted;
		}
	}
	
	public void changeMenuButton(int type, int increment, int minimum, int maximum)
	{
		if (type == 0)
		{
			menuSelected = menuSelected + increment;
			if (menuSelected < minimum)
			{
				menuSelected = maximum;
			}
			else if (menuSelected > maximum)
			{
				menuSelected = minimum;
			}
		}
		
		else if (type == 1)
		{
			scanButtonSelected = scanButtonSelected + increment;
			if (scanButtonSelected < minimum)
			{
				scanButtonSelected = maximum;
			}
			else if (scanButtonSelected > maximum)
			{
				scanButtonSelected = minimum;
			}
		}
	}
	
	public void swapAmiibo()
	{
		if ((savedData.party.firstSlot.toggleSelection == 1) && (savedData.party.secondSlot.toggleSelection == 1))
		{
			savedData.party.firstSlot.toggleSelection();
			savedData.party.secondSlot.toggleSelection();
			savedData.party.switchMembers(savedData.party.firstSlot, savedData.party.secondSlot);
		}
		
		else if ((savedData.party.firstSlot.toggleSelection == 1) && (savedData.party.thirdSlot.toggleSelection == 1))
		{
			savedData.party.firstSlot.toggleSelection();
			savedData.party.thirdSlot.toggleSelection();
			savedData.party.switchMembers(savedData.party.firstSlot, savedData.party.thirdSlot);
		}
		
		else if ((savedData.party.secondSlot.toggleSelection == 1) && (savedData.party.thirdSlot.toggleSelection == 1))
		{

			savedData.party.secondSlot.toggleSelection();
			savedData.party.thirdSlot.toggleSelection();
			savedData.party.switchMembers(savedData.party.secondSlot, savedData.party.thirdSlot);
		}
		savedData.resetToggle();
	}
	
	public void selectAmiibo()
	{	
		//If first amiibo is highlighted and user toggles it
		if ((amiiboHighlighted == 0) && ((savedData.party.secondSlot.toggleSelection != 1) || (savedData.party.thirdSlot.toggleSelection != 1)))
		{			
			savedData.party.firstSlot.toggleSelection();
		}
		
		//If user only has two amiibo and selects 1
		else if ((amiiboHighlighted == 0) && (savedData.party.thirdSlot.equals(savedData.party.blankAmiibo)))
		{
			savedData.party.firstSlot.toggleSelection();
		}
		
		//If user only has two amiibo and selects 2
		else if ((amiiboHighlighted == 1) && (savedData.party.thirdSlot.equals(savedData.party.blankAmiibo)))
		{
			savedData.party.secondSlot.toggleSelection();
		}
		
		//If second amiibo is highlighted and user toggles it
		else if ((amiiboHighlighted == 1) && ((savedData.party.firstSlot.toggleSelection != 1) || (savedData.party.thirdSlot.toggleSelection != 1)))
		{
			savedData.party.secondSlot.toggleSelection();
		}
		
		//if third amiibo is highlighted and user toggles it
		else if ((amiiboHighlighted == 2) && ((savedData.party.firstSlot.toggleSelection != 1) || (savedData.party.secondSlot.toggleSelection != 1)))
		{
			savedData.party.thirdSlot.toggleSelection();
		}
		
		//if user selects swap amiibo menu
		else if (amiiboHighlighted == 3)
		{
			swapAmiibo();
		}
	}

	
    public void keyTyped(KeyEvent e)
    {
    }
    
    /**
     * This method will handle the key released action. This method is used to see which key the player has released so that setIsMoving method can change the character sprite to
     * the appropriate moving animation. 
     */
    public void keyReleased(KeyEvent e)
    {
		// depending on the code we will then pass in the code to another method to determine the orientation of the moving sprite.
        code = e.getKeyCode();

		
        // Handles the up key
		if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W)
        {
            moveOption.setIsMoving("not moving");
        }
		
		// Handles the down key
        if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S)
        {
            moveOption.setIsMoving("not moving");
        }
        
		// Handles the right key
		if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D)
        {
            moveOption.setIsMoving("not moving");
        }
        
		// Handles the left key
		if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A)
        {
            moveOption.setIsMoving("not moving");
        }  
		
		if ((code == KeyEvent.VK_SPACE) && (inPause == true))
		{	
			if (menuSelected == 5)
			{
				
				MainMenu mainMenu = new MainMenu();
				try {
					selected.playSound();
	    			Window w = SwingUtilities.getWindowAncestor(this);
	    	        w.setVisible(false);
	    	        music.stopSound();
					mainMenu.initializeMenu();
				} catch (InterruptedException | MalformedURLException e1) {
					e1.printStackTrace();
				}
			}
		}
    }
}