
public abstract class ColidableObject 
{
  private int xPos;
  private int yPos;
  private int width;
  private int height;

  public ColidableObject()
  {
	this(0,0,10,10);
  }

  public ColidableObject(int x, int y)
  {
	this (x,y,10,10);
  }

  public ColidableObject(int x, int y, int w, int h)
  {
	xPos=x;
	yPos=y;
	width=w;
	height=h;
  }
  
  public void setPos(int x, int y)
  {
	xPos=x;
	yPos=y;
  }
  
  public void setY(int y)
  {
	yPos=y;
  }
  
  public void setX(int x)
  {
	xPos=x;
  }

  public int getX()
  {
	return xPos;
  }
  
  public int getY()
  {
	return yPos;
  }

  public void setSize(int w,int h)
  {
	width=w;
	height=h;
  }

  public int getW()
  {
	return width;
  }

  public int getH()
  {
	return height;
  }
  
  public boolean didCollideLeft(ColidableObject o)
  {
	  if(xPos <= o.xPos + o.width)
	  {
		  return true;
	  }
	  
	  return false;
  }
  
  public boolean didCollideRight(ColidableObject o)
  {
	  if(xPos + width >= o.xPos)
	  {
		  return true;
	  }
	  
	  return false;
  }
  
  public boolean didCollideTop(ColidableObject o)
  {
	  if(yPos <= o.yPos + o.height)
	  {
		  return true;
	  }
	  
	  return false;
  }
  
  public boolean didCollideBot(ColidableObject o)
  {
	  if(yPos + height >= o.yPos)
	  {
		  return true;
	  }
	  
	  return false;
  }
  
  public String toString()
  {
	return xPos+ " " +yPos + " " + width + " " + height;
  }
}
