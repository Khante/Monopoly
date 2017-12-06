/*
 * This class deals with movement. It mainly deals with movement of the token.
 */
package project_3;

import javax.swing.JOptionPane;

/**
 *
 * @author Rohan Khante, Matthew Wentz, Jonathan Sorem, Robert James Davis
 */
public class Movement {
    
    Dice processDice                            =   new Dice();
    SpaceResolutions processSpaceResolutions    =   new SpaceResolutions();
    int diceResults =   0;
    
    /* This function moves the token. We are assuming the GO space is location 0.*/
    public void moveToken(int firstRoll, Player currentActivePlayer)
    {
        int spaces = firstRoll;

        if((currentActivePlayer.currentBoardPosition + spaces) > 39)
         {
             for(int i = currentActivePlayer.currentBoardPosition; i < 41; i++) // MIGHT NEED A FIX!!! CHECK THIS TO MAKE SURE LOGIC IS RIGHT!!
             {
                 spaces = spaces - 1;
             }
             currentActivePlayer.currentBoardPosition = spaces;
             processSpaceResolutions.passedGo(currentActivePlayer);
         }
         else
         {
             currentActivePlayer.currentBoardPosition += spaces;
         }

        if(processDice.diceDoubles == true)
        {
            JOptionPane.showMessageDialog(null, "Congratulations! You rolled doubles! You get to go again.\n", "You got Doubles!", 1);
            diceResults =   processDice.rollDice();
            spaces = diceResults;

            if(processDice.diceDoubles == true)
            {
                JOptionPane.showMessageDialog(null, "To bad, you rolled doubles 3 times in a row. You now go to jail.\n", "You got Triples...?", 1);
                processSpaceResolutions.goToJail(currentActivePlayer);
            }

            if((currentActivePlayer.currentBoardPosition + spaces) > 39)
             {
                 for(int i = currentActivePlayer.currentBoardPosition; i < 41; i++) // MIGHT NEED A FIX!!! CHECK THIS TO MAKE SURE LOGIC IS RIGHT!!
                 {
                     spaces = spaces - 1;
                 }
                 currentActivePlayer.currentBoardPosition = spaces;
                 processSpaceResolutions.passedGo(currentActivePlayer);
             }
             else
             {
                 currentActivePlayer.currentBoardPosition = currentActivePlayer.currentBoardPosition + spaces;
             }

        }
        else
        {
            diceResults =   firstRoll;
        }
        //System.out.println(currentActivePlayer.currentBoardPosition);
        Values.tokens[Values.playerTokens[currentActivePlayer.id]].setLocation(Values.tokenXValues[currentActivePlayer.currentBoardPosition], Values.tokenYValues[currentActivePlayer.currentBoardPosition]);
        processSpaceResolutions.resolveSpace(currentActivePlayer);
    }
    
}
