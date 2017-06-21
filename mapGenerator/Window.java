package mapGenerator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Window extends JFrame implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String currentTile = "gA";
	String saveFile;
	boolean done = false;
	MapTile[][] map = new MapTile[40][24];
	JFrame frame = new JFrame("Enter Map Name:");

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String cmd = e.getActionCommand();
		if (cmd.length() > 3)
		{
			if (cmd.substring(0, 3).equals("SET"))
			{
				String[] temp = cmd.split(",");
				map[Integer.parseInt(temp[1])][Integer.parseInt(temp[2])].changeIcon(currentTile);
				System.out.println("Clicked, changed tile to: " + currentTile);
			}
			
			else if (cmd.equals("SAVE"))
			{
				//Save
				try {
					saveMap();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (cmd.equals("LOAD"))
			{
				//Load
				loadMap();
			}
			else if (cmd.equals("RESET"))
			{
				//Reset
				resetMap();
			}
			else
			{
				currentTile = cmd;
			}
		}

		else
		{
			currentTile = cmd;
		}
	}
	
	@SuppressWarnings("deprecation")
	public void initialize() throws IOException
	{
		//Initialize Window
		setTitle("Amiibo Land: Map Editor");
		setSize(1280, 960);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Initialize menu bar
		JMenuBar menuBar = new JMenuBar();
		//Initialize menu types
		JMenu tempMenu = new JMenu("Test");
		JMenu fileMenu = new JMenu("File");
		JMenu hospitalMenu = new JMenu("Hospital");
		JMenu protagonistMenu = new JMenu("Protagonist");
		JMenu npcHouseMenu = new JMenu("NPC House");
		JMenu treeMenu = new JMenu("Tree");
		JMenu landscapeMenu = new JMenu("Landscape");
		JMenu floorStoreMenu = new JMenu("FloorStore");
		JMenu rainforestMenu = new JMenu("Rainforest.ca");
		JMenu bullsEyeMenu = new JMenu("Bull's Eye");
		JMenu weRToysMenu = new JMenu("WeRToys");
		JMenu houseMenu = new JMenu("House");
		JMenu cityStreetMenu = new JMenu("CityStreet");
		JMenu hInteriorMenu = new JMenu("hInterior");
		menuBar.add(tempMenu);
		menuBar.add(fileMenu);
		menuBar.add(hospitalMenu);
		menuBar.add(protagonistMenu);
		menuBar.add(npcHouseMenu);
		menuBar.add(treeMenu);
		menuBar.add(landscapeMenu);
		menuBar.add(floorStoreMenu);
		menuBar.add(rainforestMenu);
		menuBar.add(bullsEyeMenu);
		menuBar.add(weRToysMenu);
		menuBar.add(houseMenu);
		menuBar.add(cityStreetMenu);
		menuBar.add(hInteriorMenu);
		menuBar.remove(0);
		setJMenuBar(menuBar);
		//Initialize Map Tile in Menu
		//File
		JMenuItem saveAction = new JMenuItem("Save");
		JMenuItem loadAction = new JMenuItem("Load");
		JMenuItem resetAction = new JMenuItem("Reset");
		saveAction.setActionCommand("SAVE");
		saveAction.addActionListener(this);
		loadAction.setActionCommand("LOAD");
		loadAction.addActionListener(this);
		resetAction.setActionCommand("RESET");
		resetAction.addActionListener(this);
		fileMenu.add(saveAction);
		fileMenu.add(loadAction);
		fileMenu.add(resetAction);
		//Hospital
		JMenuItem H00 = new JMenuItem("H00");
		JMenuItem H01 = new JMenuItem("H01");
		JMenuItem H02 = new JMenuItem("H02");
		JMenuItem H03 = new JMenuItem("H03");
		JMenuItem H04 = new JMenuItem("H04");
		JMenuItem H05 = new JMenuItem("H05");
		JMenuItem H06 = new JMenuItem("H06");
		JMenuItem H07 = new JMenuItem("H07");
		JMenuItem H08 = new JMenuItem("H08");
		JMenuItem H09 = new JMenuItem("H09");
		JMenuItem H10 = new JMenuItem("H10");
		JMenuItem H11 = new JMenuItem("H11");
		JMenuItem H12 = new JMenuItem("H12");
		JMenuItem H13 = new JMenuItem("H13");
		JMenuItem H14 = new JMenuItem("H14");
		JMenuItem H15 = new JMenuItem("H15");
		JMenuItem H16 = new JMenuItem("H16");
		JMenuItem H17 = new JMenuItem("H17");
		JMenuItem H18 = new JMenuItem("H18");
		JMenuItem H19 = new JMenuItem("H19");
		JMenuItem H20 = new JMenuItem("H20");
		JMenuItem H21 = new JMenuItem("H21");
		JMenuItem H22 = new JMenuItem("H22");
		JMenuItem H23 = new JMenuItem("H23");
		JMenuItem H24 = new JMenuItem("H24");
		JMenuItem H25 = new JMenuItem("H25");
		JMenuItem H26 = new JMenuItem("H26");
		JMenuItem H27 = new JMenuItem("H27");
		JMenuItem H28 = new JMenuItem("H28");
		JMenuItem H29 = new JMenuItem("H29");
		JMenuItem H30 = new JMenuItem("H30");
		JMenuItem H31 = new JMenuItem("H31");
		JMenuItem H32 = new JMenuItem("H32");
		JMenuItem H33 = new JMenuItem("H33");
		JMenuItem H34 = new JMenuItem("H34");
		JMenuItem H35 = new JMenuItem("H35");
		JMenuItem H36 = new JMenuItem("H36");
		JMenuItem H37 = new JMenuItem("H37");
		JMenuItem H38 = new JMenuItem("H38");
		JMenuItem H39 = new JMenuItem("H39");
		JMenuItem H40 = new JMenuItem("H40");
		JMenuItem H41 = new JMenuItem("H41");
		JMenuItem H42 = new JMenuItem("H42");
		JMenuItem H43 = new JMenuItem("H43");
		JMenuItem H44 = new JMenuItem("H44");
		JMenuItem H45 = new JMenuItem("H45");
		JMenuItem H46 = new JMenuItem("H46");
		H00.setActionCommand(H00.getLabel());
		H00.addActionListener(this);
		H01.setActionCommand(H01.getLabel());
		H01.addActionListener(this);
		H02.setActionCommand(H02.getLabel());
		H02.addActionListener(this);
		H03.setActionCommand(H03.getLabel());
		H03.addActionListener(this);
		H04.setActionCommand(H04.getLabel());
		H04.addActionListener(this);
		H05.setActionCommand(H05.getLabel());
		H05.addActionListener(this);
		H06.setActionCommand(H06.getLabel());
		H06.addActionListener(this);
		H10.setActionCommand(H10.getLabel());
		H10.addActionListener(this);
		H11.setActionCommand(H11.getLabel());
		H11.addActionListener(this);
		H12.setActionCommand(H12.getLabel());
		H12.addActionListener(this);
		H13.setActionCommand(H13.getLabel());
		H13.addActionListener(this);
		H14.setActionCommand(H14.getLabel());
		H14.addActionListener(this);
		H15.setActionCommand(H15.getLabel());
		H15.addActionListener(this);
		H16.setActionCommand(H16.getLabel());
		H16.addActionListener(this);
		H20.setActionCommand(H20.getLabel());
		H20.addActionListener(this);
		H21.setActionCommand(H21.getLabel());
		H21.addActionListener(this);
		H22.setActionCommand(H22.getLabel());
		H22.addActionListener(this);
		H23.setActionCommand(H23.getLabel());
		H23.addActionListener(this);
		H24.setActionCommand(H24.getLabel());
		H24.addActionListener(this);
		H25.setActionCommand(H25.getLabel());
		H25.addActionListener(this);
		H26.setActionCommand(H26.getLabel());
		H26.addActionListener(this);
		H30.setActionCommand(H30.getLabel());
		H30.addActionListener(this);
		H31.setActionCommand(H31.getLabel());
		H31.addActionListener(this);
		H32.setActionCommand(H32.getLabel());
		H32.addActionListener(this);
		H33.setActionCommand(H33.getLabel());
		H33.addActionListener(this);
		H34.setActionCommand(H34.getLabel());
		H34.addActionListener(this);
		H35.setActionCommand(H35.getLabel());
		H35.addActionListener(this);
		H36.setActionCommand(H36.getLabel());
		H36.addActionListener(this);
		H40.setActionCommand(H40.getLabel());
		H40.addActionListener(this);
		H41.setActionCommand(H41.getLabel());
		H41.addActionListener(this);
		H42.setActionCommand(H42.getLabel());
		H42.addActionListener(this);
		H43.setActionCommand(H43.getLabel());
		H43.addActionListener(this);
		H44.setActionCommand(H44.getLabel());
		H44.addActionListener(this);
		H45.setActionCommand(H45.getLabel());
		H45.addActionListener(this);
		H46.setActionCommand(H46.getLabel());
		H46.addActionListener(this);
		hospitalMenu.add(H00);
		hospitalMenu.add(H01);
		hospitalMenu.add(H02);
		hospitalMenu.add(H03);
		hospitalMenu.add(H04);
		hospitalMenu.add(H05);
		hospitalMenu.add(H06);
		hospitalMenu.add(H10);
		hospitalMenu.add(H11);
		hospitalMenu.add(H12);
		hospitalMenu.add(H13);
		hospitalMenu.add(H14);
		hospitalMenu.add(H15);
		hospitalMenu.add(H16);
		hospitalMenu.add(H20);
		hospitalMenu.add(H21);
		hospitalMenu.add(H22);
		hospitalMenu.add(H23);
		hospitalMenu.add(H24);
		hospitalMenu.add(H25);
		hospitalMenu.add(H26);
		hospitalMenu.add(H30);
		hospitalMenu.add(H31);
		hospitalMenu.add(H32);
		hospitalMenu.add(H33);
		hospitalMenu.add(H34);
		hospitalMenu.add(H35);
		hospitalMenu.add(H36);
		hospitalMenu.add(H40);
		hospitalMenu.add(H41);
		hospitalMenu.add(H42);
		hospitalMenu.add(H43);
		hospitalMenu.add(H44);
		hospitalMenu.add(H45);
		hospitalMenu.add(H46);
		//Protagonist
		JMenuItem PH00 = new JMenuItem("PH00");
		JMenuItem PH01 = new JMenuItem("PH01");
		JMenuItem PH02 = new JMenuItem("PH02");
		JMenuItem PH10 = new JMenuItem("PH10");
		JMenuItem PH11 = new JMenuItem("PH11");
		JMenuItem PH12 = new JMenuItem("PH12");
		JMenuItem PH20 = new JMenuItem("PH20");
		JMenuItem PH21 = new JMenuItem("PH21");
		JMenuItem PH22 = new JMenuItem("PH22");
		PH00.setActionCommand(PH00.getLabel());
		PH00.addActionListener(this);
		PH01.setActionCommand(PH01.getLabel());
		PH01.addActionListener(this);
		PH02.setActionCommand(PH02.getLabel());
		PH02.addActionListener(this);
		PH10.setActionCommand(PH10.getLabel());
		PH10.addActionListener(this);
		PH11.setActionCommand(PH11.getLabel());
		PH11.addActionListener(this);
		PH12.setActionCommand(PH12.getLabel());
		PH12.addActionListener(this);
		PH20.setActionCommand(PH20.getLabel());
		PH20.addActionListener(this);
		PH21.setActionCommand(PH21.getLabel());
		PH21.addActionListener(this);
		PH22.setActionCommand(PH22.getLabel());
		PH22.addActionListener(this);
		protagonistMenu.add(PH00);
		protagonistMenu.add(PH01);
		protagonistMenu.add(PH02);
		protagonistMenu.add(PH10);
		protagonistMenu.add(PH11);
		protagonistMenu.add(PH12);
		protagonistMenu.add(PH20);
		protagonistMenu.add(PH21);
		protagonistMenu.add(PH22);
		//NPC
		JMenuItem NPCH00 = new JMenuItem("NPCH00");
		JMenuItem NPCH01 = new JMenuItem("NPCH01");
		JMenuItem NPCH02 = new JMenuItem("NPCH02");
		JMenuItem NPCH10 = new JMenuItem("NPCH10");
		JMenuItem NPCH11 = new JMenuItem("NPCH11");
		JMenuItem NPCH12 = new JMenuItem("NPCH12");
		JMenuItem NPCH20 = new JMenuItem("NPCH20");
		JMenuItem NPCH21 = new JMenuItem("NPCH21");
		JMenuItem NPCH22 = new JMenuItem("NPCH22");
		NPCH00.setActionCommand(NPCH00.getLabel());
		NPCH00.addActionListener(this);
		NPCH01.setActionCommand(NPCH01.getLabel());
		NPCH01.addActionListener(this);
		NPCH02.setActionCommand(NPCH02.getLabel());
		NPCH02.addActionListener(this);
		NPCH10.setActionCommand(NPCH10.getLabel());
		NPCH10.addActionListener(this);
		NPCH11.setActionCommand(NPCH11.getLabel());
		NPCH11.addActionListener(this);
		NPCH12.setActionCommand(NPCH12.getLabel());
		NPCH12.addActionListener(this);
		NPCH20.setActionCommand(NPCH20.getLabel());
		NPCH20.addActionListener(this);
		NPCH21.setActionCommand(NPCH21.getLabel());
		NPCH21.addActionListener(this);
		NPCH22.setActionCommand(NPCH22.getLabel());
		NPCH22.addActionListener(this);
		npcHouseMenu.add(NPCH00);
		npcHouseMenu.add(NPCH01);
		npcHouseMenu.add(NPCH02);
		npcHouseMenu.add(NPCH10);
		npcHouseMenu.add(NPCH11);
		npcHouseMenu.add(NPCH12);
		npcHouseMenu.add(NPCH20);
		npcHouseMenu.add(NPCH21);
		npcHouseMenu.add(NPCH22);
		//Tree
		JMenuItem tA00 = new JMenuItem("tA00");
		JMenuItem tA01 = new JMenuItem("tA01");
		JMenuItem tA10 = new JMenuItem("tA10");
		JMenuItem tA11 = new JMenuItem("tA11");
		JMenuItem tA20 = new JMenuItem("tA20");
		JMenuItem tA21 = new JMenuItem("tA21");
		tA00.setActionCommand(tA00.getLabel());
		tA00.addActionListener(this);
		tA01.setActionCommand(tA01.getLabel());
		tA01.addActionListener(this);
		tA10.setActionCommand(tA10.getLabel());
		tA10.addActionListener(this);
		tA11.setActionCommand(tA11.getLabel());
		tA11.addActionListener(this);
		tA20.setActionCommand(tA20.getLabel());
		tA20.addActionListener(this);
		tA21.setActionCommand(tA21.getLabel());
		tA21.addActionListener(this);
		treeMenu.add(tA00);
		treeMenu.add(tA01);
		treeMenu.add(tA10);
		treeMenu.add(tA11);
		treeMenu.add(tA20);
		treeMenu.add(tA21);
		//Landscape
		JMenuItem bPink = new JMenuItem("bPink");
		JMenuItem bPurple = new JMenuItem("bPurple");
		JMenuItem bWhite = new JMenuItem("bWhite");
		JMenuItem cA = new JMenuItem("cA");
		JMenuItem cB = new JMenuItem("cB");
		JMenuItem cC = new JMenuItem("cC");
		JMenuItem cD = new JMenuItem("cD");
		JMenuItem cCBL = new JMenuItem("cCBL");
		JMenuItem cCBR = new JMenuItem("cCBR");
		JMenuItem cCTL = new JMenuItem("cCTL");
		JMenuItem cCTR = new JMenuItem("cCTR");
		JMenuItem fA = new JMenuItem("fA");
		JMenuItem fB = new JMenuItem("fB");
		JMenuItem fC = new JMenuItem("fC");
		JMenuItem fD = new JMenuItem("fD");
		JMenuItem faB = new JMenuItem("faB");
		JMenuItem faS = new JMenuItem("faS");
		JMenuItem gA = new JMenuItem("gA");
		JMenuItem gWB = new JMenuItem("gWB");
		JMenuItem gWF = new JMenuItem("gWF");
		JMenuItem gWM = new JMenuItem("gWM");
		JMenuItem gWP = new JMenuItem("gWP");
		JMenuItem gWS = new JMenuItem("gWS");
		JMenuItem mB = new JMenuItem("mB");
		JMenuItem n = new JMenuItem("n");
		JMenuItem pA = new JMenuItem("pA");
		JMenuItem pB = new JMenuItem("pB");
		JMenuItem pC = new JMenuItem("pC");
		JMenuItem p = new JMenuItem("p");
		JMenuItem sh = new JMenuItem("sh");
		JMenuItem tG = new JMenuItem("tG");
		JMenuItem tGWB = new JMenuItem("tGWB");
		JMenuItem tGWBP = new JMenuItem("tGWBP");
		JMenuItem tGWS = new JMenuItem("tGWS");
		JMenuItem wD = new JMenuItem("wD");
		JMenuItem wL = new JMenuItem("wL");
		JMenuItem sand = new JMenuItem("sand");
		bPink.setActionCommand(bPink.getLabel());
		bPink.addActionListener(this);
		bPurple.setActionCommand(bPurple.getLabel());
		bPurple.addActionListener(this);
		bWhite.setActionCommand(bWhite.getLabel());
		bWhite.addActionListener(this);
		cA.setActionCommand(cA.getLabel());
		cA.addActionListener(this);
		cB.setActionCommand(cB.getLabel());
		cB.addActionListener(this);
		cC.setActionCommand(cC.getLabel());
		cC.addActionListener(this);
		cD.setActionCommand(cD.getLabel());
		cD.addActionListener(this);
		cCBL.setActionCommand(cCBL.getLabel());
		cCBL.addActionListener(this);
		cCBR.setActionCommand(cCBR.getLabel());
		cCBR.addActionListener(this);
		cCTL.setActionCommand(cCTL.getLabel());
		cCTL.addActionListener(this);
		cCTR.setActionCommand(cCTR.getLabel());
		cCTR.addActionListener(this);
		fA.setActionCommand(fA.getLabel());
		fA.addActionListener(this);
		fB.setActionCommand(fB.getLabel());
		fB.addActionListener(this);
		fC.setActionCommand(fC.getLabel());
		fC.addActionListener(this);
		fD.setActionCommand(fD.getLabel());
		fD.addActionListener(this);
		faB.setActionCommand(faB.getLabel());
		faB.addActionListener(this);
		faS.setActionCommand(faS.getLabel());
		faS.addActionListener(this);
		gA.setActionCommand(gA.getLabel());
		gA.addActionListener(this);
		gWB.setActionCommand(gWB.getLabel());
		gWB.addActionListener(this);
		gWB.setActionCommand(gWF.getLabel());
		gWB.addActionListener(this);
		gWM.setActionCommand(gWM.getLabel());
		gWM.addActionListener(this);
		gWP.setActionCommand(gWP.getLabel());
		gWP.addActionListener(this);
		gWS.setActionCommand(gWS.getLabel());
		gWS.addActionListener(this);
		mB.setActionCommand(mB.getLabel());
		mB.addActionListener(this);
		n.setActionCommand(n.getLabel());
		n.addActionListener(this);
		pA.setActionCommand(pA.getLabel());
		pA.addActionListener(this);
		pB.setActionCommand(pB.getLabel());
		pB.addActionListener(this);
		pC.setActionCommand(pC.getLabel());
		pC.addActionListener(this);
		p.setActionCommand(p.getLabel());
		p.addActionListener(this);
		sh.setActionCommand(sh.getLabel());
		sh.addActionListener(this);
		tG.setActionCommand(tG.getLabel());
		tG.addActionListener(this);
		tGWB.setActionCommand(tGWB.getLabel());
		tGWB.addActionListener(this);
		tGWBP.setActionCommand(tGWBP.getLabel());
		tGWBP.addActionListener(this);
		tGWS.setActionCommand(tGWS.getLabel());
		tGWS.addActionListener(this);
		wD.setActionCommand(wD.getLabel());
		wD.addActionListener(this);
		wL.setActionCommand(wL.getLabel());
		wL.addActionListener(this);
		sand.setActionCommand(sand.getLabel());
		sand.addActionListener(this);
		landscapeMenu.add(bPink);
		landscapeMenu.add(bPurple);
		landscapeMenu.add(bWhite);
		landscapeMenu.add(cA);
		landscapeMenu.add(cB);
		landscapeMenu.add(cC);
		landscapeMenu.add(cD);
		landscapeMenu.add(cCBL);
		landscapeMenu.add(cCBR);
		landscapeMenu.add(cCTL);
		landscapeMenu.add(cCTR);
		landscapeMenu.add(fA);
		landscapeMenu.add(fB);
		landscapeMenu.add(fC);
		landscapeMenu.add(fD);
		landscapeMenu.add(faB);
		landscapeMenu.add(faS);
		landscapeMenu.add(gA);
		landscapeMenu.add(gWB);
		landscapeMenu.add(gWF);
		landscapeMenu.add(gWM);
		landscapeMenu.add(gWP);
		landscapeMenu.add(gWS);
		landscapeMenu.add(mB);
		landscapeMenu.add(n);
		landscapeMenu.add(pA);
		landscapeMenu.add(pB);
		landscapeMenu.add(pC);
		landscapeMenu.add(p);
		landscapeMenu.add(sh);
		landscapeMenu.add(tG);
		landscapeMenu.add(tGWB);
		landscapeMenu.add(tGWBP);
		landscapeMenu.add(tGWS);
		landscapeMenu.add(wD);
		landscapeMenu.add(wL);
		landscapeMenu.add(sand);
		
		menuBar.revalidate();
		System.out.println("Loaded Menu");

		//Initialize blank map
		for (int i = 0; i < 40; i++)
		{
			for (int j = 0; j < 24; j++)
			{
				map[i][j] = new MapTile(currentTile, i, j);
				map[i][j].setActionCommand("SET" + "," + i + "," + j);
				map[i][j].addActionListener(this);
				add(map[i][j]);
			}
		}
		resetMap();
		System.out.println("Loaded Blank Map");
	}
	
	public void saveMap() throws IOException
	{
		saveFile = JOptionPane.showInputDialog("Enter Map Name") + ".txt";
		File f = new File("src/resources/maps/" + saveFile);
		if (!f.getParentFile().exists())
		    f.getParentFile().mkdirs();
		if (!f.exists())
		    f.createNewFile();
		
		PrintWriter writer = new PrintWriter("src/resources/maps/" + saveFile, "UTF-8");
		for (int j = 0; j < 24; j++)
		{
			for (int i = 0; i < 40; i++)
			{
				writer.print(map[i][j].label + " ");
			}
			writer.println("");
		}
		writer.close();
		System.out.println("Map Saved!");
	}
	
	public void loadMap()
	{
		Scanner file = null;
		try
		{
			saveFile = JOptionPane.showInputDialog("Enter Map Name") + ".txt";
			file = new Scanner(new File("src/resources/maps/" + saveFile));
			for (int j = 0; j < 24; j++)
			{
				String currentLine = file.nextLine();
				String[] currentLineSplit = currentLine.split(" ");
				System.out.println(currentLine);
				for (int i = 0; i < 40; i++)
				{
					map[i][j].changeIcon(currentLineSplit[i]);
				}
			}
			System.out.println("Map was loaded!");
			file.close();
		}
		
		catch (NullPointerException e)
		{
			System.out.println("Save File was not found");
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Save File was not found");
		}
	}
	
	public void resetMap()
	{
		currentTile = "gA";
		for (int i = 0; i < 40; i++)
		{
			for (int j = 0; j < 24; j++)
			{
				map[i][j].changeIcon(currentTile);
			}
		}
		
		System.out.println("Map Reset");
	}

}
