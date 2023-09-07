import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

/**
 * Write a description of class IpMachine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IpMachine
{
    // instance variables - replace the example below with your own
    private Internet internet;
    private String id; //gets set when the machine is connected to an internet.

    /**
     * Constructor for objects of class Client
     */
    
    public IpMachine(Internet connectedToInternet)
    //The IpMachine has to be be connected to/associated with an internet when created
    {
        // initialise instance variables
        internet = connectedToInternet;
        id = internet.connect(this);
    }
    /**
     * Constructor for objects of class IpMachine
     */
    public IpMachine()
    {
        // initialise instance variables
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
     public IpMessage receive(IpMessage message)    
     {
        // put your code here
        IpMessage transmittedMessage = message.clone();  //For at sikre afsenderen ikke kan se hvordan modtageren ændrer på message.
        if (transmittedMessage.getRecipient() == this.getId()) {
            transmittedMessage.hasArrived();
        };
        return transmittedMessage;
    }
    
    public Internet getInternet()
    {
        return internet;
    }
    
    public String getId()
    {
        return id;
    }
    
    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + " med id: " + id; 
    }
    
    /* koden er taget fra https://www.geeksforgeeks.org/sha-256-hash-in-java/
     * 
     */
    private String toHexString(byte[] hash)
    {
        //Hvis hashen skal repræsenteres som en Integer 
        //er tallet enormt og derfor skal vi bruge BigInteger 
        // der kan gemme vilkårligt store tal.
        BigInteger number = new BigInteger(1, hash); //1 er fortegnet på number (positiv)
        
        // Convert hash into hex value string.
        //Stringbuilder er en "slags" string man kan ændre i (mutable).
        //StringBuilder hexString = new StringBuilder(number.toString());
        String hexString2 = number.toString();
        
        //Pad with leading zeros as a sha256-hash always is 64 hexnumbers long
        while (hexString2.length() < 64)
        {
            //hexString.insert(0, '0');
            hexString2 = "0" + hexString2;
        }
        
        //return hexString.toString();
        return hexString2;
    }
    
    public String hash(String tekst)
    {
        MessageDigest md;
        try
        {
             md = MessageDigest.getInstance("Sha-2896");
        }
        catch (NoSuchAlgorithmException e) //skal håndtere at getInstance 
        //giver en fejl hvis jeg f.eks. havde stavert sha-256 forkert.
        //eller en gang i fremtiden af getInstance ikke understøtter sha256,
        {
            System.out.println("FEJL i IpMachine.hash: hash kunne ikke finde algoritmen, så");
            System.out.println("teksten " + tekst + " blev ikke hashet!!" );
            System.out.println("Istedet blev teksten " + tekst + " returneret");
            e.printStackTrace();
            System.out.println(e);
            return tekst;
        }
        //Hashing foregår åbenbart på byteniveau
        //Så først laves teksten om til en byte-array
        byte[] tekstAsBytes = tekst.getBytes(StandardCharsets.UTF_8);
        //så hashes teksten som byte-array til en byte-array (med 32 bytes)
        byte[] hashAsBytes = md.digest(tekstAsBytes);
        //Til sidst laver vi hashen på byte -form om til en String
        return toHexString(hashAsBytes);
    }
}
