/*
 * Starter file for JHU CTY AP CS Course Final Project
 * Initial code for YahtzeeHand with stub implementations
 */
/*
 * Programmer: Tej Prattipati
 * Course: AP Computer Science A
 * Section: 24I.ACS.CDE.1
 * Assignment: Final Project Part 2
 * Description: Defines the YahtzeeHand class, which contains methods to create and Modify Dice objects, as well as arrays of them. 
 * This allows it to use methods like rollAll, changeHand, and roll to reroll the dice of the user's choice.
 * It also contains a method called showDice which returns a string containing the face and number of each die for the user to make note of when rerolling.
 * Date: 29-July-2024
 */

 // Import ArrayList and Scanner (ArrayList of Dice, Scanner for user input)
 import java.util.ArrayList;
 import java.util.Scanner;
 
 
 public class YahtzeeHand {

    // Creates an array of dice values to be used in showDice method. 
     private int[] current = new int[5];

     // Creates an arrayList of 5 dice. 
     ArrayList<Die> dice = new ArrayList<Die>();
 
     // Create the 5 Dice objects

     Die one = new Die();
     Die two = new Die();
     Die three = new Die();
     Die four = new Die();
     Die five = new Die();
 
     /**
      * Constructor for YahtzeeHand.
      */
     public YahtzeeHand() {

         dice.add(one);
         dice.add(two);
         dice.add(three);
         dice.add(four);
         dice.add(five);
 
         // Initialize the current array by calling getDice.
         current = getDice();

     }
 
     /**
      * Returns an array of integers with current values of the dice.
      * @return The array containing current dice values.
      */
     public int[] getDice() {

         // Update the current array with values of dice.
         for (int i = 0; i < 5; i++) {

             current[i] = dice.get(i).getValue();

         }

         return current;
     }
 
     /**
      * Rolls all dice.
      */
     public void rollAll() {
         // Roll all dice 

             for (int i = 0; i < 5; i++) {

                 dice.get(i).roll();

             }

             
     }
 
     /**
      * Rolls a specific die.
      * @param number The number of the die to roll (1-5).
      */
     public void roll(int number) {

         // Roll a specific die 
         
        dice.get(number - 1).roll();
             
         
     }
 
     /**
      * Allows user to change dice by rolling two more times.
      * User can choose which dice to keep.
      */
     public void changeHand() {
        
        
             Scanner input = new Scanner(System.in);
             // Booleans reflecting if the user chose to keep the die or not
             // Empty print statments for spacing*
             System.out.println("For the following requests, type 1 if you want to reroll, otherwise type anything else");
             System.out.println();
             System.out.println();
            

             // If user enters one, reroll boolean for that dice is set to true, otherwise, it is set to false and the dice will not be rerolled
             // This is the case for all Five dice. 
             System.out.println("Would you like to reroll die One?");
             boolean rerollOne = (input.nextInt() == 1);
             System.out.println();
 
             System.out.println("Would you like to reroll die Two?");
             boolean rerollTwo = (input.nextInt() == 1);
             System.out.println();
 
             System.out.println("Would you like to reroll die Three?");
             boolean rerollThree = (input.nextInt() == 1);
             System.out.println();
 
             System.out.println("Would you like to reroll die Four?");
             boolean rerollFour = (input.nextInt() == 1);
             System.out.println();
 
             System.out.println("Would you like to reroll die Five?");
             boolean rerollFive = (input.nextInt() == 1);
             System.out.println();
 

             // Rerolls the dice that have reroll booleans as true (as set above using userInput)
             System.out.println();
             System.out.println("Rerolling Selected Dice...");
             System.out.println();
             System.out.println();
            
             // rerolls the dice that the user indicated they wanted to roll

             // Rerolls dice if the boolean is true. 
             if (rerollOne) {

                 one.roll();

             }

             // Rerolls dice if the boolean is true. 
             if (rerollTwo) {

                 two.roll();

             }

             // Rerolls dice if the boolean is true. 
             if (rerollThree) {

                 three.roll();

             }

             // Rerolls dice if the boolean is true. 
             if (rerollFour) {

                 four.roll();

             }

             // Rerolls dice if the boolean is true. 
             if (rerollFive) {

                 five.roll();

             }

            
    }
         
     
 
     
     /**
      * Returns the value of a specified die.
      * @param number The number of the die (1-5).
      * @return The value of the specified die.
      */
     public int get(int number) {

         return dice.get(number - 1).getValue();

     }
 
     /**
      * Returns a string representing the current state of the dice.
      * @return A formatted string showing the dice numbers and their values.
      */
     public String showDice() {

         // Updates current with the current dice values. So that everytime display is called, it displays the correct values. 
         getDice();

         return "+------+---+---+---+---+---+\n| Dice | 1 | 2 | 3 | 4 | 5 |\n+------+---+---+---+---+---+\n| Face | " + current[0] + " | " + current[1] + " | " + current[2] + " | " + current[3] + " | " + current[4] + " |\n+------+---+---+---+---+---+";
         
     }
 }
 