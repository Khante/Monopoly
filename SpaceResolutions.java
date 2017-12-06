/*
 * This class resolves spaces and calls the appropriate functions that pertain
 * to that space.
 */
package project_3;

import javax.swing.JOptionPane;

/**
 *
 * @author Rohan Khante, Matthew Wentz, Jonathan Sorem, Robert James Davis
 */
public class SpaceResolutions {
    
    Money processMoney          =   new Money();
    Property processProperty    =   new Property();
    TaxSpace processTaxSpace    =   new TaxSpace();
    Utilities processUtilities  =   new Utilities();
    Community processCommunity  =   new Community();
    Chance processChance        =   new Chance();
    
    /*Player goes to the jail space and the current turn in jail is set to zero.*/
    public void goToJail(Player currentActivePlayer)
    {
        currentActivePlayer.currentBoardPosition   =   10;
        currentActivePlayer.currentTurnInJail      =   0;

        JOptionPane.showMessageDialog(null, "Welcome to jail you vile criminal. Hope you enjoy your stay.\n", "Jail Time.", 1);
    }
    
    /* This functions gives the player $200 everytime they pass go normally.*/
    public void passedGo(Player currentActivePlayer)
    {
        // PLayer's Total Cash updated
        currentActivePlayer.totalCash = currentActivePlayer.totalCash + 200;

        /* Money increments updated. Several money increments were used
           in order to spread the money increments and hopefully decrease
           the amount of money exchanging that would be used.
        */
        currentActivePlayer.hundredDollarBills = currentActivePlayer.hundredDollarBills + 1;
        currentActivePlayer.fiftyDollarBills   = currentActivePlayer.fiftyDollarBills + 1;
        currentActivePlayer.twentyDollarBills  = currentActivePlayer.twentyDollarBills + 1;
        currentActivePlayer.tenDollarBills     = currentActivePlayer.tenDollarBills + 2;
        currentActivePlayer.fiveDollarBills    = currentActivePlayer.fiveDollarBills + 1;
        currentActivePlayer.oneDollarBills     = currentActivePlayer.oneDollarBills + 5;
    }
    
    public void auction()
    {
        
    }
    
    public void resolveSpace(Player currentActivePlayer)
    {
        int choiceSelection;
        boolean isValid =   false;
        
         if(Values.rent[currentActivePlayer.currentBoardPosition][0] > 0)
         {
             if(Values.rent[currentActivePlayer.currentBoardPosition][0] < 25) // Train space
             {
                 if(Values.spaceOwner[currentActivePlayer.currentBoardPosition] == 0)
                 {
                    choiceSelection =   Integer.parseInt(JOptionPane.showInputDialog("Please choose one of the following options:\n"
                        + "1) Try and buy the property " + Values.currentBoard[currentActivePlayer.currentBoardPosition] + " for "
                            + Values.propertyValues[currentActivePlayer.currentBoardPosition] + ".\n"
                        + "2) Put the property up for auction.\n"));
                    
                    while(isValid == false)
                    {
                        switch(choiceSelection)
                        {
                                case 1:
                                    JOptionPane.showMessageDialog(null, "You decided to try and buy the Property.\n", "Buy Property Decision.", 1);
                                    processProperty.buyProperty(currentActivePlayer.currentBoardPosition, currentActivePlayer);
                                    isValid =   true;
                                    break;
                                case 2:
                                    JOptionPane.showMessageDialog(null, "You decided to allow the property go up for auction.\n", "Auction Time!", 1);
                                    //Game.auction();
                                    isValid =   true;
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "You need to make a valid selection in order to continue.\n", "Invalid Decision.", 1);
                        }             
                    }   
                 }
                 else if(Values.spaceOwner[currentActivePlayer.currentBoardPosition] == currentActivePlayer.id)
                 {
                     JOptionPane.showMessageDialog(null, "You already own this space!\n", "Already owned by you.", 1);
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null, "This position is already owned by someone else. Time to pay rent!\n", "Someone already owns this castle.", 1);
                     //payRent(currentActivePlayer, ???, );
                 }
             }
             else // Property Space
             {
                 if(Values.spaceOwner[currentActivePlayer.currentBoardPosition] == 0)
                 {
                    choiceSelection =   Integer.parseInt(JOptionPane.showInputDialog("Please choose one of the following options:\n"
                        + "1) Try and buy the property " + Values.currentBoard[currentActivePlayer.currentBoardPosition] + ".\n"
                        + "2) Put the property up for auction.\n"));
                    
                    while(isValid == false)
                    {
                        switch(choiceSelection)
                        {
                                case 1:
                                    JOptionPane.showMessageDialog(null, "You decided to try and buy the Property.\n", "Buy Property Decision.", 1);
                                    processProperty.buyProperty(currentActivePlayer.currentBoardPosition, currentActivePlayer);
                                    isValid =   true;
                                    break;
                                case 2:
                                    JOptionPane.showMessageDialog(null, "You decided to allow the property go up for auction.\n", "Auction Time!", 1);
                                    //Game.auction();
                                    isValid =   true;
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "You need to make a valid selection in order to continue.\n", "Invalid Decision.", 1);
                        }             
                    }   
                 }
                 else if(Values.spaceOwner[currentActivePlayer.currentBoardPosition] == currentActivePlayer.id)
                 {
                     JOptionPane.showMessageDialog(null, "You already own this space!\n", "Already owned by you.", 1);
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null, "This position is already owned by someone else. Time to pay rent!\n", "Someone already owns this castle.", 1);
                     //payRent(currentActivePlayer, )
                 }
             }
         }
         else if(currentActivePlayer.currentBoardPosition == 4) //Income Tax space
         {
            processTaxSpace.incomeTax(currentActivePlayer);
         }
         else if(currentActivePlayer.currentBoardPosition == 38) //Luxury Tax space
         {
            processTaxSpace.luxuryTax(currentActivePlayer);
         }
         else if(currentActivePlayer.currentBoardPosition == 12) //Electric Company Space
         {
             processUtilities.electricCompany(currentActivePlayer);
         }
         else if(currentActivePlayer.currentBoardPosition == 28) //Water Works Space
         {
             processUtilities.waterWorks(currentActivePlayer);
         }
         else if(currentActivePlayer.currentBoardPosition == 2 || currentActivePlayer.currentBoardPosition == 17 || currentActivePlayer.currentBoardPosition == 33) //Community Chest Spaces
         {
             processCommunity.community_chest(currentActivePlayer);
         }
         else if (currentActivePlayer.currentBoardPosition == 7 || currentActivePlayer.currentBoardPosition == 22 || currentActivePlayer.currentBoardPosition == 36) //Chance Spaces
         {
             processChance.chance(currentActivePlayer);
         }
         
    }
    
}