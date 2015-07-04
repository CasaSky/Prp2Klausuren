/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Talal Tabia
 */
public class Rack 
{
    private List<List<Object>> regal = new ArrayList<>(5); // innere Liste darf nulls enthalten

    public List<List<Object>> getRegal() {
        return regal;
    }
    
    public Rack(int columns, int rows)
    {
        List<Object> slot = new ArrayList<>(3);
        for (int i=0; i<rows; i++)
        {
            slot.add(null);
        }
        
        for (int i=0; i<columns; i++)
        {
            regal.add(slot);
        }
    }
    
    public boolean isFreeColumn(int column)
    {
        List<Object> slot = regal.get(column);
        
        for (Object fach : slot)
        {
            if (slot!=null)
                return false;
        }
        return true;
    }
    
    public boolean isFreeRow(int row)
    {
        for (List<Object> slot : regal)
        {
            Object  fach = slot.get(row);
            if (fach != null)
                return false;
        }
        return true;
    }
    
    public int noOfFreeSlots()
    {
        int noOfFreeSlots=0;
        int column = regal.size();
        for (int i=0; i<column; i++)
        {
            if (isFreeColumn(i))
            {
                int row = regal.get(i).size();
                for (int j=0; j<row; j++)
                {
                    if (isFreeRow(j))
                    {
                        noOfFreeSlots++;
                    }
                }
            }
        }
        return noOfFreeSlots;
    }
    
    public boolean contains(String anObject)
    {
        for (List<Object> slot : regal)
        {
            if (slot.contains(anObject))
                return true;
        }
        return false;
    }
    
    public int noOfSlotsContaining(String anObject)
    {
        int noOfSlotsContaining=0;
        for (List<Object> slot : regal)
        {
            for (Object fach : slot)
            {
                if (fach!=null && fach.equals(anObject))
                    noOfSlotsContaining++;
            }
        }
        return noOfSlotsContaining;
    }
    
    public Set<Object> setOfDiffObjects()
    {
        Set<Object> differentObjects = new HashSet<>();
        
        for (List<Object> slot : regal)
        {
            for (Object fach : slot)
            {
                differentObjects.add(fach);
            }
        }
        return differentObjects;
    }
    
    public boolean equals(Rack aRack)
    {
        int counter=0;
        for (List<Object> slot2 : aRack.getRegal())
        {
            if (!regal.get(counter).equals(slot2))
            {
                return false;
            }
            counter++;
        }
        return true;
    }
}
