package org.example.behavorial.message;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.time.*;
import java.util.List;

public class Message {
    private String sendName;
    private List<String> recipients;

    private String messageContent;
    private String timeStamp;


    public Message(String sendName, List<String> recipients){
        this.sendName = sendName;
        this.recipients = recipients;
    }

    public void createMessage(String messageContent){
        this.messageContent = messageContent;
        this.timeStamp = Instant.now().toString();

    }

    public List<String> getRecipients() {
        return recipients;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getSendName() {
        return sendName;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sendName='" + sendName + '\'' +
                ", recipients=" + recipients.toString() +
                ", messageContent='" + messageContent + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                "}\n";
    }
}
