import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket(InetAddress.getLocalHost(), 55);
        DataInputStream in = new DataInputStream(s.getInputStream());
        BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        while (true) {
            System.out.println("Waiting for Server Respond...");
            String str = in.readLine();
            System.out.println("Server : " + str);
            if (str.equalsIgnoreCase("End")) {
                System.out.println("Terminating Communication!!!!");
                break;
            }
            System.out.print("Client : ");
            str = sysin.readLine();
            out.writeBytes(str + "\n");
            if (str.equalsIgnoreCase("End")) {
                System.out.println("Terminating Connection!!!");
                break;
            }

        }
        s.close();
    }
}
