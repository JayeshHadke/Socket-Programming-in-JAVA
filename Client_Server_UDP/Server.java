package Client_Server_UDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Server {
    public static DatagramSocket ds;
    public static int serverPort = 1790, clientPort = 1789;

    public static void main(String[] args) throws Exception {

        ds = new DatagramSocket(serverPort);
        byte buffer[] = new byte[1024];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // Scanner in = new Scanner(System.in);
        System.out.println("Waiting for Client to Response......");
        String mesg;
        while (true) {
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            System.out.println("Client:.... ");
            ds.receive(dp);
            // System.out.print(" " + dp.getLength() + " ");
            mesg = new String(dp.getData(), 0, dp.getLength());
            if (mesg.equals("END")) {
                System.out.println("Terminating Connection......");
                mesg = "END";
                buffer = mesg.getBytes();
                ds.send(new DatagramPacket(buffer, mesg.length(), InetAddress.getLocalHost(), clientPort));
                return;
            } else {
                System.out.println(mesg);
            }
            System.out.print("Server: ");
            String mesg1 = in.readLine();
            // String mesg1 = in.nextLine();
            buffer = mesg1.getBytes();
            // System.out.print(" " + mesg1.length() + " ");
            ds.send(new DatagramPacket(buffer, mesg1.length(), InetAddress.getLocalHost(), clientPort));

        }

    }
}
