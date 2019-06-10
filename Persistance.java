import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;

class Persistance extends Canvas implements KeyListener, Runnable
{
	private boolean[] key;
	private int num;
	private BufferedImage back;
			
	public Persistance()
	{
		key = new boolean[2];
		retrieve();
		this.addKeyListener(this);
	    	new Thread(this).start();
	}
	
	public void update(Graphics window)
	{
		paint(window);
	}
	
	public void save(int n)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("temp.out");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(n);
			oos.flush();
			oos.close();
			System.out.println("yay" + n);
		}
		
		catch(IOException ex) 
        	{ 
            		System.out.println("IOException is caught"); 
        	} 
	}
	
	public void retrieve()
	{
		try
		{
			FileInputStream fis = new FileInputStream("temp.out");
			ObjectInputStream oin = new ObjectInputStream(fis);
			num = (Integer) oin.readObject();
			System.out.println("recieved");
		}
		
		catch(IOException ex) 
        	{ 
            		System.out.println("IOException is caught"); 
        	} 
		
		catch(ClassNotFoundException ex) 
        	{ 
            		System.out.println("ClassNotFoundException is caught"); 
        	} 
	}
	
	public void paint(Graphics window)
	{
		Graphics2D twoDGraph = (Graphics2D)window;
		if(back==null)
		{
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));
		}      
		Graphics graphToBack = back.createGraphics();
		graphToBack.setColor(Color.RED);
		graphToBack.drawString(""+num, 100,100);
		if(key[0])
		{
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString(""+num, 100,100);
			num++;
			save(num);
			graphToBack.setColor(Color.RED);
			graphToBack.drawString(""+num, 100,100);
		}
		
		if(key[1])
		{
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString(""+num, 100,100);
			num = 0;
			save(num);
			graphToBack.setColor(Color.RED);
			graphToBack.drawString(""+num, 100,100);
		}
		twoDGraph.drawImage(back, null, 0, 0);
		
	}
	
	public int getNum()
	{
		return num;
	}
	
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
		  key[0] = true;
		}
		    
		if (e.getKeyCode() == KeyEvent.VK_R)
		{
		  key[1] = true;
		}

	        repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
		  key[0] = false;
		}
		  
		if (e.getKeyCode() == KeyEvent.VK_R)
		{
		  key[1] = false;
		}
		  
	    	repaint();
	}

	public void keyTyped(KeyEvent e)
	{
	    //no code needed here
	}

	public void run()
	{
	  try
	  {
	    while(true)
	    {
	      Thread.currentThread().sleep(5);
	      repaint();
	    }
	  }catch(Exception e)
	  {
	  }
	}
}
