import java.io.IOException;
import java.awt.Component;
import javax.swing.JFrame;


public class CBAM extends JFrame
{
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 700;
	
	public CBAM()
	{
		super("BAM Cars");
		setSize(WIDTH,HEIGHT);
		
		World theGame = new World();
	    ((Component)theGame).setFocusable(true);

	    getContentPane().add(theGame);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	}
	
	public static void main(String args[]) throws IOException
	{
		CBAM test = new CBAM();
	}
}
