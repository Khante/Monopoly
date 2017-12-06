/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_3;

import javax.swing.JOptionPane;

/**
 *
 * @author Rohan Khante, Matthew Wentz, Jonathan Sorem, Robert James Davis
 */
public class Building {
    
    Money processMoney    =   new Money();
    
    /* Buys buildings. A player can have up to four houses or a 1 hotel per a space.*/
    public void buyBuilding(String color, int currentSpaceProperty, Player currentActivePlayer)
    {
        int moneyOwed       =   0;
        int choiceSelection;

        boolean validChoice =   false;

        if((currentActivePlayer.buildingsOwned[currentSpaceProperty] == 0) || (currentActivePlayer.buildingsOwned[currentSpaceProperty] == 1) || 
               (currentActivePlayer.buildingsOwned[currentSpaceProperty] == 2) || (currentActivePlayer.buildingsOwned[currentSpaceProperty] == 3))
        {
            choiceSelection =   Integer.parseInt(JOptionPane.showInputDialog("Please choose one of the following options:\n"
                        + "1) Buy a house for " + Values.board[currentSpaceProperty] + ".\n"
                        + "2) Do not buy a house.\n"));

            while(validChoice == false)
            {
                switch(choiceSelection)
                {
                    case 1:
                        JOptionPane.showMessageDialog(null, "You decided to buy a house.\n", "Bought a building.", 1);
                        if(("Brown".equals(color)) || ("Light Blue".equals(color)))
                        {
                            if(currentActivePlayer.totalCash >= 50)
                            {
                                JOptionPane.showMessageDialog(null, "You have at least $50.\n", "The Price", 1);
                                moneyOwed   =   50;
                                currentActivePlayer.buildingsOwned[currentActivePlayer.currentBoardPosition]    += 1;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "You do not have at least $50.\n", "The Price", 1);
                            }
                        }
                        else if(("Pink".equals(color)) || ("Orange".equals(color)))
                        {
                            if(currentActivePlayer.totalCash >= 100)
                            {
                                JOptionPane.showMessageDialog(null, "You have at least $100.\n", "The Price", 1);
                                moneyOwed   =   100;
                                currentActivePlayer.buildingsOwned[currentActivePlayer.currentBoardPosition]    += 1;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "You do not have at least $100.\n", "The Price", 1);
                            }
                        }
                        else if(("Red".equals(color)) || ("Yellow".equals(color)))
                        {
                            if(currentActivePlayer.totalCash >= 150)
                            {
                                JOptionPane.showMessageDialog(null, "You have at least $150.\n", "The Price", 1);
                                moneyOwed   =   150;
                                currentActivePlayer.buildingsOwned[currentActivePlayer.currentBoardPosition]    += 1;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "You do not have at least $150.\n", "The Price", 1);
                            }
                        }
                        else if(("Green".equals(color)) || ("Dark Blue".equals(color)))
                        {
                            if(currentActivePlayer.totalCash >= 200)
                            {
                                JOptionPane.showMessageDialog(null, "You have at least $200.\n", "The Price", 1);
                                moneyOwed   =   200;
                                currentActivePlayer.buildingsOwned[currentActivePlayer.currentBoardPosition]    += 1;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "You do not have at least $200.\n", "The Price", 1);
                            }
                        }
                        validChoice =   true;
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "You decided against buying a house.\n", "did not buy a building.", 1);
                        validChoice =   true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "You need to make a valid selection in order to continue.\n", "Invalid Decision.", 1);
                }
            }
        }
        else if(currentActivePlayer.buildingsOwned[currentSpaceProperty] == 4)
        {
            choiceSelection =   Integer.parseInt(JOptionPane.showInputDialog("Please choose one of the following options:\n"
                        + "1) Buy a Hotel for " + Values.board[currentSpaceProperty] + ".\n"
                        + "2) Do not buy a Hotel.\n"));

            while(validChoice == false)
            {
                switch(choiceSelection)
                {
                    case 1:
                        JOptionPane.showMessageDialog(null, "You decided to buy a Hotel.\n", "Bought a building.", 1);
                        if(("Brown".equals(color)) || ("Light Blue".equals(color)))
                        {
                            if(currentActivePlayer.totalCash >= 50)
                            {
                                JOptionPane.showMessageDialog(null, "You have at least $50.\n", "The Price", 1);
                                moneyOwed   =   50;
                                currentActivePlayer.buildingsOwned[currentActivePlayer.currentBoardPosition]    += 1;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "You do not have at least $50.\n", "The Price", 1);
                            }
                        }
                        else if(("Pink".equals(color)) || ("Orange".equals(color)))
                        {
                            if(currentActivePlayer.totalCash >= 100)
                            {
                                JOptionPane.showMessageDialog(null, "You have at least $100.\n", "The Price", 1);
                                moneyOwed   =   100;
                                currentActivePlayer.buildingsOwned[currentActivePlayer.currentBoardPosition]    += 1;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "You do not have at least $100.\n", "The Price", 1);
                            }
                        }
                        else if(("Red".equals(color)) || ("Yellow".equals(color)))
                        {
                            if(currentActivePlayer.totalCash >= 150)
                            {
                                JOptionPane.showMessageDialog(null, "You have at least $150.\n", "The Price", 1);
                                moneyOwed   =   150;
                                currentActivePlayer.buildingsOwned[currentActivePlayer.currentBoardPosition]    += 1;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "You do not have at least $150.\n", "The Price", 1);
                            }
                        }
                        else if(("Green".equals(color)) || ("Dark Blue".equals(color)))
                        {
                            if(currentActivePlayer.totalCash >= 200)
                            {
                                JOptionPane.showMessageDialog(null, "You have at least $200.\n", "The Price", 1);
                                moneyOwed   =   200;
                                currentActivePlayer.buildingsOwned[currentActivePlayer.currentBoardPosition]    += 1;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "You do not have at least $200.\n", "The Price", 1);
                            }
                        }
                        validChoice =   true;
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "You decided against buying a Hotel.\n", "did not buy a building.", 1);
                        validChoice =   true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "You need to make a valid selection in order to continue.\n", "Invalid Decision.", 1);
                }
            }
        }
        else if(currentActivePlayer.buildingsOwned[currentSpaceProperty] == 5)
        {
            JOptionPane.showMessageDialog(null, "This spot is already filled with buildings.\n", "To many buildings.", 1);
        }

        processMoney.moneyOwedByPlayer(moneyOwed, currentActivePlayer);
    }

    /* Sells a building on the player's chosen property. */
    public void sellBuilding(String color, int currentSpaceProperty, Player currentActivePlayer)
    {
        int moneyOwedPlayer       =   0;
        int choiceSelection;

        boolean validChoice =   false;

        if((currentActivePlayer.buildingsOwned[currentSpaceProperty] == 1) || (currentActivePlayer.buildingsOwned[currentSpaceProperty] == 2) || 
               (currentActivePlayer.buildingsOwned[currentSpaceProperty] == 3) || (currentActivePlayer.buildingsOwned[currentSpaceProperty] == 4))
        {

            choiceSelection =   Integer.parseInt(JOptionPane.showInputDialog("Please choose one of the following options:\n"
                        + "1) Sell a house for " + Values.board[currentSpaceProperty] + ".\n"
                        + "2) Do not sell a house.\n"));

            while(validChoice == false)
            {
                switch(choiceSelection)
                {
                    case 1:
                        JOptionPane.showMessageDialog(null, "You decided to Sell a house.\n", "Bought a building.", 1);
                        if(("Brown".equals(color)) || ("Light Blue".equals(color)))
                        {
                            JOptionPane.showMessageDialog(null, "You are getting paid $25.\n", "The Price", 1);
                            moneyOwedPlayer   =   25;
                            currentActivePlayer.buildingsOwned[currentActivePlayer.currentBoardPosition]    -= 1;
                        }
                        else if(("Pink".equals(color)) || ("Orange".equals(color)))
                        {
                            JOptionPane.showMessageDialog(null, "You are getting paid $50.\n", "The Price", 1);
                            moneyOwedPlayer   =   50;
                            currentActivePlayer.buildingsOwned[currentActivePlayer.currentBoardPosition]    -= 1;

                        }
                        else if(("Red".equals(color)) || ("Yellow".equals(color)))
                        {
                            JOptionPane.showMessageDialog(null, "You are getting paid $75.\n", "The Price", 1);
                            moneyOwedPlayer   =   75;
                            currentActivePlayer.buildingsOwned[currentActivePlayer.currentBoardPosition]    -= 1;

                        }
                        else if(("Green".equals(color)) || ("Dark Blue".equals(color)))
                        {
                            JOptionPane.showMessageDialog(null, "You have at least $100.\n", "The Price", 1);
                            moneyOwedPlayer   =   100;
                            currentActivePlayer.buildingsOwned[currentActivePlayer.currentBoardPosition]    -= 1;
                        }
                        validChoice =   true;
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "You decided against Selling a house.\n", "did not buy a building.", 1);
                        validChoice =   true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "You need to make a valid selection in order to continue.\n", "Invalid Decision.", 1);
                }
            }
        }
        else if(currentActivePlayer.buildingsOwned[currentSpaceProperty] == 5)
        {
            choiceSelection =   Integer.parseInt(JOptionPane.showInputDialog("Please choose one of the following options:\n"
                        + "1) Sell a Hotel for " + Values.board[currentSpaceProperty] + ".\n"
                        + "2) Do not sell a Hotel.\n"));

            while(validChoice == false)
            {
                switch(choiceSelection)
                {
                    case 1:
                        JOptionPane.showMessageDialog(null, "You decided to Sell a hotel.\n", "Sold a building.", 1);
                        if(("Brown".equals(color)) || ("Light Blue".equals(color)))
                        {
                            JOptionPane.showMessageDialog(null, "You are getting paid $25.\n", "The Price", 1);
                            moneyOwedPlayer   =   25;
                            currentActivePlayer.buildingsOwned[currentActivePlayer.currentBoardPosition]    -= 1;
                        }
                        else if(("Pink".equals(color)) || ("Orange".equals(color)))
                        {
                            JOptionPane.showMessageDialog(null, "You are getting paid $50.\n", "The Price", 1);
                            moneyOwedPlayer   =   50;
                            currentActivePlayer.buildingsOwned[currentActivePlayer.currentBoardPosition]    -= 1;

                        }
                        else if(("Red".equals(color)) || ("Yellow".equals(color)))
                        {
                            JOptionPane.showMessageDialog(null, "You are getting paid $75.\n", "The Price", 1);
                            moneyOwedPlayer   =   75;
                            currentActivePlayer.buildingsOwned[currentActivePlayer.currentBoardPosition]    -= 1;

                        }
                        else if(("Green".equals(color)) || ("Dark Blue".equals(color)))
                        {
                            JOptionPane.showMessageDialog(null, "You have at least $100.\n", "The Price", 1);
                            moneyOwedPlayer   =   100;
                            currentActivePlayer.buildingsOwned[currentActivePlayer.currentBoardPosition]    -= 1;
                        }
                        validChoice =   true;
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "You decided against selling a Hotel.\n", "did not sell a building.", 1);
                        validChoice =   true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "You need to make a valid selection in order to continue.\n", "Invalid Decision.", 1);
                }
            }
        }
        else if(currentActivePlayer.buildingsOwned[currentSpaceProperty] == 0)
        {
            JOptionPane.showMessageDialog(null, "This spot has no buildings.\n", "No buildings to sell.", 1);
        }

        processMoney.moneyOwedToPlayer(moneyOwedPlayer, currentActivePlayer);
    }
    
}
