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
        cJohn = new SimpleClient(vc);
        cJohn.setUser(john);
        cJohn.setGroup(group);
    }

    @Test
    public void sendMessageTest() {
        group.join(mark);

        Message m = new Message(group, mark, "hello");
        group.sendMessage(m);

        verify(vc).onMessage(m);
    }

    @Test
    public void joinTest() {
        group.join(mark);
        verify(vc).onJoin(mark);
    }

    @Test
    public void leaveTest() {
        group.join(mark);
        group.leave(mark);
        verify(vc).onLeave(mark);
    }

}
