/*
 * This class deals with mortgaging property. It contains the functions to
 * mortgage property as well as lift mortgaged property.
 */
package project_3;

import javax.swing.JOptionPane;

/**
 *
 * @author Rohan Khante, Matthew Wentz, Jonathan Sorem, Robert James Davis
 */
public class Mortgage {
    
    Money processMoney    =   new Money();

    /*This function allows a player to mortgage a property.*/
    public void mortgageProperty(int spaceToBeMortgaged, Player currentActivePlayer)
    {
        int moneyOwedPlayer       =   0;
        int choiceSelection;

        boolean validChoice =   false;

        choiceSelection =   Integer.parseInt(JOptionPane.showInputDialog("Please choose one of the following options:\n"
                        + "1) Mortgage the property " + Values.board[spaceToBeMortgaged] + ".\n"
                        + "2) Do not mortgage the property.\n"));

        while(validChoice == false)
        {
            switch(choiceSelection)
            {
                case 1:
                    JOptionPane.showMessageDialog(null, "You decided to mortgage the property.\n", "Selling property.", 1);

                    JOptionPane.showMessageDialog(null, "You will get " + Values.propertyValues[spaceToBeMortgaged]/2 + ", so you"
                            + ".\n", "Did mortgage property.", 1);
                    moneyOwedPlayer                        =   Values.propertyValues[spaceToBeMortgaged]/2;
                    Values.isMortgaged[spaceToBeMortgaged] = true;
                    validChoice =   true;
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "You decided against mortgaging the property.\n", "Did not mortgage property.", 1);
                    validChoice =   true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "You need to make a valid selection in order to continue.\n", "Invalid Decision.", 1);
            }
        }

        processMoney.moneyOwedToPlayer(moneyOwedPlayer, currentActivePlayer);
    }
    
    /*This function allows a player to lift a mortgage on one of their properties.*/
    public void liftMortgage(int mortgagedSpace, Player currentActivePlayer)
    {
        int moneyOwed       =   0;
        int choiceSelection;

        boolean validChoice =   false;

        choiceSelection =   Integer.parseInt(JOptionPane.showInputDialog("Please choose one of the following options:\n"
                        + "1) Lift the mortgage on the property " + Values.board[mortgagedSpace] + ".\n"
                        + "2) Do not lift the mortgage.\n"));

        switch(choiceSelection)
        {
            case 1:
                JOptionPane.showMessageDialog(null, "You decided to lift the mortgage on the property.\n", "Lifting Mortgage on property.", 1);
                if(currentActivePlayer.totalCash > (Values.propertyValues[mortgagedSpace] + (Values.propertyValues[mortgagedSpace]/10)))
                {
                    JOptionPane.showMessageDialog(null, "You have at least " + (Values.propertyValues[mortgagedSpace] + (Values.propertyValues[mortgagedSpace]/10)) + ", so you"
                            + " can lift mortgage on currentActivePlayer.\n", "Enough money for lifting mortgage.", 1);
                    moneyOwed   =   (Values.propertyValues[mortgagedSpace] + (Values.propertyValues[mortgagedSpace]/10));
                    Values.isMortgaged[mortgagedSpace]            =   false;
                }
                validChoice =   true;
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "You decided against lifting the mortgage on the property.\n", "Did not lift mortgage.", 1);
                validChoice =   true;
                break;
            default:
                JOptionPane.showMessageDialog(null, "You need to make a valid selection in order to continue.\n", "Invalid Decision.", 1);
        }

        processMoney.moneyOwedByPlayer(moneyOwed, currentActivePlayer);
    }
}
