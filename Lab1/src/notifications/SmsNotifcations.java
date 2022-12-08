package notifications;

import model.User;

import java.util.List;

public class SmsNotifcations extends Notifications {

    @Override
    public void notifyUsers(String notification, List<User> notifiedStorageUsers) {
        super.notifyUsers(notification, notifiedStorageUsers);
    }

}
