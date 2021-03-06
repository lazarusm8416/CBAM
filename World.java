import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.KeyEvent;


public class World extends Canvas implements KeyListener, Runnable
{
  private boolean[] keys;
  private static Player player;
  private Wall leftWall, rightWall, topWall, botWall;
  private BufferedImage back;
  private UserClient client;
  private static int score;
  
  public void setClient(UserClient c) {
    System.out.println("CLIENT SET");
    client = c;
  }

  public World()
  {
	keys = new boolean[5];
	retrieveScore();
	player = new Player((int)(Math.random()*800),(int)(Math.random()*800), 25, 25, 1, null, score);
	leftWall = new Wall(0,0,10,700);
	rightWall = new Wall(990,0,10,700);
	topWall = new Wall(0,0,1000,10);
	botWall = new Wall(0,670,1000,10);
	this.addKeyListener(this);
    	new Thread(this).start();
  }
  
  public void saveScore()
  {
		try
		{
			FileOutputStream fos = new FileOutputStream("temp.out");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(score);
			oos.flush();
			oos.close();
			//System.out.println("yay : " + score);
		}
		
		catch(IOException ex) 
    		{ 
        		System.out.println("IOException is caught"); 
    		} 
  }
  
  public void retrieveScore()
  {
		try
		{
			FileInputStream fis = new FileInputStream("temp.out");
			ObjectInputStream oin = new ObjectInputStream(fis);
			score = (Integer) oin.readObject();
			System.out.println("recieved score");
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

  public void update(Graphics window)
  {
	  paint(window);
  }

  public void paint(Graphics window)
  {
	 if (!(client instanceof UserClient)) {
      		return;
    	  }
	  player.setClient(client);
	  Graphics2D twoDGraph = (Graphics2D)window;
	  if(back==null)
	  {
		 back = (BufferedImage)(createImage(getWidth(),getHeight()));
	  }      
	  Graphics graphToBack = back.createGraphics();

	  graphToBack.setColor(Color.WHITE);
	  graphToBack.fillRect(0,0,1000,700);
	  graphToBack.setColor(Color.BLACK);
	  graphToBack.drawString(client.getName()+" : " + score,50,50);
	  
	  if (!(client.getWindow() instanceof Graphics)) {
      		client.setWindow(graphToBack);
    	  }
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
	  
	  if(keys[3] && !player.didCollideBot(botWall))
	  {
		  player.move("down");
		  player.draw(graphToBack);
	  }
	  
	  if(keys[4])
	  {
		  score = 0;
		  player.setScore(0);
	  }
	  
	  if (!(keys[0]||keys[1]||keys[2]||keys[3])){
		  player.decel();
		  player.draw(graphToBack);
	  }
	
	  if(player.didCollideLeft(leftWall) || player.didCollideRight(rightWall) || player.didCollideTop(topWall) || player.didCollideBot(botWall))
	  {
		  if (player.didCollideLeft(leftWall))
			  player.bounce("right");
		  if (player.didCollideRight(rightWall))
			  player.bounce("left");
		  if (player.didCollideTop(topWall))
			  player.bounce("down");
		  if (player.didCollideBot(botWall))
			  player.bounce("up");
	  }
	  score = player.getScore();
	  saveScore();
	  
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
    if (e.getKeyCode() == KeyEvent.VK_R)
    {
      keys[4] = true;
    }
    repaint();
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
    if (e.getKeyCode() == KeyEvent.VK_R)
    {
      keys[4] = false;
    }
    repaint();
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
  
  public static Player getPlayer(){
  	return player;
  }
}
