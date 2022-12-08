package builder;

import social.network.LinkedIn;
import social.network.Network;

public class LinkedInBuilder extends NetworkBuilder {

    @Override
    public Network buildNetwork() {

        return new LinkedIn();
    }
}
