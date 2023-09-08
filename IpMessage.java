
/**
 * IpMessage emulerer en besked sendt over internettet.
 * Du er velkommen til at lave så mange String-felter som du lyster
 * I virkeligheden er det IpMessage en lang string og de forskellige felter
 * svarer så til forskellige dele
 * af den lange samlede String, men det er noget nemmere at arbejde med
 * forskellige felter til forskellige formål
 * 
 * Husk blot, hvis du tilføjer flere felter til IpMessage, så skal du også
 * udskrive dem i print
 * (ellers er det snyd for en Hacker kan se hele den lange String)
 *
 * @author Kasper Astrup Eriksen
 * @version (v1)
 */
public class IpMessage implements Cloneable // implements Cloneable er for at
// det er muligt at lave en kopi af en IpMessage med den indbygged .clone()
// method.
{
    // instance variables - replace the example below with your own
    private String from; // Id på afsenderen af beskeden
    private String to; // Id på modtageren af beskeden
    private String message; // noget indholdstekst
    private String hash;
    // Husk at tilføje til print-metoden, hvis du tilføjer flere felter.

    private boolean arrived; // markerer beskeden er kommet frem. bruges vist ikke til så meget pt.

    /**
     * Constructor for objects of class IpMessage
     */
    public IpMessage()
    // Laver en tom død besked
    {
        arrived = true;
        // resten af variablerne er bare null.
    }

    public IpMessage(String from, String to, String message) {
        // initialise instance variables
        this.from = from;
        this.to = to;
        this.message = message;
        arrived = false;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param y a sample parameter for a method
     * @return the sum of x and y
     */
    public String getRecipient() {
        // put your code here
        return to;
    }

    public void setRecipient(String to) {
        this.to = to;
    }

    public String getSender() {
        // put your code here
        return from;
    }

    public void setSender(String from) {
        this.from = from;
    }

    public String getMessage() {
        // put your code here
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /*
     * public boolean isDeleted()
     * {
     * // put your code here
     * return !deleted;
     * }
     */

    public boolean getArrived() {
        // put your code here
        return arrived;
    }

    public void hasArrived() {
        arrived = true;
    }

    public void delete() {
        hasArrived();
        this.to = null;
        this.from = null;
        this.message = null;
    }

    public void print() {
        System.out.println("IpMessage: " + this);
        System.out.println("From: " + getSender());
        System.out.println("To: " + getRecipient());
        System.out.println("Message: " + getMessage());
        //System.out.println("Hash: " + g
    }

    @Override // Lidt langhåret syntaks for at kunne bruge den indbyggede clone funktion til
              // at lave en kopi af beskeden.
    public IpMessage clone() {
        try {
            return (IpMessage) super.clone();
        } catch (CloneNotSupportedException cnse) {
            cnse.printStackTrace();
            return this; // hvis ikke muligt at clone så giv oprindelig besked tilbage.
        }

    }
}
