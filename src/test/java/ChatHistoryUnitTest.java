import org.example.behavorial.chat.ChatServer;
import org.example.behavorial.chat.ChatType;
import org.example.behavorial.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChatHistoryUnitTest {

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
    public void testOutboundHistory(){
        chatServer.sendMessage(user1, Collections.singletonList("Miguel S"), "Hey");
        assertEquals(1, user1.getChatHistory(ChatType.OUTBOUND).chatHistorySize());
    }

    @Test
    public void testInboundHistory(){
        chatServer.sendMessage(user1, Collections.singletonList("Miguel S"), "Hey");
        assertEquals(0, user1.getChatHistory(ChatType.INBOUND).chatHistorySize());
    }




}
