
/**
 * Write a description of class Server here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Server extends IpMachine {
    // instance variables - replace the example below with your own
    private String password; // skal nok laves til en samling af passwords som er unikke for de enkelte
                             // klienter/users

    /**
     * Constructor for objects of class Server
     */
    public Server(Internet connectedToInternet) {
        super(connectedToInternet); // Kald konstruktøren i IpMachine
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param y a sample parameter for a method
     * @return the sum of x and y
     */
    @Override // Metoden findes også i IpMachine, så vi overskriver den metode med vores egen.
    public IpMessage receive(IpMessage message) {
        if (message.getRecipient() != this.getId())
            return message; // message er ikke til mig!
        message.hasArrived(); // beskeden er kommet frem.
        System.out.println("serveren " + this + " har modtaget beskeden:");
        message.print();
        System.out.println();
        if (message.getMessage() == "logon") {
            getInternet().transmit(new IpMessage(this.getId(), message.getSender(), "password"));
        } else if (message.getMessage() == password) {
            getInternet().transmit(
                    new IpMessage(this.getId(), message.getSender(), "Du har nu adgang til alle mine hemmeligheder"));
        }
        // Metoden skal returnere en IpMessage,
        // men det giver ikke mening at sende noget videre,
        // så returnerer null.
        return null;
    }

    public void setPassword(String userId, String newPassword) {
        password = newPassword;
        // userId is currently not used, but may be in a future version.
    }
}
