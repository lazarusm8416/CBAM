
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
	  if(  (yPos>o.getY()&&yPos<o.getY()+o.getH()) || (yPos+height>o.getY()&&yPos+height<o.getY()+o.getH()) )//heac on collision in y axis.
	  {
		if ( xPos+width>=o.getX() ) // left side touchie.
		{
		  System.out.println("collide left" +o.toString());
		  return true;
		}
	  }
	 //System.out.println("collide left");
	  return false;
  }
  
  public boolean didCollideRight(ColidableObject o)
  {
	  if(  (yPos>o.getY()&&yPos<o.getY()+o.getH()) || (yPos+height>o.getY()&&yPos+height<o.getY()+o.getH())  )
	  {
		if ( xPos<=o.getX()+o.getW() )
		{
		  System.out.println("collide right" + o.toString());
		  return true;
		}
	  }
	  //System.out.println("collide right");
	  return false;
  }
  
  public boolean didCollideTop(ColidableObject o)
  {
	  if(  (xPos>o.getX()&&xPos<o.getX()+o.getW()) || (xPos+width>o.getX()&&xPos+width<o.getX()+o.getW())  )
	  {
		if (  yPos<=o.getY()+o.getH() )
		{
		  System.out.println("collide top" + o.toString());
		  return true;
		}
	  }
	  //System.out.println("collide top");
	  return false;
  }
  
  public boolean didCollideBot(ColidableObject o)
  {
	  if(  (xPos>o.getX()&&xPos<o.getX()+o.getW()) || (xPos+width>o.getX()&&xPos+width<o.getX()+o.getW())  )
	  {
		if (yPos>=o.getY()+o.getH())
		{
		  System.out.println("collide bottom" + o.toString());
		  return true;
		}
	  }
	  //System.out.println("collide bottom");
	  return false;
  }
  
  public String toString()
  {
	return xPos+ " " +yPos + " " + width + " " + height;
  }
}
