/**
 * Heater class, simulates a heater that can raise or decrease by 5 degrees
 * 
 * @author Luigj Ndoja 
 *
 */
public class Heater  
{
    // instance variables - replace the example below with your own
    private int temp;

    // Constructer with no inputs
    public Heater()
    {
        temp = 15; // sets starting temp to 15
    }

    // method raises temp value by 5
    public void raiseTemp(){
        temp+=5;        
    }

    // method lowers temp value by 5
    public void lowerTemp(){
        temp-=5;
    }

    // method returns temp value
    public int showTemp(){
        return(temp);
    
    }
}
