package amiibo.GUI;
import java.awt.Color;
import enemy.*;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import data.*;

public class UserMenu 
{
	public void printStartMenu(AmiiboLandGameMapGUI mapGUI, Graphics g)
	{
		ImageIcon img = new ImageIcon("");
		if ((mapGUI.inPause == true) && (mapGUI.menuSelected == 0))
		{
			img = new ImageIcon("src/resources/UI/Start menu/Collection.png");
		}
		
		else if ((mapGUI.inPause == true) && (mapGUI.menuSelected == 1))
		{
			img = new ImageIcon("src/resources/UI/Start menu/Party.png");
		}
		
		else if ((mapGUI.inPause == true) && (mapGUI.menuSelected == 2))
		{
			img = new ImageIcon("src/resources/UI/Start menu/Items.png");
		}
		
		else if ((mapGUI.inPause == true) && (mapGUI.menuSelected == 3))
		{
			img = new ImageIcon("src/resources/UI/Start menu/Scan.png");
		}
		
		else if ((mapGUI.inPause == true) && (mapGUI.menuSelected == 4))
		{
			img = new ImageIcon("src/resources/UI/Start menu/Save.png");
		}
		
		else if ((mapGUI.inPause == true) && (mapGUI.menuSelected == 5))
		{
			img = new ImageIcon("src/resources/UI/Start menu/Quit.png");
		}
		
    	Image startIMG = img.getImage();	
		g.drawImage(startIMG, 1024, 40, 256, 512, null);
	}
	
