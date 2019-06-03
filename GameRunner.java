
import javax.swing.*;
import java.awt.Component;

public class GameRunner extends JFrame implements Runnable {

  public static final int WIDTH = 1200;
  public static final int HEIGHT = 800;
  private UserClient client;

  public UserClient getClient() {
    return client;
  }

  public static void main(String[] args) {
    GameRunner game = new GameRunner();
  }


  public GameRunner() {
    super("CBAM Java");
    setSize(WIDTH, HEIGHT);

    JTextArea textArea = new JTextArea();
    //CBAMGame Game = new CBAMGame();
    //((Component)Game).setFocusable(true);
    //Thread world = new Thread(Game);
    //world.start();

    getContentPane().add(textArea);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(WIDTH,HEIGHT);

    World theWorld = new World();
    ((Component)theWorld).setFocusable(true);

    getContentPane().add(theWorld);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    /*Thread t = new Thread(this);
    t.start();*/
    client = new UserClient();
    theWorld.setClient(client);

  }

  @Override
  public void run() {
    client = new UserClient();
  }

}
