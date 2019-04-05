package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import rmi.rmitter.control.RemoteController;
import rmi.rmitter.model.*;

import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class FXMLGui extends Application
        implements FeedObserver, UserObserver {

    //TODO

    private RemoteController controller;
    private String currentToken;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //TODO
    }

    private void writeToFeed(String message) {

        //TODO

    }

    public void loginPressed(ActionEvent actionEvent) {
        //TODO
    }

    public void enterPressed(ActionEvent actionEvent) {
        //TODO
    }

    // ---------------------------------- Remote events

    @Override
    public void onFolloweePost(Post post) throws RemoteException {
        writeToFeed("@" + post.getPoster().getUsername() + " -> " + post.getContent());
    }

    @Override
    public void onHashtagUse(Hashtag hashtag, Post post) throws RemoteException {
        writeToFeed("Hashtag " + hashtag + " used:");
        writeToFeed(post.getContent());
    }

    @Override
    public void onNewPost(Post post) throws RemoteException {
        writeToFeed(post.getContent());
    }

    @Override
    public void onMention(Post post) throws RemoteException {
        writeToFeed("You were mentioned in:");
        writeToFeed(post.getContent());
    }

    @Override
    public void onFollower(User user) throws RemoteException {
        writeToFeed("New follower: " + user.getUsername());
    }
}