	public void printParty(AmiiboLandGameMapGUI mapGUI, Graphics g)
	{
		if ((mapGUI.inMenu == true) && (mapGUI.menuSelected == 1))
		{
			/* Print Amiibo from Party */
			g.drawImage(mapGUI.partyMenuSelected.getImage(), 0, 0, 1280, 768, null);
			mapGUI.partyList = new CollectionList(mapGUI.savedData.party);
			AmiiboCollection partyImages = mapGUI.partyList.getHead();
			
			/*Print Title*/
			g.setFont(mapGUI.fontMenuTitle);
			g.setColor(Color.WHITE);
			g.drawString("Party", 887, 115);
			
			/*Draw first slot*/
			if (partyImages != null)
			{
				g.drawImage(mapGUI.partyList.head.image, 45, 192, 384, 384, null);
				
				/*Draw toggle*/
				if (mapGUI.savedData.party.firstSlot.toggleSelection == 1)
				{
					g.drawImage(mapGUI.partyAmiiboSelected.getImage(), 47, 538, 36, 36, null);
				}
				else
				{
					g.drawImage(mapGUI.partyAmiiboUnselected.getImage(), 47, 538, 36, 36, null);
				}
				
				/*Draw highlight*/
				if ((mapGUI.amiiboHighlighted) == 0 && (mapGUI.savedData.party.firstSlot.equals(mapGUI.savedData.party.blankAmiibo) == false))
				{
					g.drawImage(mapGUI.partyAmiiboHighlighted.getImage(), 45, 192, 384, 384, null);
				}

				/*Draw Name*/
				g.setFont(mapGUI.fontCollection);
				g.setColor(Color.WHITE);
				g.drawString(mapGUI.partyList.head.name, 220, 230);
				
				/*Draw Stats*/
				g.setFont(mapGUI.fontStats);
				g.setColor(Color.WHITE);
				g.drawString("Level: " + mapGUI.savedData.party.firstSlot.amiiboLevel, 50, 592);
				g.drawString("HP: " + mapGUI.savedData.party.firstSlot.currentHealth + "/" + mapGUI.savedData.party.firstSlot.maxHealth, 50, 612);
				g.drawString("Exp: " + mapGUI.savedData.party.firstSlot.currentExp + "/" + mapGUI.savedData.party.firstSlot.expNeeded, 50, 632);
				g.drawString("Physical Attack/Defence: " + mapGUI.savedData.party.firstSlot.physicalAttack + "/" + mapGUI.savedData.party.firstSlot.physicalDefence, 175, 592);
				g.drawString("Special Attack/Defence: " + mapGUI.savedData.party.firstSlot.specialAttack + "/" + mapGUI.savedData.party.firstSlot.specialDefence, 175, 612);
				
				/*Draw second slot*/
				if (partyImages.next != null)
				{
					g.drawImage(mapGUI.partyList.head.next.image, 450, 192, 384, 384, null);
					
					/*Draw toggle*/
					if (mapGUI.savedData.party.secondSlot.toggleSelection == 1)
					{
						g.drawImage(mapGUI.partyAmiiboSelected.getImage(), 452, 538, 36, 36, null);
					}
					else
					{
						g.drawImage(mapGUI.partyAmiiboUnselected.getImage(), 452, 538, 36, 36, null);
					}
					
					/*Draw highlight*/
					if (mapGUI.amiiboHighlighted == 1)
					{
						g.drawImage(mapGUI.partyAmiiboHighlighted.getImage(), 450, 192, 384, 384, null);
					}
					
					/*Draw Name*/
					g.setFont(mapGUI.fontCollection);
					g.setColor(Color.WHITE);
					g.drawString(mapGUI.partyList.head.next.name, 625, 230);
					
					/*Draw Stats*/
					g.setFont(mapGUI.fontStats);
					g.setColor(Color.WHITE);
					g.drawString("Level: " + mapGUI.savedData.party.secondSlot.amiiboLevel, 455, 592);
					g.drawString("HP: " + mapGUI.savedData.party.secondSlot.currentHealth + "/" + mapGUI.savedData.party.secondSlot.maxHealth, 455, 612);
					g.drawString("Exp: " + mapGUI.savedData.party.secondSlot.currentExp + "/" + mapGUI.savedData.party.secondSlot.expNeeded, 455, 632);
					g.drawString("Physical Attack/Defence: " + mapGUI.savedData.party.secondSlot.physicalAttack + "/" + mapGUI.savedData.party.secondSlot.physicalDefence, 580, 592);
					g.drawString("Special Attack/Defence: " + mapGUI.savedData.party.secondSlot.specialAttack + "/" + mapGUI.savedData.party.secondSlot.specialDefence, 580, 612);
					
					/*Draw third slot*/
					if (partyImages.next.next != null)
					{
						g.drawImage(mapGUI.partyList.head.next.next.image, 851, 192, 384, 384, null);
						
						/*Draw toggle*/
						if (mapGUI.savedData.party.thirdSlot.toggleSelection == 1)
						{
							g.drawImage(mapGUI.partyAmiiboSelected.getImage(), 853, 538, 36, 36, null);
						}
						else
						{
							g.drawImage(mapGUI.partyAmiiboUnselected.getImage(), 853, 538, 36, 36, null);
						}
						
						/*Draw highlight*/
						if (mapGUI.amiiboHighlighted == 2)
						{
							g.drawImage(mapGUI.partyAmiiboHighlighted.getImage(), 851, 192, 384, 384, null);
						}
						
						/*Draw Name*/
						g.setFont(mapGUI.fontCollection);
						g.setColor(Color.WHITE);
						g.drawString(mapGUI.partyList.head.next.next.name, 1025, 230);
						
						/*Draw Stats*/
						g.setFont(mapGUI.fontStats);
						g.setColor(Color.WHITE);
						g.drawString("Level: " + mapGUI.savedData.party.secondSlot.amiiboLevel, 856, 592);
						g.drawString("HP: " + mapGUI.savedData.party.secondSlot.currentHealth + "/" + mapGUI.savedData.party.secondSlot.maxHealth, 856, 612);
						g.drawString("Exp: " + mapGUI.savedData.party.secondSlot.currentExp + "/" + mapGUI.savedData.party.secondSlot.expNeeded, 856, 632);
						g.drawString("Physical Attack/Defence: " + mapGUI.savedData.party.secondSlot.physicalAttack + "/" + mapGUI.savedData.party.secondSlot.physicalDefence, 981, 592);
						g.drawString("Special Attack/Defence: " + mapGUI.savedData.party.secondSlot.specialAttack + "/" + mapGUI.savedData.party.secondSlot.specialDefence, 981, 612);
					}
				}
			}
			if (mapGUI.amiiboHighlighted == 3)
			{
				g.drawImage(mapGUI.swapAmiiboSelected.getImage(), 25, 691, 194, 48, null);
			}
			else
			{
				g.drawImage(mapGUI.swapAmiiboUnselected.getImage(), 25, 691, 192, 48, null);
			}
		}
	}
	
