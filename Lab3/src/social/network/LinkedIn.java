package social.network;

import utils.NotAuthorisedException;
import utils.PasswordValidator;

import java.util.Objects;

public class LinkedIn implements Network {

    private boolean isLoggedIn;

    @Override
    public void login(String email, String password) {
        if (Objects.nonNull(email) && Objects.nonNull(password) && PasswordValidator.isValid(password)){
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
