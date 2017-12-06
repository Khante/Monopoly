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
public class Chance {

        //randomly chooses a card from the chance deck.
    int card_choice =(1 + (int)(Math.random()*((16-1)+1)));
    Money processMoney = new Money();
    public void chance(Player currentActivePlayer)
    {
        switch(card_choice){
            case 1:
                advanceToGO(currentActivePlayer);
                break;
            case 2:
                advanceToIllinoisAve(currentActivePlayer);
                break;
            case 3:
                advanceToStCharlesPlace(currentActivePlayer);
                break;
            case 4:
                advanceTokenToNearestUtility(currentActivePlayer);
                break;
            case 5:
                advanceTokenToNearestRailroad(currentActivePlayer);
                break;
            case 6:
                bankPaysYou50dollars(currentActivePlayer);
                break;
            case 7:
                getOutOfJailFree(currentActivePlayer);
                break;
            case 8:
                goBack3Spaces(currentActivePlayer);
                break;
            case 9:
                goToJail(currentActivePlayer);
                break;
            case 10:
                makeGeneralRepairs(currentActivePlayer);
                break;
            case 11:
                payPoorTax15dollars(currentActivePlayer);
                break;
            case 12:
                takeATripToReadingRailroad(currentActivePlayer);
                break;
            case 13:
                takeAWalkOnBoardwalk(currentActivePlayer);
                break;
            case 14:
                getElectedChairmanOfBoard(currentActivePlayer);
                break;
            case 15:
                yourBuildingAndLoanMatures(currentActivePlayer);
                break;
            case 16:
                youWonCrosswordCompetitition(currentActivePlayer);
                break;
        }
    }

        // each function is an individual card in the chance deck.
    
