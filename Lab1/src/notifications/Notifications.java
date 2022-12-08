package notifications;

import model.User;

import java.util.List;

public abstract class Notifications {
    public void notifyUsers(String notification, List<User> notifiedStorageUsers){
        System.out.println("Send from: " + this.getClass().getName() + "\n" + notification + "\n");
    }
}
