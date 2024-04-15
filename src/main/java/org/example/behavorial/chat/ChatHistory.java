package org.example.behavorial.chat;

import org.example.behavorial.user.IterableByUser;
import org.example.behavorial.message.Message;
import org.example.behavorial.user.SearchByUser;
import org.example.behavorial.user.User;

import java.util.*;

public class ChatHistory  implements IterableByUser {
    private LinkedList<Message> messageHistory;

    public ChatHistory(){
        messageHistory = new LinkedList<>();

    }

    public void addMessage(Message message){
        messageHistory.add(message);
    }

    public int chatHistorySize(){
        return messageHistory.size();
    }

    public Message removeMessage(){
        return messageHistory.removeLast();
    }

    @Override
    public String toString() {
        return messageHistory.toString();
    }

    public LinkedList<Message> getMessageHistory(){
        return messageHistory;
    }



    @Override
    public SearchByUser iterator(User userToSearch) {
        return new SearchByUser(userToSearch);
    }
}
