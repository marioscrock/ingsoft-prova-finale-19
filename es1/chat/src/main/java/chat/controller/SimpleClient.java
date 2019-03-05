package chat.controller;

import chat.model.*;
import chat.view.ViewClient;

public class SimpleClient implements MessageReceivedObserver, GroupChangeListener {

    private User currentUser;
    private Group currentGroup;
    private ViewClient vc;

    public SimpleClient(User user, Group group, ViewClient vc) {
        this.currentUser = user;
        this.currentGroup = group;
        this.vc = vc;

        user.listenToMessages(this);
        group.observe(this);
    }

    @Override
    public void onMessage(Message message) {
        vc.displayMessage(message.toString());
    }

    @Override
    public void onJoin(User user) {
        vc.displayGroupChange(currentGroup.getName(),
                user.getUsername(), true);

    }

    @Override
    public void onLeave(User user) {
        vc.displayGroupChange(currentGroup.getName(),
                user.getUsername(), false);
    }

}
