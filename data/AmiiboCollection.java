package data;

import java.awt.Image;

import javax.swing.ImageIcon;

import data.*;

public class AmiiboCollection 
{
	public ImageIcon imageIcon;
	public Image image;
	public String name;
	public String index;
	public AmiiboCollection next = null;
	public AmiiboCollection prev = null;
	
	public AmiiboCollection(Amiibo amiibo)
	{
		if (amiibo.index == -1)
		{
			imageIcon = new ImageIcon("");
			name = "Blank";
		}
		
		else if (amiibo.index == 0)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Mario.png");
			name = "Mario";
		}
		
		else if (amiibo.index == 1)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/DonkeyKong.png");
			name = "Donkey Kong";
		}
		
		else if (amiibo.index == 2)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Link.png");
			name = "Link";
		}
		
		else if (amiibo.index == 3)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Samus.png");
			name = "Samus";
		}
		
		else if (amiibo.index == 4)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Yoshi.png");
			name = "Yoshi";
		}
		
		else if (amiibo.index == 5)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Kirby.png");
			name = "Kirby";
		}
		
		else if (amiibo.index == 6)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Fox.png");
			name = "Fox";
		}
		
		else if (amiibo.index == 7)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Pikachu.png");
			name = "Pikachu";
		}
		
		else if (amiibo.index == 8)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Luigi.png");
			name = "Luigi";
		}
		
		else if (amiibo.index == 9)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/CaptainFalcon.png");
			name = "Captain Falcon";
		}
		
		else if (amiibo.index == 10)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Peach.png");
			name = "Peach";
		}
		
		else if (amiibo.index == 11)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Bowser.png");
			name = "Bowser";
		}
		
		else if (amiibo.index == 12)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Zelda.png");
			name = "Zelda";
		}
		
		else if (amiibo.index == 13)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Sheik.png");
			name = "Sheik";
		}
		
		else if (amiibo.index == 14)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Marth.png");
			name = "Marth";
		}
		
		else if (amiibo.index == 15)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/MetaKnight.png");
			name = "Meta Knight";
		}
		
		else if (amiibo.index == 16)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Pit.png");
			name = "Pit";
		}
		
		else if (amiibo.index == 17)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/ZeroSuitSamus.png");
			name = "Zero Suit Samus";
		}
		
		else if (amiibo.index == 18)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Ike.png");
			name = "Ike";
		}
		
		else if (amiibo.index == 19)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Charizard.png");
			name = "Charizard";
		}
		
		else if (amiibo.index == 20)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/DiddyKong.png");
			name = "Diddy Kong";
		}
		
		else if (amiibo.index == 21)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/KingDeDeDe.png");
			name = "King DeDeDe";
		}
		
		else if (amiibo.index == 22)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Olimar.png");
			name = "Pikmin & Olimar";
		}
		
		else if (amiibo.index == 23)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Lucario.png");
			name = "Lucario";
		}
		
		else if (amiibo.index == 24)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/ToonLink.png");
			name = "Toon Link";
		}
		
		else if (amiibo.index == 25)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Villager.png");
			name = "Villager";
		}
		
		else if (amiibo.index == 26)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/WiiFitTrainer.png");
			name = "Wii Fit Trainer";
		}
		
		else if (amiibo.index == 27)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Rosalina.png");
			name = "Rosalina & Luma";
		}
		
		else if (amiibo.index == 28)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/LittleMac.png");
			name = "Little Mac";
		}
		
		else if (amiibo.index == 29)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Greninja.png");
			name = "Greninja";
		}
		
		else if (amiibo.index == 30)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Palutena.png");
			name = "Palutena";
		}
		
		else if (amiibo.index == 31)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Robin.png");
			name = "Robin";
		}
		
		else if (amiibo.index == 32)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Lucina.png");
			name = "Lucina";
		}
		
		else if (amiibo.index == 33)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Shulk.png");
			name = "Shulk";
		}
		
		else if (amiibo.index == 34)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Sonic.png");
			name = "Sonic";
		}
		
		else if (amiibo.index == 35)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/MegaMan.png");
			name = "Mega Man";
		}
		
		else if (amiibo.index == 36)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Pac-Man.png");
			name = "Pac-Man";
		}
		
		else if (amiibo.index == 37)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Ness.png");
			name = "Ness";
		}
		
		else if (amiibo.index == 38)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Falco.png");
			name = "Falco";
		}
		
		else if (amiibo.index == 39)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Wario.png");
			name = "Wario";
		}
		
		else if (amiibo.index == 40)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/DrMario.png");
			name = "Dr. Mario";
		}
		
		else if (amiibo.index == 41)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/DarkPit.png");
			name = "Dark Pit";
		}
		
		else if (amiibo.index == 42)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Ganondorf.png");
			name = "Ganondorf";
		}
		
		else if (amiibo.index == 43)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/ROB.png");
			name = "R.O.B.";
		}
		
		else if (amiibo.index == 44)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/BowserJr.png");
			name = "Bowser Jr.";
		}
		
		else if (amiibo.index == 45)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/MrGameAndWatch.png");
			name = "Mr. Game & Watch";
		}
		
		else if (amiibo.index == 46)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/DuckHunt.png");
			name = "Duck Hunt";
		}
		
		else if (amiibo.index == 47)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Jigglypuff.png");
			name = "Jigglypuff";
		}
		
		else if (amiibo.index == 48)
		{
			imageIcon = new ImageIcon("src/resources/UI/Collection/Mewtwo.png");
			name = "Mewtwo";
		}

		index = amiibo.index + "";
		image = imageIcon.getImage();
	}
}
