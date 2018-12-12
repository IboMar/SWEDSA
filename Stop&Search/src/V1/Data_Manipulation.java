package V1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class will contain all the methods to manipulate our array
 */
public class Data_Manipulation {

	/**
	 * This Method will get all the unique objects of search within the merged files
	 * 
	 * @param temp List<CrimeStopAndSearch> of all files
	 * @return tempList List of all unique Strings for objectOfSearch
	 */
	public List<String> uniqueObjectOfSearch(ArrayList<CrimeStopAndSearch> temp) {

		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndSearch currentCrime : temp) {
			if (currentCrime.Object_Of_Search.equalsIgnoreCase("")
					|| currentCrime.Object_Of_Search.equalsIgnoreCase(null)) {
			} else {
				if (!tempList.contains(currentCrime.Object_Of_Search)) {
					tempList.add(currentCrime.Object_Of_Search);
				}
			}
		}
		//System.out.println("Unique Object_of_search count: " + tempList.size());
		int i = 0;
		for (String uniqueSeach : tempList) {
			System.out.println(i + " " +uniqueSeach);
			i++;
		}
		return tempList;
	}

	/**
	 * This Method will get all the unique dates within the merged files
	 * 
	 * @param temp List<CrimeStopAndSearch> of all files
	 * @return tempList List of all unique Strings for dates
	 */
	public List<String> uniqueDate(List<CrimeStopAndSearch> temp) {

		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndSearch currentCrime : temp) {
			if (currentCrime.Date.equalsIgnoreCase("") || currentCrime.Date.equalsIgnoreCase(null)) {
			} else {
				String substringDate = currentCrime.Date;
				substringDate = substringDate.substring(0, 7);
				if (!tempList.contains(substringDate)) {
					tempList.add(substringDate);
				}
			}

		}
		int i = 1;
		for (String date : tempList) {
			System.out.println(i++ + ". " + date);
		}

		return tempList;
	}

	/**
	 * This Method will get all the unique genders within the merged files
	 * 
	 * @param temp List<CrimeStopAndSearch> of all files
	 * @return tempList List of all unique Strings for gender
	 */
	public List<String> uniqueGender(List<CrimeStopAndSearch> temp) {
		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndSearch currentCrime : temp) {
			if (currentCrime.Gender.equalsIgnoreCase("") || currentCrime.Gender == null) {
			} else {
				if (!tempList.contains(currentCrime.Gender)) {
					tempList.add(currentCrime.Gender);
				}
			}

		}
		int i = 1;
		for (String gender : tempList) {
			System.out.println(i++ + ". " + gender);
		}

		return tempList;
	}

	/**
	 * This Method will get all the unique Ethnics within the merged files
	 * 
	 * @param temp List<CrimeStopAndSearch> of all files
	 * @return tempList List of all unique Strings for Ethnic
	 */
	public List<String> uniqueEthnic(List<CrimeStopAndSearch> temp) {

		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndSearch currentCrime : temp) {
			if (currentCrime.Self_Defined_Ethnicity != null
					&& !currentCrime.Self_Defined_Ethnicity.equalsIgnoreCase("")) {
				if (!tempList.contains(currentCrime.Self_Defined_Ethnicity)) {
					tempList.add(currentCrime.Self_Defined_Ethnicity);
				}
			}
		}
		int i = 0;
		for (String ethnic : tempList) {
			System.out.println(i++ + ". " + ethnic);
		}

		return tempList;
	}

	/**
	 * This Method will get all the unique Police within the merged files
	 * 
	 * @param temp List<CrimeStopAndSearch> of all files
	 * @return tempList List of all unique Strings for Police
	 */
	public List<String> uniquePolice(List<CrimeStopAndSearch> temp) {

		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndSearch currentCrime : temp) {
			if (currentCrime.Policing_Operation.equalsIgnoreCase("")
					|| currentCrime.Policing_Operation.equalsIgnoreCase(null)) {
			} else {
				if (!tempList.contains(currentCrime.Policing_Operation))
					tempList.add(currentCrime.Policing_Operation);
			}

		}
		int i = 1;
		for (String police : tempList) {
			System.out.println(i++ + ". " + police);
		}

		return tempList;
	}

	/**
	 * This Method will get all the unique Legislations within the merged files
	 * 
	 * @param temp List<CrimeStopAndSearch> of all files
	 * @return tempList List of all unique Strings for Legislations
	 */
	public List<String> uniqueLeg(List<CrimeStopAndSearch> temp) {

		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndSearch currentCrime : temp) {
			if (currentCrime.Legislation.equalsIgnoreCase("") || currentCrime.Legislation.equalsIgnoreCase(null)) {
			} else {
				if (!tempList.contains(currentCrime.Legislation))
					tempList.add(currentCrime.Legislation);
			}

		}
		int i = 1;
		for (String leg : tempList) {
			System.out.println(i++ + ". " + leg);
		}

		return tempList;
	}

	
	/** This Method will be used to print out one object of search that the user has selected
	 * @param temp List<CrimeStopAndSearch>
	 * @param objectOfSearchTemp String user choice objectOfSearch
	 */
	public void outPutOneObjectOfSearch(ArrayList<CrimeStopAndSearch> temp, String objectOfSearchTemp) {

		for (CrimeStopAndSearch currentCrime : temp) {
			if (currentCrime.Object_Of_Search.contains(objectOfSearchTemp)) {
				 System.out.println(currentCrime.toCSVString());
			}
		}
	}
	/**
	 * Move elements of arr[0..i-1], that are 
     * greater than key, to one position ahead 
     * of their current position
	 * @param myList
	 * @param comp
	 */
	public void insertSort(List<CrimeStopAndSearch> myList, Comparator<CrimeStopAndSearch> comp) {
		int n = myList.size(); 
        for (int i=1; i<n; ++i) 
        { 
            CrimeStopAndSearch key = myList.get(i); 
            int j = i-1;
            while (j>=0 && comp.compare(myList.get(j),key)>0) 
            { 
                myList.set(j+1, myList.get(j)); 
                j = j-1; 
            } 
            myList.set(j+1, key); 
        } 
	}

	
	/** This method will be used to find the highest successful legislation for a given month
	 * @param temp List<CrimeStopAndSearch>
	 * @param pickDate String user choice date
	 */
	public void allFilesLegislationHighestSucessful(ArrayList<CrimeStopAndSearch> temp, String pickDate) {
		// Creates a list to collect all unique legislations 
		List<CrimeStopAndSearch> myList = new ArrayList<>();
		CrimeStopAndSearch storage = null;
		Data_Handling instance = new Data_Handling();
		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndSearch currentCrime : temp) {
			if (currentCrime.Legislation.equalsIgnoreCase("") || currentCrime.Legislation.equals(null)) {
			} else {
				if (!tempList.contains(currentCrime.Legislation))
					tempList.add(currentCrime.Legislation);
			}
		}
		for (String Legislation : tempList) {
			int successful = 0, unSuccessful = 0, partial = 0;
			for (CrimeStopAndSearch currentCrime : temp) {

				if (Legislation.equals(currentCrime.Legislation) && currentCrime.Date.contains(pickDate)) {
					// For each legislation the counter gets reset and if the parameters are met only then the increment takes place
					int[] counter = instance.SuccessfulSearch(currentCrime.Outcome_Linked_To_Object_Of_Search);
					successful = successful + counter[0];
					unSuccessful = unSuccessful + counter[1];
					partial = partial + counter[2];
				}
			}
			storage = new CrimeStopAndSearch(Legislation, successful, unSuccessful, partial);
			myList.add(storage);
		}
		// Orders the list on successful crimes highest to smallest
		
		
		
		
		
		insertSort(myList, new Comparator<CrimeStopAndSearch>() {
			@Override
			public int compare(CrimeStopAndSearch z1, CrimeStopAndSearch z2) {
				if (z1.getSuccessful() < z2.getSuccessful())
					return 1;
				if (z1.getSuccessful() > z2.getSuccessful())
					return -1;
				return 0;
			}
		});

		// The list has been ordered now you print the largest item and break which will give you the highest successful value
		for (CrimeStopAndSearch list : myList) {
			System.out.println(list.highestSucessLeg());
			break;
			
		}

	}

	/** This method will be used to find the highest total crimes for each legislation for a given month
	 * @param temp List<CrimeStopAndSearch>
	 * @param pickDate String user choice date
	 */
	public void highestTotal(ArrayList<CrimeStopAndSearch> temp, String pickDate) {
		List<CrimeStopAndSearch> myList = new ArrayList<>();
		CrimeStopAndSearch storage = null;
		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndSearch currentCrime : temp) {
			if (currentCrime.Legislation.equalsIgnoreCase("") || currentCrime.Legislation.equalsIgnoreCase(null)) {
			} else {
				if (!tempList.contains(currentCrime.Legislation))
					tempList.add(currentCrime.Legislation);
			}
		}
		for (String Legislation : tempList) {
			int total = 0;
			for (CrimeStopAndSearch currentCrime : temp) {

				if (Legislation.equals(currentCrime.Legislation) && currentCrime.Date.contains(pickDate)) {
					total++;
				}
			}
			storage = new CrimeStopAndSearch(Legislation, total);
			myList.add(storage);
		}
		Comparator<CrimeStopAndSearch> cmp = Comparator.comparing(CrimeStopAndSearch::getTotal);
		insertSort(myList, cmp.reversed());
		
		for (CrimeStopAndSearch list : myList) {
			System.out.println(list.highestTotal());
			break;
		}

	}

	
	/** This method will be used to sort in chronological order list from F(i) and then print the list out
	 * @param temp List<CrimeStopAndSearch>
	 */
	public void chronoLogicalOrder(List<CrimeStopAndSearch> policedateArray) {

		Comparator<CrimeStopAndSearch> cmp = Comparator.comparing(CrimeStopAndSearch::getDate);
		insertSort(policedateArray, cmp.reversed());
		for (CrimeStopAndSearch currentCrime : policedateArray) {
			System.out.println(currentCrime.toCSVString());
		}
	}

	
	/** This method will be used to see total crimes for each ethnic group based on user parameters of date and police
	 * @param temp List<CrimeStopAndSearch>
	 * @param pickDate user String date
	 * @param String user policeForce
	 * @return chronoArray A list of data we found within this method for the users options will be used to sort in chronological order
	 */
	public List<CrimeStopAndSearch> ethnic(ArrayList<CrimeStopAndSearch> temp, String pickDate, String policeForce) {
		List<CrimeStopAndSearch> myList = new ArrayList<>();
		CrimeStopAndSearch storage = null;
		List<String> tempList = new ArrayList<>();
		List<CrimeStopAndSearch> chronoArray = new ArrayList<>();

		for (CrimeStopAndSearch currentCrime : temp) {
			if (currentCrime.Self_Defined_Ethnicity.equalsIgnoreCase("")
					|| currentCrime.Self_Defined_Ethnicity.equalsIgnoreCase(null)) {
			} else {
				if (!tempList.contains(currentCrime.Self_Defined_Ethnicity))
					tempList.add(currentCrime.Self_Defined_Ethnicity);
			}
		}
		for (String Ethnic : tempList) {
			int total = 0;
			for (CrimeStopAndSearch currentCrime : temp) {

				if (Ethnic.equals(currentCrime.Self_Defined_Ethnicity) && currentCrime.Date.contains(pickDate)
						&& currentCrime.Policing_Operation.contains(policeForce)) {
					chronoArray.add(currentCrime);
					;
					total++;
				}
			}
			storage = new CrimeStopAndSearch(Ethnic, total);
			myList.add(storage);
		}

			insertSort(myList, new Comparator<CrimeStopAndSearch>() {
			@Override
			public int compare(CrimeStopAndSearch z1, CrimeStopAndSearch z2) {
				if (z1.getTotal() < z2.getTotal())
					return 1;
				if (z1.getTotal() > z2.getTotal())
					return -1;
				return 0;
			}
		});

		for (CrimeStopAndSearch j : myList) {

			System.out.println(j.highestTotal());
			break;
		}

		return chronoArray;
	}

	
	/** This method will be used to sort by Legislation and then print it out on the given ethnic and gender
	 * @param temp List<CrimeStopAndSearch>
	 * @param pickGender user String gender
	 * @param pickEthnic user String Ethnic
	 */
	public void sortByLegislation(ArrayList<CrimeStopAndSearch> temp, String pickGender, String pickEthnic) {
		List<CrimeStopAndSearch> tempList = new ArrayList<>();
		for (CrimeStopAndSearch currentCrime : temp) {

			if (currentCrime.Gender.equals(pickGender) && currentCrime.Self_Defined_Ethnicity.equals(pickEthnic)) {
				tempList.add(currentCrime);
				;

			}
		}

		Comparator<CrimeStopAndSearch> cmp = Comparator.comparing(CrimeStopAndSearch::getLegislation);
		insertSort(tempList, cmp);

		for (CrimeStopAndSearch j : tempList) {
			System.out.println(j.toCSVString());
		}
	}

	/** This method will find the highest total crimes for each ethnicity on a given legislation 
	 * @param temp List<CrimeStopAndSearch>
	 * @param pickLegislation user String Legislation
	 */
	public void ethnicLeg(ArrayList<CrimeStopAndSearch> temp, String pickLegislation) {
		List<CrimeStopAndSearch> myList = new ArrayList<>();
		CrimeStopAndSearch storage = null;
		List<String> tempList = new ArrayList<>();

		for (CrimeStopAndSearch currentCrime : temp) {
			if (currentCrime.Self_Defined_Ethnicity.equalsIgnoreCase("")
					|| currentCrime.Self_Defined_Ethnicity.equalsIgnoreCase(null)) {
			} else {
				if (!tempList.contains(currentCrime.Self_Defined_Ethnicity)) {
					tempList.add(currentCrime.Self_Defined_Ethnicity);
				}
			}
		}
		for (String Ethnic : tempList) {
			int total = 0;
			for (CrimeStopAndSearch currentCrime : temp) {

				if (Ethnic.equals(currentCrime.Self_Defined_Ethnicity)
						&& currentCrime.Legislation.contains(pickLegislation)) {

					total++;
				}
			}
			storage = new CrimeStopAndSearch(Ethnic, total);
			myList.add(storage);
		}
		insertSort(myList, new Comparator<CrimeStopAndSearch>() {
			@Override
			public int compare(CrimeStopAndSearch z1, CrimeStopAndSearch z2) {
				if (z1.getTotal() < z2.getTotal())
					return 1;
				if (z1.getTotal() > z2.getTotal())
					return -1;
				return 0;
			}
		});

		for (CrimeStopAndSearch j : myList) {
			System.out.println(j.highestTotal());
			break;
		}

	}
}
