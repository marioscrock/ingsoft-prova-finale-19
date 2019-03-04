package chat.model;

import chat.exceptions.UserNotInGroupException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.rmi.RemoteException;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class GroupTest {

    private Group group;
    private User john, mark, carl;

    @Before
    public void before() throws RemoteException {
        //TODO
    }

    @Test
    public void groupSizeTest() throws RemoteException {
        //TODO
    }

    @Test
    public void sendMessageTest() {
        //TODO
    }

    @Test //TODO
    public void testIllegalMessage() throws RemoteException {
        //TODO
    }
}
