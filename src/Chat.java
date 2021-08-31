import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chat {
    private String receiverName;
    private User sender;
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
        Message messager = new Message(senderName,message);
        messages.add(messager);
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
