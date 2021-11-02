import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] arg) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        serverSocket = new ServerSocket(8066);
        while (true) {
            try {
                socket = serverSocket.accept();
                System.out.println("Accepted !");
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    String clientMsg = bufferedReader.readLine();
                    System.out.println("CLIENT: " + clientMsg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
