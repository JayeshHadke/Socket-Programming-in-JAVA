import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostFinder {
    public static void main(String[] args) {
        try {
            // InetAddress ad = InetAddress.getLocalHost();
            System.out.println("\n" + InetAddress.getLocalHost().toString());
        } catch (UnknownHostException e) {
            System.out.println(e);
        }
    }
}
