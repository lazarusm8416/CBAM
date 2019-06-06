import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class Player extends ColidableObject{

  private int speed;
  private Color color;
  private UserClient client;
  private Image image;
  private int lilS;
  private String direction;

	
  public Player(){
	this(0,0,10,10,1,null);
	try{
		URL url = getClass().getResource("car.jpg");
	    image = ImageIO.read(url);
		}
		catch(Exception e){
		}
  }


  public Player (int x, int y){

	this (x,y,10,10,1,null);
	try{
		URL url = getClass().getResource("car.jpg");
	    image = ImageIO.read(url);
		}
		catch(Exception e){
		}
  }

  public Player (int x, int y, int s){
	this (x,y,10,10,s,null);
	try{
		URL url = getClass().getResource("car.jpg");
	    image = ImageIO.read(url);
		}
		catch(Exception e){
		}
  }
  
  public Player(int x, int y, int w, int h, int s, UserClient client)
  {
	super(x,y,w,h);
	speed=s;
	this.client = client;
	lilS=0;
	color = rColor();
	try{
		URL url = getClass().getResource("car.jpg");
	    image = ImageIO.read(url);
		}
		catch(Exception e){
		}
  }

  public void setS(int s)
  {
	speed = s;
  }
	
  public void setClient(UserClient client)
  {
    this.client = client;
  }
	
  public int getS()
  {
	return speed;
  }
  


  public Color rColor()
  {
	int r = (int)(Math.random()*255);
	int b = (int)(Math.random()*255);
	int g = (int)(Math.random()*255);
	return new Color(r,g,b);
  }

  public void bounce(String dir)
  {
	decel();
	for (int i =0; i<25; i++){
		move(dir);
	}
  }

  public void bump(Player p){
	if (didCollideLeft(p)){
		bounce("right");
		p.bounce("left");
	}
	if (didCollideRight(p)){
		bounce("left");
		p.bounce("right");
	}
	if(didCollideTop(p)){
		bounce("down");
		p.bounce("up");
	if (didCollideBot(p)){
		bounce("up");
		p.bounce("down");
	}


	/*if (getY()==p.getY()+p.getH()){ //this top bounce
		if ( (getX() > p.getX() && getX() < p.getX()+p.getW()) || (getX()+getW() > p.getX() && getX()+getW() < p.getX()+p.getW()) ){
			bounce("down");
			System.out.println("hit top");
			p.bounce("up");
		}
	}

	if (getX()==p.getX()+p.getW()){ // this left bounce
		if ( (getY() > p.getY() && getY() < p.getY()+p.getH()) || (getY()+getH() > p.getY() && getY()+getH() < p.getY()+p.getH()) ){
			bounce("right");
			System.out.println("hit left");
			p.bounce("left");
		}
	}

	if (getX()+getW()==p.getX()){//hits right
		if ( (getY() > p.getY() && getY() < p.getY()+p.getH()) || (getY()+getH() > p.getY() && getY()+getH() < p.getY()+p.getH()) ){
			bounce("left");
			System.out.println("hit right");
			p.bounce("right");
		}
	}

	if (getY()+getH() == p.getY()){//hits bot
		if ( (getX() > p.getX() && getX() < p.getX()+p.getW()) || (getX()+getW() > p.getX() && getX()+getW() < p.getX()+p.getW()) ){
			bounce("up");
			System.out.println("hit bot");
			p.bounce("down");
		}
	}*/
  }
  }

  public void move (String dir){
	direction = dir;
	if (dir.equals("up"))
		setY(getY()-speed);
	if (dir.equals("down"))
		setY(getY()+speed);
	if (dir.equals("left"))
		setX(getX()-speed);
	if (dir.equals("right"))
		setX(getX()+speed);
	if (speed<=20)
		lilS();
  }
  public void lilS()
  {
	  lilS+=1;
	  if (lilS==20){
		  speed+=1;
		  lilS=0;
	  }
  }
	
  public void decel()
  {
	speed=1;
	lilS=0;
  }

  public void draw (Graphics window)
  {
	window.setColor(color);
	window.fillRect(getX(),getY(),getW(),getH());
	client.broadcastMessage(client.getName() + "," + "moved to " + getX() + "[]" + getY() + "][" + direction);
  }
  
  
  public String toString(){
	return super.toString() + " " + speed + " " + color;
  }
}
