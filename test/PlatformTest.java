
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class PlatformTest {

    @Test
    void userCanRegister() throws UserAlreadyExistException {
        User user = new User("Sunny","sunny@gmail.com","queen10");
        User user1 = new User("jake","jake@gmail.com","queen10");
        Platform.register(user);
        assertEquals(1, Platform.getNumberOfRegisteredUsers());
        Platform.register("jake","jake@gmail.com","queen10");

        try{
            Platform.register(user1);
        assertEquals(2, Platform.getNumberOfRegisteredUsers());}
        catch (UserAlreadyExistException er){
            System.out.println(er.getMessage());
        }
    }
    @Test
    void userCanRegisterWithName() throws UserAlreadyExistException {
        User user = new User("Sunny","sunny@gmail.com","queen10");
        Platform.register("Danny","danny@yahoo.com","queen10");
        assertEquals(1, Platform.getNumberOfRegisteredUsers());
        Platform.register(user);
        assertEquals(2, Platform.getNumberOfRegisteredUsers());
    }
    @Test
    void userCannotRegisterTwice() throws UserAlreadyExistException {
        User user = new User("dami","sunny@gmail.com","queen10");
        Platform.register(user);
        try {
            Platform.register("Dami", "dami@gmail.com", "queen10");
            assertEquals(2, Platform.getNumberOfRegisteredUsers());
        }catch(UserAlreadyExistException er){
            System.out.println(er.getMessage());
        }
    }

    @Test
    void userCanSendFriendRequest() throws UserAlreadyExistException {
        User user = new User("dan","dane@gmail.com","queen10");
        User user1 = new User("dane","dane@gmail.com","queen10");
        FriendRequest friendRequest = new FriendRequest(user,user1);
        Platform.register(user1);
        Platform.sendRequest(friendRequest);
        assertEquals(1,user.sentFriendRequests.size());
    }
    @Test
    void userCanLogin(){
        User user = new User("dan","dane@gmail.com","queen10");
        user.login("dan", "queen10");
    }
}