/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author dancye, 2018
 * Team members: Nitee Sharma(991511406), Vinit Patel(991510686), Dien Nguyen(991501600)
 * 
 */
public abstract class Card 
{
    //default modifier for child classes
    
    /**
     * Students should implement this method for their specific children classes 
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
	public enum Suit{
        HEARTS ,
        SPADES ,
        DIAMONDS,
        CLUBS ;}

	public enum Value{
        ACE, DEUCE, THREE, FOUR, FIVE,
        SIX, SEVEN, EIGHT, NINE, TEN,
        JACK, QUEEN, KING;}
        
    
    @Override
    public abstract String toString();
    
}
