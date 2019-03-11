package chat.view;

import chat.model.GroupChangeListener;
import chat.model.Message;
import chat.model.MessageReceivedObserver;
import chat.model.User;

public class ViewClient implements MessageReceivedObserver, GroupChangeListener {

    @Override
    public void onMessage(Message message) {
        System.out.println(message);
    }

    @Override
    public void onJoin(User user) {
        System.out.println("User " + user + " joins the group");
    }

    @Override
    public void onLeave(User user) {
        System.out.println("User " + user + " leaves the group");
    }
}
