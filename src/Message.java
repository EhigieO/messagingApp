import java.time.LocalDate;

public class Message {
    private final String senderName;
    private final String message;
    private final LocalDate date = LocalDate.now();


    public Message(String senderName, String message) {
        this.senderName = senderName;
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "senderName='" + senderName + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}

