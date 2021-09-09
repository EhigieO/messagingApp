import java.util.HashMap;

public class Platform {
    static HashMap<String, User> registeredUsers = new HashMap<>();

    public static void register(User user) throws UserAlreadyExistException {
        if (registeredUsers.containsKey(user.getUserName())) {
            throw new UserAlreadyExistException("This user already exist");
        } else {
            registeredUsers.put(user.getUserName(), user);
        }

    }

    public static int getNumberOfRegisteredUsers() {
        return registeredUsers.size();
    }

    public static void register(String username, String email, String password) throws UserAlreadyExistException {
        User user = new User(username, email, password);
        if (registeredUsers.containsKey(user.getUserName())) {
            throw new UserAlreadyExistException(username + " already exist");
        } else {
            registeredUsers.put(user.getUserName(), user);
        }
    }


    public static User getUsername(String userName) throws UserDoesNotExistException {
        User user;
        if (registeredUsers.containsKey(userName)) {
            user = registeredUsers.get(userName);
        } else {
            throw new UserDoesNotExistException("user nor found");
        }
        return user;
    }

    public static void sendRequest(FriendRequest friendRequest) {
        if (registeredUsers.containsKey(friendRequest.getReceiver().getUserName())) {
            friendRequest.getSender().sentFriendRequests.add(friendRequest);
            friendRequest.getReceiver().receivedFriendRequests.add(friendRequest);
        }
    }

    public static void acceptFriendRequest(User receiver, String senderName) {
        for (FriendRequest u : receiver.receivedFriendRequests) {
            if (u.getSender().getUserName().equals(senderName)) {
                User friend = u.getSender();
                receiver.receivedFriendRequests.remove(u);
                receiver.friends.put(senderName, friend);
                friend.sentFriendRequests.remove(u);
                friend.friends.put(receiver.getUserName(), receiver);
            }
            break;
        }
    }

    public static void rejectFriendRequest(User receiver, String senderName) {
        for (FriendRequest u : receiver.receivedFriendRequests) {
            if (u.getSender().getUserName().equals(senderName)) {
                User enemy = u.getSender();
                receiver.receivedFriendRequests.remove(u);
                enemy.sentFriendRequests.remove(u);
            }
            break;
        }
    }

    public static void login(String userName, String password, User user) {
        if (registeredUsers.containsKey(userName) && user.getPassword().equals(password)){
            user.isLogin();
        }
    }
}

