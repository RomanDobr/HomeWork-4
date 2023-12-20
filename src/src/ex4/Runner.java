package src.ex4;

public class Runner {
    public static void main(String[] args) {
        OneGramChat chat = new OneGramChat();
        User nowUser = null;
        chat.title();

        while (true) {
            String str = null;
            System.out.print("Введите команду: ");

            try {
                str = chat.inputString();
            } catch (ErrorUser e) {
                System.out.println(e.getMessage());
            }

            if (str.equals("exit") ) {
                break;

            } else if (str.equals("новый")) {
                try {
                    chat.makeUser();
                } catch (ErrorUser e) {
                    System.out.println(e.getMessage());
                }

            } else if (str.equals("войти")) {
                try {
                    nowUser = chat.inputUser();
                } catch (ErrorUser e) {
                    System.out.println(e.getMessage());
                }

            } else if (str.equals("выйти")) {
                nowUser = null;

            } else if (str.equals("написать")) {
                try {
                    chat.setMessage(nowUser);
                } catch (ErrorUser e) {
                    System.out.println(e.getMessage());
                }

            } else if (str.equals("прочитать")) {
                try {
                    System.out.println(chat.readMessage(nowUser));
                } catch (ErrorUser e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
