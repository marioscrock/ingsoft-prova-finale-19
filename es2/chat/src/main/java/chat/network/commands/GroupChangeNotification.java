package chat.network.commands;

import chat.model.Group;
import chat.model.User;
import chat.ClientContext;

public class GroupChangeNotification implements Response {
    public final boolean inOut;
    public final User user;

    public GroupChangeNotification(boolean inOut, User user) {
        this.inOut = inOut;
        this.user = user;
    }

    @Override
    public void handle(ResponseHandler handler) {
        Group currentGroup = ClientContext.get().getCurrentGroup();
        if (inOut) {
            currentGroup.join(user);
        } else {
            currentGroup.leave(user);
        }
    }
}
