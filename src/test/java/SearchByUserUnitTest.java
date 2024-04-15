import org.example.behavorial.chat.ChatServer;
import org.example.behavorial.user.SearchByUser;
import org.example.behavorial.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchByUserUnitTest {

    private ChatServer chatServer;
    private User user1, user2;

    private SearchByUser chatHistoryIterator;

    @BeforeEach
    public void setUp(){
        chatServer = new ChatServer();
        user1 = new User("David", chatServer);
        user2 = new User("Miguel", chatServer);
        chatServer.registerUser(user1);
        chatServer.registerUser(user2);


        chatServer.sendMessage(user1, Collections.singletonList("Miguel"), "Hi MigL");
        chatServer.sendMessage(user1, Collections.singletonList("Miguel"), "Hi MigL again");


    }


    @Test
    public void testHasNext(){
        chatHistoryIterator = user1.iterator(user2);
        assertTrue(chatHistoryIterator.hasNext());


    }



    @Test
    public void testNext(){
        chatHistoryIterator = user1.iterator(user2);
        assertNotNull(chatHistoryIterator.next());
    }
}
