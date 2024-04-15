package org.example.behavorial.user;

import org.example.behavorial.chat.ChatHistory;
import org.example.behavorial.chat.ChatServer;
import org.example.behavorial.chat.ChatType;
import org.example.behavorial.message.Message;
import org.example.behavorial.message.MessageMemento;

public class User implements IterableByUser{

    private String userName;
    private ChatServer chatServer;
    private ChatHistory inBoundChatHistory, outboundChatHistory;

    private MessageMemento messageMemento;

    public User(String userName, ChatServer chatServer){
        this.userName =  userName;
        this.chatServer = chatServer;
        inBoundChatHistory = new ChatHistory();
        outboundChatHistory = new ChatHistory();
        this.messageMemento = new MessageMemento(null);
    }

    public String getUserName(){
        return userName;
    }


    public void sendMessage(Message message){
        System.out.println("Sent message to " + message.getRecipients().toString());
        messageMemento.setMessageState(message);
        outboundChatHistory.addMessage(message);

    }

    public void undoMessage(){
        outboundChatHistory.removeMessage();
        if (outboundChatHistory.chatHistorySize() == 0){
            messageMemento.setMessageState(null);
        }
        else {
            messageMemento.setMessageState(outboundChatHistory.getMessageHistory().getLast());
        }

    }

    public void receiveMessage(Message message){
        System.out.println("Message received from: " + message.getSendName());
        inBoundChatHistory.addMessage(message);


    }


    public void printChatHistory(ChatType type){
        switch (type){
            case INBOUND -> {
                System.out.println("Printing inbound chat history!");
                chatHistoryHelper(inBoundChatHistory);
            }
            case OUTBOUND -> {
                System.out.println("Printing outbound chat history!");
                chatHistoryHelper(outboundChatHistory);
            }
            default -> System.out.println("Error");
        }


    }

    private void chatHistoryHelper(ChatHistory chatHistory){
        System.out.println(chatHistory);

    }


    public ChatHistory getChatHistory(ChatType type){
        switch (type){
            case OUTBOUND -> {
                return outboundChatHistory;
            }
            case INBOUND -> {
                return inBoundChatHistory;
            }
            default -> {
                return null;
            }

        }

    }



    @Override
    public SearchByUser iterator(User userToSearch) {
        return new SearchByUser(userToSearch);
    }
}
