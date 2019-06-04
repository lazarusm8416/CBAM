import java.awt.*;

public class DrawPlayer extends ColidableObject{

    private int x;
    private int y;
    private Player player;
    private String name;
    private Image image;

    public DrawPlayer(int x, int y, String name) {
        super(x,y,50,30);
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setImage(Image i) {
        image = i;
    }

}
