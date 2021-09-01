import java.util.*;

public class User {
    private String username;
    private String email;
    private String password;


    Map<String,User> friends = new HashMap<>();
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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void sendFriendRequest(User receiver) {
        FriendRequest friendRequest = new FriendRequest(this,receiver);
        Platform.sendRequest(friendRequest);
    }

    public void acceptFriendRequest(String senderName) {
        Platform.acceptFriendRequest(this,senderName);
    }

    public int getNumberOfFriends() {
        return friends.size();
    }

    public void rejectFriendRequest(String senderName) {
        Platform.rejectFriendRequest(this,senderName);
    }

    public Chat createChatFor(String receiverName) {
        return new Chat(this,receiverName);
    }

    public void sendMessage(String receiverName, String message) {
        if (friends.containsKey(receiverName)) {
            Chat chat = createChatFor(receiverName);
            Platform.sendMessage(chat, message);
            if(!chats.containsKey(receiverName)){
                chats.put(receiverName,chat);
            }
            else {
                chats.get(receiverName)
                        .add(chats.get(receiverName)
                                .getSender()
                                .getUsername(), message);
            }
        }
    }

    public Chat getChatWith(String friendName) {
        return chats.get(friendName);
    }
}
