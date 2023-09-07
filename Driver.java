
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    // instance variables - replace the example below with your own
    
    /**
     * Constructor for objects of class Driver
     */
    public Driver()
    {
        // initialise instance variables
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main()
    {
        // put your code here
        Internet internet = new Internet();
        //HackerListener nsa = new HackerListener(internet);
        Client mathilde = new Client(internet);
        Server server = new Server(internet);
        server.setPassword(mathilde.getId(), "1234");
        //System.out.println(client.getId());
        //IpMessage ipM = new IpMessage(client.getId(), client.getId(), "hul igennem");
        //internet.transmit(ipM);
        mathilde.startSession(server.getId());
    }
}








