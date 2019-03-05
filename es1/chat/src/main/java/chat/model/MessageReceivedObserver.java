package chat.model;

public interface MessageReceivedObserver {
    void onMessage(Message message);
}
