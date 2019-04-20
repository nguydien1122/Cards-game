/*
 * Dien Nguyen
 * Student ID: 991501600
 * SYST10199 - Web Programming
 */
package ca.sheridancollege.project;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class BlackJack
{

    private static Scanner s = new Scanner(System.in);
    private int[] deck;   
    private int currentPosition; // deck's current position
    private Vector hand;   // card in hand
    int playerSum = 0;
    int dealerSum = 0;

    public static void main(String[] args)
    {
        new BlackJack().run();
    }

    public void run()
    {
        // user's amount
        int money = 100;          
        // amount user bets on the game
        int bet;            
        int players;
        boolean userWins;   
        boolean isValidNumber =false;
        int player;
        Game game = new Game_Name("------------------------WELCOME to BLACKJACK-------------------------");
        ArrayList<Game> name = new ArrayList<Game>();
        name.add(game);
        System.out.println(name.get(0).getGameName());
        
        do {
        System.out.println("How many players?(1 - 5)");
        Scanner num = new Scanner(System.in);
        
        player = num.nextInt();
        if (checkNum(player))
            { 
            isValidNumber=true;
            System.out.print("Number of player: "+player);  
            }
        else {
        System.out.println("Invalid Input.\nPlayers should be from 1 to 5");
        }
        }
        while (!isValidNumber);
      
        System.out.println("\nPlease enter player names");
        ArrayList<Player> iD = new ArrayList<Player>();
        for(int i =0; i<player;i++){
        Scanner in= new Scanner(System.in);
        String playersName =in.nextLine();
        Player play =new Player_Id (playersName);
        iD.add(play);
        }
        System.out.println("Enjoy!!!");
        System.out.println("---------------------------------------------------------");
        while (true)
        {
            System.out.println("---------------------------------------------------------");
            System.out.println("You have " + money + " dollars.");
            do
            {
                System.out.println("How many dollars would you like to bet? (input 0 to exit)");
                bet = s.nextInt();
                if (bet < 0 || bet > money)
                {
                    System.out.println("Your money should be at least from 1 to " + money + '.');
                }
            } while (bet < 0 || bet > money);
            if (bet == 0)
            {
                System.out.println("Thank you. It was nice having you!!");
                break;
            }
            userWins = playBlackjack();
            if (userWins)
            {
                money = money + bet;
            } else
            {
                money = money - bet;
            }
            System.out.println();
            if (money == 0)
            {
                System.out.println("---------------------------------------------------------");
                System.out.println("Sorry! You LOST!!! \nYou do not have any money left.");
                break;
            }
        }
    }// main() ends

    public static boolean checkNum(int s)
        {
            if(s <= 5 && s>0)
        {
        return true;
        }
        return false;
        }

    private boolean playBlackjack()
    {
        Vector dealerHand;  
        Vector userHand; 

        //an unshuffled deck of cards.
        deck = new int[52];
        //cards have been created 
        int countCard = 0; 
        for (int suit = 0; suit <= 3; suit++)
        {
            for (int value = 1; value <= 13; value++)
            {
                deck[countCard] = value;
                countCard++;
            }
        }
        currentPosition = 0;
        dealerHand = new Vector();
        userHand = new Vector();
        
        shuffle();

        dealerHand.addElement(dealCard());
        dealerHand.addElement(dealCard());
        userHand.addElement(dealCard());
        userHand.addElement(dealCard());
        
        //Check if a player/dearler has 2 cards which totals to 21 points  
        if (value(dealerHand) == 21)
        {
            System.out.println("The Dealer has " + showCard(getCard(dealerHand, 0)) + " and " + showCard(getCard(dealerHand, 1)) + ".");
            System.out.println("You have " + showCard(getCard(userHand, 0)) + " and " + showCard(getCard(userHand, 1)) + ".");
            System.out.println("---------------------------------------------------------");
            System.out.println("The Dealer has Blackjack -> Dealer wins.");
            dealerSum++;
            return false;
        }

        if (value(userHand) == 21)
        {
            System.out.println("The Dealer has " + showCard(getCard(dealerHand, 0)) + " and " + showCard(getCard(dealerHand, 1)) + ".");
            System.out.println("You have " + showCard(getCard(userHand, 0)) + " and " + showCard(getCard(userHand, 1)) + ".");
            System.out.println("---------------------------------------------------------");
            System.out.println("Horey! You have Blackjack, You win.");
            playerSum++;
            return true;
        }

        //If neither players and dealer have BlackJack 
        while (true)
        {
            //Check if players want to hit or stand
            System.out.println("---------------------------------------------------------");
            System.out.println("Here are your cards:");
            for (int i = 0; i < userHand.size(); i++)
            {
                System.out.println(showCard(getCard(userHand, i)));
            }
            System.out.println("Your total:" + value(userHand));
            System.out.println("---------------------------------------------------------");
            System.out.println("Dealer is showing card");
            System.out.println("Do you want to Hit or Stand?(h/s)");
            
            //user's response
            char userAction;  
            do
            {
                userAction = Character.toUpperCase(s.next().charAt(0));
                if (userAction != 'H' && userAction != 'S')
                {
                    System.out.print("Please input H or S:  ");
                }
            } while (userAction != 'H' && userAction != 'S');

            if (userAction == 'S')
            {
                //finish player's turn
                break;
            } else
            { 
                int newCard = dealCard();
                userHand.addElement(newCard);
                System.out.println("---------------------------------------------------------");
                System.out.println("Your card: " + showCard(newCard));
                System.out.println("Your total now: " + value(userHand));
                
                if (value(userHand) > 21)
                {
                    System.out.println("---------------------------------------------------------");
                    System.out.println("You busted by going over 21-> You lose!!!");
                    //System.out.println("The card was "+showCard(getCard(dealerHand, 1)));
                    System.out.println("Dealer's point: " + value(dealerHand));
                    dealerSum++;
                    return false;
                }
            }
        }//while loop ends

        //Player got 21 points, Dealer need to get cards till the dealer's total is > 15. 
        System.out.println("---------------------------------------------------------");
        System.out.println("Dealer's cards are:");
        System.out.println(showCard(getCard(dealerHand, 0)));
        System.out.println(showCard(getCard(dealerHand, 1)));
        while (value(dealerHand) <= 15)
        {
            int newCard = dealCard();
            System.out.println("---------------------------------------------------------");
            System.out.println("Dealer hits and gets: " + showCard(newCard));
            dealerHand.addElement(newCard);
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Dealer's total: " + value(dealerHand));
        
        
        //Declare winner
        if (value(dealerHand) > 21)
        {
            System.out.println("Dealer busted by going over 21.\nHorey!! You win.");
            playerSum++;
            return true;
        } else
        {
            if (value(dealerHand) == value(userHand))
            {
                System.out.println("---------------------------------------------------------");
                System.out.println("Dealer wins on a tie. -> You lose.");
                dealerSum++;
                return false;
            } else
            {
                if (value(dealerHand) > value(userHand))
                {
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Dealer wins, " + value(dealerHand) + " points to " + value(userHand));
                    dealerSum++;
                    return false;
                } else
                {
                    System.out.println("---------------------------------------------------------");
                    System.out.println("You win, " + value(userHand) + " points to " + value(dealerHand));
                    playerSum++;
                    return true;
                }
            }
        } 
    }//playBlackjack() ends 

    public int dealCard()
    {
        //return card
        if (currentPosition == 52)
        {
            shuffle();
        }
        currentPosition++;
        return deck[currentPosition - 1];
    }

    //shuffe cards in random orders
    public void shuffle()
    {
        for (int i = 51; i > 0; i--)
        {
            int rand = (int) (Math.random() * (i + 1));
            int temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        currentPosition = 0;
    }

    public int getCard(Vector hand, int position)
    {
        if (position >= 0 && position < hand.size())
        {
            return ((Integer)hand.elementAt(position)).intValue();
        } else
        {
            return 0;
        }
    }

    //return the value of cards
    public int value(Vector hand)
    {
        int val;    
        boolean ace;  
        int cards;// number of cards in the hand.

        val = 0;
        ace = false;
        cards = hand.size();

        for (int i = 0; i < cards; i++)
        {
            int card;   
            int cardVal;  
            card = getCard(hand, i);
            //normal value from 1 to 13
            cardVal = getCardVal(card);  
            if (cardVal > 10)
            {
                //suits
                cardVal = 10;  
            }
            if (cardVal == 1)
            {
                ace = true;  
            }
            val = val + cardVal;
        }

        if (ace == true && val + 10 <= 21)
        val = val + 10;
        
        return val;
    }
    
    public int getCardVal(int card)
    {
        int result = card;
        switch (card)
        {
            case 11:
            case 12:
            case 13:
                result =  10;
        }
        return result;
    }
    public String showCard(int card)
    {
        switch (card)
        {
            case 1:
                return "Ace";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return "Invalid";
        }
    }
}  
