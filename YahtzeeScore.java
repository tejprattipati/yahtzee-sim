/* Starter file for JHU CTY AP CS Course Final Project 
 * Initial code for YahtzeeScore with stub implementations
 */
/*
*Programmer: Tej Prattipati
*Course: AP Computer Science A
*Section: 24I.ACS.CDE.1
*Assignment: Final Project Part 2
*Description: Contains methods to score all Upper and Lower Categories. Constructor is initially called with an array of dice values which is used by the Scoring methods. 
*Scores all 13 Categories, including upper categories (1-6), and lower (three of a kind, four of a kind, full house, yahtzee, small/large straight, chance, bonus yahtzee)
*Date: 29-July-2024
*/

import java.util.Arrays;

public class YahtzeeScore {   
    // Boolean to check if the chance score has been used
    private boolean chanceUsed = false;
    
    // Boolean to track if a Yahtzee has been scored
    private boolean yahtzeeScoredYet;
    
    // Array to store the values of the dice
    private int[] dice = new int[5];

    /**
     * Constructor initializes the YahtzeeScore object with an array of dice values.
     * @param dice an array of integers representing the values of the dice
     */
    public YahtzeeScore(int[] dice) {
        this.dice = dice;
    }

    /**
     * Sorts an array of integers using selection sort.
     * Extra method, included to sort arrays with my own code. 
     * @param array the array of integers to be sorted
     */
    public static void sortArray(int[] array) {

        // Initialize variables
        int atStart; 
        int minVal = 0;
        int minIndex = 0;

        // Use nested for loop to perform selection sort in the array
        for(int startIndex = 0; startIndex < array.length - 1; startIndex++ ) {

            minVal = Integer.MAX_VALUE;
            minIndex = startIndex;

            for(int i = startIndex; i < array.length; i++) {

                if(array[i] < minVal) {

                    minVal = array[i];
                    minIndex = i;

                }

            }

            atStart = array[startIndex];
            array[startIndex] = array[minIndex];
            array[minIndex] = atStart;
        }
    }

    /**
     * Calculates the upper score for a given value.
     * @param value the value to calculate the score for
     * @return the total score for the given value
     */
    public int getUpperScore(int value) {
        // Tracks the total of that number
        int totalValue = 0;

        // Iterates through the array dice to add to totalValue all the dice of the value 'value'
        for (int die : dice) {
            if(die == value) {
                totalValue += value;
            }
        }

        // Returns the total combined value
        return totalValue;
    }

    /**
     * Determines if there is a three of a kind and returns the correct score.
     * @return the score for three of a kind, or 0 if not found
     */
    public int scoreThreeOfAKind() {
        // Starts as false
        boolean threeOfAKind = false;
        int score = 0;
        int numberOfAKind = 0;

        // Determines the score that will be given if the dice meet the threeOfAKind requirement
        for (int die: dice) {
            score += die;
        }

        // Checks each number and finds if any of them are in the dice as a threeOfAKind
        for(int i = 1; i < 7; i++) {
            for(int die : dice) {
                if(die == i) {
                    numberOfAKind++;
                }
            }

            if(numberOfAKind >= 3) {
                // Sets threeOfAKind if the loop above increments numberOfAKind
                threeOfAKind = true;
                // Breaks loop if condition is determined to be true
                break;
            }

            // Reset count
            numberOfAKind = 0;
        }

        if(threeOfAKind) {
            // Returns the total of all dice values (score) if threeOfAKind is true
            return score;
        } else return 0; // Returns 0 if the condition is not met
    }

    /**
     * Determines if there is a four of a kind and returns the correct score.
     * @return the score for four of a kind, or 0 if not found
     */
    public int scoreFourOfAKind() {
        boolean fourOfAKind = false;
        int score = 0;
        int numberOfAKind = 0;
        
        // Determines the score that will be given if the dice meet the fourOfAKind requirement
        for (int die: dice) {
            score += die;
        }

        // Checks each number and finds if any of them are in the dice as a fourOfAKind
        for(int i = 1; i < 7; i++) {
            for(int die : dice) {
                if(die == i) {
                    numberOfAKind++;
                }
            }

            if(numberOfAKind >= 4) {
                fourOfAKind = true;
                break;
            }

            // Reset count
            numberOfAKind = 0;
        }

        if(fourOfAKind) {
            return score;
        } else return 0;
    }

