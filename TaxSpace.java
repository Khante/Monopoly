/*
 * This class processes the tax spaces. Income tax space and luxury functions
 * are located in this class.
 */
package project_3;

import javax.swing.JOptionPane;

/**
 *
 * @author Rohan Khante, Matthew Wentz, Jonathan Sorem, Robert James Davis
 */
public class TaxSpace {
    
    int choiceSelection =   0;
    boolean isValid     =   false;
    
    Money processMoney  =   new Money();
    
    void incomeTax(Player currentActivePlayer)
    {
        choiceSelection =   Integer.parseInt(JOptionPane.showInputDialog("You landed on the Income Tax. Please choose one of the following options:\n"
                        + "1) Pay 10% of your remaining cash.\n"
                        + "2) Pay $200\n"));
            if(currentActivePlayer.totalCash < 200)
            {
                JOptionPane.showMessageDialog(null, "You do not have $200, so you will pay %10.\n", "Buy Property Decision.", 1);
                choiceSelection =   1;
            }

            while(isValid == false)
            {
                switch(choiceSelection)
                {
                        case 1:
                            JOptionPane.showMessageDialog(null, "You will pay 10% of your total cash. which is " + currentActivePlayer.totalCash/10 + ".\n", "Income Tax 10%.", 1);
                            processMoney.moneyOwedByPlayer(currentActivePlayer.totalCash/10, currentActivePlayer);
                            isValid =   true;
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "You decided to pay $200.\n", "Income Tax", 1);
                            processMoney.moneyOwedByPlayer(200, currentActivePlayer);
                            isValid =   true;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "You need to make a valid selection in order to continue.\n", "Invalid Decision.", 1);
                }             
            } 
    }
    
    void luxuryTax(Player currentActivePlayer)
    {
        JOptionPane.showMessageDialog(null, "You landed on the Luxury Tax Space.\n", "Luxury Tax", 1);
        if(currentActivePlayer.totalCash > 74)
        {
            JOptionPane.showMessageDialog(null, "You will pay $75.\n", "Luxury Tax", 1);
            processMoney.moneyOwedByPlayer(200, currentActivePlayer);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You only had " + currentActivePlayer.totalCash + "So you will pay all of it.\n", "Luxury Tax", 1);
            currentActivePlayer.totalCash  =   0;
        }
    }
    
}
