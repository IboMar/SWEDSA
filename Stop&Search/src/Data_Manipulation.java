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
		Map<Map<String, Integer>, Integer> mapinc = new HashMap<Map<String, Integer>, Integer>();
		
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

}