	public void printItem(AmiiboLandGameMapGUI mapGUI, Graphics g)
	{
		AmiiboCollection partyImages = null;
		if (mapGUI.useItemMenu == true)
		{
			mapGUI.partyList = new CollectionList(mapGUI.savedData.party);
			partyImages = mapGUI.partyList.getHead();
		}
		
		if ((mapGUI.inMenu == true) && (mapGUI.menuSelected == 2))
		{
			//Draw Screen
			g.drawImage(mapGUI.itemMenuSelected.getImage(), 0, 0, 1280, 768, null);
			if (mapGUI.useItemMenu == false)
			{
				/*Print Title*/
				g.setFont(mapGUI.fontMenuTitle);
				g.setColor(Color.WHITE);
				g.drawString("Items", 887, 115);
			}
			
			else
			{
				/*Print Title*/
				g.setFont(mapGUI.fontMenuTitle);
				g.setColor(Color.WHITE);
				g.drawString("Select Amiibo", 887, 115);	
			}
	
			//Draw Items
			if (mapGUI.useItemMenu == false)
			{
				//Item 1
				g.drawImage(mapGUI.currentItem.getImage(), 45, 192, 384, 384, null);
				if (mapGUI.itemHighlighted == 0)
				{
					g.drawImage(mapGUI.partyAmiiboHighlighted.getImage(), 45, 192, 384, 384, null);
				}
				
				//Item 2
				g.drawImage(mapGUI.currentItem.next.getImage(), 450, 192, 384, 384, null);
				if (mapGUI.itemHighlighted == 1)
				{
					g.drawImage(mapGUI.partyAmiiboHighlighted.getImage(), 450, 192, 384, 384, null);
				}
				
				//Item 3
				g.drawImage(mapGUI.currentItem.next.next.getImage(), 851, 192, 384, 384, null);
				if (mapGUI.itemHighlighted == 2)
				{
					g.drawImage(mapGUI.partyAmiiboHighlighted.getImage(), 851, 192, 384, 384, null);
				}
				
				//Name
				g.setFont(mapGUI.fontItems);
				g.setColor(Color.WHITE);
				g.drawString(mapGUI.currentItem.getName(), 220, 230);
				g.drawString(mapGUI.currentItem.next.getName(), 625, 230);
				g.drawString(mapGUI.currentItem.next.next.getName(), 1025, 230);
				
				//Quantity
				g.setFont(mapGUI.fontQuantity);
				g.setColor(Color.WHITE);
				g.drawString(mapGUI.currentItem.quantity + "x", 222, 620);
				g.drawString(mapGUI.currentItem.next.quantity + "x", 622, 620);
				g.drawString(mapGUI.currentItem.next.next.quantity + "x", 1022, 620);
			}
			
			//Draw Amiibo
			if (mapGUI.useItemMenu == true)
			{
				/*Draw first slot*/
				if (partyImages != null)
				{
					g.drawImage(mapGUI.partyList.head.image, 45, 192, 384, 384, null);
					
					/*Draw highlight*/
					if ((mapGUI.amiiboToUseItem) == 0 && (mapGUI.savedData.party.firstSlot.equals(mapGUI.savedData.party.blankAmiibo) == false))
					{
						g.drawImage(mapGUI.partyAmiiboHighlighted.getImage(), 45, 192, 384, 384, null);
					}

					/*Draw Name*/
					g.setFont(mapGUI.fontItems);
					g.setColor(Color.WHITE);
					g.drawString(mapGUI.partyList.head.name, 220, 230);
					
					/*Draw Stats*/
					g.setFont(mapGUI.fontStats);
					g.setColor(Color.WHITE);
					g.drawString("Level: " + mapGUI.savedData.party.firstSlot.amiiboLevel, 50, 592);
					g.drawString("HP: " + mapGUI.savedData.party.firstSlot.currentHealth + "/" + mapGUI.savedData.party.firstSlot.maxHealth, 50, 612);
					g.drawString("Exp: " + mapGUI.savedData.party.firstSlot.currentExp + "/" + mapGUI.savedData.party.firstSlot.expNeeded, 50, 632);
					g.drawString("Physical Attack/Defence: " + mapGUI.savedData.party.firstSlot.physicalAttack + "/" + mapGUI.savedData.party.firstSlot.physicalDefence, 175, 592);
					g.drawString("Special Attack/Defence: " + mapGUI.savedData.party.firstSlot.specialAttack + "/" + mapGUI.savedData.party.firstSlot.specialDefence, 175, 612);
					
					/*Draw second slot*/
					if (partyImages.next != null)
					{
						g.drawImage(mapGUI.partyList.head.next.image, 450, 192, 384, 384, null);
						
						/*Draw highlight*/
						if (mapGUI.amiiboToUseItem == 1)
						{
							g.drawImage(mapGUI.partyAmiiboHighlighted.getImage(), 450, 192, 384, 384, null);
						}
						
						/*Draw Name*/
						g.setFont(mapGUI.fontItems);
						g.setColor(Color.WHITE);
						g.drawString(mapGUI.partyList.head.next.name, 625, 230);
						
						/*Draw Stats*/
						g.setFont(mapGUI.fontStats);
						g.setColor(Color.WHITE);
						g.drawString("Level: " + mapGUI.savedData.party.secondSlot.amiiboLevel, 455, 592);
						g.drawString("HP: " + mapGUI.savedData.party.secondSlot.currentHealth + "/" + mapGUI.savedData.party.secondSlot.maxHealth, 455, 612);
						g.drawString("Exp: " + mapGUI.savedData.party.secondSlot.currentExp + "/" + mapGUI.savedData.party.secondSlot.expNeeded, 455, 632);
						g.drawString("Physical Attack/Defence: " + mapGUI.savedData.party.secondSlot.physicalAttack + "/" + mapGUI.savedData.party.secondSlot.physicalDefence, 580, 592);
						g.drawString("Special Attack/Defence: " + mapGUI.savedData.party.secondSlot.specialAttack + "/" + mapGUI.savedData.party.secondSlot.specialDefence, 580, 612);
						
						/*Draw third slot*/
						if (partyImages.next.next != null)
						{
							g.drawImage(mapGUI.partyList.head.next.next.image, 851, 192, 384, 384, null);
							
							/*Draw highlight*/
							if (mapGUI.amiiboToUseItem == 2)
							{
								g.drawImage(mapGUI.partyAmiiboHighlighted.getImage(), 851, 192, 384, 384, null);
							}
							
							/*Draw Name*/
							g.setFont(mapGUI.fontCollection);
							g.setColor(Color.WHITE);
							g.drawString(mapGUI.partyList.head.next.next.name, 1025, 230);
							
							/*Draw Stats*/
							g.setFont(mapGUI.fontStats);
							g.setColor(Color.WHITE);
							g.drawString("Level: " + mapGUI.savedData.party.secondSlot.amiiboLevel, 856, 592);
							g.drawString("HP: " + mapGUI.savedData.party.secondSlot.currentHealth + "/" + mapGUI.savedData.party.secondSlot.maxHealth, 856, 612);
							g.drawString("Exp: " + mapGUI.savedData.party.secondSlot.currentExp + "/" + mapGUI.savedData.party.secondSlot.expNeeded, 856, 632);
							g.drawString("Physical Attack/Defence: " + mapGUI.savedData.party.secondSlot.physicalAttack + "/" + mapGUI.savedData.party.secondSlot.physicalDefence, 981, 592);
							g.drawString("Special Attack/Defence: " + mapGUI.savedData.party.secondSlot.specialAttack + "/" + mapGUI.savedData.party.secondSlot.specialDefence, 981, 612);
						}
					}
				}
			}
		}
	}
	
