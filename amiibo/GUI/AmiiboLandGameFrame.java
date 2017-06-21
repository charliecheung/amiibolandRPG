package amiibo.GUI;
import javax.swing.*;

import data.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.MalformedURLException;

/**
  * 
  * Last Updated: April 10th
  * This class contains the frame of the maze game. Will create a frame from the GUI component of the project.
  */
public class AmiiboLandGameFrame extends JFrame implements ActionListener
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// variables for the frame height and width.
    public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 786;
	SavedData savedData;

    /**
	  * Default constructor of the class. 
	  */
    public AmiiboLandGameFrame()
    {
    
    }
      
    /**
      * Constructor Method sets the Timer, adds the Timer to the Frame,
      * and sets the properties of the frame.
     * @throws MalformedURLException 
      */
	public AmiiboLandGameFrame(SavedData save, String level) throws MalformedURLException
    {
		String levelChoice = level;
	
		//creates and starts a new Timer
		Timer timer = new Timer(1000, this );
    	timer.start();
    	
    	
    	//adds the Timer to the JLabel located on the Frame
		//timerLabel = new JLabel("Timer:" + timer);
		//add(timerLabel,BorderLayout.SOUTH);
		try {
			add(new AmiiboLandGameMapGUI(save,levelChoice,timer));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Amiibo Land: Brian Came Out");
		setResizable(false);
		setVisible(true);
		// repaints the screen every 1000ms from the Timer
		repaint();
    }
	
	public AmiiboLandGameFrame(SavedData save, String level, int x, int y)
    {
		String levelChoice = level;
	
		//creates and starts a new Timer
		Timer timer = new Timer(1000, this );
    	timer.start();
    	
    	
    	//adds the Timer to the JLabel located on the Frame
		//timerLabel = new JLabel("Timer:" + timer);
		//add(timerLabel,BorderLayout.SOUTH);
		try {
			add(new AmiiboLandGameMapGUI(save,levelChoice,timer,x,y));
		} catch (FileNotFoundException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Amiibo Land: Brian Came Out");
		setResizable(false);
		setVisible(true);
		// repaints the screen every 1000ms from the Timer
		repaint();

    }
    	
    /**
      * Each time the timer repaints the frame, (every 100ms) this will be the execution. The 
      * count will increase by one, and the time will be written to a file to be saved.
      * This executes later in the program with ScoreScreen, when the time is needed
      * to be saved.
      */
    public void actionPerformed(ActionEvent e) 
	{
    	/*
		count++;
		timerLabel.setText("Count: " + count);
            File counter = new File ("counter.txt");
            
            //writing the count to text file
            try 
            {
                //if the file already exists, it is overridden
                if(counter.exists())
                {
                    counter.delete();
                }
                // the time score, is added to the file            
                PrintWriter timeCountScore = new PrintWriter ("counter.txt");
                timeCountScore.print(count);
                timeCountScore.close();
                             
            } 
            catch (FileNotFoundException fnfe) 
            {
                fnfe.printStackTrace();
            }  */     
	}
}