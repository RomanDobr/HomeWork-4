package src.ex4;

public class User {
    private String name;
    private String password;

    private Message[] messagesArr;

    public User(String name, String password, Message[] messagesArr) {
        this.name = name;
        this.password = password;
        this.messagesArr = messagesArr;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Message[] getMessagesArr() {
        return messagesArr;
    }

    public void setMessagesArr(Message[] messagesArr) {
        this.messagesArr = messagesArr;
    }
}
