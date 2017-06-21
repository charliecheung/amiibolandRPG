package data;
import java.io.IOException;

import amiibo.GUI.*;

public class Driver 
{
	static String version = "0.33 Alpha";
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		MainMenu mainMenu = new MainMenu();
		mainMenu.initializeMenu();
	}
}
