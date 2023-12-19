package src.ex4;

public class Message {

    private String text;

    //Входящее сообщение = true / Исходящее сообщение = false
    private boolean isInOutMessage;

    private String nameUser;

    public Message(String text, boolean isInOutMessage, String nameUser) {
        this.text = text;
        this.isInOutMessage = isInOutMessage;
        this.nameUser = nameUser;
    }

    public String getText() {
        return text;
    }

    public boolean isInOutMessage() {
        return isInOutMessage;
    }

    public String getNameUser() {
        return nameUser;
    }

}
