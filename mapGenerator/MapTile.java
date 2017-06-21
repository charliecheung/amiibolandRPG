package mapGenerator;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MapTile extends JButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6207219844660934377L;
	public String label;
	public int x;
	public int y;
	public ImageIcon image;
	
	public MapTile(String label, int x, int y)
	{
		this.label = label;
		this.x = 32 * x;
		this.y = 32 * y;
		String directory = "src/resources/textures/overworld/" + label + ".png";
		image = new ImageIcon(directory);
		setIcon(image);
		setSize(32, 32);
		setLocation(this.x, this.y);
		setVisible(true);
		revalidate();
	}
	
	public void changeIcon(String label)
	{
		this.label = label;
		String directory = "src/resources/textures/overworld/" + label + ".png";
		image = new ImageIcon(directory);
		setIcon(image);
		setSize(32, 32);
		setLocation(this.x, this.y);
		setVisible(true);
		revalidate();
	}
}
