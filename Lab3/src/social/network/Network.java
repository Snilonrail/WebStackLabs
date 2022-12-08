package social.network;

import utils.NotAuthorisedException;

public interface Network {

    void login(String id, String password);
    void publish(String text) throws NotAuthorisedException;

}
