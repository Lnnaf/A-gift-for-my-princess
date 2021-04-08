package login.com.demo.payload.repose;

public class MessageRepose {
    private String message;

    public MessageRepose(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
