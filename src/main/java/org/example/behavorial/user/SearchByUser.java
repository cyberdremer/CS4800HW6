package org.example.behavorial.user;

import org.example.behavorial.chat.ChatType;
import org.example.behavorial.message.Message;

import java.util.Iterator;
import java.util.LinkedList;

public class SearchByUser implements Iterator {
    private LinkedList<Message> messageArrayList;
    private String userName;
    private int collectionSize;

    private int indexInCollection;

    public SearchByUser(User userToSearch){
        messageArrayList = new LinkedList<>();
        messageArrayList.addAll(userToSearch.getChatHistory(ChatType.INBOUND).getMessageHistory());
        messageArrayList.addAll(userToSearch.getChatHistory(ChatType.OUTBOUND).getMessageHistory());
        collectionSize = messageArrayList.size();
        userName = userToSearch.getUserName();
        indexInCollection = 0;




    }

    private boolean containsName(Message message){
        return message.getSendName().equals(userName) || message.getRecipients().contains(userName);
    }

    @Override
    public boolean hasNext() {
        Message message;
        while (indexInCollection < collectionSize){
            message = messageArrayList.get(indexInCollection);
            if(containsName(message)){
                return true;
            }
            else {
                indexInCollection++;
            }

        }
        return false;
    }

    @Override
    public Object next() {
        if (hasNext()){
            return messageArrayList.get(indexInCollection++);
        }
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}
