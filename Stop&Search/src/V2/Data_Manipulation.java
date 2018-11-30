package V2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class will contain all the methods to manipulate our data
 */
public class Data_Manipulation {
	
	/**
	 * This method will be used to print out the list from F(i) reverse
	 * chronological order
	 * 
	 * @param policedateArray List of CrimeStopAndsearch
	 */
	protected ArrayList<CrimeStopAndsearch> quickSort(ArrayList<CrimeStopAndsearch> list)
	{
	    if (list.size() <= 1) 
	        return list; // Already sorted  

	    ArrayList<CrimeStopAndsearch> sorted = new ArrayList<CrimeStopAndsearch>();
	    ArrayList<CrimeStopAndsearch> lesser = new ArrayList<CrimeStopAndsearch>();
	    ArrayList<CrimeStopAndsearch> greater = new ArrayList<CrimeStopAndsearch>();
	    CrimeStopAndsearch pivot = list.get(list.size()-1); // Use last Vehicle as pivot
	    for (int i = 0; i < list.size()-1; i++)
	    {
	        //int order = list.get(i).compareTo(pivot);
	        if (list.get(i).Date.compareTo(pivot.Date) <0)
	            lesser.add(list.get(i));    
	        else
	            greater.add(list.get(i));   
	    }
	    lesser = quickSort(lesser);
	    greater = quickSort(greater);
	    lesser.add(pivot);
	    lesser.addAll(greater);
	    sorted = lesser;

	    return sorted;
	}
	
	/**
	 * This method will be used to print out the list from F(i) reverse
	 * chronological order
	 * 
	 * @param policedateArray List of CrimeStopAndsearch
	 */
	public void chronoLogicalOrder(List<CrimeStopAndsearch> policedateArray) {

		Comparator<CrimeStopAndsearch> cmp = Comparator.comparing(CrimeStopAndsearch::getDate);
		Collections.sort(policedateArray, cmp.reversed());
		for (CrimeStopAndsearch currentCrime : policedateArray) {
			System.out.println(currentCrime.toCSVString());
		}
	}
}