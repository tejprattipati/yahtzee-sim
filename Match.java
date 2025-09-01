/*
 * Programmer: Tej Prattipati
 * Course: AP Computer Science A
 * Section: 24I.ACS.CDE.1
 * Assignment: Final Project Part 2
 * Description: Defines the Match class, which manages a series of Yahtzee games.
 * It loops to create and run new Game instances until the user decides to end the match by indicating it in their input
 * OR Runs Until 3 Games have been played (If user wants to continue that far at all) (Based on Rubric Criteria)
 * Date: 29-July-2024
 */
//Import all
import java.util.*;

// Match class (Can run multiple Games in a row) loops creating new games and running them until the user wants to end the Match (Set of Games) OR Until 3 Games have been played (Based on Rubric)
public class Match {
    public static void main(String[] args) {
        boolean endMatch = false;
        String trueOrFalse = "";
        int gameNumber = 0; 
        int matchScore = 0;

        Scanner input = new Scanner(System.in);

        // doWhile loop running Games of Yahtzee up to 3 times or until User wants to end match.
        // tracks total match score of all games combined. 
        // tracks the game number by incrementing gameNumber
        do {

            // Increment gameNumber so that only 3 games can be played, and to display the correct gameNuber to the user. 
            gameNumber++;
            // Creates a new game each loop.
            Game game = new Game();

            // extra print statements for spacing. 
            // clear Lines to differentiate different games: 
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();
            System.out.println();

            // Start game statement
            System.out.println("Game number " + gameNumber + " begins NOW!");
            System.out.println();
            System.out.println();
            System.out.println();



            // RUNS THE FULL GAME; runGame plays a full 13 hand game of yahtzee as described in Game.java
            game.runGame();




            // Spacing
            System.out.println();
            System.out.println();

            // clear Lines and SPACING to differentiate different games on the users end.
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();


            // Loop Condition
            // Prompts user if they want to play again or not. 
            System.out.print("Would you like to play a new game? Enter Y if Yes, N if No: ");
            trueOrFalse = input.next();
            System.out.println();

            // Update match score by adding finalScore to it.
            matchScore += game.getFinalScore();

            // if/else to use trueOrFalse to set endMatch's value as true or false. If the user enters an illegal argument into the console, then program assumes 'No' and endMatch is set as true.
            if(trueOrFalse.equals("Y")) {

                System.out.println("Great! The new game will start promptly! ");
                System.out.println("Your current score across all games played so far is: " + matchScore + "! Keep at it!");
                endMatch = false;

            } else if (trueOrFalse.equals("N")) {

                System.out.println("Ending Match... Thanks for Playing! Have a Nice Day!");
                System.out.println("Your final score was across all games played was: " + matchScore + "! Well Done.");
                endMatch = true;

            } else {

                // lets user know why match is ending, as well as a final closing statement. 
                System.out.println();
                System.out.println("You did not input Y or N, so the match will end.");
                System.out.println();
                System.out.println("Ending Match... Thanks for Playing! Have a Nice Day!");
                System.out.println("Your final score was across all games played was: " + matchScore + "! Well Done.");

                endMatch = true;


            }

            // Runs as long as the user doesn't want to end match and as long as 3 matches have not already been played. (Could've been infinite but went with program requirements here to cap at 3 loops)
        } while(!endMatch && gameNumber < 3);

    }
}
