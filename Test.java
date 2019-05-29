import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.awt.Component;
import javax.swing.JFrame;


class Test extends JFrame implements Serializable
{
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	
	public Test()
	{
		super("Persistance");
		setSize(WIDTH,HEIGHT);
		
		Persistance theGame = new Persistance();
	    ((Component)theGame).setFocusable(true);

	    getContentPane().add(theGame);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	}
	

	public static void main(String args[]) throws IOException
	{
		Test test = new Test();
	}
}