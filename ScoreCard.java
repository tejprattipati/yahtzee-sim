/*
 * Programmer: Tej Prattipati
 * Course: AP Computer Science A
 * Section: 24I.ACS.CDE.1
 * Assignment: Final Project Part 2
 * Description: Defines the Scorecard class, which tracks each category of scoring using 3 different arrays, which hold the name of each category, its status (used or unused), and its score at the time. 
 * It also contains a method to display the scores, name, and status in a Scorecard, using a for loop to implement this. (displayScoreCard method)
 * Date: 29-July-2024
 */



 // DID NOT USE PROVIDED INTERFACE - Just a reminder so I don't lose points: We established by email that the program requirements said that it was optional, and it was unnecessary for my implementation. 
 


// Import Arrays class and its commands (used for fill command to help intialize the arrays that hold the scores/statuses)
import java.util.Arrays;

// ScoreCard Class - Does not implement YahtzeeScorecard Interface because you said I didn't need to and it was perfectly functional without the method included in that interface.
public class ScoreCard {

    // Holds the scores of the categories
    private int[] categoryScores = new int[14];

    // holds booleans showing whether the category has been used or not. 
    private boolean[] used = new boolean[14];

    // Holds the names of each category
    private String[] names = {"1s", "2s", "3s", "4s", "5s", "6s", "Three of a Kind", "Four of a Kind", "Small Straight", "Large Straight", "Full House", "Yahtzee", "Bonus Yahtzee", "Chance"};

    private int totalScore = 0; 
    // Fills the arrays that are not fully initialized.
    public ScoreCard() {

        Arrays.fill(categoryScores, 0);
        Arrays.fill(used, false);

    }

    /**
     * Displays the scorecard using a for loop and the values contained in the three arrays (used, names, and categoryScores.)
     */
    public void displayScoreCard() {
        // Runs 14 times (once for each category)

        totalScore = getFinalScore();

        for (int i = 0; i < 14; i++) {

            if (i == 0) {

                // Header printed Before Upper section scores
                System.out.println("-- Upper Section --");

            } else if (i == 6) {

                // Header printed before lower section scores
                System.out.println("-- Lower Section --");

            }

            // print out the name of the category, its score, and if it's been used.
            System.out.print(names[i] + ": " + categoryScores[i] + " - " + used[i]);
            
            // newline
            System.out.println();

        }

        // Prints current total Score.
        System.out.println();
        System.out.println("Grand Total: " + totalScore);

        // Spacing
        System.out.println();
        System.out.println();
    }

    /**
     * Updates the used array that the category in the parameter is scored (category) with 'true', and updates the category scores array in the corresponding index by adding the score achieved (score)
     * @param category
     * @param score
     */
    public void updateScore(int category, int score) {

        // if statement to ensure that the user didn't input an incorrect category. if they did, nothing will be scored, as they entered an invalid category.
        if (category >= 1 && category <= 14) {

            // Updates the index corresponding to the number, so it decreases the index by one to do that, because the user selects 1-14 but indexes are 0-13
            used[category - 1] = true;
            categoryScores[category - 1] = score;

        }

    }

    /**
     * 
     * @param category
     * @return the value of used for the corresponding category
     */
    public boolean isCategoryUsed(int category) {
        
        return used[category - 1];

    }

    public int getCategoryScore(int category) {

        return categoryScores[category - 1];

    }

    /**
     * Calculates and returns current totalScore - called to find the final score, as well as in displayScorecard to display current total score.
     * @return endScore (totalScore)
     */
    public int getFinalScore() {

        int endScore = 0;
        

        // Enhanced for loop totaling all category scores in the array
        for (int score : categoryScores) {

            endScore += score;

        }

        return endScore;

    }

    /***
     * Returns the number of categories where the score is more than one, or the number of successfully scored categories.
     * Doesn't use the used array because that only counts attempts, not successful scores. 
     * @return
     */
    public int getScoredCategories() {
        
        // tracks the number of categories successfully scored in. 
        int scoredCategories = 0;

        // for each loop iterates through the scores and incremenrs the scoredCategories tracker if that category has a score above 0
        for (int score : categoryScores) {

            if (score > 0) {

                // increment scoredCategories
                scoredCategories++;

            }

        }

        // returns the number of successfully scored categories. 
        return scoredCategories;
    }
}
