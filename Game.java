/*
 * Programmer: Tej Prattipati
 * Course: AP Computer Science A
 * Section: 24I.ACS.CDE.1
 * Assignment: Final Project Part 2
 * Description: Defines the Game class, which manages the flow of a single-player Yahtzee game.
 * It includes methods to display the scorecard, run the game, handle turns, and manage rerolling and scoring sequences.
 * Date: 29-July-2024
 */

 // Import Scanner Class for user input
import java.util.Scanner;

public class Game {

    // Stores the final score of the game.
    private int finalScore;

    // Stores the number of categories that were scored out of the 13.
    private int scoredCategories = 0;


    private int turnNumber = 1;
    private ScoreCard card = new ScoreCard();

    /*
    How the Scorecard should look for reference
     * -- Upper Section --
               1s 
               2s 
               3s   9 
               4s 
               5s 
               6s 
      Upper Total   9    
      Upper Bonus   0    
 -- Lower Section --
  Three of a Kind 
   Four of a Kind 
       Full House  25 
   Small Straight 
   Large Straight 
           Chance 
     */

     
    /**
     * Displays the scoreCard using the displayScoreCard metod of the ScoreCard Class.
     */
    public void displayScoreCard() {

        card.displayScoreCard();

    }

    /**
     * Runs a full game of single player Yahtzee. Uses a for loop of 13 turns.
     */
    public void runGame() {

        // Creates a new YahtzeeHand object to be used throughout this game in all methods. 
        YahtzeeHand hand = new YahtzeeHand();
        
        // For loop of 13 turns. Turns are independent and run using the turn method 
        for (int i = 0; i < 13; i++) {

            // turn method for a new turn. 
            turn(hand);

        }

        // gets the Final Total Score from the scoreCard.
        finalScore = card.getFinalScore();
        // gets the number of Categories that were scored in. 
        scoredCategories = card.getScoredCategories();
        System.out.println("The game is over. Your total Score for this game is: " + finalScore);
        System.out.println("You managed to score points in " + scoredCategories + " categories!");

    }

    /**
     * Runs one turn of Yahtzee, updating the necessary variables and collecting user input when needed.
     * @param hand - YahtzeeHand object
     */
    public void turn(YahtzeeHand hand) {

        System.out.println();
        System.out.println();
        // Clear lines to differentiate different turns on the screen.
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        
        // Helps user keep track of what turn they are on. 
        System.out.println("Turn Number " + turnNumber + " Starting now. ");

        // Increments turnNumber so it can accurately print which turn it's on each turn. 
        turnNumber++;

        // One turn 
        // Extra Println statements for readability on console (Spacing)
        System.out.println();
        System.out.println();

        // Display the Scorecard for Reference
        System.out.println("Here is the scorecard: (true is printed if the category has been used and false if not) ");
        System.out.println();
        System.out.println();
        displayScoreCard();

        System.out.println();
        System.out.println();

        // TURN BEGINS
        System.out.println("Now for your turn. ");
        System.out.println();

        // Roll Dice to reset their values
        System.out.println("Rolling Dice...");
        hand.rollAll();

        // DICE SHOWN
        System.out.println();
        System.out.println("Here are your dice and their faces: ");
        System.out.println();
        System.out.println();

        // Prints the current arrangement of the dice
        System.out.println(hand.showDice());

        System.out.println();
        System.out.println();

        // REROLLING
        // Performs Rerolling Sequence which asks user if they want to reroll up to two times.
        rerollingSequence(hand);

        System.out.println();
        System.out.println();
        System.out.println();

        // SCORING + UPDATING SCORECARD
        // Scores based on user input of which category to score in. 
        scoringSequence(hand);

        System.out.println();
        System.out.println();
        // Clear lines to differentiate different turns on the screen.
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();

    }

