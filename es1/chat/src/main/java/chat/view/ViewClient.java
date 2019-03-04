package chat.view;

public class ViewClient {

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayGroupChange(String group, String user, boolean join) {
        if(join)
            System.out.println("User " + user + " joins the group " + group);
        else
            System.out.println("User " + user + " leaves the group " + group);
    }
}
