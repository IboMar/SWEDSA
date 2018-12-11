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
	 * @param policedateArray List of CrimeStopAndSearch
	 */
	protected ArrayList<CrimeStopAndSearch> quickSort(ArrayList<CrimeStopAndSearch> list, Comparator<CrimeStopAndSearch> comp)
	{
	    if (list.size() <= 1) 
	        return list; // Already sorted  

	    ArrayList<CrimeStopAndSearch> sorted = new ArrayList<CrimeStopAndSearch>();
	    ArrayList<CrimeStopAndSearch> lesser = new ArrayList<CrimeStopAndSearch>();
	    ArrayList<CrimeStopAndSearch> greater = new ArrayList<CrimeStopAndSearch>();
	    CrimeStopAndSearch pivot = list.get(list.size()-1); // Use last Vehicle as pivot
	    for (int i = 0; i < list.size()-1; i++)
	    {
	        //int order = list.get(i).compareTo(pivot);
	        //if (list.get(i).Date.compareTo(pivot.Date) <0)
	    	if (comp.compare(list.get(i), pivot) < 0)
	            lesser.add(list.get(i));    
	        else
	            greater.add(list.get(i));   
	    }
	    lesser = quickSort(lesser, comp);
	    greater = quickSort(greater, comp);
	    lesser.add(pivot);
	    lesser.addAll(greater);
	    sorted = lesser;

	    return sorted;
	}
	
	/**
	 * This method will be used to print out the list from F(i) reverse
	 * chronological order
	 * 
	 * @param policedateArray List of CrimeStopAndSearch
	 */
	public void chronologicalOrder(List<CrimeStopAndSearch> policedateArray) {

		Comparator<CrimeStopAndSearch> cmp = Comparator.comparing(CrimeStopAndSearch::getDate);
		Collections.sort(policedateArray, cmp.reversed());
		for (CrimeStopAndSearch currentCrime : policedateArray) {
			System.out.println(currentCrime.toCSVString());
		}
	}
}