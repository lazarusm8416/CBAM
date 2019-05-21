
import java.awt.Color;
import java.awt.Graphics;

public abstract class ColidableObject {
  private int xPos;
  private int yPos;
  private int width;
  private int height;

  public ColidableObject(){
	this(0,0,10,10);
  }

  public ColidableObject(int x, int y, int w, int h){
	xPos=x;
	yPos=y;
	width=w;
	height=h;
  }
}
