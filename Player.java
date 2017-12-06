/*
 * This is the Player class which containes functions and variables that pertain
 * to the player.
 */
package project_3;

import javax.swing.JOptionPane;

/**
 *
 * @author Rohan Khante, Matthew Wentz, Jonathan Sorem, Robert James Davis
 */
public class Player{
    public int id;
    public int totalCash;
    public int oneDollarBills;
    public int fiveDollarBills;
    public int tenDollarBills;
    public int twentyDollarBills;
    public int fiftyDollarBills;
    public int hundredDollarBills;
    public int fiveHundredDollarBills;
    public int currentBoardPosition;
    public int currentTurnInJail;
    
    
    public boolean inJail;
    public boolean chestGetOutFree;
    public boolean chanceGetOutFree;
    public int buildingsOwned[] = new int[40];
    public int totalValue;
    public boolean propertiesOwned[]   =   {false, false, false, false, false, false, false, 
                    false, false, false, false, false, false, false, false, false, false, false, false, false, 
                    false, false, false, false, false, false, false, false, false, false, false, false, false, 
                    false, false, false, false, false, false, false};
    
	public Player(int id) //id is for identifying  
	{
            
		this.id                     =   id;
		this.totalCash              =   1500;
		this.oneDollarBills         =   5;
		this.fiveDollarBills        =   5;
		this.tenDollarBills         =   5;
		this.twentyDollarBills      =   6;
		this.fiftyDollarBills       =   2;
		this.hundredDollarBills     =   2;
		this.fiveHundredDollarBills =   2;
		this.currentBoardPosition   =   0; 
		this.currentTurnInJail      =   5;
		this.totalValue             =   0;
                
                
                
		
                this.inJail                 = false;
	}
	
	public void PlaceBid(int bidAmount)
	{
		this.totalCash -= bidAmount;
		int billsToBeRemoved  = 0;
		
		billsToBeRemoved = bidAmount%this.fiveHundredDollarBills;
		this.fiveHundredDollarBills -= billsToBeRemoved;
		bidAmount -= billsToBeRemoved*this.fiveHundredDollarBills;
		
		billsToBeRemoved = bidAmount%this.hundredDollarBills;
		this.hundredDollarBills -= billsToBeRemoved;
		bidAmount -= billsToBeRemoved*this.hundredDollarBills;
		
		billsToBeRemoved = bidAmount%this.fiftyDollarBills;
		this.fiftyDollarBills -= billsToBeRemoved;
		bidAmount -= billsToBeRemoved*this.fiftyDollarBills;
		
		billsToBeRemoved = bidAmount%this.twentyDollarBills;
		this.twentyDollarBills -= billsToBeRemoved;
		bidAmount -= billsToBeRemoved*this.twentyDollarBills;
		
		billsToBeRemoved = bidAmount%this.tenDollarBills;
		this.tenDollarBills -= billsToBeRemoved;
		bidAmount -= billsToBeRemoved*this.tenDollarBills;
		
		billsToBeRemoved = bidAmount%this.fiveDollarBills;
		this.fiveDollarBills -= billsToBeRemoved;
		bidAmount -= billsToBeRemoved*this.fiveDollarBills;
		
		billsToBeRemoved = bidAmount%this.oneDollarBills;
		this.oneDollarBills -= billsToBeRemoved;
		bidAmount -= billsToBeRemoved*this.oneDollarBills;		

	}
	
        public void totalValue()
	{
		int amount = 0;
		for(int i=0; i<40; i++)
		{
			if(Values.spaceOwner[i] == this.id)
			{
				amount += Values.rent[i][this.buildingsOwned[i]]; //hopefully this is right
			}
		}
		this.totalValue += amount + this.totalCash;
	}
            
}
