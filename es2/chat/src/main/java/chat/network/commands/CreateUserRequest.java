package chat.network.commands;

public class CreateUserRequest implements Request {
    public final String username;

    public CreateUserRequest(String username) {
        this.username = username;
    }

    @Override
    public Response handle(RequestHandler handler) {
        return handler.handle(this);
    }
}
