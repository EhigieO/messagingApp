import java.util.HashSet;
import java.util.Set;

public class Platform {
    Set<User> registeredUsers = new HashSet<>();

    public void register(User user) throws UserAlreadyExistException {
        if (registeredUsers.contains(user)) {
            throw new UserAlreadyExistException("User already exist");
        } else {
            registeredUsers.add(user);
        }
    }

    public int getNumberOfRegisteredUsers() {
        return registeredUsers.size();
    }

    public void register(String username, String email, String password) throws UserAlreadyExistException {
        User user = new User(username, email, password);
        for (User u : registeredUsers) {
            if (u.getUsername().equals(username)) {
                throw new UserAlreadyExistException("Username already exist");
            } else {
                registeredUsers.add(user);
            }
        }
    }

//    public User getUsername(String userName) throws UserDoesNotExistException {
//        User user = null;
//        for (User u : registeredUsers) {
//            if (u.getUsername().equals(userName)) {
//                user = u;
//            } else {
//                throw new UserDoesNotExistException();
//            }
//        }
//        return user;
//    }
    public String getUsername(String userName) throws UserDoesNotExistException {
        String name = null;
        for (User u : registeredUsers) {
            if (u.getUsername().equals(userName)) {
                System.out.println(u.getUsername().equals(userName));
                name = u.getUsername();
            } else {
                throw new UserDoesNotExistException();
            }
        }
        return name;
    }
}

