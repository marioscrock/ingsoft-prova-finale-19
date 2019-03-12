package chat.network.commands;

/**
 * A method for every possible Request
 */
public interface RequestHandler {
    Response handle(SendMessageRequest request);

    Response handle(CreateUserRequest request);

    Response handle(ChooseGroupRequest chooseGroupRequest);
}