    /**
     * Gives the user 2 chances to rerolls his/her hand. They can choose to reroll one, many, or all of the dice using the methods roll, rollAll, and changeHand
     * @param hand YahtzeeHand object
     */
    public void rerollingSequence(YahtzeeHand hand) {
        Scanner input = new Scanner(System.in);
        System.out.println("You can reroll up to two times");

        // Starts at Yes (Initial)
        String yesOrNo = "Yes";

        // yesOrNo condition so that if user says no to rerolling it doesn't go again and ask the same thing. (Extra Convenience for User, prevents cluttering of the output stream)
        // Makes sure user can only reroll twice max
        for (int i = 0; i < 2 && yesOrNo.equals("Yes"); i++) {

            // Spacing
            System.out.println();
            System.out.println();

            // If the user says no once, there is no reason to say yes the second time, so it also uses yesOrNo in the loop condition above, rather than always repeating twice
            // prompts user if they want to reroll or not
            System.out.print("Would you like to reroll any dice? | Type Yes or No (ONLY):  ");
            yesOrNo = input.next();
            System.out.println();   


            // If yes, asks which type of reroll, Many, All, or one
            if (yesOrNo.equals("Yes")) {

                // Prompts user for One, Many, or All Dice to reroll
                System.out.println("Would you like to reroll all, reroll one, or reroll more than one, but not all?");
                System.out.print("Respond All, One, or Many to reflect these answers (Case Sensitive, be careful):  ");
                String whichOne = input.next();


                System.out.println();

                // If/Else to control flow based on the user's input of All, Many, or One.

                if (whichOne.equals("All")) {

                    hand.rollAll();

                } else if (whichOne.equals("One")) {
                    
                    // Asks which specific die to reroll (1-5)
                    System.out.print("Which die do you want to reroll? (1 - 5):  ");
                    int rerolledDie = input.nextInt();

                    // Calls roll based on that die number
                    hand.roll(rerolledDie);

                } else if (whichOne.equals("Many")) {

                    hand.changeHand();

                } else {

                    System.out.println("Invalid Input, can only enter Many, Yes, or No; assumed NO reroll.");

                }

                System.out.println();
                System.out.println();

                // Prints the current hand of dice after rerolls have concluded
                System.out.println("Dice after reroll: ");
                System.out.println(hand.showDice());

            } else if (!yesOrNo.equals("No")) {
            
                // Invalid Input Case. 
                System.out.println("Neither Yes or No was inputted, so no rerolls will be given due to a violation.");
                System.out.println();
                System.out.println();

            } else {

                // This is the 'No' Case
                System.out.println("No rerolls taken");
                System.out.println();
                System.out.println();

            }
        }
    }

    /**
     * Runs the scoring sequence, using YahtzeeHand hand as a parameter.
     * Asks user for input of which category to score in, then updates the scoreCard and arrays accordingly. 
     * @param hand
     */
    public void scoringSequence(YahtzeeHand hand)  {
        // tracks the score for this turn
        int turnScore = 0;

        // Initialize Yahtzee score object to access its methods. 
        YahtzeeScore score = new YahtzeeScore(hand.getDice());

        // Set Scanner
        Scanner input = new Scanner(System.in);

        // Key and User Input for Which category to score this turn in
        // Explains Rules for User Input during Scoring.
        System.out.println("Now that rerolls have concluded, scoring must be done.");
        System.out.println("If you want to use an upperScoring category type 1 - 6 reflecting the number you want to score");
        System.out.println("And if you want to use a lowerScoring category, type 7 - 13 by this key: ");
        System.out.println("Three of a Kind (7), Four of a Kind (8), Small Straight (9), Large Straight (10)\nFull House (11), Yahtzee (12), Bonus Yahtzee (13), Chance (14)");

        // user enters the category they want to score in. 
        System.out.print("Number Here: ");
        int categoryToScore = input.nextInt();

        // Spacing
        System.out.println();
        System.out.println();
        System.out.println();

        // If they enter a used category (Gives one extra chance to enter the right one)
        if(card.isCategoryUsed(categoryToScore)) {

            // Error Message
            System.out.println("That category has already been used this game. You have one more chance to enter a category that hasn't been used. Check the Scorecard and select a category that is under 'False'");
            System.out.println();


            // Reprompts Number
            System.out.println("Enter the number of your new category: ");
            categoryToScore = input.nextInt();

            // Spacing
            System.out.println();
            System.out.println();
        }


        // Upper Scoring
        if (categoryToScore > 0 && categoryToScore < 7) {

            turnScore = score.getUpperScore(categoryToScore);

        }

        // Lower Scoring Switch Statement invoking the corresponding scoring method from yahtzeeScore class. 
        switch (categoryToScore) {
            case 7:
                turnScore = score.scoreThreeOfAKind();
                break;
            case 8:
                turnScore = score.scoreFourOfAKind();
                break;
            case 9:
                turnScore = score.scoreSmallStraight();
                break;
            case 10:
                turnScore = score.scoreLargeStraight();
                break;
            case 11:
                turnScore = score.scoreFullHouse();
                break;
            case 12:
                turnScore = score.scoreYahtzee();
                break;

                // Bonus Yahtzee has its own method according to program requirements so it has its own number. 
            case 13:
                turnScore = score.scoreBonusYahtzee();
                break;
            case 14:
                turnScore = score.scoreChance();
                break;
            
        }

        // update the arrays which don't need a switch statement.
        card.updateScore(categoryToScore, turnScore);

        // Messages to User. 
        System.out.println("All Scores are updated.");

        // Spacing
        System.out.println();
        System.out.println();

        System.out.println("Next Turn Starting...");

        // Spacing
        System.out.println();
        System.out.println();
    }
    
    /**
     * Returns the final score of the game. Used in the Match Class. 
     * @return the final score. 
     */
    public int getFinalScore() {

        // Returns the final/total score of the game. 
        return card.getFinalScore();

    }

}
