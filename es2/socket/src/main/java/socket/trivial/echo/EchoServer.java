package socket.trivial.echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer implements Closeable {
    private final int port;
    private ServerSocket serverSocket;

    public EchoServer(int port) {
        this.port = port;
    }

    public void init() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println(">>> Listening on " + port);
    }

    public Socket acceptConnection() throws IOException {
        // blocking call
        Socket accepted = serverSocket.accept();
        System.out.println("Connection accepted: " + accepted.getRemoteSocketAddress());
        return accepted;
    }

    public void handleConnection(Socket clientConnection) throws IOException {
        // TODO
    }

    public void lifeCycle() throws IOException {
        init();

        try {
            Socket socket = acceptConnection();
            handleConnection(socket);
        } finally {
            close();
        }
    }

    public void close() throws IOException {
        serverSocket.close();
    }
}
