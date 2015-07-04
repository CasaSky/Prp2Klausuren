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
public class RestPlan {
    
    private static final int anzahlAnTischen = 5;
    private static final int plaetzenProTisch = 4;

    private List<TablePlan> restplan = new ArrayList<>(anzahlAnTischen);
    
    public RestPlan()
    {
        for (int i=0; i<anzahlAnTischen; i++)
        {
            restplan.add(new TablePlan());
        }
    }
    
    public boolean isFree(int noOfPersons, int firstHour, int lastHour)
    {
        int counter = 0;
        while (noOfPersons>0 || counter<restplan.size())
        {
                if (restplan.get(counter).isFree(firstHour, lastHour))
                {
                    noOfPersons -= plaetzenProTisch;
                }
                counter++;    
        }
        return noOfPersons<=0;
    }
}
