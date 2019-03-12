package chat.network.commands;

public class ChooseGroupRequest implements Request {
    @Override
    public Response handle(RequestHandler handler) {
        return handler.handle(this);
    }
}
