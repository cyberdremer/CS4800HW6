package org.example.behavorial.message;

public class MessageMemento {
    private Message messageState;

    public MessageMemento(Message message){
        this.messageState = message;

    }

    public void setMessageState(Message messageState) {
        this.messageState = messageState;
    }

    public Message getMessageState() {
        return messageState;
    }
}
