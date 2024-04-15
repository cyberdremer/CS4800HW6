package org.example;

import org.example.behavorial.chat.ChatServer;
import org.example.behavorial.chat.ChatType;
import org.example.behavorial.user.SearchByUser;
import org.example.behavorial.user.User;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        SearchByUser searchByUserTool;

        User user1 = new User("Alice", chatServer);
        User user2 = new User("Bob", chatServer);
        User user3 = new User("Charlie", chatServer);

        chatServer.registerUser(user1);
        chatServer.registerUser(user2);
        chatServer.registerUser(user3);

        chatServer.sendMessage(user1, Collections.singletonList("Bob"), "Hello Bob");
        chatServer.sendMessage(user1, Collections.singletonList("Bob"), "Why are you not responding?");
        chatServer.sendMessage(user1, Collections.singletonList("Bob"), "Respond now or I will block you!");

        searchByUserTool = user1.iterator(user2);

        while (searchByUserTool.hasNext()){
            System.out.println(searchByUserTool.next());
        }




        chatServer.sendMessage(user2, Arrays.asList("Charlie", "Alice"), "Hello Everyone!");

        user1.undoMessage();

        chatServer.blockUser("Bob", "Charlie");

        user2.printChatHistory(ChatType.OUTBOUND);
        user2.printChatHistory(ChatType.INBOUND);



    }
}