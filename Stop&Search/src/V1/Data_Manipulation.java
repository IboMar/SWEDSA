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
	 * @param temp List<CrimeStopAndsearch> of all files
	 * @return tempList List of all unique Strings for objectOfSearch
	 */
	public List<String> uniqueObjectOfSearch(ArrayList<CrimeStopAndsearch> temp) {

		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndsearch currentCrime : temp) {
			if (currentCrime.Object_of_search.equalsIgnoreCase("")
					|| currentCrime.Object_of_search.equalsIgnoreCase(null)) {
			} else {
				if (!tempList.contains(currentCrime.Object_of_search)) {
					tempList.add(currentCrime.Object_of_search);
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
	 * @param temp List<CrimeStopAndsearch> of all files
	 * @return tempList List of all unique Strings for dates
	 */
	public List<String> uniqueDate(List<CrimeStopAndsearch> temp) {

		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndsearch currentCrime : temp) {
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
	 * @param temp List<CrimeStopAndsearch> of all files
	 * @return tempList List of all unique Strings for gender
	 */
	public List<String> uniqueGender(List<CrimeStopAndsearch> temp) {
		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndsearch currentCrime : temp) {
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
	 * @param temp List<CrimeStopAndsearch> of all files
	 * @return tempList List of all unique Strings for Ethnic
	 */
	public List<String> uniqueEthnic(List<CrimeStopAndsearch> temp) {

		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndsearch currentCrime : temp) {
			if (currentCrime.Self_defined_ethnicity != null
					&& !currentCrime.Self_defined_ethnicity.equalsIgnoreCase("")) {
				if (!tempList.contains(currentCrime.Self_defined_ethnicity)) {
					tempList.add(currentCrime.Self_defined_ethnicity);
				}
			}
		}
		int i = 1;
		for (String ethnic : tempList) {
			System.out.println(i++ + ". " + ethnic);
		}

		return tempList;
	}

	/**
	 * This Method will get all the unique Police within the merged files
	 * 
	 * @param temp List<CrimeStopAndsearch> of all files
	 * @return tempList List of all unique Strings for Police
	 */
	public List<String> uniquePolice(List<CrimeStopAndsearch> temp) {

		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndsearch currentCrime : temp) {
			if (currentCrime.Policing_operation.equalsIgnoreCase("")
					|| currentCrime.Policing_operation.equalsIgnoreCase(null)) {
			} else {
				if (!tempList.contains(currentCrime.Policing_operation))
					tempList.add(currentCrime.Policing_operation);
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
	 * @param temp List<CrimeStopAndsearch> of all files
	 * @return tempList List of all unique Strings for Legislations
	 */
	public List<String> uniqueLeg(List<CrimeStopAndsearch> temp) {

		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndsearch currentCrime : temp) {
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
	 * @param temp List<CrimeStopAndsearch>
	 * @param objectOfSearchTemp String user choice objectOfSearch
	 */
	public void outPutOneObjectOfSearch(ArrayList<CrimeStopAndsearch> temp, String objectOfSearchTemp) {

		for (CrimeStopAndsearch currentCrime : temp) {
			if (currentCrime.Object_of_search.contains(objectOfSearchTemp)) {
				System.out.println(currentCrime.toCSVString());
			}
		}
	}

	
	/** This method will be used to find the highest successful legislation for a given month
	 * @param temp List<CrimeStopAndsearch>
	 * @param pickDate String user choice date
	 */
	public void allFilesLegislationHighestSucessful(ArrayList<CrimeStopAndsearch> temp, String pickDate) {
		// Creates a list to collect all unique legislations 
		List<CrimeStopAndsearch> myList = new ArrayList<>();
		CrimeStopAndsearch storage = null;
		Data_Handling instance = new Data_Handling();
		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndsearch currentCrime : temp) {
			if (currentCrime.Legislation.equalsIgnoreCase("") || currentCrime.Legislation.equals(null)) {
			} else {
				if (!tempList.contains(currentCrime.Legislation))
					tempList.add(currentCrime.Legislation);
			}
		}
		for (String Legislation : tempList) {
			int successful = 0, unsuccessful = 0, partial = 0;
			for (CrimeStopAndsearch currentCrime : temp) {

				if (Legislation.equals(currentCrime.Legislation) && currentCrime.Date.contains(pickDate)) {
					// For each legislation the counter gets reset and if the parameters are met only then the increment takes place
					int[] counter = instance.SuccessfulSearch(currentCrime.Outcome_linked_to_object_of_search);
					successful = successful + counter[0];
					unsuccessful = unsuccessful + counter[1];
					partial = partial + counter[2];
				}
			}
			storage = new CrimeStopAndsearch(Legislation, successful, unsuccessful, partial);
			myList.add(storage);
		}
		// Orders the list on successful crimes highest to smallest
		Collections.sort(myList, new Comparator<CrimeStopAndsearch>() {
			@Override
			public int compare(CrimeStopAndsearch z1, CrimeStopAndsearch z2) {
				if (z1.getSuccessful() < z2.getSuccessful())
					return 1;
				if (z1.getSuccessful() > z2.getSuccessful())
					return -1;
				return 0;
			}
		});

		// The list has been ordered now you print the largest item and break which will give you the highest successful value
		for (CrimeStopAndsearch list : myList) {
			System.out.println(list.highestSucessLeg());
			break;

		}

	}

	/** This method will be used to find the highest total crimes for each legislation for a given month
	 * @param temp List<CrimeStopAndsearch>
	 * @param pickDate String user choice date
	 */
	public void highestTotal(ArrayList<CrimeStopAndsearch> temp, String pickDate) {
		List<CrimeStopAndsearch> myList = new ArrayList<>();
		CrimeStopAndsearch storage = null;
		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndsearch currentCrime : temp) {
			if (currentCrime.Legislation.equalsIgnoreCase("") || currentCrime.Legislation.equalsIgnoreCase(null)) {
			} else {
				if (!tempList.contains(currentCrime.Legislation))
					tempList.add(currentCrime.Legislation);
			}
		}
		for (String Legislation : tempList) {
			int total = 0;
			for (CrimeStopAndsearch currentCrime : temp) {

				if (Legislation.equals(currentCrime.Legislation) && currentCrime.Date.contains(pickDate)) {
					total++;
				}
			}
			storage = new CrimeStopAndsearch(Legislation, total);
			myList.add(storage);
		}
		Collections.sort(myList, new Comparator<CrimeStopAndsearch>() {
			public int compare(CrimeStopAndsearch z1, CrimeStopAndsearch z2) {
				if (z1.getTotal() < z2.getTotal())
					return 1;
				if (z1.getTotal() > z2.getTotal())
					return -1;
				return 0;
			}
		});

		for (CrimeStopAndsearch list : myList) {
			System.out.println(list.highestTotal());
			break;
		}

	}

	
	/** This method will be used to sort in chronological order list from F(i) and then print the list out
	 * @param temp List<CrimeStopAndsearch>
	 */
	public void chronoLogicalOrder(List<CrimeStopAndsearch> policedateArray) {

		Comparator<CrimeStopAndsearch> cmp = Comparator.comparing(CrimeStopAndsearch::getDate);
		Collections.sort(policedateArray, cmp.reversed());
		for (CrimeStopAndsearch currentCrime : policedateArray) {
			System.out.println(currentCrime.toCSVString());
		}
	}

	
	/** This method will be used to see total crimes for each ethnic group based on user parameters of date and police
	 * @param temp List<CrimeStopAndsearch>
	 * @param pickDate user String date
	 * @param String user policeForce
	 * @return chronoArray A list of data we found within this method for the users options will be used to sort in chronological order
	 */
	public List<CrimeStopAndsearch> ethnic(ArrayList<CrimeStopAndsearch> temp, String pickDate, String policeForce) {
		List<CrimeStopAndsearch> myList = new ArrayList<>();
		CrimeStopAndsearch storage = null;
		List<String> tempList = new ArrayList<>();
		List<CrimeStopAndsearch> chronoArray = new ArrayList<>();

		for (CrimeStopAndsearch currentCrime : temp) {
			if (currentCrime.Self_defined_ethnicity.equalsIgnoreCase("")
					|| currentCrime.Self_defined_ethnicity.equalsIgnoreCase(null)) {
			} else {
				if (!tempList.contains(currentCrime.Self_defined_ethnicity))
					tempList.add(currentCrime.Self_defined_ethnicity);
			}
		}
		for (String Ethnic : tempList) {
			int total = 0;
			for (CrimeStopAndsearch currentCrime : temp) {

				if (Ethnic.equals(currentCrime.Self_defined_ethnicity) && currentCrime.Date.contains(pickDate)
						&& currentCrime.Policing_operation.contains(policeForce)) {
					chronoArray.add(currentCrime);
					;
					total++;
				}
			}
			storage = new CrimeStopAndsearch(Ethnic, total);
			myList.add(storage);
		}

		Collections.sort(myList, new Comparator<CrimeStopAndsearch>() {
			@Override
			public int compare(CrimeStopAndsearch z1, CrimeStopAndsearch z2) {
				if (z1.getTotal() < z2.getTotal())
					return 1;
				if (z1.getTotal() > z2.getTotal())
					return -1;
				return 0;
			}
		});

		for (CrimeStopAndsearch j : myList) {

			System.out.println(j.highestTotal());
			break;
		}

		return chronoArray;
	}

	
	/** This method will be used to sort by Legislation and then print it out on the given ethnic and gender
	 * @param temp List<CrimeStopAndsearch>
	 * @param pickGender user String gender
	 * @param pickEthnic user String Ethnic
	 */
	public void sortByLegislation(ArrayList<CrimeStopAndsearch> temp, String pickGender, String pickEthnic) {
		List<CrimeStopAndsearch> tempList = new ArrayList<>();
		for (CrimeStopAndsearch currentCrime : temp) {

			if (currentCrime.Gender.equals(pickGender) && currentCrime.Self_defined_ethnicity.equals(pickEthnic)) {
				tempList.add(currentCrime);
				;

			}
		}

		Comparator<CrimeStopAndsearch> cmp = Comparator.comparing(CrimeStopAndsearch::getLegislation);
		Collections.sort(tempList, cmp);

		for (CrimeStopAndsearch j : tempList) {

			System.out.println(j.toCSVString());
		}
	}

	/** This method will find the highest total crimes for each ethnicity on a given legislation 
	 * @param temp List<CrimeStopAndsearch>
	 * @param pickLegislation user String Legislation
	 */
	public void ethnicLeg(ArrayList<CrimeStopAndsearch> temp, String pickLegislation) {
		List<CrimeStopAndsearch> myList = new ArrayList<>();
		CrimeStopAndsearch storage = null;
		List<String> tempList = new ArrayList<>();

		for (CrimeStopAndsearch currentCrime : temp) {
			if (currentCrime.Self_defined_ethnicity.equalsIgnoreCase("")
					|| currentCrime.Self_defined_ethnicity.equalsIgnoreCase(null)) {
			} else {
				if (!tempList.contains(currentCrime.Self_defined_ethnicity)) {
					tempList.add(currentCrime.Self_defined_ethnicity);
				}
			}
		}
		for (String Ethnic : tempList) {
			int total = 0;
			for (CrimeStopAndsearch currentCrime : temp) {

				if (Ethnic.equals(currentCrime.Self_defined_ethnicity)
						&& currentCrime.Legislation.contains(pickLegislation)) {

					total++;
				}
			}
			storage = new CrimeStopAndsearch(Ethnic, total);
			myList.add(storage);
		}
		Collections.sort(myList, new Comparator<CrimeStopAndsearch>() {
			@Override
			public int compare(CrimeStopAndsearch z1, CrimeStopAndsearch z2) {
				if (z1.getTotal() < z2.getTotal())
					return 1;
				if (z1.getTotal() > z2.getTotal())
					return -1;
				return 0;
			}
		});

		for (CrimeStopAndsearch j : myList) {
			System.out.println(j.highestTotal());
			break;
		}

	}
}
