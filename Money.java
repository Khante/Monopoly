/*
 * This class deals with all functions that dabble with money. Pay rent, money
 * owed by player, and money owed to player are all located here.
 */
package project_3;

import javax.swing.JOptionPane;

/**
 *
 * @author Rohan Khante, Matthew Wentz, Jonathan Sorem, Robert James Davis
 */
public class Money {
    
    /*Function used for a player to pay another player rent. TO DO*/
    public void payRent(Player currentActivePlayer, Player moneyOwedPlayer, int moneyOwed)
    {

        /*If the player does not have enough money to pay rent, he pays everything he has got left.
        We do currentActivePlayer because players do not go bankrupt in currentActivePlayer. MAY WANT TO CHANGE THIS LATER WITH MORTGAGING...*/
        if(currentActivePlayer.totalCash > moneyOwed)
        {
            JOptionPane.showMessageDialog(null, "You only have $" + currentActivePlayer.totalCash + " and not a full $"
                    + moneyOwed + " You will Pay your entire balance.\n", "Not enough money.", 1);

            moneyOwedPlayer.totalCash               =   moneyOwedPlayer.totalCash + currentActivePlayer.totalCash;
            moneyOwed                               =   moneyOwed - currentActivePlayer.totalCash;
            currentActivePlayer.totalCash                 =   0;

            moneyOwedPlayer.fiveHundredDollarBills  =   moneyOwedPlayer.fiveHundredDollarBills + currentActivePlayer.fiveHundredDollarBills;
            moneyOwedPlayer.hundredDollarBills      =   moneyOwedPlayer.hundredDollarBills + currentActivePlayer.hundredDollarBills;
            moneyOwedPlayer.fiftyDollarBills        =   moneyOwedPlayer.fiftyDollarBills + currentActivePlayer.fiftyDollarBills;
            moneyOwedPlayer.twentyDollarBills       =   moneyOwedPlayer.twentyDollarBills + currentActivePlayer.twentyDollarBills;
            moneyOwedPlayer.tenDollarBills          =   moneyOwedPlayer.tenDollarBills + currentActivePlayer.tenDollarBills;
            moneyOwedPlayer.fiveDollarBills         =   moneyOwedPlayer.fiveDollarBills + currentActivePlayer.fiveDollarBills;
            moneyOwedPlayer.oneDollarBills          =   moneyOwedPlayer.oneDollarBills + currentActivePlayer.oneDollarBills;

            currentActivePlayer.fiveHundredDollarBills    =   0;
            currentActivePlayer.hundredDollarBills        =   0;
            currentActivePlayer.fiftyDollarBills          =   0;
            currentActivePlayer.twentyDollarBills         =   0;
            currentActivePlayer.tenDollarBills            =   0;
            currentActivePlayer.fiveDollarBills           =   0;
            currentActivePlayer.oneDollarBills            =   0;

            JOptionPane.showMessageDialog(null, "You still owe $" + moneyOwed + ".\n", "Still Owing your competitor.", 1);
            //NOW WE WILL HAVE TO MORTGAGE PROPERTY TO GET TO THE OWED AMOUNT
        }

        /*If the player has enough money to pay the rent, currentActivePlayer iterates through
        a while loop till there is no more money owed. The highest denominations are
        withdrawn from the paying player first.
        */
        while(moneyOwed > 0)
        {
            if((currentActivePlayer.fiveHundredDollarBills > 0) && (500 <= moneyOwed))
            {
                currentActivePlayer.fiveHundredDollarBills    = currentActivePlayer.fiveHundredDollarBills - 1;
                moneyOwedPlayer.fiveHundredDollarBills  = moneyOwedPlayer.fiveHundredDollarBills + 1;
                moneyOwedPlayer.totalCash               = moneyOwedPlayer.totalCash + 500;
                currentActivePlayer.totalCash                 = currentActivePlayer.totalCash - 500;
                moneyOwed                               = moneyOwed - 500;
            }
            else if((currentActivePlayer.hundredDollarBills > 0) && (100 <= moneyOwed))
            {
                currentActivePlayer.hundredDollarBills        = currentActivePlayer.hundredDollarBills - 1;
                moneyOwedPlayer.hundredDollarBills      = moneyOwedPlayer.hundredDollarBills + 1;
                moneyOwedPlayer.totalCash               = moneyOwedPlayer.totalCash + 100;
                currentActivePlayer.totalCash                 = currentActivePlayer.totalCash - 100;
                moneyOwed                               = moneyOwed - 100;
            }
            else if((currentActivePlayer.fiftyDollarBills > 0) && (50 <= moneyOwed))
            {
                currentActivePlayer.fiftyDollarBills          = currentActivePlayer.fiftyDollarBills - 1;
                moneyOwedPlayer.fiftyDollarBills        = moneyOwedPlayer.fiftyDollarBills + 1;
                moneyOwedPlayer.totalCash               = moneyOwedPlayer.totalCash + 50;
                currentActivePlayer.totalCash                 = currentActivePlayer.totalCash - 50;
                moneyOwed                               = moneyOwed - 50;
            }
            else if((currentActivePlayer.twentyDollarBills > 0) && (20 <= moneyOwed))
            {
                currentActivePlayer.twentyDollarBills         = currentActivePlayer.twentyDollarBills - 1;
                moneyOwedPlayer.twentyDollarBills       = moneyOwedPlayer.twentyDollarBills + 1;
                moneyOwedPlayer.totalCash               = moneyOwedPlayer.totalCash + 20;
                currentActivePlayer.totalCash                 = currentActivePlayer.totalCash - 20;
                moneyOwed                               = moneyOwed - 20;
            }
            else if((currentActivePlayer.tenDollarBills > 0) && (10 <= moneyOwed))
            {
                currentActivePlayer.tenDollarBills            = currentActivePlayer.tenDollarBills - 1;
                moneyOwedPlayer.tenDollarBills          = moneyOwedPlayer.tenDollarBills + 1;
                moneyOwedPlayer.totalCash               = moneyOwedPlayer.totalCash + 10;
                currentActivePlayer.totalCash                 = currentActivePlayer.totalCash - 10;
                moneyOwed                               = moneyOwed - 10;
            }
            else if((currentActivePlayer.fiveDollarBills > 0) && (5 <= moneyOwed))
            {
                currentActivePlayer.fiveDollarBills           = currentActivePlayer.fiveDollarBills - 1;
                moneyOwedPlayer.fiveDollarBills         = moneyOwedPlayer.fiveDollarBills + 1;
                moneyOwedPlayer.totalCash               = moneyOwedPlayer.totalCash + 5;
                currentActivePlayer.totalCash                 = currentActivePlayer.totalCash - 5;
                moneyOwed                               = moneyOwed - 5;
            }
            else if((currentActivePlayer.oneDollarBills > 0) && (1 <= moneyOwed))
            {
                currentActivePlayer.oneDollarBills            = currentActivePlayer.oneDollarBills - 1;
                moneyOwedPlayer.oneDollarBills          = moneyOwedPlayer.oneDollarBills + 1;
                moneyOwedPlayer.totalCash               = moneyOwedPlayer.totalCash + 1;
                currentActivePlayer.totalCash                 = currentActivePlayer.totalCash - 1;
                moneyOwed                               = moneyOwed - 1;
            }
        }

    }
    
