
/**
 * Write a description of class HackerListener here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HackerListener extends IpMachine {
    // instance variables - replace the example below with your own
    private Internet internet;

    /**
     * Constructor for objects of class HackerListener
     */
    public HackerListener(Internet connectIntoInternet) {
        // initialize instance variables
        internet = connectIntoInternet;
        internet.addMachine(this);
    }

    @Override
    public IpMessage receive(IpMessage message) {
        System.out.println("Hacker " + this + " har opsnappet beskeden");
        message.print();
        System.out.println();
        return message;
    }

}
