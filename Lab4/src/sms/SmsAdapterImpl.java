package sms;

public class SmsAdapterImpl implements SmsAdapter{
    private Integer phone;
    private String sender;

    public SmsAdapterImpl(String sender, Integer phone){
        this.phone = phone;
        this.sender = sender;
    }

    @Override
    public void send(String title, String message) {
        System.out.println("Sender " + sender + "sends " + message + "\nHis phone: " + phone);
    }
}
