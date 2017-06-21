package enemy;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

import data.Amiibo;

class Enemy extends Amiibo
{
	
	Enemy(String[] amiiboData) 
	{
			super(amiiboData);
			// TODO Auto-generated constructor stub
	}
	Enemy()
	{
		
	}
	
	ImageIcon poseStand;
	ImageIcon posePrimary;
	ImageIcon poseSecondary;
	
	Image getPose()
	{
		return poseStand.getImage();
	}
	
	Image getPrimary()
	{
		return posePrimary.getImage();
	}
	
	Image getSecondary()
	{
		return poseSecondary.getImage();
	}
}
