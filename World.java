import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class World extends Canvas implements KeyListener, Runnable{
  
  private ArrayList<Player> players;
  private boolean[] keys;
  private Car car;
  private BufferedImage back;

  public World()
  {
	keys = new boolean[4];
	//car = new Car(100,100, 3, Color.MAGENTA);
	car = new Car(100,100,50,35,3);
	this.addKeyListener(this);
    new Thread(this).start();
  }

  public void update(Graphics window)
  {
	  paint(window);
  }

  public void paint(Graphics window)
  {
	  Graphics2D twoDGraph = (Graphics2D)window;
	  if(back==null)
	  {
		 back = (BufferedImage)(createImage(getWidth(),getHeight()));
	  }      
	  Graphics graphToBack = back.createGraphics();
	  
	  graphToBack.setColor(Color.WHITE);
	  graphToBack.fillRect(0,0,1000,700);
	  car.draw(graphToBack);
	  
	  if(keys[0])
	  {
		  car.move("left");
		  car.draw(graphToBack);
	  }
	  
	  if(keys[1])
	  {
		  car.move("right");
		  car.draw(graphToBack);
	  }
	  
	  if(keys[2])
	  {
		  car.move("up");
		  car.draw(graphToBack);
	  }
	  
	  if(keys[3])
	  {
		  car.move("down");
		  car.draw(graphToBack);
	  }
	  
	  twoDGraph.drawImage(back, null, 0, 0);
  }

  public void keyPressed(KeyEvent e){


    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[0] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[1] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[2] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[3] = true;
    }
  }

  public void keyReleased(KeyEvent e){

   if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[0] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[1] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[2] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[3] = false;
    }
  }

  public void keyTyped(KeyEvent e){}

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
