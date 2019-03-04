package chat.model;

import java.util.LinkedList;
import java.util.List;

public class User {

    private String username;
    //TODO

    public User(String username) {
        super();
        this.username = username;
        //TODO
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //TODO register clients

    public void receiveMessage(Message message) {
        //TODO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return username != null ? username.equals(user.username) : user.username == null;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "@" + username;
    }

}
