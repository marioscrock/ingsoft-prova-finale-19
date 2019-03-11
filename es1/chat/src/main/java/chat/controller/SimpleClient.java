package chat.controller;

import chat.model.*;
import chat.view.ViewClient;

public class SimpleClient {

    private User currentUser;
    private Group currentGroup;
    private ViewClient vc;

    public SimpleClient(ViewClient vc) {
        this.vc = vc;
    }

    public void setUser(User user) {
        if (user != null) {
            this.currentUser = user;
            user.listenToMessages(vc);
        }
    }

    public void setGroup(Group group) {
        if (currentUser != null) {
            if (!group.in(currentUser))
                group.join(currentUser);
            this.currentGroup = group;
            group.observe(vc);
        }
    }

}
