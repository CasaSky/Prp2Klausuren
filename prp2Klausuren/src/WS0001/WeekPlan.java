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
public class WeekPlan {
    
    private List<DayPlan> wochenPlan;

    public List<DayPlan> getWochenPlan() {
        return wochenPlan;
    }
    
    public String author()
    {
        return "Talal Tabia 2178365";
    }
    
    public WeekPlan()
    {
        wochenPlan = new ArrayList<>(5);
    }
    
    public void aPut(int aDayIndex, DayPlan aDayPlan)
    {
        if (aDayIndex >= 0 && aDayIndex < 5)
            wochenPlan.add(aDayIndex, aDayPlan); // ersetzt das alte DayPlan in dieser Position
    }
    
    public boolean contains(String aLectureString)
    {        
        if (aLectureString == null)
            return false;
        
        for (DayPlan dayplan : wochenPlan)
        {
            if (dayplan.contains(aLectureString))
                return true;
        }
        
        return false;
    }
    
    public List days(String aLectureString)
    {
        List days = new ArrayList();

        if (aLectureString == null)
            System.out.println("Das aLectureString darf nicht null sein!");
        
        else
        {        
            if (contains(aLectureString))
            {
                int index = -1;
                for (DayPlan dayplan : wochenPlan)
                {
                    index++;
                
                    if (dayplan.contains(aLectureString))
                    {
                        days.add(index);
                    }
                }
            }
        }
        return days;
    }
    
    public int noOfQuarters()
    {
        int noOfQuarters = 0;
        
        for (DayPlan dayplan : wochenPlan)
        {
            for (String vorlesung : dayplan.getTagesplan())
            {
                if (!vorlesung.isEmpty())
                    noOfQuarters++;
            }
        }
        return noOfQuarters;
    }
    
    public int noOfLectures()
    {
        int noOfLectures = 0;
        
        if (!wochenPlan.isEmpty())
        {
            List<String> vorlesungen = new ArrayList<>(); // unterschiedlichen Vorlesungen
          
            for (DayPlan dayplan : wochenPlan)
            {
                for (String vl : dayplan.getTagesplan())
                {
                    if (!vorlesungen.contains(vl))
                    {
                        vorlesungen.add(vl);
                    }
                }
            }
            noOfLectures = vorlesungen.size();
        }

        return noOfLectures;
    }
    
    public boolean equals(WeekPlan aWeekPlan)
    {
        List<DayPlan> wochenPlan2 = aWeekPlan.getWochenPlan();
        boolean equals=true;
        
        for (int i = 0; i< wochenPlan.size(); i++)
        {
            if (!wochenPlan.get(i).equals(wochenPlan2.get(i)))
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
        String string = "(";
        for (DayPlan dayplan : wochenPlan)
        {
            string += dayplan.toString();
        }
        string += ")";
        
        return string;
    }
    
}
