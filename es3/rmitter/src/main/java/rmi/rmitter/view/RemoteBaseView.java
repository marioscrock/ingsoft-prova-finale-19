package rmi.rmitter.view;

import rmi.rmitter.model.FeedObserver;
import rmi.rmitter.model.UserObserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteBaseView extends Remote, UserObserver, FeedObserver {
    void error(String message) throws RemoteException;
    void ack(String message) throws RemoteException;
}
