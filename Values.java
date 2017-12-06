/*
 * This is the Values class. This class holds all of the values which are constantly
 * called throughout the entirety of the project. This made accessing these values easier
 * as well as manipulating the values. Also better to read.
 */
package project_3;

import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author Rohan Khante, Matthew Wentz, Jonathan Sorem, Robert James Davis
 */

public class Values
{
    public static int i = 0;
    public static JLabel[] tokens = {GUI.jLabel2, GUI.jLabel3, GUI.jLabel4, GUI.jLabel5};
    public static String[] houses = {"/project_3/1house.png", "/project_3/2house.png", "/project_3/3house.png", "/project_3/4house.png", "/project_3/hotel.png"};
    public static int[] tokenXValues = {685, 595, 535, 475, 410, 350, 290, 225, 165, 105, 25, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 105, 165, 230, 290, 350, 410, 475, 535, 595, 675, 685, 685, 685, 685, 685, 685, 685, 685, 685};
    public static int[] tokenYValues = {685, 685, 685, 685, 685, 685, 685, 685, 685, 685, 715, 605, 545, 485, 425, 360, 300, 240, 175, 115, 45, 30, 30, 30, 30, 30, 30, 30, 30, 30, 35, 115, 175, 235, 300, 360, 420, 485, 545, 605};
    
    public static int jailX = 36;
    public static int jailY = 665;
    
    public static List<Player> Players;
    
    public static int[] houseXValues = {0, 620, 0, 497, 0, 0, 314, 0, 190, 129, 0, 87, 0, 87, 87, 0, 87, 0, 87, 87, 0, 128, 0, 252, 312, 0, 436, 497, 0, 620, 0, 661, 661, 0, 661, 0, 0, 661, 0, 661};
    public static int[] houseYValues = {0, 662, 0, 662, 0, 0, 662, 0, 662, 662, 0, 619, 0, 496, 436, 0, 312, 0, 190, 128, 0, 87, 0, 87, 87, 0, 87, 87, 0, 87, 0, 127, 190, 0, 312, 0, 0, 496, 0, 619};  
    
    public static int[] propertyValues    =   {0, 60, 0, 60, 0, 200, 100, 0, 100, 120, 0, 140, 150, 140, 160, 200, 180, 0, 180, 200,
                0, 220, 0, 220, 240, 200, 260, 260, 150, 280, 0, 300, 300, 0, 320, 200, 0, 350, 0, 400};
    
    public static String[] board   = new String[]{"Go", "Meditarranean Ave","Community Chest", "Baltic Ave", "Income Tax", "Reading Railroad", "Oriental Ave", "Chance", "Vermont Ave", "Connecticut Ave", "Just Visiting/Jail",
        "St. Charles Place", "Electric Company", "States Ave", "Virginia Ave", "Pennsylvania Railroad", "St. James Ave", "Community Chest", "Tennessee Ave", "New York Ave", "Free Parking",
        "Kentucky Ave", "Chance", "Indiana Ave", "Illinois Ave", "B&O Railroad", "Atlantic Ave", "Ventor Ave", "Water Works", "Marvin Gardens", "Go To Jail",
        "Pacific Ave", "North Caroline Ave", "Community Chest", "Pennsylvania Ave", "Short Line Railroad", "Chance", "Park Place", "Luxury Tax", "Boardwalk"};
    
    public static String[] pboard   = new String[]{"Go", "Geodude","Trainer Battle", "Onix", "Your Rival Attacks!", "Pokeball", "Staryu", "Professor Oak", "Starmie", "Horsea", "Just Visiting/Jail",
        "Voltorb", "Zapdos", "Electabuzz", "Raichu", "Great Ball", "Victreebel", "Trainer Battle", "Tangela", "Vileplume", "Free Parking",
        "Kadabra", "Professor Oak", "Mr. Mime", "Venomoth", "Ultra Ball", "Koffing", "Muk", "Articuno", "Weezing", "Go To Jail",
        "Growlithe", "Ponyta", "Trainer Battle", "Rapidash", "Master Ball", "Professor Oak", "Nidoqueen", "Team Rocket Attacks!", "Nidoking"};
    
    public static String[]currentBoard;
    
    public static String[] color   = new String[]{"Go", "Brown", "Community Chest", "Brown", "Income Tax", "Train",
            "Light Blue", "Chance", "Light Blue", "Light Blue", "Jail", "Pink", "Electric Company", "Pink", "Pink", "Train",
            "Orange", "Community Chest", "Orange", "Orange", "Free Parking", "Red", "Chance", "Red", "Red", "Train", "Yellow",
            "Yellow", "Water Works", "Yellow", "Go to Jail", "Green", "Green", "Community Chest", "Green", "Train", "Chance",
            "Dark Blue", "Luxury Tax", "Dark Blue"};
    
    public static int[][] rent = {
            {0, 0, 0, 0, 0},
            {2,10,30,90,160,250},
            {0, 0, 0, 0, 0},
            {4,20,60,180,320,450},
            {0, 0, 0, 0, 0},
            {25, 50, 100, 200, 0},
            {6,30,90,270,400,550},
            {0, 0, 0, 0, 0},
            {6,30,90,270,400,550},
            {8,40,100,300,450,600},
            {0, 0, 0, 0, 0},
            {10,50,150,450,625,750},
            {0, 0, 0, 0, 0},
            {10,50,150,450,625,750},
            {12,60,180,500,700,900},
            {25, 50, 100, 200, 0},
            {14,70,200,550,750,950},
            {0, 0, 0, 0, 0},
            {14,70,200,550,750,950},
            {16,80,220,600,800,1000},
            {0, 0, 0, 0, 0},
            {18,90,250,700,875,1050},
            {0, 0, 0, 0, 0},
            {18,90,250,700,875,1050},
            {20,100,300,750,925,1100},
            {25, 50, 100, 150, 0},
            {22,110,330,800,975,1150},
            {22,110,330,800,975,1150},
            {0, 0, 0, 0, 0},
            {24,120,360,850,1025,1200},
            {0, 0, 0, 0, 0},
            {26,130,390,900,1100,1275},
            {26,130,390,900,1100,1275},
            {0, 0, 0, 0, 0},
            {28,150,450,1000,1200,1400},
            {25, 50, 100, 200, 0},
            {0, 0, 0, 0, 0},
            {35,175,500,1100,1300,1500},
            {0, 0, 0, 0, 0},
            {50,200,600,1400,1700,2000},
    };
    
    public static int[] playerTokens = new int[4];
    public static String[] playerNames = new String[4];
    //public static Player[] playerArray = new Player[4];
    
    public static int[] spaceOwner = new int[40]; //Set value 1-4 to indicate which player owns the space
    public static boolean[] isMortgaged = {false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, false, 
        false, false, false};
}