    /*This function the player pays what they owe to the bank.*/
    public void moneyOwedByPlayer(int moneyOwed, Player currentActivePlayer)
    {
        while(moneyOwed > 0)
        {
            if((currentActivePlayer.fiveHundredDollarBills > 0) && (500 <= moneyOwed))
            {
                currentActivePlayer.fiveHundredDollarBills    -= 1;
                currentActivePlayer.totalCash                 -= 500;
                moneyOwed                                     -= 500;
            }
            if((currentActivePlayer.hundredDollarBills > 0) && (100 <= moneyOwed))
            {
                currentActivePlayer.hundredDollarBills        -= 1;
                currentActivePlayer.totalCash                 -= 100;
                moneyOwed                                     -= 100;
            }
            if((currentActivePlayer.fiftyDollarBills > 0) && (50 <= moneyOwed))
            {
                currentActivePlayer.fiftyDollarBills          -= 1;
                currentActivePlayer.totalCash                 -= 50;
                moneyOwed                                     -= 50;
            }
            else if((currentActivePlayer.twentyDollarBills > 0) && (20 <= moneyOwed))
            {
                currentActivePlayer.twentyDollarBills         -= 1;
                currentActivePlayer.totalCash                 -= 20;
                moneyOwed                                     -= 20;
            }
            else if((currentActivePlayer.tenDollarBills > 0) && (10 <= moneyOwed))
            {
                currentActivePlayer.tenDollarBills            -= 1;
                currentActivePlayer.totalCash                 -= 10;
                moneyOwed                                     -= 10;
            }
            else if((currentActivePlayer.fiveDollarBills > 0) && (5 <= moneyOwed))
            {
                currentActivePlayer.fiveDollarBills           -= 1;
                currentActivePlayer.totalCash                 -= 5;
                moneyOwed                                     -= 5;
            }
            else if((currentActivePlayer.oneDollarBills > 0) && (1 <= moneyOwed))
            {
                currentActivePlayer.oneDollarBills            -= 1;
                currentActivePlayer.totalCash                 -= 1;
                moneyOwed                                     -= 1;
            }
        }
    }
    
