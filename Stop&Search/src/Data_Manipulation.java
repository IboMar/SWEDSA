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

// This class will be used to sort insert and modify the data
public class Data_Manipulation {

	public void LegislationHighest(StopAndSearchFiles temp) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (CrimeStopAndsearch currentCrime : temp.getStopAndSearchFiles()) {
			if (currentCrime.Legislation.equalsIgnoreCase("") || currentCrime.Legislation.equalsIgnoreCase(null)) {
				int count = map.containsKey("Unspecified") ? map.get("Unspecified") : 0;
				map.put("Unspecified", count + 1);
			} else {
				int count = map.containsKey(currentCrime.Legislation) ? map.get(currentCrime.Legislation) : 0;
				map.put(currentCrime.Legislation, count + 1);

			}
		}
		print_largest_hashmap(map);

	}

	public Set<String> objectOfSearch(ArrayList<CrimeStopAndsearch> temp) {

		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndsearch currentCrime : temp) {
			if (currentCrime.Object_of_search.equalsIgnoreCase("")
					|| currentCrime.Object_of_search.equalsIgnoreCase(null)) {
			} else {
				tempList.add(currentCrime.Object_of_search);
			}
		}
		Set<String> uniqueobjectOfSearch = new HashSet<String>(tempList);
		System.out.println("Unique Object_of_search count: " + uniqueobjectOfSearch.size());
		for (String uniqueSeach : uniqueobjectOfSearch) {
			System.out.println(uniqueSeach);
		}
		return uniqueobjectOfSearch;
	}
	
	
	public Set<String> uniqueDate(List<CrimeStopAndsearch> temp) {

		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndsearch currentCrime : temp) {
			if (currentCrime.Date.equalsIgnoreCase("")
					|| currentCrime.Date.equalsIgnoreCase(null)) {
			} else {
				 String substringDate = currentCrime.Date;
				 substringDate = substringDate.substring(0,7);
				tempList.add(substringDate);
			}
			
			
			
		
		}
		Set<String> uniqueDates = new HashSet<String>(tempList);
		int i=1;
		for(String date : uniqueDates) {
			System.out.println(i++ + ". " + date);
		}
		
		return uniqueDates;
	}
	
	
	

	public void print_all_hashmap(Map<String, Integer> map) {

		for (String name : map.keySet()) {
			String key = name;
			String value = map.get(name).toString();
			System.out.println(value + " " + key);

		}

	}

	public void print_largest_hashmap(Map<String, Integer> map) {
		Integer big = null;
		String biggestLeg = null;
		for (String name : map.keySet()) {
			String key = name;
			String value = map.get(name).toString();
			Integer storage = map.get(name);
			if (big == null || big < map.get(name)) {
				big = map.get(name);
				biggestLeg = key;
			}
		}
		System.out.println(biggestLeg + " " + big);
	}

	public void print_largest_hashmapObj(Map<Object, Integer> map) {

	}

	public void outPutOneObjectOfSearch(ArrayList<CrimeStopAndsearch> temp, String objectOfSearchTemp) {

		for (CrimeStopAndsearch currentCrime : temp) {
			if (currentCrime.Object_of_search.contains(objectOfSearchTemp)) {
				System.out.println(currentCrime.toCSVString());
			}

		}
	}
	
	public ArrayList<CrimeStopAndsearch> outPutOneDate(ArrayList<CrimeStopAndsearch> temp, String tempDate) {
		ArrayList<CrimeStopAndsearch> uniqueDates = new ArrayList<>();
		
		
		for (CrimeStopAndsearch currentCrime : temp) {
			if (currentCrime.Date.contains(tempDate)) {
				uniqueDates.add(currentCrime);
				
			}

		}
		
		return uniqueDates;
		
	}
	
	
	public void allFilesLegislationHighestSucessful(ArrayList<CrimeStopAndsearch> temp) {
		List<objectStorage> myList = new ArrayList<>();
		objectStorage storage = null;
		Data_Handling instance = new Data_Handling();
		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndsearch currentCrime : temp) {
			if (currentCrime.Legislation.equalsIgnoreCase("") || currentCrime.Legislation.equalsIgnoreCase(null)) {
			} else {
				tempList.add(currentCrime.Legislation);
			}
		}
		Set<String> uniqueLegislation = new HashSet<String>(tempList);
		for (String Legislation : uniqueLegislation) {
			int successful = 0, unsuccessful = 0, partial = 0;
			for (CrimeStopAndsearch currentCrime : temp) {

				if (Legislation.equals(currentCrime.Legislation)) {
					int[] counter = instance.SuccessfulSearch(currentCrime.Outcome_linked_to_object_of_search);
					successful = successful + counter[0];
					unsuccessful = unsuccessful + counter[1];
					partial = partial + counter[2];
				}
			}
			storage = new objectStorage(Legislation, successful, unsuccessful, partial);
			myList.add(storage);
		}
		Collections.sort(myList, new Comparator<objectStorage>() {
			@Override
			public int compare(objectStorage z1, objectStorage z2) {
				if (z1.getSuccessful() < z2.getSuccessful())
					return 1;
				if (z1.getSuccessful() > z2.getSuccessful())
					return -1;
				return 0;
			}
		});
		
		
		for(objectStorage list : myList) {
			System.out.println(list.toString());
			break;
		}
	
		
	}
	
	
	public void highestTotal(ArrayList<CrimeStopAndsearch> temp) {
		List<objectStorage> myList = new ArrayList<>();
		objectStorage storage = null;
		Data_Handling instance = new Data_Handling();
		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndsearch currentCrime : temp) {
			if (currentCrime.Legislation.equalsIgnoreCase("") || currentCrime.Legislation.equalsIgnoreCase(null)) {
			} else {
				tempList.add(currentCrime.Legislation);
			}
		}
		Set<String> uniqueLegislation = new HashSet<String>(tempList);
		for (String Legislation : uniqueLegislation) {
			int successful = 0, unsuccessful = 0, partial = 0;
			for (CrimeStopAndsearch currentCrime : temp) {

				if (Legislation.equals(currentCrime.Legislation)) {
					int[] counter = instance.SuccessfulSearch(currentCrime.Outcome_linked_to_object_of_search);
					successful = successful + counter[0];
					unsuccessful = unsuccessful + counter[1];
					partial = partial + counter[2];
				}
			}
			storage = new objectStorage(Legislation, successful, unsuccessful, partial);
			myList.add(storage);
		}
		Collections.sort(myList, new Comparator<objectStorage>() {
			@Override
			public int compare(objectStorage z1, objectStorage z2) {
				if (z1.getTotal() < z2.getTotal())
					return 1;
				if (z1.getTotal() > z2.getTotal())
					return -1;
				return 0;
			}
		});
		
		
		for(objectStorage list : myList) {
			System.out.println(list.toString());
			break;
		}
	
		
	}
	
	
	

	public void ethnic(StopAndSearchFiles temp) {
		List<objectStorage> myList = new ArrayList<>();
		objectStorage storage = null;
		Data_Handling instance = new Data_Handling();
		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndsearch currentCrime : temp.getStopAndSearchFiles()) {
			if (currentCrime.Self_defined_ethnicity.equalsIgnoreCase("")
					|| currentCrime.Self_defined_ethnicity.equalsIgnoreCase(null)) {
			} else {
				tempList.add(currentCrime.Self_defined_ethnicity);
			}
		}
		Set<String> uniqueSelfEthnic = new HashSet<String>(tempList);
		for (String Ethnic : uniqueSelfEthnic) {
			int successful = 0, unsuccessful = 0, partial = 0;
			for (CrimeStopAndsearch currentCrime : temp.getStopAndSearchFiles()) {

				if (Ethnic.equals(currentCrime.Self_defined_ethnicity)) {
					int[] counter = instance.SuccessfulSearch(currentCrime.Outcome_linked_to_object_of_search);
					successful = successful + counter[0];
					unsuccessful = unsuccessful + counter[1];
					partial = partial + counter[2];
				}
			}
			storage = new objectStorage(Ethnic, successful, unsuccessful, partial);
			myList.add(storage);
		}
		Collections.sort(myList, new Comparator<objectStorage>() {
			@Override
			public int compare(objectStorage z1, objectStorage z2) {
				if (z1.getSuccessful() < z2.getSuccessful())
					return 1;
				if (z1.getSuccessful() > z2.getSuccessful())
					return -1;
				return 0;
			}
		});

		for (objectStorage j : myList) {
			System.out.println(j.toString());
		}
	}

	public void ethnicForLeg(ArrayList<CrimeStopAndsearch>  temp) {
		List<CrimeStopAndsearch> myList = new ArrayList<>();
		CrimeStopAndsearch storage = null;
		Data_Handling instance = new Data_Handling();
		List<String> tempList = new ArrayList<>();
		List<String> tempList2 = new ArrayList<>();
		for (CrimeStopAndsearch currentCrime : temp) {
			if (currentCrime.Legislation.equalsIgnoreCase("") || currentCrime.Legislation.equalsIgnoreCase(null)) {
			} else {
				tempList.add(currentCrime.Legislation);
			}
			if (currentCrime.Self_defined_ethnicity.equalsIgnoreCase("")
					|| currentCrime.Self_defined_ethnicity.equalsIgnoreCase(null)) {
			} else {
				tempList2.add(currentCrime.Self_defined_ethnicity);
			}
		}
		Set<String> uniqueSelfEthnic = new HashSet<String>(tempList2);
		Set<String> uniqueLeg = new HashSet<String>(tempList);
		for (String Ethnic : uniqueSelfEthnic) {
			int successful = 0, unsuccessful = 0, partial = 0;
			String legistration = "";
			for (String leg : uniqueLeg) {

				for (CrimeStopAndsearch currentCrime : temp) {

					if (leg.equals(currentCrime.Legislation)) {
						if (Ethnic.equals(currentCrime.Self_defined_ethnicity)) {
							int[] counter = instance.SuccessfulSearch(currentCrime.Outcome_linked_to_object_of_search);
							successful = successful + counter[0];
							unsuccessful = unsuccessful + counter[1];
							partial = partial + counter[2];
							legistration = leg;
						}
					}
				}
			}
			storage = new CrimeStopAndsearch(Ethnic, legistration, successful, unsuccessful, partial);
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
		for (CrimeStopAndsearch j : myList) {
			System.out.println(j.toString2());
		}
	}

}
