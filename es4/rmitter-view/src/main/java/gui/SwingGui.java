package gui;

import rmi.rmitter.control.RemoteController;
import rmi.rmitter.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class SwingGui extends UnicastRemoteObject
        implements FeedObserver, UserObserver, ActionListener {

    private final RemoteController controller;
    private JFrame mainFrame;
    private JTextArea textArea;
    private JTextField tokenTextField, usernameTextField, postTextField;
    private JButton loginButton;

    private String token;

    public SwingGui(RemoteController controller) throws RemoteException {
        super();
        this.controller = controller;
    }

    public void init() {
        //TODO
    }

    public void draw() {
        //TODO
    }

    private void writeToTextArea(String msg) {
        textArea.append(msg + "\n");
        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        //TODO
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        //TODO
    }

    private void onEnterPressed() {
        //TODO
    }

    // ---------------------------------- Remote events

    @Override
    public void onFolloweePost(Post post) throws RemoteException {
        writeToTextArea("@" + post.getPoster().getUsername() + " -> " + post.getContent());
    }

    @Override
    public void onHashtagUse(Hashtag hashtag, Post post) throws RemoteException {
        writeToTextArea("Hashtag " + hashtag + " used:");
        writeToTextArea(post.getContent());
    }

    @Override
    public void onNewPost(Post post) throws RemoteException {
        writeToTextArea(post.getContent());
    }

    @Override
    public void onMention(Post post) throws RemoteException {
        writeToTextArea("You were mentioned in:");
        writeToTextArea(post.getContent());
    }

    @Override
    public void onFollower(User user) throws RemoteException {
        writeToTextArea("New follower: " + user.getUsername());
    }

    public static void main(String[] args) throws Exception {
        //TODO
    }
}
