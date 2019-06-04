import java.awt.*;

public class DrawPlayer extends ColidableObject{

    private Player player;
    private String name;
    private Image image;
    private int lilS;

    public DrawPlayer(int x, int y, String name) {
        super(x,y,50,30);
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setImage(Image i) {
        image = i;
    }
    public void bounce(String dir){
	    decel();
	    for (int i =0; i<10; i++){
		    move(dir);
	    }
	    decel();
    }
    public void bump(Object p){
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
	    if (speed<=20)
		    lilS();
    }
    public void lilS(){
	    lilS+=1;
	    if (lilS==20){
		    speed+=1;
		    lilS=0;
	    }
    }
	
    public void decel(){
	    speed=1;
	    lilS=0;
    }

}
