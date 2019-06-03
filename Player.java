import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;

public class Player extends ColidableObject{

  private int speed;
  private Color color;
  private UserClient client;
  private Image image;
	
  public Player(){
	this(0,0,10,10,5);
	try{
		URL url = getClass().getResource("car.jpg");
	    image = ImageIO.read(url);
		}
		catch(Exception e){
		}
  }

  public Player (int x, int y){
	this (x,y,10,10,5);
	try{
		URL url = getClass().getResource("car.jpg");
	    image = ImageIO.read(url);
		}
		catch(Exception e){
		}
  }

  public Player (int x, int y, int s){
	this (x,y,10,10,s);
	try{
		URL url = getClass().getResource("car.jpg");
	    image = ImageIO.read(url);
		}
		catch(Exception e){
		}
  }
  
  public Player(int x, int y, int w, int h, int s){
	super(x,y,w,h);
	speed=s;
	color = rColor();
	try{
		URL url = getClass().getResource("car.jpg");
	    image = ImageIO.read(url);
		}
		catch(Exception e){
		}
  }

  public void setS(int s){
	speed = s;
  }
	
  public void setClient(UserClient client) {
    this.client = client;
  }
	
  public int getS(){
	return speed;
  }

  public Color rColor(){
	int r = (int)(Math.random()*255);
	int b = (int)(Math.random()*255);
	int g = (int)(Math.random()*255);
	return new Color(r,g,b);
  }

  public void bounce(String dir){
	decel();
	for (int i =0; i<10; i++){
		move(dir);
	}
  }
  public void bump(Player p){
	if (getY()==p.getY()+p.getH()){ //this top bounce
		if ( (getX() > p.getX() && getX() < p.getX()+p.getW()) || (getX()+getW() > p.getX() && getX()+getW() < p.getX()+p.getW()) ){
			bounce("down");
			p.bounce("up");
		}
	}

	if (getX()==p.getX()+p.getW()){ // this left bounce
		if ( (getY() > p.getY() && getY() < p.getY()+p.getH()) || (getY()+getH() > p.getY() && getY()+getH() < p.getY()+p.getH()) ){
			bounce("left");
			p.bounce("right");
		}
	}
  }
  public void move (String dir){
	if (dir.equals("up"))
		setY(getY()-speed);
	if (dir.equals("down"))
		setY(getY()+speed);
	if (dir.equals("left"))
		setX(getX()-speed);
	if (dir.equals("right"))
		setX(getX()+speed);
	setS(speed+1);
  }
  public void decel(){
	speed=5;
  }

  public void draw (Graphics window){
	window.setColor(color);
	window.drawImage(image,getX(),getY(),getW(),getH(),null);
  }
  
  
  public String toString(){
	return super.toString() + " " + speed + " " + color;
  }
}
