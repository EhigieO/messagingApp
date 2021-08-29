import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user = new User("sade","sade@yahoo.com","queen10");
    @Test
    void userCanAddFriend() throws UserAlreadyExistException {
        User friend = new User("danny","danny@yahoo.com","queen10");
        Platform.register(friend);
        user.sendFriendRequest(friend);
        assertEquals(1,friend.receivedFriendRequests.size());
    }

    @Test
    void getEmail() {

    }

    @Test
    void getPassword() {

    }
    @Test
    void acceptFriend() throws UserAlreadyExistException {
        User friend = new User("Blessing","blessing@yahoo.com","queen10");
        Platform.register(user);
        friend.sendFriendRequest(user);
        user.acceptFriendRequest("Blessing");
        assertEquals(1,user.getNumberOfFriends());
    }
    @Test
    void userCanRejectFriendRequest() throws UserAlreadyExistException {
        User enemy = new User("solo","solo@gmaail.com","queen10");
        Platform.register(enemy);
        enemy.sendFriendRequest(user);
        user.rejectFriendRequest("solo");
        assertEquals(0,enemy.sentFriendRequests.size());
        assertEquals(0,user.friends.size());
    }
    @Test
    void userCanSendMessage(){
        user.sendMessage("senderName","Message");
    }
}