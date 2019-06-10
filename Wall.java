import java.awt.Color;
import java.awt.Graphics;

public class Wall extends ColidableObject
{
	public Wall(int x, int y, int w, int h)
	{
		super(x,y,w,h);
	}
	
	public void draw(Graphics window)
	{
		window.setColor(Color.WHITE);
		window.fillRect(getX(), getY(), getW(), getH());
	}
}
