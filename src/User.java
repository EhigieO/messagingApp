import java.util.*;

public class User {
    private String userName;
    private String email;
    private String password;


    Map<String,User> friends = new HashMap<>();
    List<FriendRequest> receivedFriendRequests = new ArrayList<>();
    List<FriendRequest> sentFriendRequests = new ArrayList<>();
    Map<String, Chat> chats = new HashMap<>();
    private boolean isLoggedIn;

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getUserName() {
        return userName;
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
                "username='" + userName + '\'' +
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
            chat.add(receiverName,message);
            friends.get(receiverName)
                    .receiveMessage(this.userName,message,chat);
            if(!chats.containsKey(receiverName)){
                chats.put(receiverName,chat);
            }
            else {
                chats.get(receiverName)
                        .add(chat.getSender()
                                .getUserName(), message);
            }
        }
    }

    public Chat getChatWith(String friendName) {
        return chats.get(friendName);
    }

    public void receiveMessage(String senderName, String message, Chat chat) {
        if(chats.containsKey(senderName)){
            chats.get(senderName)
                    .add(senderName,message);
        } else {
            chats.put(senderName, chat);
        }
    }

    public void login(String userName, String password) {
        Platform.login(userName, password, this);
    }

    public void isLogin() {
        isLoggedIn = true;
    }
}
