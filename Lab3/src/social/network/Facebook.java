package social.network;

import utils.NotAuthorisedException;
import utils.PasswordValidator;

import java.util.Objects;

public class Facebook implements Network {

    private boolean isLoggedIn;

    @Override
    public void login(String login, String password) {
        if (Objects.nonNull(login) && Objects.nonNull(password) && PasswordValidator.isValid(password)){
            isLoggedIn = true;
        } else {
            throw new IllegalArgumentException("either login or password is incorrect");
        }
    }

    @Override
    public void publish(String postContent) throws NotAuthorisedException {
        if (isLoggedIn) {
            System.out.println("New post:" + postContent);
        } else {
            throw new NotAuthorisedException("not authorized");
        }
    }

}
