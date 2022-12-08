package builder;

import social.network.Network;

public abstract class NetworkBuilder {

    public abstract Network buildNetwork();

    public Network getInstance(String index, String pas) {
        Network network = buildNetwork();
        network.login(index, pas);
        System.out.println("Network " + network.getClass() + " created");
        return network;
    }

}
