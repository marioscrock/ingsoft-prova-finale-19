package chat.controller;

import chat.model.Group;
import chat.model.Message;
import chat.model.User;
import chat.view.ViewClient;
import org.junit.Before;
import org.junit.Test;

import java.rmi.RemoteException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SimpleClientTest {

    private Group group;
    private User john, mark;
    private SimpleClient cJohn;
    private ViewClient vc;

    @Before
    public void before() throws RemoteException {
        group = new Group();
        john = new User("john");
        mark = new User("mark");

        vc = mock(ViewClient.class);
        group.join(john);
        cJohn = new SimpleClient(john, group, vc);
    }

    @Test
    public void sendMessageTest() {
        group.join(mark);

        Message m = new Message(group, mark, "hello");
        group.sendMessage(m);

        verify(vc).displayMessage(m.toString());
    }

    @Test
    public void joinTest() {
        group.join(mark);
        verify(vc).displayGroupChange(group.getName(), mark.getUsername(),true);
    }

    @Test
    public void leaveTest() {
        group.join(mark);
        group.leave(mark);
        verify(vc).displayGroupChange(group.getName(), mark.getUsername(),false);
    }

}