	public void printScan(AmiiboLandGameMapGUI mapGUI, Graphics g)
	{
		if ((mapGUI.inMenu == true) && (mapGUI.menuSelected == 3))
		{
			g.drawImage(mapGUI.scanMenuScreen.getImage(), 0, 0, 1280, 768, null);
			
			/*Print Title*/
			g.setFont(mapGUI.fontMenuTitle);
			g.setColor(Color.WHITE);
			g.drawString("Scan Amiibo", 887, 115);
			
			if (mapGUI.scanButtonSelected == 0)
			{
				g.drawImage(mapGUI.howSelected.getImage(), 142, 153, 1138, 515, null);
			}
			
			else
			{
				g.drawImage(mapGUI.howUnselected.getImage(), 107, 272, 256, 64, null);
			}
			
			if (mapGUI.scanButtonSelected == 1)
			{
				g.drawImage(mapGUI.scanSelected.getImage(), 142, 153, 1138, 515, null);
				
				if (mapGUI.scanAttempted == true)
				{
					if (mapGUI.successfulScan == true)
					{
						g.setFont(mapGUI.font);
						g.setColor(Color.WHITE);
						g.drawString("Scan was successful!", 580, 315);
					}
					else
					{
						g.setFont(mapGUI.font);
						g.setColor(Color.WHITE);
						g.drawString("Scan was unsuccessful :(", 580, 315);
					}						
				}
			}
			
			else
			{
				g.drawImage(mapGUI.scanUnselected.getImage(), 107, 361, 256, 64, null);
			}
			
			if (mapGUI.scanButtonSelected == 2)
			{
				g.drawImage(mapGUI.backSelected.getImage(), 142, 446, 260, 71, null);
			}
			
			else
			{
				g.drawImage(mapGUI.backUnselected.getImage(), 107, 451, 256, 64, null);
			}
		}
	}
	
