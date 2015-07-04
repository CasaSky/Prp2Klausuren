/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS0102;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author talal_000
 */
public class TablePlan {
    
    private static final int stundenAmTag = 6;
    private static final int anzahlAnTischen = 5;
    private static final int plaetzenProTisch = 4;
    
    private List<Integer> tablePlan = new ArrayList<>(stundenAmTag); // Integer -> Anzahl an je 6 Personen

    public List<Integer> getTablePlan() {
        return tablePlan;
    }
    
    public TablePlan()
    {
        for (int i=0; i< stundenAmTag; i++)
            tablePlan.add(0);
    }
    
    public boolean isFree(int firstHour, int lastHour)
    {
        boolean free=true;
        if (firstHour>=stundenAmTag && lastHour>=stundenAmTag)
            return false;
        
        for (int i=firstHour; i<lastHour; i++)
        {
            if (tablePlan.get(i) != 0)
            {
                free = false;
                break;
            }
        }
        return free;
    }
    
    public boolean seatPersons(int noOfPersons, int firstHour, int lastHour)
    {
        boolean reservierungErfuellbar = false;
        if (isFree(firstHour, lastHour))
        {
            reservierungErfuellbar = true;
            for (int i=firstHour; i<lastHour; i++)
                tablePlan.add(i, noOfPersons);
        }
        
        return reservierungErfuellbar;
    }
    
    public int noOfGuests(int hour)
    {
        int noOfGuests = 0;
        noOfGuests = tablePlan.get(hour); 
        return noOfGuests;
    }
    
    public boolean equals(TablePlan aTablePlan)
    {
        boolean equals = true;
        
        for (int i=0; i<stundenAmTag; i++)
        {
            
            if (noOfGuests(i) != aTablePlan.noOfGuests(i))
            {
                equals = false;
                break;
            }
        }
        return equals;
    }
    
    @Override
    public String toString()
    {
        String string = "TablePlan(";
        for (Integer personen : tablePlan)
            string += personen;
        string += ")";
        return string;
    }
}
