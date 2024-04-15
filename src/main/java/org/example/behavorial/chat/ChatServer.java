package org.example.behavorial.chat;

import org.example.behavorial.message.Message;
import org.example.behavorial.user.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ChatServer {
    private HashMap<String, User> userHashMap;
    private HashMap<String, HashSet<String>> blockList;

    public ChatServer(){
        userHashMap = new HashMap<>();
        blockList = new HashMap<>();
    }

    public void registerUser(User user){
        userHashMap.put(user.getUserName(), user);
        blockList.put(user.getUserName(), new HashSet<>());
    }

    public void unregisterUser(User user){
        userHashMap.remove(user.getUserName());
        blockList.remove(user.getUserName());

    }

    public boolean isBlocked(String sender, String receiver){
        return blockList.get(receiver).contains(sender);

    }

    public boolean userExists(String userName){
        return userHashMap.containsKey(userName);
    }




    public void blockUser(String blocker, String blocked){
        blockList.get(blocker).add(blocked);
    }


    public void sendMessage(User sender, List<String> recipients, String messageContent){
        for (String recipient : recipients){
            if (userExists(recipient) && !isBlocked(recipient, sender.getUserName()) ){
                Message message = new Message(sender.getUserName(), Collections.singletonList(recipient));
                message.createMessage(messageContent);

                userHashMap.get(recipient).receiveMessage(message);


            }
        }
        Message finalMessage = new Message(sender.getUserName(), recipients);
        finalMessage.createMessage(messageContent);
        sender.sendMessage(finalMessage);

    }

}
