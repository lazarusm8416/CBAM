public class gameClient {
    private DatagramSocket socket;
    private InetAddress address;
 
    private byte[] buf;
 
    public gameClient() {
        socket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
    }
 
    public String send(String msg) {
        buf = msg.getBytes();
        DatagramPacket packet 
          = new DatagramPacket(buf, buf.length, address, 4445);
        socket.send(packet);
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        String received = new String(
          packet.getData(), 0, packet.getLength());
        return received;
    }
 
    public void close() {
        socket.close();
    }
}
