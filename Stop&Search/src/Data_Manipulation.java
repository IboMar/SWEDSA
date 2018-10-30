import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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

	public Set<String> objectOfSearch(StopAndSearchFiles temp) {

		List<String> tempList = new ArrayList<>();
		for (CrimeStopAndsearch currentCrime : temp.getStopAndSearchFiles()) {
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

	public void outPutOneObjectOfSearch(StopAndSearchFiles temp, String objectOfSearchTemp) {

		for (CrimeStopAndsearch currentCrime : temp.getStopAndSearchFiles()) {
			if (currentCrime.Object_of_search.contains(objectOfSearchTemp)) {
				System.out.println(currentCrime.toCSVString());
			}

		}
	}
	
	public void LegislationHighestSucessful(StopAndSearchFiles temp) {
		Map<Object, Integer> objmap = new HashMap<Object, Integer>();

		objectStorage HighestSucessful;
		List<String> tempList = new ArrayList<>();
		int[] counter;
		
		for (CrimeStopAndsearch currentCrime : temp.getStopAndSearchFiles()) {
			counter = Data_Handling.SuccessfulSearch(currentCrime.Object_of_search);
			if (currentCrime.Legislation.equalsIgnoreCase("")
					|| currentCrime.Legislation.equalsIgnoreCase(null)) {
			} else {
				tempList.add(currentCrime.Legislation);
			}
		}
		objectStorage hello = new objectStorage();
		Set<String> uniqueLegislation = new HashSet<String>(tempList);
		System.out.println("Unique Object_of_search count: " + uniqueLegislation.size());
		for (String Legislation : uniqueLegislation) {
			System.out.println(Legislation);
		}
		
		
		
		print_largest_hashmapObj(objmap);

	}

}

class objectStorage {
	private int sucessful;
	private int parial;
	private int unsucessful;
	private String val;

	public String toString() {
		return val + " " + sucessful + " " + parial + " " + unsucessful;
	}

	public objectStorage(String temp, int[] tempData) {
		val = temp;
		sucessful = tempData[0];
		parial = tempData[1];
		unsucessful = tempData[2];
	}
	
	
}
