package builder;

import social.network.Facebook;
import social.network.Network;

public class FacebookBuilder extends NetworkBuilder {

    @Override
    public Network buildNetwork() {

        return new Facebook();
    }

}
