/*
 * This class deals with the jail, specifically jail processing of a player.
 */
package project_3;

import javax.swing.JOptionPane;

/**
 *
 * @author Rohan Khante, Matthew Wentz, Jonathan Sorem, Robert James Davis
 */
public class Jail {
    
    Dice processDice            =   new Dice();
    Movement processMovement    =   new Movement();

    /* This function deals with the processing of the jail.*/
    public void jailProcessing(Player currentActivePlayer)
    {
        int choiceSelection;
        int diceRoll;
        int moneyOwed       =   50;

        boolean validChoice =   false;

        currentActivePlayer.currentTurnInJail++;

        while(validChoice == false)
        {
            if((currentActivePlayer.currentTurnInJail < 4)&&(currentActivePlayer.totalCash > 50))
            {
                choiceSelection =   Integer.parseInt(JOptionPane.showInputDialog("Please choose one of the following options:\n"
                        + "1) Roll dice and hope for doubles.\n"
                        + "2) Pay $500.\n", "Decisions in Jail."));
                System.out.println(choiceSelection);
            }
            else if(currentActivePlayer.totalCash < 50)
            {
                JOptionPane.showMessageDialog(null, "Your balance is below $500. Your going to have to hope for doubles.\n", "Jail Balance.", 1);
                choiceSelection = 2;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Since you have enough money and you have been in jail for over 3 turns, please pay the bank $500.\n", "Pay the Jail.", 1);
                choiceSelection = 1;
            }

            switch(choiceSelection)
            {
                case 1:
                    diceRoll    =   processDice.rollDice();
                    if(processDice.diceDoubles  == true)
                    {
                        processDice.diceDoubles =   false;
                        JOptionPane.showMessageDialog(null, "Congratulations! You rolled doubles! You are now out of jail and will move. But you"
                                + "can only move once.\n", "Rolling out of Jail.", 1);

                        processMovement.moveToken(diceRoll, currentActivePlayer);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Ah, to bad. looks like you didn't roll doubles. You are stuck here for a while longer.\n", "Stuck in Jail.", 1);
                    }
                    validChoice =   true;
                    break;
                case 2:
                    while(moneyOwed > 0)
                    {
                        if((currentActivePlayer.fiftyDollarBills > 0) && (50 <= moneyOwed))
                        {
                            currentActivePlayer.fiftyDollarBills          = currentActivePlayer.fiftyDollarBills - 1;
                            currentActivePlayer.totalCash                 = currentActivePlayer.totalCash - 50;
                            moneyOwed                      = moneyOwed - 50;
                        }
                        else if((currentActivePlayer.twentyDollarBills > 0) && (20 <= moneyOwed))
                        {
                            currentActivePlayer.twentyDollarBills         = currentActivePlayer.twentyDollarBills - 1;
                            currentActivePlayer.totalCash                 = currentActivePlayer.totalCash - 20;
                            moneyOwed                      = moneyOwed - 20;
                        }
                        else if((currentActivePlayer.tenDollarBills > 0) && (10 <= moneyOwed))
                        {
                            currentActivePlayer.tenDollarBills            = currentActivePlayer.tenDollarBills - 1;
                            currentActivePlayer.totalCash                 = currentActivePlayer.totalCash - 10;
                            moneyOwed                      = moneyOwed - 10;
                        }
                        else if((currentActivePlayer.fiveDollarBills > 0) && (5 <= moneyOwed))
                        {
                            currentActivePlayer.fiveDollarBills           = currentActivePlayer.fiveDollarBills - 1;
                            currentActivePlayer.totalCash                 = currentActivePlayer.totalCash - 5;
                            moneyOwed                      = moneyOwed - 5;
                        }
                        else if((currentActivePlayer.oneDollarBills > 0) && (1 <= moneyOwed))
                        {
                            currentActivePlayer.oneDollarBills    = currentActivePlayer.oneDollarBills - 1;
                            currentActivePlayer.totalCash         = currentActivePlayer.totalCash - 1;
                            moneyOwed              = moneyOwed - 1;
                        }
                    }
                    validChoice =   true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "You need to make a valid selection in order to continue.\n", "Invalid Decision.", 1);
            }
        }
        Values.tokens[Values.playerTokens[currentActivePlayer.id]].setLocation(Values.tokenXValues[currentActivePlayer.currentBoardPosition], Values.tokenYValues[currentActivePlayer.currentBoardPosition]);
    }
    
}