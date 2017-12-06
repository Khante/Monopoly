/*
 * This is the Pokemon Game class, a variant of the regular monopoly game.
 * This game runs more the higher level functions and
 * initialization procedures. Players are instantiated here as well as determing
 * the winner, the number of players, the max number of rounds, etc.
 */
package project_3;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Rohan Khante, Matthew Wentz, Jonathan Sorem, Robert James Davis
 */

public class PokemonGame {
    
    public int max_rounds;
    public int current_round =0;
    public int num_players;
    public String[] turn_order;
    public String[] available_tokens;
    public int board_position;
    public boolean game_over = false;
    public List<Integer> playerOrder;
    public List<Player> Players;
    
    
    
    public void newGame() //don't change the name
    {
        Values.currentBoard = Values.pboard;
        getNumPlayers();
        chooseToken();
        rollForFirst();
//                                      //This while loop somehow breaks things
//        while(game_over != true)      //newGame somehow enters this loop before calling all functions above it
//        {
//            //take turns here
//        }
        while(this.current_round <=this.max_rounds) //need to set max rounds somewhere
        {
            performRound();
        }
        winner();
    }
    
    public void rollForFirst() 
    {
		//System.out.println("Test");
        this.playerOrder = new ArrayList<>();
		for (int i=1; i<=this.num_players; i++)
		{
			this.playerOrder.add(i);
		}
		Collections.shuffle(this.playerOrder);
        this.Players = new ArrayList<>();
        for(int i=0; i<this.num_players; i++)
        {
            this.Players.add(i, (new Player((int)this.playerOrder.get(i))    ));
        }                
    }
    
    public void performRound()
    {
        //functions from the term class will go here
        for (int i = 0; i < this.num_players; i++)
        {
            Turn currentTurn    =   new Turn();
            currentTurn.doPlayerTurn(Players.get(i));
        }
        this.current_round++;
    }
    
    public void auction()
    {
        //this should either be in the turn class or the space class
    }
    
    public void winner()
    {
        int maxAmount=0;// can someone have negative amount?
        int index=0;
        for(int i=0; i< this.num_players; i++)
        {
            this.Players.get(i).totalValue();
            if (this.Players.get(i).totalValue > maxAmount)
            {
                maxAmount = this.Players.get(i).totalValue;
                index = this.Players.get(i).id;
            }
        }
        JOptionPane.showMessageDialog(null, "Winner is this no lifer dude with index  being "
         + index+ " and money being " + maxAmount);
    }
    public void getNumPlayers()
    {
        boolean isValid =   false;
        while(isValid == false)
        {
            //System.out.println("Number of players: ");
            this.num_players = Integer.parseInt(JOptionPane.showInputDialog("Enter number of players: "));
            if((this.num_players < 5) && (this.num_players > 1))
            {
                isValid = true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "You put in invalid number of players. please choose between 2 and 4 players.");
            }
        }
    }
    
    public void chooseToken()
    {

        //this is where the players would choose their token

        for(int x = 0; x < this.num_players; x++)
        {
            Values.playerNames[x] = JOptionPane.showInputDialog("Enter player "+(x+1)+"'s name");
            Values.playerTokens[x] = (Integer.parseInt(JOptionPane.showInputDialog("Player " + (x+1) + ", please choose your token.\n1. Pikachu\n2. Bulbasaur\n3. Charmander\n4. Squirtle")))-1;
            GUI.jLabel1.add(Values.tokens[Values.playerTokens[x]]);
            Values.tokens[Values.playerTokens[x]].setLocation(Values.tokenXValues[0], Values.tokenYValues[0]);
        }
        this.max_rounds = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of rounds to be played"));
    }
}
