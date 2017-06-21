package amiibo.GUI;
/**
 * This method will grab the appropriate image for the AmiiboLandGame Map for each element of the map and then returns the appropriate ImageIcon back.
 * Last Modified: January 27th, 2015
 * @author Andrew Dong
 *
 */

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.*;

import data.*;

public class AmiiboLandGameImageDecipher 
{
	// Theses are the instance variables for the class
	private Image returnedImage;
	
	/**
	 * Default Constructor does nothing
	 */
	public AmiiboLandGameImageDecipher()
	{
		
	}
	
	/**
	 * This method will take in a string as an argument and then return an image to the class calling it. The image returned will be based on what
	 * string is passed in for the method. Example if the class is called and the string "G1" is passed in then the method will returned the image that corresponds
	 * to G1
	 * @param imageInfo: This is the string that is passed in
	 * @return will return an image depending what string is passed in.
	 */
	public Image GetImage(String imageInfo)
	{
		String directory = "src/resources/textures/Overworld/" + imageInfo + ".png";
		ImageIcon img = new ImageIcon(directory);
		returnedImage = img.getImage();
		return returnedImage;
	}
	
}