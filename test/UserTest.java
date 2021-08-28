import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    Platform platform = new Platform();
    User user;
    @BeforeEach
    void setUp() {
        user = new User("Sunny","sunny@gmail.com","queen10");
    }
    @Test
    void userCanRegister() throws UserAlreadyExistException {
        platform.register(user);
        assertEquals(1,platform.getNumberOfRegisteredUsers());
    }
    @Test
    void userCanRegisterWithName() throws UserAlreadyExistException {
        platform.register("Danny","danny@yahoo.com","queen10");
        assertEquals(1,platform.getNumberOfRegisteredUsers());
        platform.register(user);
        assertEquals(2,platform.getNumberOfRegisteredUsers());
    }
    @Test
    void userCannotRegisterTwice() throws UserAlreadyExistException {
        platform.register(user);
        assertEquals(1,platform.getNumberOfRegisteredUsers());
        try {
            platform.register(user);
            assertEquals(1,platform.getNumberOfRegisteredUsers());
        }catch(UserAlreadyExistException er){
            System.out.println(er.getMessage());
        }
        platform.register("Dami","dami@gmail.com","queen10");
        try {
            platform.register("Dami", "dami@gmail.com", "queen10");
            assertEquals(1,platform.getNumberOfRegisteredUsers());
        }catch(UserAlreadyExistException er){
            System.out.println(er.getMessage());
        }
    }

//    @Test
//    void getUsername() throws UserAlreadyExistException, UserDoesNotExistException {
//        platform.register("Dami","dami@gmail.com","queen10");
//        assertEquals("Dami",platform.getUsername("Dami"));
//    }

    @Test
    void getEmail() {
    }

    @Test
    void getPassword() {
    }
    @Test
    void userCanSendFriendRequest() throws UserAlreadyExistException {
        User user1 = new User("dane","dane@gmail.com","queen10");
        platform.register(user1);
        user.sendFriendRequestTo(user1);
    }
}