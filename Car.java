import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Car Class, Creates a car that can move around, 
 * 
 * @author Luigj Ndoja
 * 
 */
public class Car extends Actor
{
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;
    private int maxSpeed;
    private String licensePlate;

    //Constructor with inputs of the default licenseplate and the max speed in, note that the default is over the character limit and how the setLicensePlate method limits it
    public Car(String licensePlateIn, int maxSpeedIn) { 
        this.setLicensePlate(licensePlateIn); 
        this.setMaxSpeed(maxSpeedIn);
    }

    //Setter for current speed, limits it so it cannot be less than 0 and cannot be over the max speed
    public void setSpeed(int speedIn){
        if (speedIn > maxSpeed){
            speed = maxSpeed; //sets speed to max speed if input speed is greater than max speed
        }
        else if (speedIn < 0){
            speed = 0; //sets speed to 0 if the input speed is less than 0
        }
        else{
            speed = speedIn;
        }
    }

    //Setter for max speed, limits it so it cannot be less than 0
    public void setMaxSpeed(int speedIn){
        if (speedIn > 0){ 
            maxSpeed = speedIn;
        }
        else{
            maxSpeed = 0; //sets max speed to 0 if input max speed is less than 0
        }
    }

    //Setter for speed except it sets the speed by increnting it with a change in velocity.
    public void accelerate(int deltaV){
        this.setSpeed(speed+deltaV);
    }

    //Sets the license plate and limits it to 8 characters
    public void setLicensePlate(String licensePlateIn){

        if (licensePlateIn.length() > 8){
            //System.out.print("License Plate has too many characters!");
            licensePlate = licensePlateIn.substring(0,8); // cuts the string into its first 8 characters if its over limit
        }
        else{
            licensePlate = licensePlateIn;
        }
    }

    //returns current set speed
    public int getSpeed(){
        return(speed);
    }

    //returns current max speed
    public int getMaxSpeed(){
        return(maxSpeed);
    }    

    //returns current license plate
    public String getLicensePlate(){
        return(licensePlate);
    }

    //responsible for movement
    public void move(String direction){
        //gets current location
        int y = getY();
        int x = getX();

        switch(direction){    //changes coordinates by speed value dependant on direction      
            case "up":
            y -=speed;
            break;
            case "down":
            y+=speed;
            break;
            case "left":
            x-=speed;
            break;
            case "right":
            x+=speed;  
            break;    
        }
        setLocation(x,y); //sets the location to new x,y values
    }
}
