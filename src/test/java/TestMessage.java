import org.example.behavorial.message.Message;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestMessage {

    @Test
    public void testSender(){
        Message test = new Message("David", Collections.singletonList(""));
        String senderName = "David";
        assertEquals(senderName, test.getSendName());

    }



    @Test
    public void testRecipients(){
        Message test = new Message("", Arrays.asList("John", "David", "Stubert"));
        List<String> recipients = Arrays.asList("John", "David", "Stubert");
        assertIterableEquals(test.getRecipients(), recipients);
    }


    @Test
    public void testMessageCreation(){
        Message test = new Message("", Arrays.asList(""));
        String actualMessage = "The";
        test.createMessage("The");
        assertEquals(actualMessage, test.getMessageContent());
    }
}
