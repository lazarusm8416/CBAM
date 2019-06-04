import java.awt.*;

public class DrawPlayer extends Player{

    private String name;
    private Image image;

    public DrawPlayer(int x, int y, String name) {
        super(x,y,50,30,3,null);
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
    
}
