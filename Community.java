package project_3;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Rohan Khante, Matthew Wentz, Jonathan Sorem, Robert James Davis
 */
public class Community {
    
    Money processMoney = new Money();
    Turn processTurn = new Turn();
    
    // randomly chooses card from community chest deck
    
    public void community_chest(Player currentActivePlayer){
        
        int card_choice =(1 + (int)(Math.random()*((16-1)+1)));
        
        switch(card_choice){
            case 1:
                advance_to_go(currentActivePlayer);
                break;
            case 2:
                bank_error(currentActivePlayer);
                break;
            case 3:
                doctor_fees(currentActivePlayer);
                break;
            case 4:
                sale_of_stock(currentActivePlayer);
                break;
            case 5:
                jail_free(currentActivePlayer);
                break;
            case 6:
                go_to_jail(currentActivePlayer);
                break;
            case 7:
                opera_opening(currentActivePlayer);
                break;
            case 8:
                holiday_fund_matures(currentActivePlayer);
                break;
            case 9:
                income_tax_refund(currentActivePlayer);
                break;
            case 10:
                insurance_matures(currentActivePlayer);
                break;
            case 11:
                hospital_fees(currentActivePlayer);
                break;
            case 12:
                school_fees(currentActivePlayer);
                break;
            case 13:
                consultancy_fee(currentActivePlayer);
                break;
            case 14:
                street_repairs(currentActivePlayer);
                break;
            case 15:
                second_prize(currentActivePlayer);
                break;
            case 16:
                inherit_100(currentActivePlayer);
                break;
        }
    }
    
    // functions below represent each individual card in community chest
    
    public void advance_to_go(Player currentActivePlayer){
        currentActivePlayer.currentBoardPosition = 0;
        processMoney.moneyOwedToPlayer(200, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Advance directly to Go! Receive $200!","Community Chest", 1);
    }
    
    public void bank_error(Player currentActivePlayer){
        processMoney.moneyOwedToPlayer(200,  currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Bank error in your favor","Community Chest", 1);
    }
    
    public void doctor_fees(Player currentActivePlayer){
        processMoney.moneyOwedByPlayer(50, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Doctor's Fees, Pay $50","Community Chest", 1);
    }
    
    public void sale_of_stock(Player currentActivePlayer){
        processMoney.moneyOwedToPlayer(45, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"From sale of stock, you get $50","Community Chest", 1);
    }
    
    public void jail_free(Player currentActivePlayer){
        currentActivePlayer.chestGetOutFree = true;
        JOptionPane.showMessageDialog(null,"You receive a Get Out of Jail Free Card!","Community Chest", 1);
    }
    
    public void go_to_jail(Player currentActivePlayer){
        currentActivePlayer.currentBoardPosition = 10;
        JOptionPane.showMessageDialog(null,"Go to jail! You are now in jail!","Community Chest", 1);
    }
    
    public void opera_opening(Player currentActivePlayer){
        for(int i = 0; i < Values.Players.size(); i++){
            processMoney.moneyOwedByPlayer(50, Values.Players.get(i));
        }
        int money_due = Values.Players.size() * 50;
        processMoney.moneyOwedToPlayer(money_due, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Opera House Opening! Every Player owes you $50!","Community Chest", 1);
    }
    
    public void holiday_fund_matures(Player currentActivePlayer){
        processMoney.moneyOwedToPlayer(100, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Holiday Fund matures, receive $100","Community Chest", 1);
    }
    
    public void income_tax_refund(Player currentActivePlayer){
        processMoney.moneyOwedToPlayer(20, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Income tax refune, receive $20","Community Chest", 1);
    }
    
    public void insurance_matures(Player currentActivePlayer){
        processMoney.moneyOwedByPlayer(100, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Life insurance matures, receive $100","Community Chest", 1);
    }
    
    public void hospital_fees(Player currentActivePlayer){
        processMoney.moneyOwedByPlayer(100, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Pay hospital fees of $100","Community Chest", 1);
    }
    
    public void school_fees(Player currentActivePlayer){
        processMoney.moneyOwedByPlayer(150, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Pay school fees of $150","Community Chest", 1);
    }
    
    public void consultancy_fee(Player currentActivePlayer){
        processMoney.moneyOwedToPlayer(25, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"Receive $25 consultancy fee","Community Chest", 1);
    }
    
    public void street_repairs(Player currentActivePlayer){
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
        money_due = (num_houses * 40) + (num_hotels * 115);
        processMoney.moneyOwedByPlayer(money_due, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"You are assessed for street repairs, $40 per house and $115 per hotel.","Community Chest", 1);
    }
    
    public void second_prize(Player currentActivePlayer){
        processMoney.moneyOwedToPlayer(10, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"You somehow won second place in beauty contest, receive $10.","Community Chest", 1);
    }
    
    public void inherit_100(Player currentActivePlayer){
        processMoney.moneyOwedToPlayer(100, currentActivePlayer);
        JOptionPane.showMessageDialog(null,"You inherit a small loan of $100.","Community Chest", 1);
    }
}
