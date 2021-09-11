import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.runners.model.MultipleFailureException.assertEmpty;

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
    @Test
    void userCanDeleteAMessage(){
        User userNew= new User("sedge","sege@yahoo.com","queen10");
        String message = "Hi come help me here";
        try {
            Platform.register(userNew);
        } catch (UserAlreadyExistException e) {
            e.printStackTrace();
        }
        try {
            Platform.register(user);
        } catch (UserAlreadyExistException e) {
            e.printStackTrace();
        }
        user.sendFriendRequest(userNew);
        userNew.acceptFriendRequest("sade");
        assertEquals(0,user.chats.size());
        user.sendMessage("sedge",message);
        assertEquals(1,user.chats.size());
        user.deleteMessage("sedge",0);
        assertEquals(0,user.chats.get("sedge").messages.size());

    }@Test
    void userCanDeleteChat(){
        User userNew= new User("sedge","sege@yahoo.com","queen10");
        String message = "Hi come help me here";
        try {
            Platform.register(userNew);
        } catch (UserAlreadyExistException e) {
            e.printStackTrace();
        }
        try {
            Platform.register(user);
        } catch (UserAlreadyExistException e) {
            e.printStackTrace();
        }
        user.sendFriendRequest(userNew);
        userNew.acceptFriendRequest("sade");
        assertEquals(0,user.chats.size());
        user.sendMessage("sedge",message);
        assertEquals(1,user.chats.size());
        user.deleteChat("sedge");
        assertEquals(0,user.chats.size());
    }

//    @Test
//    void test(){
//        System.out.println(randomGen());
//    }
//    public boolean randomGen(){
//        int [][] numbers = {{1,2,4,3,5},{6,7,8,9},{10,21,10}};
//        for (int i = 0; i < numbers.length; i ++){
//            for (int j = 0; j < numbers[i].length; j++){
//                System.out.printf("%5d",numbers[i][j]);
//            }
//            System.out.println();
//        }
//        return false;
//    }
//
//    public int randomPrime(){
//        SecureRandom random = new SecureRandom();
//        int ranGen = 500000 + random.nextInt(1000001);
//        boolean notFound = false;
//        while (!notFound){
//            for (int i = 2; i <= Math.sqrt(ranGen); i++) {
//                if (ranGen % i != 0){
//                    continue;
//                }
//                notFound= true;
//            }
//            if (notFound){
//                return ranGen;
//            }
//            else{
//                ranGen = 500000 + random.nextInt(1000001);
//            }
//        }
//        return ranGen;
//    }

}