import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FriendRequestTest {
    FriendRequest friendRequest;
    @Test
    void createFriendRequest() {
        User user = new User("Daniel","daniel@yahoo.com","queen10");
        User user1 = new User("Susan","susan@yahoo.com","queen10");
        friendRequest = new FriendRequest(user,user1);
        assertEquals(user,friendRequest.getSender());
        assertEquals(user1,friendRequest.getReceiver());
    }
}