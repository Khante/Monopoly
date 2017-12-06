/*
 * Refrences: Generating random numbers (https://www.mkyong.com/java/java-generate-random-integers-in-a-range/)
 * This class rolls the dice. We made this seperate from the others in order to have a better organization of
 * the overall structure of the code.
 */
package project_3;

import javax.swing.JOptionPane;

/**
 *
 * @author Rohan Khante, Matthew Wentz, Jonathan Sorem, Robert James Davis
 */
public class Dice {
    
    Boolean diceDoubles =   false;
    
    /* The rollDice functions rolls a pairs of dice, calls doubleDice to see if player rolled
       doubles, and then calculates the total movement.*/
    public int rollDice()
    {
        int diceResultOne   =   (int) ((Math.random() * ((6 - 1) + 1)) + 1);
        int diceResultTwo   =   (int) ((Math.random() * ((6 - 1) + 1)) + 1);
        int totalDiceResult =   diceResultOne + diceResultTwo;

        diceDoubles         =   doubleDice(diceResultOne, diceResultTwo);  

        JOptionPane.showMessageDialog(null, "You rolled a " + diceResultOne + " and a " + diceResultTwo + ".\n", "Result", 1);

        return totalDiceResult;
    }

    /* The doubleDice function checks to see if the player rolled doubles and then
       returns true or false depending on the result.*/
    public boolean doubleDice(int diceOne, int diceTwo)
    {
        if(diceOne == diceTwo)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}
