/*
 * This class handles functions that deal with property, that is, the spaces.
* It contains options to buy and sell property.
 */
package project_3;

import javax.swing.JOptionPane;

/**
 *
 * @author Rohan Khante, Matthew Wentz, Jonathan Sorem, Robert James Davis
 */
public class Property {
    
    Money processMoney          =   new Money();
    Building processBuilding    =   new Building();
    
    /*This allows a player the option to buy property.*/
    public void buyProperty(int spaceToBeBought, Player currentActivePlayer)
    {
        int moneyOwed       =   0;
        int choiceSelection;

        boolean validChoice =   false;

        choiceSelection =   Integer.parseInt(JOptionPane.showInputDialog("Please choose one of the following options:\n"
                        + "1) Continue to buy the property " + Values.currentBoard[spaceToBeBought] + ".\n"
                        + "2) End up not buying the property.\n"));

        switch(choiceSelection)
        {
            case 1:
                JOptionPane.showMessageDialog(null, "You decided to continue to try and buy the property.\n", "Buying property.", 1);
                if(currentActivePlayer.totalCash > Values.propertyValues[spaceToBeBought])
                {
                    JOptionPane.showMessageDialog(null, "You have at least " + Values.propertyValues[spaceToBeBought] + ", so you"
                            + " can buy the property.\n", "Enough money for property.", 1);
                    moneyOwed   =   Values.propertyValues[spaceToBeBought];
                    currentActivePlayer.propertiesOwned[spaceToBeBought]     =   true;
                    Values.spaceOwner[spaceToBeBought] = currentActivePlayer.id;
                }
                validChoice =   true;
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "You decided against buying the property.\n", "Did not buy property.", 1);
                validChoice =   true;
                break;
            default:
                JOptionPane.showMessageDialog(null, "You need to make a valid selection in order to continue.\n", "Invalid Decision.", 1);
        }

        processMoney.moneyOwedByPlayer(moneyOwed, currentActivePlayer);
    }

    /*This function allows a player to sell a piece of property.*/
    public void sellProperty(String color, int spaceToBeSold, Player currentActivePlayer)
    {
        int moneyOwedPlayer       =   0;
        int choiceSelection;

        boolean validChoice =   false;

        choiceSelection =   Integer.parseInt(JOptionPane.showInputDialog("Please choose one of the following options:\n"
                        + "1) Continue to try and sell the property " + Values.board[spaceToBeSold] + ".\n"
                        + "2) Do not sell property.\n"));

        switch(choiceSelection)
        {
            case 1:
                JOptionPane.showMessageDialog(null, "You decided to contnue and sell the property.\n", "Selling property.", 1);

                if(currentActivePlayer.buildingsOwned[spaceToBeSold] != 0)
                {
                    JOptionPane.showMessageDialog(null, "You have buildings on currentActivePlayer property "
                            + "that you have to sell before selling the property.\n", "Selling buildings before property.", 1);
                    processBuilding.sellBuilding(color, spaceToBeSold, currentActivePlayer);
                }
                JOptionPane.showMessageDialog(null, "You will get " + Values.propertyValues[spaceToBeSold]/2 + ", so you"
                        + ".\n", "Did sell property.", 1);
                moneyOwedPlayer                           =   Values.propertyValues[spaceToBeSold]/2;
                currentActivePlayer.propertiesOwned[spaceToBeSold]            = false;
                Values.spaceOwner[spaceToBeSold] = 0;
                validChoice =   true;
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "You decided against selling the property.\n", "Did not sell property.", 1);
                validChoice =   true;
                break;
            default:
                JOptionPane.showMessageDialog(null, "You need to make a valid selection in order to continue.\n", "Invalid Decision.", 1);
        }

        processMoney.moneyOwedToPlayer(moneyOwedPlayer, currentActivePlayer);
    }
    
}
