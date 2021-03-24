/**
 * Roach Population class, simulations growth of roach population in a kitchen
 * 
 * @author Luigj Ndoja 
 * 
 */
public class RoachPopulation  
{
    // instance variables - replace the example below with your own
    private int populationSize;

    // constructer with starting pop input
    public RoachPopulation(int startPop){    
        if (startPop < 0){ // sets negative values to positive 
            startPop *=-1;
        }

        populationSize = startPop; //sets population size to input population

    }

    // method doubles population size
    public void growth(){    
        populationSize *=2;
    }

    // method reduces population size by 10%
    public void spray(){
        populationSize-= populationSize*0.1;
    }

    // method returns population size
    public int getSize(){
        return populationSize;
    }
}
