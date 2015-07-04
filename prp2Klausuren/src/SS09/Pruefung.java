/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SS09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import sun.applet.Main;

/**
 *
 * @author Talal tabia
 */
public class Pruefung 
{
    public static int compareCharLists(List<Character> list1, List<Character> list2)
    {
        if (list1 == null || list2 == null)
            throw new IllegalArgumentException();
        for (Character char1 : list1)
        {
            for (Character char2 : list2)
            {
                int diff = char1 - char2;
                
                if (diff!=0)
                    return diff;
            }
        }
        
        return list1.size() - list2.size();
    }
    
    public static List<List<Integer>> intMaptToPairList(Map<Integer, Integer> map)
    {
        if (map == null)
            throw new IllegalArgumentException();
        List<List<Integer>> liste = new ArrayList<>();
        
        for(Entry<Integer, Integer> entry : map.entrySet()) 
        {
            List<Integer> innereListe = new ArrayList<>();
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            innereListe.add(key);
            innereListe.add(value);
            liste.add(innereListe);
        }
        return liste;
    }
    
    public static Map<String, Integer> listToMultiSet(List<String> list)
    {
        if (list == null)
            throw new IllegalArgumentException();
        Map<String, Integer> map = new HashMap<>();
        for (String string : list)
            map.put(string, map.containsKey(string)? map.get(string)+1 : 1);
        return map;
    }
    
    //Hilfsmethode um zu zählen, wei oft ein String in einer liste vorhanden ist
    public static int calculate(String string, List<String> list)
    {
        int counter=0;
        if (string == null)
            System.err.println("Null in string, nicht erlaubt!");
        for (String str : list)
        {
            if (str.equals(string))
                counter++;
        }
        return counter;
    }
    
    public static void main(String[] args)
    {
        //1
        System.out.println("Aufgabe1:");
        List<Character> l1 = Arrays.asList('a','b','c');
        List<Character> l2 = Arrays.asList('a','b','d');
        System.out.println("compareCharListe:("+l1+","+l2+")ergibt:");
        System.out.println(compareCharLists(l1, l2));
        //3
        System.out.println("\nAufgabe3:");
        Map<Integer, Integer> m1 = new HashMap<>();
        m1.put(1, 1);
        m1.put(2, 2);
        System.out.println("intMapToPairList("+m1+")ergibt:");
        System.out.println(intMaptToPairList(m1));
        //4
        System.out.println("\nAufgabe4:");
        List<String> l4 = Arrays.asList("a", "a", "b");
        System.out.println("listToMultiSet("+l4+")ergibt:");
        System.out.println(listToMultiSet(l4));

    }
}
