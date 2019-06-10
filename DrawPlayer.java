import java.awt.*;

public class DrawPlayer extends Player{

    private String name;
    private Image image;
    private Color color;

    public DrawPlayer(int x, int y, String name) {
        super(x,y,25,25,3,null,0);
        this.name = name;
        color=rColor();
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
