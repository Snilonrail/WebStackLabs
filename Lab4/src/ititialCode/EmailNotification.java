package ititialCode;

public class EmailNotification implements Notification {

    private String sender;

    public EmailNotification(String sender){
        this.sender = sender;
    }

    @Override
    public void send(String title, String message) {
        sendEmail(title, message);
    }

    private void sendEmail(String title, String message) {
        System.out.println("Email title " + title + " from " + sender + " with text: " + message);
    }
}
