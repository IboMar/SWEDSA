package V1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class will contain all the methods to manipulate our array
 */
public class Data_Manipulation {

	public List<String> objectOfSearch(ArrayList<CrimeStopAndsearch> temp) {

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
		System.out.println("Unique Object_of_search count: " + tempList.size());
		for (String uniqueSeach : tempList) {
			System.out.println(uniqueSeach);
		}
		return tempList;
	}

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
		// Set<String> uniqueGender = new HashSet<String>(tempList);
		int i = 1;
		for (String gender : tempList) {
			System.out.println(i++ + ". " + gender);
		}

		return tempList;
	}

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
	public void outPutOneObjectOfSearch(ArrayList<CrimeStopAndsearch> temp, String objectOfSearchTemp) {

		for (CrimeStopAndsearch currentCrime : temp) {
			if (currentCrime.Object_of_search.contains(objectOfSearchTemp)) {
				System.out.println(currentCrime.toCSVString());
			}
		}
	}

	public void allFilesLegislationHighestSucessful(ArrayList<CrimeStopAndsearch> temp, String pickDate) {
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
					int[] counter = instance.SuccessfulSearch(currentCrime.Outcome_linked_to_object_of_search);
					successful = successful + counter[0];
					unsuccessful = unsuccessful + counter[1];
					partial = partial + counter[2];
				}
			}
			storage = new CrimeStopAndsearch(Legislation, successful, unsuccessful, partial);
			myList.add(storage);
		}
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

		for (CrimeStopAndsearch list : myList) {
			System.out.println(list.highestSucessLeg());
			break;

		}

	}

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

	public void chronoLogicalOrder(List<CrimeStopAndsearch> policedateArray) {

		Comparator<CrimeStopAndsearch> cmp = Comparator.comparing(CrimeStopAndsearch::getDate);
		Collections.sort(policedateArray, cmp.reversed());

		// sort the list

		for (CrimeStopAndsearch currentCrime : policedateArray) {

			System.out.println(currentCrime.toCSVString());
		}

	}

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

	public void sortByEthnicity(ArrayList<CrimeStopAndsearch> temp, String pickGender, String pickEthnic) {
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

	public void ethnicLeg(ArrayList<CrimeStopAndsearch> temp, String pickLegislation) {
		List<CrimeStopAndsearch> myList = new ArrayList<>();
		CrimeStopAndsearch storage = null;
		// Data_Handling instance = new Data_Handling();
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
