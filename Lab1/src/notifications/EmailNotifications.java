package notifications;

import model.User;

import java.util.List;

public class EmailNotifications extends Notifications {

    @Override
    public void notifyUsers(String text, List<User> notifiedStorageUsers) {
       super.notifyUsers(text, notifiedStorageUsers);
    }

}
