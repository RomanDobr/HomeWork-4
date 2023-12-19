package src.ex4;

import java.util.ArrayList;

public class User {
    private String name;
    private String password;

    private ArrayList<Message> messages = new ArrayList<>(100);

    public User(String name, String password, ArrayList<Message> messages) {
        this.name = name;
        this.password = password;
        this.messages = messages;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

}