	public void printCollection(AmiiboLandGameMapGUI mapGUI, Graphics g)
	{
		if ((mapGUI.inMenu == true) && (mapGUI.menuSelected == 0))
		{
			g.drawImage(mapGUI.menuSelectedIMG, 0, 0, 1280, 768, null);
			
			/*Print Title*/
			g.setFont(mapGUI.fontMenuTitle);
			g.setColor(Color.WHITE);
			g.drawString("Collection", 887, 115);
			
			if (mapGUI.currentAmiiboIcon != null)
			{
				g.drawImage(mapGUI.currentAmiiboIcon.image, 45, 192, 384, 384, null);
				g.setFont(mapGUI.fontCollection);
				g.setColor(Color.WHITE);
				g.drawString(mapGUI.currentAmiiboIcon.name, 220, 230);
				
				if (mapGUI.currentAmiiboIcon.next != null)
				{
					g.drawImage(mapGUI.currentAmiiboIcon.next.image, 450, 192, 384, 384, null);
					g.setFont(mapGUI.fontCollection);
					g.setColor(Color.WHITE);
					g.drawString(mapGUI.currentAmiiboIcon.next.name, 625, 230);
					
					if (mapGUI.currentAmiiboIcon.next.next != null)
					{
						g.drawImage(mapGUI.currentAmiiboIcon.next.next.image, 851, 192, 384, 384, null);
						g.setFont(mapGUI.fontCollection);
						g.setColor(Color.WHITE);
						g.drawString(mapGUI.currentAmiiboIcon.next.next.name, 1025, 230);
					}
				}
			}
		}
	}
	
