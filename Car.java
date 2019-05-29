import java.awt.Color;
import java.awt.Graphics;

public class Car extends ColidableObject
{
	private Color color;
	private int speed;
	
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
	
	public void draw(Graphics window)
	{
		window.setColor(color);
		window.fillRect(getX(), getY(), getW(), getH());
	}
}
