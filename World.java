import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class World extends Canvas implements KeyListener, Runnable
{
  private ArrayList<Player> players;
  private boolean[] keys;
  private Player player;
  private Wall leftWall, rightWall, topWall, botWall;
  private BufferedImage back;
  private UserClient client;
  
  public void setClient(UserClient c) {
    System.out.println("CLIENT SET");
    client = c;
  }

  public World()
  {
	keys = new boolean[4];
	player = new Player(100,100, 50, 35, 3);
	leftWall = new Wall(0,0,10,700);
	rightWall = new Wall(990,0,10,700);
	topWall = new Wall(0,0,1000,10);
	botWall = new Wall(0,670,1000,10);
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
	  player.draw(graphToBack);
	  leftWall.draw(graphToBack);
	  rightWall.draw(graphToBack);
	  topWall.draw(graphToBack);
	  botWall.draw(graphToBack);
	  
	  if(keys[0] && !player.didCollideLeft(leftWall))
	  {
		  player.move("left");
		  player.draw(graphToBack);
	  }
	  
	  if(keys[1] && !player.didCollideRight(rightWall))
	  {
		  player.move("right");
		  player.draw(graphToBack);
	  }
	  
	  if(keys[2] && !player.didCollideTop(topWall))
	  {
		  player.move("up");
		  player.draw(graphToBack);
	  }
	  
	  //System.out.println("left " + player.didCollideLeft(leftWall));
	  
	  if(keys[3] && !player.didCollideBot(botWall))
	  {
		  player.move("down");
		  player.draw(graphToBack);
	  }
	  
	if (!(keys[0]||keys[1]||keys[2]||keys[3])){
		System.out.println("decel");
		player.decel();
		player.draw(graphToBack);
	}

	
	  client.draw();
	  twoDGraph.drawImage(back, null, 0, 0);
  }

  public void keyPressed(KeyEvent e)
  {

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

  public void keyTyped(KeyEvent e){  }

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
