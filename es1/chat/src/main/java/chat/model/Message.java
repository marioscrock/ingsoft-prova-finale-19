package chat.model;

import java.io.Serializable;

public class Message implements Serializable {

    private final String content;
    private final User user;
    private final Group group;

    public Message(Group group, User sender, String content) {
        this.group = group;
        this.content = content;
        this.user = sender;
    }

    public User getSender() {
        return user;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return user.getUsername() + "@" + group.getName() + ": " + content;
    }

}
