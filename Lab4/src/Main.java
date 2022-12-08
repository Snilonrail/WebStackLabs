import ititialCode.EmailNotification;
import ititialCode.Notification;
import slack.SlackAdapter;
import slack.SlackAdapterImpl;
import sms.SmsAdapterImpl;

public class Main {

    public static void main(String[] args) {
        Notification email1 = new EmailNotification("someStrngeEmail@gmail.com");
        SlackAdapter slackMes1 = new SlackAdapterImpl("parent1", "apiKey", "Parents_chat");
        SlackAdapter slackMes2 = new SlackAdapterImpl("child1", "apiKey", "Children_chat");
        email1.send("my message to all", "something goes here");
        slackMes1.send("so what is title?", "writing some nonsense");
        slackMes2.send("hilfe", "my parents hide chocolate");
        SmsAdapterImpl smsAdapterImpl1 = new SmsAdapterImpl("Sender 1", 989990);
        SmsAdapterImpl smsAdapterImpl2 = new SmsAdapterImpl("Sender 2",44489790);
        smsAdapterImpl1.send("new sms", "what's up?");
        smsAdapterImpl2.send("old sms", "I'm ok");
    }

}