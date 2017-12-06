/*
 * This is the Utilities Class. This Class holds the functions to process the
 * electric company utility and the water works utility.
 */
package project_3;

import javax.swing.JOptionPane;

/**
 *
 * @author Rohan Khante, Matthew Wentz, Jonathan Sorem, Robert James Davis
 */
public class Utilities {
    
    int choiceSelection         =   0;
    boolean isValid             =   false;
    
    Money processMoney          =   new Money();
    Property processProperty    =   new Property();
    
    void electricCompany(Player currentActivePlayer)
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
            //payRent(currentActivePlayer, ) //diceresults*4 if one owned, diceresults*10 if both owned
        }
    }
    
    void waterWorks(Player currentActivePlayer)
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
            //payRent(currentActivePlayer, ) //diceresults*4 if one owned, diceresults*10 if both owned
        }
    }
    
}
