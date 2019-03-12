package chat.network.commands;

import chat.model.Group;

public class JoinGroupResponse implements Response {
    public final Group group;

    public JoinGroupResponse(Group group) {
        this.group = group;
    }

    @Override
    public void handle(ResponseHandler handler) {
        handler.handle(this);
    }
}
