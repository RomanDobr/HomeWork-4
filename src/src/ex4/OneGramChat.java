package src.ex4;

import java.io.InputStreamReader;
import java.util.Scanner;

public class OneGramChat {
    private User user;
    private static User[] usersArr = new User[100];
    Scanner scanner = new Scanner(new InputStreamReader(System.in));

    //создать пользователя
    public void makeUser() throws ErrorUser{
        String name = inputLoginAndPassword("Введите имя пользователя: ");
        String password = inputLoginAndPassword("Введите пароль: ");
        user = new User(name, password, new Message[100]);
        addArrUsers(user, usersArr);
    }

    //Войти пользователю
    public User inputUser() throws ErrorUser {
        String name = inputLoginAndPassword("Введите имя пользователя: ");
        String password = inputLoginAndPassword("Введите пароль: ");
        if (usersArr != null) {
            for (User user : usersArr) {
                if (user != null && (user.getName().equals(name)) && (user.getPassword().equals(password))) {
                    System.out.println("Поздравляю Вы успешно зашли в чат!!!");
                    return user;
                }
            }
        }
        throw new ErrorUser("Ошибка: такого пользователя не существует");
    }

    //Написать письмо
    public void setMessage(User nowUser) throws ErrorUser {

        if (nowUser == null) {
            throw new ErrorUser("Ошибка: вы не авторизованы");
        }

        System.out.println("Пишем письмо");
        System.out.print("Кому: ");
        String nameOut = inputString();

        //проверяем есть ли такой пользователь
        User userOut = null;
        for (User user : usersArr) {

            if (user != null && user.getName().equals(nameOut)) {
                userOut = user;
                break;
            }
        }
        if (userOut == null) {
            throw new ErrorUser("Ошибка: такого пользователя нет");
        }

        System.out.print("Текст: ");
        String text = inputString();

        Message newMessageForUserIn = new Message(text, false, userOut.getName());
        nowUser.setMessagesArr(addArrMess(newMessageForUserIn, nowUser.getMessagesArr()));

        Message newMessageForUserOut = new Message(text, true, nowUser.getName());
        userOut.setMessagesArr(addArrMess(newMessageForUserOut, userOut.getMessagesArr()));
    }

    //Прочитать письма:
    public String readMessage(User nowUser) throws ErrorUser {
        if (nowUser == null) {
            throw new ErrorUser("Ошибка: вы не авторизованы");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nowUser.getMessagesArr().length; i++) {
            if (nowUser.getMessagesArr()[i] != null) {

                if (nowUser.getMessagesArr()[i].isInOutMessage()) {
                    stringBuilder.append("письмо от ");
                    stringBuilder.append(nowUser.getMessagesArr()[i].getNameUser());
                    stringBuilder.append(": ");
                    stringBuilder.append(nowUser.getMessagesArr()[i].getText());
                    stringBuilder.append("\n");
                } else if (!nowUser.getMessagesArr()[i].isInOutMessage()){
                    stringBuilder.append("письмо к ");
                    stringBuilder.append(nowUser.getMessagesArr()[i].getNameUser());
                    stringBuilder.append(": ");
                    stringBuilder.append(nowUser.getMessagesArr()[i].getText());
                    stringBuilder.append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }

    public String inputLoginAndPassword(String message) throws ErrorUser {
        System.out.print(message);
        return inputString();
    }

    public void title() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"войти\" - запуск функции \"войти пользователю\";\n");
        stringBuilder.append("\"новый\" - запуск функции \"создать пользователя\";\n");
        stringBuilder.append("\"выйти\" - запуск функции \"выйти пользователю\";\n");
        stringBuilder.append("\"написать\" - запуск функции \"написать письмо\";\n");
        stringBuilder.append("\"прочитать\" - запуск функции \"прочитать письмо\";\n");
        stringBuilder.append("\"exit\" - окончание работы программы;\n");
        System.out.println(stringBuilder.toString());
    }

    public String inputString() throws ErrorUser {
        String str = scanner.nextLine();
        if (str.length() >= 1) {
            return str;
        }
        throw new ErrorUser("Ошибка");
    }

    public void addArrUsers(User user, User[] users) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                break;
            }
        }
    }

    public Message[] addArrMess(Message message, Message[] messages) {
        for (int i = 0; i < messages.length; i++) {
            if (messages[i] == null) {
                messages[i] = message;
                break;
            }
        }
        return messages;
    }
}
