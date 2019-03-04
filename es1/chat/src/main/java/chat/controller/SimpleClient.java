package chat.controller;

import chat.model.Group;
import chat.model.User;
import chat.view.ViewClient;

//TODO Should be updated on messages and group changes
public class SimpleClient {

    private User currentUser;
    private Group currentGroup;
    private ViewClient vc;

    public SimpleClient(User user, Group group, ViewClient vc) {
        this.currentUser = user;
        this.currentGroup = group;
        this.vc = vc;

        //TODO
    }

    //TODO
}
