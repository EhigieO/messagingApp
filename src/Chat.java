import java.util.ArrayList;
import java.util.List;

public class Chat {
    private final String receiverName;
    private final User sender;
    List<Message> messages = new ArrayList<>();

    public Chat(User sender, String receiverName) {
        this.sender = sender;
        this.receiverName = receiverName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public User getSender() {
        return sender;
    }

    public void add(String senderName, String message) {
        Message myMessage = new Message(senderName,message);
        messages.add(myMessage);
    }

    @Override
    public String toString() {
        return "Chat{" +
                "receiverName='" + receiverName + '\'' +
                ", sender=" + sender +
                ", messages=" + messages +
                '}';
    }

}
