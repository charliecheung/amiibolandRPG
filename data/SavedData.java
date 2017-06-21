package data;
import java.io.File;

import amiibo.GUI.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class SavedData 
{
	int linesOfSave = 7;
	private static Scanner inputStream = null;
	public Amiibo[] dataAmiibo = new Amiibo[49];
	public String[] savedGameFile = new String[linesOfSave];
	public Party party = new Party();
	String[] importedAmiibo = new String[17];
	String scannedAmiibo;
	Dialogue text;
	int tempX;
	int tempY;
	String singleLine = "";
	String[] line;
	String[] playerData= new String[2];
	public int linesOfItems = 1;
	public String[] savedItems = new String[linesOfItems];
	
	public String[] loadGame()
	{
		try
		{
			inputStream = new Scanner(new File("src/resources/saves/saveGame.txt"));
			for (int i = 0; i < linesOfSave; i++)
			{
				savedGameFile[i] = inputStream.nextLine();
			}
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Save File was not found");
			System.exit(0);
		}
		inputStream.close();
		loadAmiiboFile();
		loadItems();
		playerData = savedGameFile[0].split(",");
		return savedGameFile;
	}
	
	public void saveItems() throws FileNotFoundException, UnsupportedEncodingException
	{
		PrintWriter writer = new PrintWriter("src/resources/saves/item.txt", "UTF-8");
		int i = 0;
		while (i < linesOfItems)
		{
			writer.println(savedItems[i]);							//Write to file
			i++;
		}
		writer.close();
	}
	
	public void loadItems()
	{
		try
		{
			inputStream = new Scanner(new File("src/resources/saves/item.txt"));		//Grab saved file directory
			for (int i = 0; i < linesOfItems; i++)
			{
				String tempString = inputStream.nextLine();						//Get each line of saved file
				savedItems[i] = tempString;
			}
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Fresh Save file was not found");
			System.exit(0);
		}
	}
	
	public void newItems() throws FileNotFoundException, UnsupportedEncodingException
	{
		try
		{
			inputStream = new Scanner(new File("src/resources/saves/freshItem.txt"));		//Grab saved file directory
			for (int i = 0; i < linesOfItems; i++)
			{
				String tempString = inputStream.nextLine();						//Get each line of saved file
				savedItems[i] = tempString;
			}
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Fresh Save file was not found");
			System.exit(0);
		}
		System.out.println(savedItems[0] + "savedItems");
		saveItems();
	}
	
	public void saveGame() throws FileNotFoundException, UnsupportedEncodingException
	{
		saveParty();
		saveItems();
		PrintWriter writer = new PrintWriter("src/resources/saves/saveGame.txt", "UTF-8");
		int i = 0;
		while (i < linesOfSave)
		{
			writer.println(savedGameFile[i]);							//Write to file
			i++;
		}
		writer.close();
		
	}
	
	public void newGame(String name, String gender) throws FileNotFoundException, UnsupportedEncodingException
	{
		/*Fresh Amiibo Save*/
		try
		{
			inputStream = new Scanner(new File("src/resources/saves/freshSaveAmiibo.txt"));		//Grab saved file directory
			for (int i = 0; i < 49; i++)
			{
				String tempString = inputStream.nextLine();						//Get each line of saved file
				String[] splitTempString = tempString.split(",");				//Split by ','
				Amiibo tempAmiibo = new Amiibo(splitTempString);				//Create Amiibo using constructor
				dataAmiibo[i] = tempAmiibo;										//Store into array
			}
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Fresh Save file was not found");
			System.exit(0);
		}
		saveAmiiboFile();
		
		/*Fresh Save*/
		try
		{
			inputStream = new Scanner(new File("src/resources/saves/blankSave.txt"));
			for (int i = 0; i < linesOfSave; i++)
			{
				savedGameFile[i] = inputStream.nextLine();
			}
			savedGameFile[0] = name + "," + gender;
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Save File was not found");
			System.exit(0);
		}
		inputStream.close();
		
			PrintWriter writer = new PrintWriter("src/resources/saves/saveGame.txt", "UTF-8");
			int index = 0;
			while (index < linesOfSave)
			{
				writer.println(savedGameFile[index]);							//Write to file
				index++;
			}
			
			writer.close();
			newItems();
			loadGame();
	}
	
	public void setParty(Amiibo first, Amiibo second, Amiibo third)
	{
		if (first.equals(party.blankAmiibo) == false)
		{
			party = new Party(first);
			if (second.equals(party.blankAmiibo) == false)
			{
				party = new Party(first, second);
				if (third.equals(party.blankAmiibo) == false)
				{
					party = new Party(first, second, third);
				}
			}
		}
	}
	
	public int getObtainedNum()
	{
		int obtained = 0;
		for (int i = 0; i < 49; i++)
		{
			if (dataAmiibo[i].obtained == 1)
			{
				obtained++;
			}
		}
		
		return obtained;
	}
	
	public void resetToggle()
	{
		for (int i = 0; i < 49; i++)
		{
			dataAmiibo[i].toggleSelection = 0;
		}
	}
	
	public void loadParty()
	{
		String data = savedGameFile[3];
		String[] indexesString = data.split(",");
		int[] index = new int[3];
		index[0] = Integer.parseInt(indexesString[0]);
		index[1] = Integer.parseInt(indexesString[1]);
		index[2] = Integer.parseInt(indexesString[2]);
		
		if (index[0] != -1)
		{
			party = new Party(dataAmiibo[index[0]]);
			if (index[1] != -1)
			{
				party = new Party(dataAmiibo[index[0]], dataAmiibo[index[1]]);
				if (index[2] != -1)
				{
					party = new Party(dataAmiibo[index[0]], dataAmiibo[index[1]], dataAmiibo[index[2]]);
				}
			}
		}
	}
	
	public Amiibo[] loadAmiiboFile()
	{
		try
		{
			inputStream = new Scanner(new File("src/resources/saves/saveAmiibo.txt"));		//Grab saved file directory
			for (int i = 0; i < 49; i++)
			{
				String tempString = inputStream.nextLine();						//Get each line of saved file
				String[] splitTempString = tempString.split(",");				//Split by ','
				Amiibo tempAmiibo = new Amiibo(splitTempString);				//Create Amiibo using constructor
				dataAmiibo[i] = tempAmiibo;										//Store into array
			}
			loadParty();
			return dataAmiibo;
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Save file was not found");
			System.exit(0);
		}
		return dataAmiibo;
	}
	
	public void saveParty() throws FileNotFoundException, UnsupportedEncodingException
	{
		/*Get Party save line*/
		String[] partySave = savedGameFile[3].split(",");
		/*Save Party*/
		if (party.firstSlot.equals(party.blankAmiibo) == false)
		{
			dataAmiibo[party.firstSlot.index] = party.firstSlot;
			partySave[0] = "" + party.firstSlot.index;
		}
		else
		{
			partySave[0] = "-1";
		}
		
		if (party.secondSlot.equals(party.blankAmiibo) == false)
		{
			dataAmiibo[party.secondSlot.index] = party.secondSlot;
			partySave[1] = "" + party.secondSlot.index;
		}
		else
		{
			partySave[1] = "-1";
		}
		
		if (party.thirdSlot.equals(party.blankAmiibo) == false)
		{
			dataAmiibo[party.thirdSlot.index] = party.thirdSlot;
			partySave[2] = "" + party.thirdSlot.index;
		}
		else
		{
			partySave[2] = "-1";
		}
		savedGameFile[3] = partySave[0] + "," + partySave[1] + "," + partySave[2];
		saveAmiiboFile();
	}
	
	public void storeParty()
	{
		/*Save Party*/
		if (party.firstSlot.equals(party.blankAmiibo) == false)
		{
			dataAmiibo[party.firstSlot.index] = party.firstSlot;
		}
		
		if (party.secondSlot.equals(party.blankAmiibo) == false)
		{
			dataAmiibo[party.secondSlot.index] = party.secondSlot;
		}
		
		if (party.thirdSlot.equals(party.blankAmiibo) == false)
		{
			dataAmiibo[party.thirdSlot.index] = party.thirdSlot;
		}
	}
	
	public void saveAmiiboFile() throws FileNotFoundException, UnsupportedEncodingException
	{
		/*Save Amiibo File*/
		PrintWriter writer = new PrintWriter("src/resources/saves/saveAmiibo.txt", "UTF-8");
		int i = 0;
		while (i < 49)
		{
			writer.println(dataAmiibo[i].getString());							//Write to file
			i++;
		}
		writer.close();
	}
	
	public LinkedList readDialogue(String directory)
	{
		LinkedList linkedList = new LinkedList(null);
		try
		{
			inputStream = new Scanner(new File(directory));						//Grab saved file directory
			while (inputStream.hasNextLine())
			{
				text = new Dialogue(inputStream.nextLine(), null, null);
				linkedList.insert(text);
			}
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Text was not found");
			System.exit(0);
		}
	
		return linkedList;
	}
	
	public boolean scanAmiibo()
	{
		boolean scanned = false;
		try
		{
			File[] files;
			String user = System.getProperty("user.name");
			if (System.getProperty("os.name").toLowerCase().startsWith(("windows")))
			{
				//C:/Users/name/Google Drive
				File directory = new File("C:/Users/" + user + "/Google Drive");
				files = directory.listFiles();
				System.out.println("Success" + "\n Windows");
				System.out.println(directory);
			}
			else if (System.getProperty("os.name").toLowerCase().startsWith(("mac os x")))
			{
				//Untitled/Users/anthonydoan/Google Drive
				File directory = new File("/Users/" + user + "/Google Drive");
				files = directory.listFiles();
				System.out.println("Success" + "\n Mac");
				System.out.println(directory);
			}
			else
			{
				File directory = new File("src/Resources/XML/");					//Get all files
				files = directory.listFiles();
				System.out.println("Fail");
				System.out.println(directory);
			}
			
			for (int i = 0; i < files.length; i++)
			{
				if (((files[i].getPath().substring(files[i].getPath().length() - 3, files[i].getPath().length())).equals("xml")) || (files[i].getPath().substring(files[i].getPath().length() - 3, files[i].getPath().length()).equals("XML")))
				{
					System.out.println("Scanning: " + files[i].getPath());
					inputStream = new Scanner(new File(files[i].getPath()));
					for (int j = 0; j < 57; j++)
					{
						inputStream.nextLine();			
					}
					String[] identifiers = new String[2];
					identifiers[0] = inputStream.nextLine().substring(69, 77);		//Parse text
					identifiers[1] = inputStream.nextLine().substring(69, 77);		//Parse text
					
					for (int k = 0; k < 49; k++)
					{
						if ((dataAmiibo[k].identifierFirst.equals(identifiers[0])) && (dataAmiibo[k].identifierSecond.equals(identifiers[1])))
						{
							getAmiibo(k);
							scanned = true;
							k = 49;
						}
					}
				}
				else
				{
					System.out.println("Skipping file: " + files[i].getName());
				}
			}
	
			return scanned;
		}
		
		catch(FileNotFoundException e)
		{
			return scanned;
		}
		
		catch (NullPointerException e)
		{
			return scanned;
		}
	}

	public void getAmiibo(int index) throws FileNotFoundException
	{
		if (hasAmiibo(index) == false)
		{
			dataAmiibo[index].obtained = 1;
			party.add(dataAmiibo[index]);
		}
		else
		{
			System.out.println("You already have this Amiibo!");
		}
	}
	
	public boolean hasAmiibo(int index)
	{
		if (dataAmiibo[index].obtained == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
