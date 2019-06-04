import java.awt.*;

public class DrawPlayer extends ColidableObject{

    private Player player;
    private String name;
    private Image image;

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

}
