import java.net.InetAddress;
import java.util.Scanner;

public class IPFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Host Name");
        String ip = sc.nextLine();
        try {
            // InetAddress name = InetAddress.getByName(ip);
            System.out.println("Ip Address : " + InetAddress.getByName(ip).toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        sc.close();
    }
}