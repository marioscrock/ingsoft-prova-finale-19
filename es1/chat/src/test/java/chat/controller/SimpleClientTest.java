package chat.controller;

import chat.exceptions.UserNotInGroupException;
import chat.controller.SimpleClient;
import chat.model.Group;
import chat.model.Message;
import chat.model.User;
import chat.view.ViewClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import java.rmi.RemoteException;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

//Tipologie di test: Unità, Integrazione, Sistema
public class SimpleClientTest {

    private Group group;
    private User john, mark;
    private SimpleClient c_john;
    private ViewClient vc;

    @Before
    public void before() throws RemoteException {
        //TODO
    }

    @Test
    public void sendMessageTest() {
        //TODO
    }

    @Test
    public void joinTest() {
        //TODO
    }

    @Test
    public void leaveTest() {
        //TODO
    }

}
