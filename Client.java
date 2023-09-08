
/**
 * Write a description of class Client here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Client extends IpMachine {
    /**
     * Constructor for objects of class Client
     */

    public Client(Internet connectedToInternet)
    // The client has to be be connected to an internet when created
    {
        super(connectedToInternet);
    }

    @Override
    public IpMessage receive(IpMessage message) {
        if (message.getRecipient() != this.getId())
            return message; // message er ikke til mig!
        message.hasArrived(); // beskeden er kommet frem.
        System.out.println("clienten " + this + " har modtaget beskeden:");
        message.print();
        System.out.println();

        if (message.getMessage() == "password") {
            getInternet().transmit(new IpMessage(this.getId(), message.getSender(), "1234"));
        }

        // Metoden skal returnere en IpMessage,
        // men det giver ikke mening at sende noget videre,
        // så returnerer null.
        return null;
    }

    public void startSession(String serverId) {
        getInternet().transmit(new IpMessage(this.getId(), serverId, "logon"));
    }

}