	public void printBattle(AmiiboLandGameMapGUI mapGUI, Graphics g)
	{
		if (mapGUI.inBattle == true)
		{
			//Print background
			
			//Print options
		    if (mapGUI.currentBattleMenuSelected == 0)
		    {
		    	g.drawImage(mapGUI.physicalAttackMenu.getImage(), 0, 512, 1280, 256, null);
		    }
		    else if (mapGUI.currentBattleMenuSelected == 1)
		    {
		    	g.drawImage(mapGUI.specialAttackMenu.getImage(), 0, 512, 1280, 256, null);
		    }
		    else if (mapGUI.currentBattleMenuSelected == 2)
		    {
		    	g.drawImage(mapGUI.fleeMenu.getImage(), 0, 512, 1280, 256, null);
		    }
		    else if (mapGUI.currentBattleMenuSelected == 3)
		    {
		    	g.drawImage(mapGUI.itemBattleMenu.getImage(), 0, 512, 1280, 256, null);
		    }
			
		    //Print Amiibo

		    //Print stats
		    //Print Amiibo Stats
			g.setFont(mapGUI.fontBattle);
			g.setColor(Color.WHITE);
		    if (mapGUI.savedData.party.firstSlot.amiiboName.equals("Name") == false)
		    {
				if (mapGUI.currentAmiiboFighting == 0)
				{
					g.drawString(mapGUI.savedData.party.firstSlot.amiiboName, 815, 605);
				}
				else
				{
					g.drawString(mapGUI.savedData.party.firstSlot.amiiboName, 800, 605);
				}
				//Stats
				g.drawString("HP: " + mapGUI.savedData.party.firstSlot.currentHealth + "/" + mapGUI.savedData.party.firstSlot.maxHealth, 815, 635);
				
		    }
		    if (mapGUI.savedData.party.secondSlot.amiiboName.equals("Name") == false)
		    {
				if (mapGUI.currentAmiiboFighting == 1)
				{
					g.drawString(mapGUI.savedData.party.secondSlot.amiiboName, 815, 665);
				}
				else
				{
					g.drawString(mapGUI.savedData.party.secondSlot.amiiboName, 800, 665);
				}
				g.drawString("HP: " + mapGUI.savedData.party.secondSlot.currentHealth + "/" + mapGUI.savedData.party.secondSlot.maxHealth, 815, 695);
		    }
		    if (mapGUI.savedData.party.thirdSlot.amiiboName.equals("Name") == false)
		    {
				if (mapGUI.currentAmiiboFighting == 1)
				{
					g.drawString(mapGUI.savedData.party.thirdSlot.amiiboName, 815, 725);
				}
				else
				{
					g.drawString(mapGUI.savedData.party.thirdSlot.amiiboName, 800, 725);
				}
				g.drawString("HP: " + mapGUI.savedData.party.thirdSlot.currentHealth + "/" + mapGUI.savedData.party.thirdSlot.maxHealth, 815, 755);
		    }
		    
		    //Print enemy stats
		    if (mapGUI.battle.foe.firstSlot.amiiboName.equals("Name") == false)
		    {
				g.drawString(mapGUI.battle.foe.firstSlot.amiiboName, 500, 605);
				g.drawString("HP: " + mapGUI.battle.foe.firstSlot.currentHealth + "/" + mapGUI.battle.foe.firstSlot.maxHealth, 515, 635);
		    }
		}
	}
	
