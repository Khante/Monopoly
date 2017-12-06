/*
 * The Player's Turn is processed in this class.
 *
 */
package project_3;

import javax.swing.JOptionPane;

/**
 *
 * @author Rohan Khante, Matthew Wentz, Jonathan Sorem, Robert James Davis
 */
public class Turn{
    
    public void doPlayerTurn(Player currentActivePlayer)
    {
        Money processMoney          =   new Money();
        Mortgage processMortgage    =   new Mortgage();
        Property processProperty    =   new Property();
        Building processBuilding    =   new Building();
        Jail processJail            =   new Jail();
        Dice processDice            =   new Dice();
        Movement processMovement    =   new Movement();

        if(currentActivePlayer.currentTurnInJail == 0)
        {
            processJail.jailProcessing(currentActivePlayer);
        }
        else
        {
             int diceResult  =   processDice.rollDice();
             processMovement.moveToken(diceResult, currentActivePlayer);
             int exitWhile   =   0;

             int choiceSelection;

             while(exitWhile == 0)
             {
                 boolean validChoice =   false;

                 choiceSelection =   Integer.parseInt(JOptionPane.showInputDialog("Since you have resolved the space you have "
                         + "landed on, Please choose one of the following options:\n"
                                 + "1) Buy buildings.\n"
                                 + "2) Sell Buildings.\n"
                                 + "3) Sell Property.\n"
                                 + "4) Mortgage Property.\n"
                                 + "5) Lift Mortgage Property.\n"
                                 + "6) End Turn"));

                 while(validChoice == false)
                 {
                     switch(choiceSelection)
                     {
                         case 1:
                             JOptionPane.showMessageDialog(null, "You decided to mortgage the property.\n", "Selling property.", 1);
                             /* In this area would give the player a list of their availible properties to buy buildings on.
                             A comparison would also be made of their availible bodies to make sure they have all of a suite.
                             */
                             processBuilding.buyBuilding("Brown", 1, currentActivePlayer);
                             validChoice =   true;
                             break;
                         case 2:
                             JOptionPane.showMessageDialog(null, "You decided against mortgaging the property.\n", "Did not mortgage property.", 1);
                             /* In this area would give the player a list of their availible properties to sell buildings on.
                             */ 
                             processBuilding.sellBuilding("Brown", 1, currentActivePlayer);
                             validChoice =   true;
                             break;
                         case 3:
                             /* In this area the player would be given a list of properties they own.
                             If they try to sell a property with buildings on it, the sell property function will go through selling
                             all those buildings.
                             */
                             processProperty.sellProperty("Brown", 1, currentActivePlayer);
                             validChoice =   true;
                             break;
                         case 4:
                             /* In this area the player will be given an option to mortgage off some of their property.
                             If they have buildings on the property, they will be asked to sell them, otherwise they do not mortgage the building.
                             */
                             processMortgage.mortgageProperty(1, currentActivePlayer);
                             validChoice =   true;
                             break;
                         case 5:
                             /* In this area the player will have an option to lift the mortgages
                             on any of their properties that are currently mortgaged.
                             */
                             processMortgage.liftMortgage(1, currentActivePlayer);
                             validChoice =   true;
                             break;
                         case 6: // This will exit the while loop, effectivly ending the players turn.
                             exitWhile   =   1;
                             validChoice =   true;
                             break;
                         default:
                             JOptionPane.showMessageDialog(null, "You need to make a valid selection in order to continue.\n", "Invalid Decision.", 1);
                     }
                 }
             }
        } 
    }
    
}
