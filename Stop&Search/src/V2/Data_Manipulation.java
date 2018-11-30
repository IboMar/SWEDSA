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
 * This class will contain all the methods to manipulate our array
 */
public class Data_Manipulation {
	
	/** This method will be used to print out the list from F(i) reverse chronological order
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
	
	

