/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS0001;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author talal_000
 */
public class DayPlan {
    
    private List<String> tagesplan = new ArrayList<>(4);

    public List<String> getTagesplan() {
        return tagesplan;
    }
    
    public String author()
    {
        return "Talal Tabia 2178365";
    }
    
    public DayPlan()
    {
        for (int i = 0; i < 4; i++)
            tagesplan.add(i, null);
    }
    
    public DayPlan(String[] anArray)
    {
        
        if (anArray == null)
        {
            System.out.println("Das Array darf nicht null sein");
        }
        
        else
        {
            int size = anArray.length;
            for (int i = 0; i < size; i++)
            {
                tagesplan = new ArrayList<>();
                tagesplan.add(anArray[i]);
            }
        }
    }
    
    public void atPut(int aQuarterIndex, String aLectureString)
    {
        if (aQuarterIndex >= 0 && aQuarterIndex < 4)
            tagesplan.add(aQuarterIndex, aLectureString);
        else
            System.out.println("Das aQuarterIndex soll zwischen 0 und 3 liegen!");
    }
    
    public boolean contains(String aLectureString)
    {
        return (tagesplan.contains(aLectureString));
    }
    
    public int noOfLectures()
    {
        return tagesplan.size();
    }
    
    public boolean equals(DayPlan aDayPlan)
    {
        if (noOfLectures() == aDayPlan.noOfLectures())
        {
            int i=0;
            for (String vorlesung : tagesplan)
            {
                String vl = aDayPlan.getTagesplan().get(i);
                if (vorlesung == null && vorlesung == vl) // der kritische Fall, falls null existiert
                {i++;}
                
                else if (!vorlesung.equals(vl))
                    return false;
                else
                i++;
            }
            return true;
        }
        else return false;
    }
    
    @Override
    public String toString()
    {
        return "DayPlan ("+ tagesplan.toString()+ ")";
    }
}
