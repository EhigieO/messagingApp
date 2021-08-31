import java.util.HashMap;

import static javax.sound.midi.MidiSystem.getReceiver;

public class Platform {
    static HashMap<String, User> registeredUsers = new HashMap<>();

    public static void register(User user) throws UserAlreadyExistException {
        if (registeredUsers.containsKey(user.getUsername())) {
            throw new UserAlreadyExistException("This user already exist");
        } else {
            registeredUsers.put(user.getUsername(), user);
        }

    }

    public static int getNumberOfRegisteredUsers() {
        return registeredUsers.size();
    }

    public static void register(String username, String email, String password) throws UserAlreadyExistException {
        User user = new User(username, email, password);
        if (registeredUsers.containsKey(user.getUsername())) {
            throw new UserAlreadyExistException(username + " already exist");
        } else {
            registeredUsers.put(user.getUsername(), user);
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
        if (registeredUsers.containsKey(friendRequest.getReceiver().getUsername())) {
            friendRequest.getSender().sentFriendRequests.add(friendRequest);
            friendRequest.getReceiver().receivedFriendRequests.add(friendRequest);
        }
    }

    public static void acceptFriendRequest(User receiver, String senderName) {
        for (FriendRequest u : receiver.receivedFriendRequests) {
            if (u.getSender().getUsername().equals(senderName)) {
                User friend = u.getSender();
                receiver.receivedFriendRequests.remove(u);
                receiver.friends.put(senderName, friend);
                friend.sentFriendRequests.remove(u);
                friend.friends.put(receiver.getUsername(), receiver);
            }
            break;
        }
    }

    public static void rejectFriendRequest(User receiver, String senderName) {
        for (FriendRequest u : receiver.receivedFriendRequests) {
            if (u.getSender().getUsername().equals(senderName)) {
                User enemy = u.getSender();
                receiver.receivedFriendRequests.remove(u);
                enemy.sentFriendRequests.remove(u);
            }
            break;
        }
    }

    public static void sendMessage(Chat chat, String message) {
        chat.add(chat
                .getSender()
                .getUsername(), message);

        registeredUsers.get(chat.getReceiverName())
                .chats
                .put(chat.getReceiverName(), chat);
    }
}

