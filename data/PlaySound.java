package data;
import java.applet.*;
import java.io.File;
import java.net.*;

public class PlaySound extends Applet
{
	AudioClip sound;
	String TallonOverworld = "src/resources/sound/music/Metroid - Tallon Overworld.wav";
	String MegaManII = "src/resources/sound/music/Mega Man II - Dr. Wily Stage 1.wav";
	String MegaManIII = "src/resources/sound/music/Mega Man III - Main.wav";
	String LegendOfZelda = "src/resources/sound/music/Legend Of Zelda - Main.wav";
	String ShakeItOff = "src/resources/sound/music/Shake It Off.wav";
	String PalletTown = "src/resources/sound/music/Pallet Town.wav";
	
	public void playSound()
	{
		sound.play();
	}
	
	public void menuToggle()
	{
	  try 
	  {
	     sound = Applet.newAudioClip(new File("src/resources/sound/UI/Menu Toggle.wav").toURI().toURL());
	  } 
	  catch (MalformedURLException murle) 
	  {
	  murle.printStackTrace();
	  } 
	}

	public void gameSelected()
	{
	  try 
	  {
	     sound = Applet.newAudioClip(new File("src/resources/sound/ui/Main Menu Selected.wav").toURI().toURL());
	  } 
	  catch (MalformedURLException murle) 
	  {
	  murle.printStackTrace();
	  } 
	}	
	
	public void dialogue()
	{
	  try 
	  {
	     sound = Applet.newAudioClip(new File("src/resources/sound/ui/Dialogue.wav").toURI().toURL());
	  } 
	  catch (MalformedURLException murle) 
	  {
	  murle.printStackTrace();
	  } 
	}	
	
	public void heal()
	{
	  try 
	  {
	     sound = Applet.newAudioClip(new File("src/resources/sound/ui/Heal.wav").toURI().toURL());
	  } 
	  catch (MalformedURLException murle) 
	  {
	  murle.printStackTrace();
	  } 
	}	
	
	public void startMenuSelected()
	{
	  try 
	  {
	     sound = Applet.newAudioClip(new File("src/resources/sound/UI/Start Menu Selected.wav").toURI().toURL());
	  } 
	  catch (MalformedURLException murle) 
	  {
	  murle.printStackTrace();
	  } 
	}	
	
	public void amiibo()
	{
	  try 
	  {
	     sound = Applet.newAudioClip(new File("src/resources/sound/Announcer/Amiibo.wav").toURI().toURL());
	  } 
	  catch (MalformedURLException murle) 
	  {
	  murle.printStackTrace();
	  } 
	}	
	
	public void bossBattle()
	{
	  try 
	  {
	     sound = Applet.newAudioClip(new File("src/resources/sound/Announcer/Boss Battle.wav").toURI().toURL());
	  } 
	  catch (MalformedURLException murle) 
	  {
	  murle.printStackTrace();
	  } 
	}	
	
	public void chooseYourFighter()
	{
	  try 
	  {
	     sound = Applet.newAudioClip(new File("src/resources/sound/Announcer/Choose Your Fighter.wav").toURI().toURL());
	  } 
	  catch (MalformedURLException murle) 
	  {
	  murle.printStackTrace();
	  } 
	}	
	
	public void playContinue()
	{
	  try 
	  {
	     sound = Applet.newAudioClip(new File("src/resources/sound/Announcer/Continue.wav").toURI().toURL());
	  } 
	  catch (MalformedURLException murle) 
	  {
	  murle.printStackTrace();
	  } 
	}	
	
	public void defeated()
	{
	  try 
	  {
	     sound = Applet.newAudioClip(new File("src/resources/sound/Announcer/Defeated.wav").toURI().toURL());
	  }
	  catch (MalformedURLException murle) 
	  {
	  murle.printStackTrace();
	  } 
	}	
	
	public void finalBattle()
	{
	  try 
	  {
	     sound = Applet.newAudioClip(new File("src/resources/sound/Announcer/Final Battle.wav").toURI().toURL());
	  } 
	  catch (MalformedURLException murle) 
	  {
	  murle.printStackTrace();
	  } 
	}	
	
	public void setSong(String type) throws MalformedURLException
	{
		if (type.equals("Tallon Overworld"))
		{
			try
			{
				sound = Applet.newAudioClip(new File(TallonOverworld).toURI().toURL());
				loopSound();
			} 
			catch (MalformedURLException murle) 
			{
				murle.printStackTrace();
			} 
		}
		
		else if (type.equals("MegaManII"))
		{
			try
			{
				sound = Applet.newAudioClip(new File(MegaManII).toURI().toURL());
		        loopSound(); 
			} 
			catch (MalformedURLException murle) 
			{
				murle.printStackTrace();
			} 
		}
		
		else if (type.equals("MegaManIII"))
		{
			try
			{
				sound = Applet.newAudioClip(new File(MegaManIII).toURI().toURL());
		        loopSound(); 
			} 
			catch (MalformedURLException murle) 
			{
				murle.printStackTrace();
			} 
		}
		
		else if (type.equals("Legend Of Zelda"))
		{
			try
			{
				sound = Applet.newAudioClip(new File(LegendOfZelda).toURI().toURL());
		        loopSound(); 
			} 
			catch (MalformedURLException murle) 
			{
				murle.printStackTrace();
			} 
		}
		
		else if (type.equals("Shake It Off"))
		{
			try
			{
				sound = Applet.newAudioClip(new File(ShakeItOff).toURI().toURL());
		        loopSound(); 
			} 
			catch (MalformedURLException murle) 
			{
				murle.printStackTrace();
			} 
		}
		
		else if (type.equals("Pallet Town"))
		{
			try
			{
				sound = Applet.newAudioClip(new File(PalletTown).toURI().toURL());
		        loopSound(); 
			} 
			catch (MalformedURLException murle) 
			{
				murle.printStackTrace();
			} 
		}
	}
	
	public void loopSound()
	{
		sound.loop();
	}
	
	public void stopSound()
	{
		sound.stop();
	}
}