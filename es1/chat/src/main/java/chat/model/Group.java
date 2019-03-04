package chat.model;

import chat.exceptions.DuplicateEntityException;
import chat.exceptions.UserNotInGroupException;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Group {

    private static int uniqueGroupID = 0;
    private int groupID;
    private String groupName;
    private Set<User> users = new HashSet<>();
    private List<Message> messages = new LinkedList<>();
    //TODO

    public Group() {
        super();
        groupID = uniqueGroupID;
        groupName = "group" + groupID;
        uniqueGroupID++;
    }

    public void sendMessage(Message message) throws UserNotInGroupException {
        //TODO
    }

    public void join(User user) throws DuplicateEntityException {
        //TODO
    }

    public void leave(User user) throws UserNotInGroupException {
        //TODO
    }

    //TODO register clients

    private void checkUserInGroup(User user) throws UserNotInGroupException {
        if (!users.contains(user)) {
            throw new UserNotInGroupException(user, this);
        }
    }

    public List<Message> messages() {
        //NOTE new LIST!!
        return new LinkedList<>(messages);
    }

    public int size() {
        return users.size();
    }

    public Set<User> users() {
        return new HashSet<>(users);
    }

    public String getName() {
        return groupName;
    }

    public void setName(String name) {
        this.groupName = name;
    }

    public boolean in(User user) {return users.contains(user);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group users = (Group) o;

        return groupID == users.groupID;
    }

    @Override
    public int hashCode() {
        return groupID;
    }

}
