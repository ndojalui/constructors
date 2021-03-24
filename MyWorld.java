
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * World contains all the classes we are testing and implements methods to test them by using user input.
 * 
 * @author Luigj Ndoja 
 * 
 */
public class MyWorld extends World
{

    private Car testCar; //makes car variable be usable throughout the class
    private Heater testHeater;
    private RoachPopulation testRoach;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        testHeater = new Heater(); //Adds heater class to the world

        addObject(new Car("LicensePlateThatIsOver8Characters",50),300,200); //Adds the car to the world
        //Gets car and makes it a variable we can use 
        List carList = getObjectsAt(300,200,Car.class);
        testCar = (Car)(carList.get(0));
        testCar.setSpeed(10); //sets the initial speed to 10
    }

    //Loops while run is playing
    public void act(){
        String key = Greenfoot.getKey();

        //Text being displayed to show values and controls to the user
        showText("Press 'shift' to accelerate, \r\n and 'control' to slow down",130,50);
        showText("Speed of car is "+Integer.toString(testCar.getSpeed())+" Max speed is "+Integer.toString(testCar.getMaxSpeed())+"\r\n License Plate is "+testCar.getLicensePlate(),160,110);
        showText("Press 'q' to set the max speed",145,160);
        showText("Press 'e' to set the license plate",145,160);
        showText("Press 'h' for Heater test",400,350);
        showText("Press 'r' for Roach Population test",400,300);

        if (key!=null){
            System.out.println(key);
            testCar.move(key); //Moves car dependent of arrow keys
            switch (key){ //dependent on keys pressed, will run functions of car class / run the other tests.
                case "shift": // accelerates by 5
                testCar.accelerate(5);
                break;
                case "control": // slows down by 5
                testCar.accelerate(-5);// negative value will slow it down
                break;
                case "q": // sets max speed
                int maxSpeed = Integer.parseInt(Greenfoot.ask("Enter desired max speed "));
                testCar.setMaxSpeed(maxSpeed);
                break;
                case "e": // sets license plate
                String plate = Greenfoot.ask("Enter desired License Plate (max 8 characters)");
                testCar.setLicensePlate(plate);
                break;
                case "h": // heater test
                for(int i=0;i<4;i++){
                    if (i < 3){ // will raise temp 3 times
                        testHeater.raiseTemp();
                    }
                    else{testHeater.lowerTemp();} // will lower temp 2 times
                    Greenfoot.delay(20); // time between runs
                    showText("Temperature is "+Integer.toString(testHeater.showTemp()),400,350); //displays resulting temperature
                }
                break;
                case "r": //roach population test
                int startPop = Integer.parseInt(Greenfoot.ask("Enter desired starting population "));
                testRoach = new RoachPopulation(startPop); //sets starting population to value determined by user
                for (int i=0;i<3;i++){ // runs simulation 3 times.
                    Greenfoot.delay(20); // time between runs
                    testRoach.growth();
                    testRoach.spray();
                    int popSize = testRoach.getSize();
                    showText("Population size is "+Integer.toString(popSize),400,300); // displays resulting population
                }
                break;
            }
        }

    }
}
