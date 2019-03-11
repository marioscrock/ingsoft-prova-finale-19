package socket.serde;

import java.io.Serializable;

public class Message implements Serializable {
    public final String content;

    public Message(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return ">>> " + content;
    }
}