    /**
     * Determines if there is a full house and returns the correct score.
     * @return the score for a full house, or 0 if not found
     */
    public int scoreFullHouse() {
        // Necessary variables
        int secondNumberOfAKind = 0;
        int excludedNumber = 0;
        int score = 25;
        int firstNumberOfAKind = 0;
        boolean threeYes = false;
        boolean twoYes = false;

        for(int i = 1; i < 7; i++) {
            for(int die : dice) {
                if(die == i) {
                    firstNumberOfAKind++;
                }
            }

            if(firstNumberOfAKind == 3) {
                threeYes = true;
                excludedNumber = i;
                break;
            } 

            // Reset count
            firstNumberOfAKind = 0;
        }

        if(!threeYes) {
            return 0;
        }

        for(int i = 1; i < 7; i++) {

            if(i == excludedNumber) {
                // Skip the excluded number because it was already part of the three of a kind. 

            } else {

                for(int die : dice) {

                    if(die == i) {

                        secondNumberOfAKind++;

                    }

                }

                if(secondNumberOfAKind == 2) {

                    twoYes = true;
                    break;

                } 
            }

            // Reset count
            secondNumberOfAKind = 0;
        }

        // if both are true it returns score, by way of elimination. The other two options are if the 2 of a kind doesn't exist or if the threeofakind doesn't exist. 
        if(!twoYes) {

            return 0;

        } else return score;
    }

    /**
     * Determines if there is a small straight and returns the correct score.
     * @return the score for a small straight, or 0 if not found
     */
    public int scoreSmallStraight() {

        // Sort the array so that the smallStraight method can work effectively
        Arrays.sort(dice);
    
        int score = 30;
        int numberInARow = 1;  // Start with 1 because the first number is counted
    
        for (int i = 1; i < dice.length; i++) {
    
            if (numberInARow == 4) {

                return score;

            }
    
            if (dice[i] == dice[i - 1] + 1) {

                numberInARow++;

            } else if (dice[i] != dice[i - 1]) {

                numberInARow = 1; // Reset if not consecutive and not a duplicate

            }

        }
    
        // Check at the end of the loop if numberInARow has reached 4 and not caught earlier because it happened on the last loop
        if (numberInARow == 4) {

            return score;

        }
    
        return 0;
    }
    

    /**
     * Determines if there is a large straight and returns the correct score.
     * @return the score for a large straight, or 0 if not found
     */
    public int scoreLargeStraight() {

        // Sorts array so that the largeStraight method can work effectively
        sortArray(dice);
        int score = 40;
        int firstNumber = 0;
        int numberInARow = 0;

        for(int i = 0; i < 5; i++) {

            if(numberInARow == 0) {

                firstNumber = dice[i];
                numberInARow++;

            } else if(numberInARow > 0) {

                if(dice[i] == firstNumber + numberInARow) {

                    numberInARow++;

                } else {

                    firstNumber = dice[i];
                    numberInARow = 1;

                }

            }

        }


        if(numberInARow == 5) {
            return score;
        }

        return 0;
    }

    /**
     * Calculates the score for chance, which can only be used once.
     * @return the score for chance, or 0 if it has already been used
     */
    public int scoreChance() {

        // makes it so that you can already set if the chance was used early so it doesn't affect the method. IT cant be set too late becuase return statements end the method.
        boolean original = chanceUsed;

        // Now chance will be used once
        chanceUsed = true;

        int totalVal = 0;

        if(original) {

            return 0;

        } else {

            for(int die : dice) {

                totalVal += die;

            }

            return totalVal;

        }

    }

    /**
     * Determines if there is a Yahtzee and returns the correct score.
     * @return the score for a Yahtzee, or 0 if not found
     */
    public int scoreYahtzee() {

        int firstDieValue = dice[0];

        for (int die : dice) {

            if (die != firstDieValue) {

                return 0;

            }

        }

        yahtzeeScoredYet = true;
        return 50;
    }

    /**
     * Determines if there is a bonus Yahtzee and returns the correct score.
     * @return the score for a bonus Yahtzee, or 0 if a Yahtzee was not previously scored
     */
    public int scoreBonusYahtzee() {

        if (!yahtzeeScoredYet) {
            
            return 0;

        }

        int firstDieValue = dice[0];

        for (int die : dice) {

            if (die != firstDieValue) {

                return 0;

            }

        }

        return 100;
    }
}