	public void printDialogue(AmiiboLandGameMapGUI mapGUI, Graphics g)
	{
        /*Print Dialogue*/
		if (mapGUI.inDialogue == true)
		{
			//Print Character Image
			printDialogueImage(mapGUI.current.name, g, mapGUI);
			
			//Print interaction bar
			ImageIcon img = new ImageIcon("src/resources/UI/Interaction/Interaction Bar.png");
        	Image interactionIMG = img.getImage();	
			g.drawImage(interactionIMG, 0, 512, 1280, 256, null);
			

			//Set font	
			g.setFont(mapGUI.font);
			g.setColor(Color.WHITE);
			if (mapGUI.current.name != null)
			{
				if (mapGUI.current.name.equals("#USER"))
				{
					g.drawString(mapGUI.savedData.savedGameFile[0].split(",")[0], 1020, 588);	//Draw Name of Player
				}
				else
				{
					g.drawString(mapGUI.current.name, 1020, 588);							//Draw Name of NPC
				}
			}
			
			//Play Sound if available
			if (mapGUI.current.sound != null && mapGUI.current.soundPlayed == false)
			{
				mapGUI.current.sound.playSound();
				//Disable from looping
				mapGUI.current.soundPlayed = true;
				
			}
			
			//Check if menu
			if (mapGUI.current.text.equals("CHANGE_PARTY"))
			{	
				mapGUI.inChangeParty = true;
				setParty(mapGUI, g);
			}
			
			else if (mapGUI.current.text.equals("BATTLE_RED"))
			{	
				mapGUI.inBattle = true;
				Red red = new Red();
				Party enemyParty = new Party(red);
				mapGUI.battle =  new Battle(enemyParty, mapGUI.savedData.party);
				mapGUI.inDialogue = false;
				
			}
			
			if (mapGUI.inChangeParty == false)
			{
				/*Slowly print text*/
				if(mapGUI.currentStringLength < mapGUI.current.text.length())
				{
					g.drawString(mapGUI.current.text.substring(0, mapGUI.currentStringLength), 25, 675);			//Draw text
					mapGUI.dialogueSound.playSound();
					mapGUI.currentStringLength++;
					try 
					{
						Thread.sleep(60);
					} 
					catch (InterruptedException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				/*Finish printing*/
				else if (mapGUI.currentStringLength == mapGUI.current.text.length())
				{
					g.drawString(mapGUI.current.text, 25, 675);			//Draw text
				}
			}
		}	
	}

	public void setParty(AmiiboLandGameMapGUI mapGUI, Graphics g)
	{
		//Update Collction
		if (mapGUI.listUpdated == false)
		{
			mapGUI.savedData.storeParty();
			mapGUI.updateAmiiboList();
			mapGUI.listUpdated = true;
		}
		
		if (mapGUI.inChangeParty == true)
		{
			g.drawImage(mapGUI.setPartyMenu.getImage(), 0, 0, 1280, 768, null);
			
			/*Print Title*/
			g.setFont(mapGUI.fontMenuTitle);
			g.setColor(Color.WHITE);
			g.drawString("Set Party", 887, 115);
			
			//First
			if (mapGUI.currentAmiiboIcon != null)
			{
				g.drawImage(mapGUI.currentAmiiboIcon.image, 45, 192, 384, 384, null);
				
				/*Highlight*/
				if ((mapGUI.collectionAmiiboHighlighted == 0) && (mapGUI.currentAmiiboIcon.name.equals("Blank") == false))
				{
					g.drawImage(mapGUI.partyAmiiboHighlighted.getImage(), 45, 192, 384, 384, null);
				}
				
				/*Draw toggle*/
				if (mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.index)].toggleSelection == 1)
				{
					g.drawImage(mapGUI.partyAmiiboSelected.getImage(), 47, 538, 36, 36, null);
				}
				else
				{
					g.drawImage(mapGUI.partyAmiiboUnselected.getImage(), 47, 538, 36, 36, null);
				}
				
				/*Name*/
				g.setFont(mapGUI.fontCollection);
				g.setColor(Color.WHITE);
				g.drawString(mapGUI.currentAmiiboIcon.name, 220, 230);
				
				/*Draw Stats*/
				g.setFont(mapGUI.fontStats);
				g.setColor(Color.WHITE);
				g.drawString("Level: " + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.index)].amiiboLevel, 50, 592);
				g.drawString("HP: " + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.index)].currentHealth + "/" + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.index)].maxHealth, 50, 612);
				g.drawString("Exp: " + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.index)].currentExp + "/" + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.index)].expNeeded, 50, 632);
				g.drawString("Physical Attack/Defence: " + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.index)].physicalAttack + "/" + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.index)].physicalDefence, 175, 592);
				g.drawString("Special Attack/Defence: " + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.index)].specialAttack + "/" + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.index)].specialDefence, 175, 612);
				
				//Second
				if (mapGUI.currentAmiiboIcon.next != null)
				{
					g.drawImage(mapGUI.currentAmiiboIcon.next.image, 450, 192, 384, 384, null);
					
					/*Draw highlight*/
					if ((mapGUI.collectionAmiiboHighlighted == 1) && (mapGUI.currentAmiiboIcon.next.name.equals("Blank") == false))
					{
						g.drawImage(mapGUI.partyAmiiboHighlighted.getImage(), 450, 192, 384, 384, null);
					}
					
					/*Draw toggle*/
					if (mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.index)].toggleSelection == 1)
					{
						g.drawImage(mapGUI.partyAmiiboSelected.getImage(), 452, 538, 36, 36, null);
					}
					else
					{
						g.drawImage(mapGUI.partyAmiiboUnselected.getImage(), 452, 538, 36, 36, null);
					}
					
					//Name
					g.setFont(mapGUI.fontCollection);
					g.setColor(Color.WHITE);
					g.drawString(mapGUI.currentAmiiboIcon.next.name, 625, 230);
							
					/*Draw Stats*/
					g.setFont(mapGUI.fontStats);
					g.setColor(Color.WHITE);
					g.drawString("Level: " + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.index)].amiiboLevel, 455, 592);
					g.drawString("HP: " + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.index)].currentHealth + "/" + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.index)].maxHealth, 455, 612);
					g.drawString("Exp: " + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.index)].currentExp + "/" + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.index)].expNeeded, 455, 632);
					g.drawString("Physical Attack/Defence: " + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.index)].physicalAttack + "/" + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.index)].physicalDefence, 580, 592);
					g.drawString("Special Attack/Defence: " + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.index)].specialAttack + "/" + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.index)].specialDefence, 580, 612);
					
					//Third
					if (mapGUI.currentAmiiboIcon.next.next != null)
					{
						g.drawImage(mapGUI.currentAmiiboIcon.next.next.image, 851, 192, 384, 384, null);
						
						/*Draw highlight*/
						if ((mapGUI.collectionAmiiboHighlighted == 2) && (mapGUI.currentAmiiboIcon.next.next.name.equals("Blank") == false))
						{
							g.drawImage(mapGUI.partyAmiiboHighlighted.getImage(), 851, 192, 384, 384, null);
						}
						
						/*Draw toggle*/
						if (mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.next.index)].toggleSelection == 1)
						{
							g.drawImage(mapGUI.partyAmiiboSelected.getImage(), 853, 538, 36, 36, null);
						}
						else
						{
							g.drawImage(mapGUI.partyAmiiboUnselected.getImage(), 853, 538, 36, 36, null);
						}
						
						//Name
						g.setFont(mapGUI.fontCollection);
						g.setColor(Color.WHITE);
						g.drawString(mapGUI.currentAmiiboIcon.next.next.name, 1025, 230);
								
						/*Draw Stats*/
						g.setFont(mapGUI.fontStats);
						g.setColor(Color.WHITE);
						g.drawString("Level: " + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.next.index)].amiiboLevel, 856, 592);
						g.drawString("HP: " + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.next.index)].currentHealth + "/" + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.next.index)].maxHealth, 856, 612);
						g.drawString("Exp: " + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.next.index)].currentExp + "/" + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.next.index)].expNeeded, 856, 632);
						g.drawString("Physical Attack/Defence: " + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.next.index)].physicalAttack + "/" +mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.next.index)].physicalDefence, 981, 592);
						g.drawString("Special Attack/Defence: " + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.next.index)].specialAttack + "/" + mapGUI.savedData.dataAmiibo[Integer.parseInt(mapGUI.currentAmiiboIcon.next.next.index)].specialDefence, 981, 612);

					}
				}
			}
		}
		
		//Button
		if (mapGUI.collectionAmiiboHighlighted == 3)
		{
			g.drawImage(mapGUI.selectButtonSelected.getImage(), 25, 691, 194, 48, null);
		}
		else
		{
			g.drawImage(mapGUI.selectButtonUnselected.getImage(), 25, 691, 192, 48, null);
		}
	}
	
	public void printDialogueImage(String name, Graphics g, AmiiboLandGameMapGUI gameMap)
	{
		ImageIcon face = new ImageIcon();
		//Check if user
		String lineOneOfSave = gameMap.savedData.savedGameFile[0];
		String[] splitOfLineOne = lineOneOfSave.split(",");
		
		if (name != null)
		{
			if ((name.equals("#USER") && (splitOfLineOne[1].equals("Male"))))
			{
				face = new ImageIcon("src/resources/characters/Player/Male/Dialogue.png");
				g.drawImage(face.getImage(), 0, 231, 512, 512, null);
			}
			
			else if ((name.equals("#USER")) && (splitOfLineOne[1].equals("Female")))
			{
				face = new ImageIcon("src/resources/characters/Player/Female/Dialogue.png");
				g.drawImage(face.getImage(), 0, 231, 512, 512, null);
			}
			
			else if (name.equals("Brian"))
			{
				face = new ImageIcon("src/resources/characters/brian/Dialogue.png");
				g.drawImage(face.getImage(), 768, 200, 512, 512, null);
			}
			
			else if (name.equals("Nurse"))
			{
				face = new ImageIcon("src/resources/characters/Nurse/Dialogue.png");
				g.drawImage(face.getImage(), 768, 231, 512, 512, null);
			}
		}
	}
}
