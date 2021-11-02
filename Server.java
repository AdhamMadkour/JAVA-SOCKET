import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] arg) throws IOException {
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;

        serverSocket = new ServerSocket(8833);
        while (true) {
            try {
                socket = serverSocket.accept();
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);
                int cnt = 1;
                while (true) {
                    String msg = bufferedReader.readLine();
                    bufferedWriter.write("DONE TEST " + cnt);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    ++cnt;
                    System.out.println(cnt);
                    if (cnt == 6) {
                        bufferedWriter.write("FINISH");
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        break;
                    } else continue;
                }
                socket.close();
                inputStreamReader.close();
                outputStreamWriter.close();
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
