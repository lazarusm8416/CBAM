import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;


public class Car extends ColidableObject
{
	private Color color;
	private int speed;
	private UserClient client;
	private Image image;
	
	//still kept the methods with the colors
	public Car(int x, int y, int s, Color c)
	{
		super(x,y);
		speed = s;
		color = c;
	}
	
	public Car(int x, int y, int w, int h, Color c)
	{
		super(x,y,w,h);
		color = c;
	}
	public Car(int x, int y, int w, int h, int s, Color c)
	{
		super(x,y,w,h);
		speed = s;
		color = c;
	}
	
//<<<<<<< HEAD
	public Car(int x, int y, int s)
	{
		super(x,y);
		speed = s;
		//color = c;
		//this.client = client;
		try{
			URL url = getClass().getResource("car.jpg");
		    image = ImageIO.read(url);
    		}
    		catch(Exception e){
    		}
	}
	public Car(int x, int y, int w, int h, int s)
	{
		super(x,y, w,h);
		speed = s;
		//color = c;
		//this.client = client;
		try{
			URL url = getClass().getResource("car.jpg");
		    image = ImageIO.read(url);
    		}
    		catch(Exception e){
    		}
	}
	
	public void setClient(UserClient client) {
    		this.client = client;
  	}
	
	public void move(String d)
	{
		if(d.equals("left"))
		{
			setX(getX() - speed);
		}
		
		else if(d.equals("right"))
		{
			setX(getX() + speed);
		}
		
		else if(d.equals("up"))
		{
			setY(getY() - speed);
		}
		
		else if(d.equals("down"))
		{
			setY(getY() + speed);
		}
	}
	/*
	public void draw(Graphics window)
	{
		window.setColor(color);
		window.fillRect(getX(), getY(), getW(), getH());
	}
	
	*/
	public void draw( Graphics window ){
	    window.drawImage(image,getX(),getY(),getW(),getH(),null);
	  }
	/*
	public void draw(Graphics window, int x, int y)
	{
		setX(x);
		setY(y);
		window.setColor(color);
		window.fillRect(getX(), getY(), getW(), getH());
	}
	*/
}
