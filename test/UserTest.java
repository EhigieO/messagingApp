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
        assertEquals(1,friend.getNumberOfFriends());
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
    void userCanCreateChat(){
        user.createChatFor("Sunny");
    }
    @Test
    void userCanSendMessage() throws UserAlreadyExistException {
        User userNew= new User("sedge","sege@yahoo.com","queen10");
        Platform.register(userNew);
        Platform.register(user);
        user.sendFriendRequest(userNew);
        userNew.acceptFriendRequest("sade");
        assertEquals(1,user.getNumberOfFriends());
        user.sendMessage("sedge","Hi come help me here");
        assertEquals(1,user.chats.size());
        assertEquals(1,userNew.chats.size());
    }
    @Test
    void userCanGetChats() throws UserAlreadyExistException {
        User userNew= new User("sedge","sege@yahoo.com","queen10");
        Platform.register(userNew);
        Platform.register(user);
        user.sendFriendRequest(userNew);
        userNew.acceptFriendRequest("sade");
        assertEquals(1,user.getNumberOfFriends());
        user.sendMessage("sedge","Hi come help me here");
        user.sendMessage("sedge","are you there");
        assertEquals(1,user.chats.size());
        assertEquals(1,userNew.chats.size());
        System.out.println(user.getChatWith("sedge"));
        System.out.println(userNew.getChatWith("sade"));
        //assertEquals(1,user.getChatWith("sedge"));
    }
    @Test
    void userCanReceiveChat() throws UserAlreadyExistException {
        User userNew= new User("sedge","sege@yahoo.com","queen10");
        String message = "Hi come help me here";
        Platform.register(userNew);
        Platform.register(user);
        user.sendFriendRequest(userNew);
        userNew.acceptFriendRequest("sade");
        user.sendMessage("sedge",message);
        assertNotNull(userNew.chats);
    }

}