    public void advanceToGO(Player currentActivePlayer){
        int spacesToGo = 40-currentActivePlayer.currentBoardPosition;
        Movement processMovement = new Movement();
        processMovement.moveToken(spacesToGo , currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Advance directly to Go! Receive $200!","Chance", 1);
    }
    public void advanceToIllinoisAve(Player currentActivePlayer){
        int spacesToGo = 24-currentActivePlayer.currentBoardPosition;
        Movement processMovement = new Movement();
        processMovement.moveToken(spacesToGo , currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Advance to Illinois Ave","Chance", 1);
    }
    public void advanceToStCharlesPlace(Player currentActivePlayer){
        int spacesToGo = 11-currentActivePlayer.currentBoardPosition;
        Movement processMovement = new Movement();
        processMovement.moveToken(spacesToGo , currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Advance to Charles Place.","Chance", 1);
    }
    public void advanceTokenToNearestUtility(Player currentActivePlayer){
        Movement processMovement = new Movement();
        if(currentActivePlayer.currentBoardPosition<12){
            processMovement.moveToken(12-currentActivePlayer.currentBoardPosition, currentActivePlayer);
        }
        else if(currentActivePlayer.currentBoardPosition <28){
            processMovement.moveToken(28-currentActivePlayer.currentBoardPosition, currentActivePlayer);
        }
        else {
            processMovement.moveToken(40-currentActivePlayer.currentBoardPosition, currentActivePlayer);
            processMovement.moveToken(12-currentActivePlayer.currentBoardPosition, currentActivePlayer);
        }
        JOptionPane.showMessageDialog(null,"Advance to nearest utility.","Chance", 1);
    }
    public void advanceTokenToNearestRailroad(Player currentActivePlayer){
        Movement processMovement = new Movement();
        if(currentActivePlayer.currentBoardPosition<5){
            processMovement.moveToken(5-currentActivePlayer.currentBoardPosition, currentActivePlayer);
        }
        else if(currentActivePlayer.currentBoardPosition<15){
            processMovement.moveToken(15-currentActivePlayer.currentBoardPosition, currentActivePlayer);
        }
        else if(currentActivePlayer.currentBoardPosition<25){
            processMovement.moveToken(25-currentActivePlayer.currentBoardPosition, currentActivePlayer);
        }
        else if(currentActivePlayer.currentBoardPosition<35){
            processMovement.moveToken(35-currentActivePlayer.currentBoardPosition, currentActivePlayer);
        }
        else{
            processMovement.moveToken(40-currentActivePlayer.currentBoardPosition, currentActivePlayer);
            processMovement.moveToken(5-currentActivePlayer.currentBoardPosition, currentActivePlayer);
        }
        JOptionPane.showMessageDialog(null,"Advance to nearest railroad.","Chance", 1);
    }
    public void bankPaysYou50dollars(Player currentActivePlayer){
        Money processMoney = new Money();
        processMoney.moneyOwedToPlayer(50, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Bank Error! You recieve $50.","Chance", 1);
    }
    public void getOutOfJailFree(Player currentActivePlayer){
        currentActivePlayer.chanceGetOutFree = true;
        JOptionPane.showMessageDialog(null,"You receive a Get Out of Jail Free card!","Chance", 1);
    }
    public void goBack3Spaces(Player currentActivePlayer){
        Movement processMovement = new Movement();
        processMovement.moveToken(-3, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Go back 3 spaces","Chance", 1);
    }
    public void goToJail(Player currentActivePlayer){
        SpaceResolutions processJail = new SpaceResolutions();
        processJail.goToJail(currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Go directly to Jail!","Chance", 1);
    }
    public void makeGeneralRepairs(Player currentActivePlayer){
        Money processMoney = new Money();
        int money_due = 0;
        int num_houses = 0;
        int num_hotels = 0;
        for(int x = 0; x < 40; x++){
            if (currentActivePlayer.buildingsOwned[x] == 5){
                num_hotels = num_hotels + 1;
            }
            else{
                num_houses = num_houses + currentActivePlayer.buildingsOwned[x];
            }
        }
        money_due = num_houses * 25 + num_hotels * 100;
        processMoney.moneyOwedByPlayer(money_due, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Make general repairs! Pay $25 per house and $100 per hotel!","Chance", 1);
    }
    public void payPoorTax15dollars(Player currentActivePlayer){
        Money processMoney = new Money();
        processMoney.moneyOwedByPlayer(15, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Pay poor tax of $15!","Chance", 1);
    }
    public void takeATripToReadingRailroad(Player currentActivePlayer){
        int spacesToGoToRailroad = 5-currentActivePlayer.currentBoardPosition;
        int spacesToGo = 40 - currentActivePlayer.currentBoardPosition;
        if(spacesToGo < spacesToGoToRailroad){
            Money processMoney =new Money();
            processMoney.moneyOwedToPlayer(200, currentActivePlayer);
        }
        Movement processMovement = new Movement();
        processMovement.moveToken(spacesToGoToRailroad , currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Take a trip on the Reading Railroad.","Chance", 1);
    }
    public void takeAWalkOnBoardwalk(Player currentActivePlayer){
        int spacesToGo = 39-currentActivePlayer.currentBoardPosition;
        Movement processMovement = new Movement();
        processMovement.moveToken(spacesToGo , currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Take a walk on the Boardwalk!","Chance", 1);
    }
    public void getElectedChairmanOfBoard(Player currentActivePlayer){
        for(int i = 0; i < Values.Players.size(); i++){
            processMoney.moneyOwedToPlayer(50, Values.Players.get(i));
        }
        int money_due = Values.Players.size() * 50;
        processMoney.moneyOwedByPlayer(money_due, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"You are elected Chairman of the Board! Pay each player $50!","Chance", 1);
    }
    public void yourBuildingAndLoanMatures(Player currentActivePlayer){
        Money processMoney = new Money();
        processMoney.moneyOwedToPlayer(150, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Your building loan matures! Receive $150!","Chance", 1);

    }
    public void youWonCrosswordCompetitition(Player currentActivePlayer){
        Money processMoney = new Money();
        processMoney.moneyOwedToPlayer(100, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"You win crossword competition! You receive $100!","Chance", 1);
        
    }
}