    /* This function gives money to the player for the amount they are owed.*/
    public void moneyOwedToPlayer(int moneyOwedPlayer, Player currentActivePlayer)
    {
        while(moneyOwedPlayer > 0)
        {
            if((currentActivePlayer.fiveHundredDollarBills > 0) && (500 <= moneyOwedPlayer))
            {
                currentActivePlayer.fiveHundredDollarBills    +=   1;
                currentActivePlayer.totalCash                 +=   500;
                moneyOwedPlayer                               -=   500;
            }
            if((currentActivePlayer.hundredDollarBills > 0) && (100 <= moneyOwedPlayer))
            {
                currentActivePlayer.hundredDollarBills        +=    1;
                currentActivePlayer.totalCash                 +=    100;
                moneyOwedPlayer                               -=    100;
            }
            if((currentActivePlayer.fiftyDollarBills > 0) && (50 <= moneyOwedPlayer))
            {
                currentActivePlayer.fiftyDollarBills          +=    1;
                currentActivePlayer.totalCash                 +=    50;
                moneyOwedPlayer                               -=    50;
            }
            else if((currentActivePlayer.twentyDollarBills > 0) && (20 <= moneyOwedPlayer))
            {
                currentActivePlayer.twentyDollarBills         +=   1;
                currentActivePlayer.totalCash                 +=   20;
                moneyOwedPlayer                               -=   20;
            }
            else if((currentActivePlayer.tenDollarBills > 0) && (10 <= moneyOwedPlayer))
            {
                currentActivePlayer.tenDollarBills            +=   1;
                currentActivePlayer.totalCash                 +=   10;
                moneyOwedPlayer                               -=   10;
            }
            else if((currentActivePlayer.fiveDollarBills > 0) && (5 <= moneyOwedPlayer))
            {
                currentActivePlayer.fiveDollarBills           +=   1;
                currentActivePlayer.totalCash                 +=   5;
                moneyOwedPlayer                               -=   5;
            }
            else if((currentActivePlayer.oneDollarBills > 0) && (1 <= moneyOwedPlayer))
            {
                currentActivePlayer.oneDollarBills            +=   1;
                currentActivePlayer.totalCash                 +=   1;
                moneyOwedPlayer                               -=   1;
            }
        }
    }
}
