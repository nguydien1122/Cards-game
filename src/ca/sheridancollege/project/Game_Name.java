/*
 * Dien Nguyen
 * Student ID: 991501600
 * SYST10199 - Web Programming
 */
package ca.sheridancollege.project;

/**
 *
 * @author Dien
 */
public class Game_Name extends Game{

    private int sumDealer=0;
    private int sumPlayer=0;
    public Game_Name(String name){
        super(name);
    }
    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean declareWinner() {
       if(sumDealer > 21) return true;
       else if(sumPlayer > sumDealer)    
        return true;
       else
        return false;
    }
    
}
