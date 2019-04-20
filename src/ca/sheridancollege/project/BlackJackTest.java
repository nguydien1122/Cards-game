/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author radhi
 */
public class BlackJackTest {
    
    public BlackJackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkNum method, of class BlackJack.
     */
    @Test
    public void testCheckNumGood() {
        System.out.println("Good Test of checkNum");
        int s = 3;
        boolean expResult = true;
        boolean result = BlackJack.checkNum(s);
        assertEquals(expResult, result);
    }
     @Test
    public void testCheckNumBoundary() {
        System.out.println("Boundary Test of checkNum");
        int s = 5;
        boolean expResult = true;
        boolean result = BlackJack.checkNum(s);
        assertEquals(expResult, result);
    }
     @Test
    public void testCheckNumBad() {
        System.out.println("Bad Test of checkNum");
        int s = 7;
        boolean expResult = false;
        boolean result = BlackJack.checkNum(s);
        assertEquals(expResult, result);
    }

  
    
    /**
     * Test of getCard method, of class BlackJack.
     */
    @Test
    public void testGetCardbad() {
        System.out.println("Bad test of getCard");
        Vector hand = null;
        int position = -1;
        BlackJack instance = new BlackJack();
        int expResult = 0;
        int result = instance.getCard(hand, position);
        assertEquals(expResult, result);
    }
   
    /**
     * Test of getCardVal method, of class BlackJack.
     */
    @Test
    public void testGetCardValGood() {
        System.out.println("Good test of getCardVal");
        int card = 12;
        BlackJack instance = new BlackJack();
        int expResult = 10;
        int result = instance.getCardVal(card);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetCardValBoundary() {
        System.out.println("Boundary test of getCardVal");
        int card = 13;
        BlackJack instance = new BlackJack();
        int expResult = 10;
        int result = instance.getCardVal(card);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetCardValBad() {
        System.out.println("Bad test of getCardVal");
        int card = 9;
        BlackJack instance = new BlackJack();
        int expResult = 9;
        int result = instance.getCardVal(card);
        assertEquals(expResult, result);
    }

    /**
     * Test of showCard method, of class BlackJack.
     */
    @Test
    public void testShowCardGood() {
        System.out.println("Good test of showCard");
        int card = 10;
        BlackJack instance = new BlackJack();
        String expResult = "10";
        String result = instance.showCard(card);
        assertEquals(expResult, result);
    }
     @Test
    public void testShowCardBoundary() {
        System.out.println("Boundary test of showCard");
        int card = 13;
        BlackJack instance = new BlackJack();
        String expResult = "King";
        String result = instance.showCard(card);
        assertEquals(expResult, result);
    }
    @Test
    public void testShowCardBad() {
        System.out.println("Bad test of showCard");
        int card = 15;
        BlackJack instance = new BlackJack();
        String expResult = "Invalid";
        String result = instance.showCard(card);
        assertEquals(expResult, result);
    }
    
}
