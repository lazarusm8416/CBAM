import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class gameClient {
    private DatagramSocket socket;
    private InetAddress address;
 
    private byte[] buf;
 
    public gameClient() {
        socket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
    }
 
    public void send(String msg) {
        buf = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
        socket.send(packet);
    }
 
    public void close() {
        socket.close();
    }
}
