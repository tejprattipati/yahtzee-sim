/* Starter file for JHU CTY AP CS Course Final Project 
 * Initial code for Die with stub implementations
 */
/*
*Programmer: Tej Prattpati
*Course: AP Computer Science A
*Section: 24I.ACS.CDE.1
*Assignment: Final Project Part 2
*Description: Defines the die class, which defines a single Die object. It also contains the methods roll and getValue which are used in YahtzeeHand's methods to edit dice values and gather them. 
*Constructor also initializes the die by invoking the roll() method. 
*Date: 29-July-2024
*/
public class Die {

    // Tracks the current value of the die (1-6)
    private int dieVal;

    // Constructor. Starts by rolling the dice to give it an original random value. 
    public Die() {

        // Give die an original random value for dieVal;
        roll();
         
    }
    
    /**
    *Rolls a die and returns its numerical value 
    *@return dieVal
    **/
    public int roll() {

        // generates a random integer between 1 and 6.
        dieVal = (int) (Math.random() * 6) + 1;

        // returns the new value of the die (dieVal)
        return dieVal;

    }
    
   
    /**
    *Returns the value of the die without re-rolling it
    *@return dieVal
    **/
    public int getValue() {

    	return dieVal;

    }
}