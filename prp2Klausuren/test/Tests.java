/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import WS0001.DayPlan;
import WS0001.WeekPlan;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author talal_000
 */
public class Tests {
    
    public Tests() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
        DayPlan dayplan1 = new DayPlan();
        DayPlan dayplan2 = new DayPlan();
        DayPlan dayplan3 = new DayPlan();
        WeekPlan weekplan1 = new WeekPlan();        
        WeekPlan weekplan2 = new WeekPlan();
        WeekPlan weekplan3 = new WeekPlan();



        
        public void examples()
        {
            System.err.println(dayplan1.toString());
        dayplan3.atPut(0, "PRP1");
        dayplan3.atPut(1, "PR2");
        dayplan3.atPut(2, "BW2");
        dayplan3.atPut(3, "GKA");      
        dayplan2.atPut(0, "PRP2");
        dayplan2.atPut(1, "PR2");
        dayplan2.atPut(2, "BW2");
        dayplan2.atPut(3, "GKA");     
        dayplan1.atPut(0, "PRP2");
        dayplan1.atPut(1, "PR2");
        dayplan1.atPut(2, "BW2");
        dayplan1.atPut(3, "GKA");  
        }
        
        public void examples2()
        {
            examples();
            weekplan1.aPut(0, dayplan1);
            weekplan1.aPut(1, dayplan2);
            weekplan1.aPut(2, dayplan3);
            weekplan2.aPut(0, dayplan1);
            weekplan2.aPut(1, dayplan2);
            weekplan2.aPut(2, dayplan3);
            weekplan3.aPut(0, dayplan3);
            weekplan3.aPut(1, dayplan2);
            weekplan3.aPut(2, dayplan3);
        }
        
    @Test
    public void testDayPlan() {
        
        examples();
        
        assertTrue(dayplan1.contains("PRP2"));
        assertTrue(dayplan1.contains("GKA"));
        assertFalse(dayplan1.contains("PRP1"));
        assertTrue(dayplan1.equals(dayplan2));
        assertFalse(dayplan1.equals(dayplan3));
        dayplan2 = new DayPlan();
        assertFalse(dayplan1.equals(dayplan2));
    }
    
    @Test
    public void testWeekPlan()
    {
        examples2();
        assertTrue(weekplan1.contains("PRP2"));
        assertFalse(weekplan1.contains("prp1"));
        assertTrue(weekplan1.equals(weekplan2));
        assertFalse(weekplan1.equals(weekplan3));
        
        System.out.println(weekplan1.toString());
        System.out.println("By "+weekplan1.author());

    
    }
}
