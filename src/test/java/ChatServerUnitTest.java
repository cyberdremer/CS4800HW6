import org.example.behavorial.chat.ChatServer;
import org.example.behavorial.chat.ChatType;
import org.example.behavorial.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChatServerUnitTest {

    private ChatServer chatServer;
    private User user1, user2;

    @BeforeEach
    public void setUp(){
        chatServer = new ChatServer();
        user1 = new User("David", chatServer);
        user2 = new User("Miguel S", chatServer);
        chatServer.registerUser(user1);
        chatServer.registerUser(user2);

    }

    @Test
    public void testUserDoesNotExist(){
        assertFalse(chatServer.userExists("David L"));

    }


    @Test
    public void testUserRegistration(){
        assertTrue(chatServer.userExists("David"));
    }


    @Test
    public void testBlockUser(){
        chatServer.blockUser("David", "Miguel S");
        assertTrue(chatServer.isBlocked("Miguel S", "David"));


    }

    @Test
    public void testUnregisterUser(){
        chatServer.unregisterUser(user1);
        assertFalse(chatServer.userExists("David"));
    }

    @Test
    public void testSendMessage(){
        List<String> recipients = new ArrayList<>();
        recipients.add("Miguel S");
        chatServer.sendMessage(user1, recipients, "Hello Miguel!");
        assertEquals(1, user2.getChatHistory(ChatType.INBOUND).chatHistorySize());
    }





}
