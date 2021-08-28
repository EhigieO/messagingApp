import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String username;
    private String email;
    private String password;


    List<User> friends = new ArrayList<>();
    List<FriendRequest> receivedFriendRequests = new ArrayList<>();
    List<FriendRequest> sentFriendRequests = new ArrayList<>();
    Map<String, Chat> chats = new HashMap<>();

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }


    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }

    public void sendFriendRequestTo(User user1) {

    }
}
