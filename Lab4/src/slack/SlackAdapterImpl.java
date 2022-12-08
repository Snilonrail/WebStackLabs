package slack;
import java.util.*;

public class SlackAdapterImpl implements SlackAdapter{

    private final boolean authorized;
    private String chatName;

    public SlackAdapterImpl(String login, String apiKey, String chatName) throws RuntimeException {
        if (Objects.nonNull(login) && Objects.nonNull(apiKey) && apiKey.length() > 2) {
            this.authorized = true;
            this.chatName = chatName;
        } else {
            throw new RuntimeException("wrong creds");
        }
    }

    @Override
    public void send(String title, String message) {
        System.out.println("Authorised in Slack: " + authorized);
        System.out.println("Message " + message + " sent with title " + title + " to chat " + chatName);
    }
}
