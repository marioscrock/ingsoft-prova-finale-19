package chat;

import chat.model.Group;
import chat.model.Message;
import chat.model.User;
import chat.network.Client;
import chat.network.commands.*;

import java.io.IOException;

/**
 * CLIENT-SIDE controller
 *
 * It holds a reference to the view for sending sudden responses.
 * It holds a reference to the networking layer.
 */
public class ClientController implements ResponseHandler {
    // reference to networking layer
    private final Client client;
    private Thread receiver;

    // the view
    private final ViewClient view;

    public ClientController(Client client) {
        this.client = client;
        this.view = new ViewClient(this);
    }

    /**
     *
     * @param username
     * @return the created user or null in case of failure
     */
    public User createUser(String username) {
        client.request(new CreateUserRequest(username));
        client.nextResponse().handle(this);
        return ClientContext.get().getCurrentUser();
    }

    public Group chooseGroup() {
        client.request(new ChooseGroupRequest()); // dummy
        client.nextResponse().handle(this);
        return ClientContext.get().getCurrentGroup();
    }

    public void startMessaging() {
        // start a receiver thread
        receiver = new Thread(
                () -> {
                    Response response;
                    do {
                        response = client.nextResponse();
                        if (response != null) {
                            response.handle(this);
                        }
                    } while (response != null);
                }
        );
        receiver.start();
    }

    public void sendMessage(String content) {
        Message m = new Message(ClientContext.get().getCurrentGroup(),
                ClientContext.get().getCurrentUser(), content);
        client.request(new SendMessageRequest(m));
    }

    public void run() throws IOException {
        view.chooseUsernamePhase();
        view.chooseGroupPhase();
        view.messagingPhase();

        receiver.interrupt();
    }

    // -------------------------- Response handling

    @Override
    public void handle(TextResponse textResponse) {
        view.displayText(textResponse.toString());
    }

    @Override
    public void handle(JoinGroupResponse joinGroupResponse) {
        ClientContext.get().setCurrentGroup(joinGroupResponse.group);
    }

    @Override
    public void handle(UserCreatedResponse userCreatedResponse) {
        ClientContext.get().setCurrentUser(userCreatedResponse.user);
    }
}
