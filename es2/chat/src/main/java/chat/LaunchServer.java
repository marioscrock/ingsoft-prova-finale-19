package chat;


import chat.network.ChatServer;

import java.io.IOException;

public class LaunchServer {
    public static void main(String[] args) throws IOException {
        ChatServer server = new ChatServer(8000);

        try {
            server.run();
        } finally {
            server.close();
        }
    }
}
