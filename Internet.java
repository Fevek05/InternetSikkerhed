import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.HashMap;


/**
 * Write a description of class Internet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Internet
{
    
    // instance variables - replace the example below with your own
    private Collection<IpMachine> computers;
    private int current_id_number = 0; //to make the id unique.
    private HashMap<String, IpMachine> id2IpMachine; //en slags DNS-server
    
    
    /**
     * Constructor for objects of class Internet
     */
    public Internet()
    {
        // initialise instance variables
        computers = new ArrayList<>();
        id2IpMachine = new HashMap<>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void transmit(IpMessage message)
    {
        IpMessage transmittedMessage = message.clone();
        //send the message through all the computers on the internet including potential hackers
        Iterator<IpMachine> machines = computers.iterator();
        while (machines.hasNext() && !transmittedMessage.getArrived()) 
        {
            IpMachine machine = machines.next();
            transmittedMessage = machine.receive(transmittedMessage); 
        }
        //Finally send the message to the intended recipient if it was not 
        // interrupted along the way.
        id2IpMachine.get(transmittedMessage.getRecipient())
        .receive(transmittedMessage);
    }
    
    public void addMachine(IpMachine machine)
    {
        computers.add(machine);
    }
    
    public String connect(IpMachine machine)
    {
        current_id_number++;
        String id;
        if (machine.getClass().getSimpleName() == "Client") {
            id = "user"+ current_id_number;
        } else {
            id = "www." +  machine.getClass().getSimpleName() + current_id_number + ".net";
        }
        id2IpMachine.put(id, machine);
        return id;
    }
    
}
