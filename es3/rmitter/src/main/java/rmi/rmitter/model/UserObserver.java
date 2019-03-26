package rmi.rmitter.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Observes updates of state for a User
 */
public interface UserObserver extends Remote {
    void onNewPost(Post post) throws RemoteException;
    void onMention(Post post) throws RemoteException;
    void onFollower(User follower) throws RemoteException;
}
