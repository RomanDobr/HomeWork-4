package src.ex4;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class OneGramChat {
    private User user;

    public static ArrayList<User> users = new ArrayList<>();
    Scanner scanner = new Scanner(new InputStreamReader(System.in));

    //создать пользователя
    public void makeUser() throws ErrorUser{
        String name = inputLoginAndPassword("Введите имя пользователя: ");
        String password = inputLoginAndPassword("Введите пароль: ");
        user = new User(name, password, new ArrayList<>(100));
        users.add(user);
    }


    //Войти пользователю
    public User inputUser() throws ErrorUser {
        String name = inputLoginAndPassword("Введите имя пользователя: ");
        String password = inputLoginAndPassword("Введите пароль: ");
        if (users != null) {
            for (User user : users) {
                if ((user.getName().equals(name)) && (user.getPassword().equals(password))) {
                    System.out.println("Поздравляю Вы успешно зашли в чат!!!");
                    return user;
                }
            }
        }
        throw new ErrorUser("Ошибка: такого пользователя не существует");
    }

    //Написать письмо: Вводится имя пользователя, вводится текст письма.
    //У текущего пользователя записывается в список сообщений как исходящий
    //У пользователя которому пишем, записывается в список сообщений как входящее
    //если такого пользователя нет, то возникает ошибка: такого пользователя нет
    //если текущего пользователя нет, то возникает ошибка: вы не авторизованы
    public void setMessage(User nowUser) throws ErrorUser {

        if (nowUser == null) {
            throw new ErrorUser("Ошибка: вы не авторизованы");
        }

        System.out.println("Пишем письмо");
        System.out.print("Кому: ");
        String nameOut = inputString();

        //проверяем есть ли такой пользователь
        User userOut = null;
        for (User user : users) {
            if (user.getName().equals(nameOut)) {
                userOut = user;
            }
        }
        if (userOut == null) {
            throw new ErrorUser("Ошибка: такого пользователя нет");
        }

        System.out.print("Текст: ");
        String text = inputString();

        Message newMessageForUserOut = new Message(text, true, nowUser.getName());
        Message newMessageForUserIn = new Message(text, false, userOut.getName());

        ArrayList<Message> messagesIn = nowUser.getMessages();
        messagesIn.add(newMessageForUserIn);
        nowUser.setMessages(messagesIn);

        ArrayList<Message> messagesOut = userOut.getMessages();
        messagesOut.add(newMessageForUserOut);
        userOut.setMessages(messagesOut);

    }

    //Прочитать письма:
    //Вывести все письма текущего пользователя.
    //Формат входящего: "письмо от {имя пользователя}: {текст сообщения}"
    //Формат исходящего: "письмо к {имя пользователя}: {текст сообщения}"
    //если текущего пользователя нет, то возникает ошибка: вы не авторизованы
    public String readMessage(User nowUser) throws ErrorUser {
        if (nowUser == null) {
            throw new ErrorUser("Ошибка: вы не авторизованы");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nowUser.getMessages().size(); i++) {
            if (nowUser.getMessages().get(i) != null) {

                if (nowUser.getMessages().get(i).isInOutMessage()) {
                    stringBuilder.append("письмо от ");
                    stringBuilder.append(nowUser.getMessages().get(i).getNameUser());
                    stringBuilder.append(": ");
                    stringBuilder.append(nowUser.getMessages().get(i).getText());
                    stringBuilder.append("\n");
                } else if (!nowUser.getMessages().get(i).isInOutMessage()){
                    stringBuilder.append("письмо к ");
                    stringBuilder.append(nowUser.getMessages().get(i).getNameUser());
                    stringBuilder.append(": ");
                    stringBuilder.append(nowUser.getMessages().get(i).getText());
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

}
