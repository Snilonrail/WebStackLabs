import builder.FacebookBuilder;
import builder.LinkedInBuilder;
import builder.NetworkBuilder;
import social.network.Facebook;
import social.network.Network;
import utils.NotAuthorisedException;

public class Main {

    public static void main(String[] args) throws NotAuthorisedException {
        NetworkBuilder LINKED_IN_CREATOR = new LinkedInBuilder();
        NetworkBuilder FACEBOOK_CREATOR = new FacebookBuilder();

        Network fbInstance = FACEBOOK_CREATOR.getInstance("A_user", "A~$^+=<>a1");
        Network linkedIninstance= LINKED_IN_CREATOR.getInstance("An_email", "A[{}]:;',?/*a1");

        fbInstance.publish("Message 0");
        linkedIninstance.publish("something");

        try{
            Facebook fb = new Facebook();
            fb.publish("Message 1");
        } catch (NotAuthorisedException ex){
            System.out.println(ex.getMessage());
            System.out.println("Attempt to publish with authorisation");
        }
    }

}