public class gameTester {
    gameClient client;
 
    @Before
    public void setup(){
        new gameServer().start();
        client = new gameClient();
    }
 
    @Test
    public void test() {
    }
 
    @After
    public void end() {
    }
}
