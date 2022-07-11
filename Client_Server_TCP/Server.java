import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(55);
        Socket s = ss.accept();
        System.out.println("Connected!!!");
        DataInputStream in = new DataInputStream(s.getInputStream());
        BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        while (true) {
            System.out.print("Server : ");
            String str = sysin.readLine();
            out.writeBytes(str + "\n");
            if (str.equalsIgnoreCase("END")) {
                System.out.println("Terminating Connection!!!");
                break;
            }
            System.out.println("Waiting For Client Respond...");
            str = in.readLine();
            System.out.println("Client : " + str);
            if (str.equalsIgnoreCase("End")) {
                System.out.println("Terminating Connection!!!");
                break;
            }
        }
        ss.close();
    }
}
