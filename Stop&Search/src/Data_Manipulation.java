import java.util.ArrayList;
import java.util.List;

// This class will be used to sort insert and modify the data
public class Data_Manipulation {

	// IDK if this is good :P
	public static void crime_Lexicographic_order(ArrayList<Crime> tempcrime) {

		for (int i = 1; i < tempcrime.size(); i++) {
			for (int j = i; j > 0; j--) {
				Crime lower = tempcrime.get(j - 1);
				Crime higher = tempcrime.get(j);
				if (higher.crimetype.compareTo(lower.crimetype) < 0) {
					tempcrime.set(j, lower);
					tempcrime.set(j - 1, higher);
				} else
					break;
			}
		}
	}

	public static void category_Lexicographic_order(ArrayList<Crime> tempcrime) {
		
		for (int i = 1; i < tempcrime.size(); i++) {
			for (int j = i; j > 0; j--) {
				Crime lower = tempcrime.get(j - 1);
				Crime higher = tempcrime.get(j);
				if (higher.outcome.compareTo(lower.outcome) < 0) {
					tempcrime.set(j, lower);
					tempcrime.set(j - 1, higher);
				} else
					break;
			}
		}

	}

	public static void LSOA_Name(ArrayList<Crime> tempcrime) {
		for (int i = 1; i < tempcrime.size(); i++) {
			for (int j = i; j > 0; j--) {
				Crime lower = tempcrime.get(j - 1);
				Crime higher = tempcrime.get(j);
				if (higher.lsoaN.compareTo(lower.lsoaN) < 0) {
					tempcrime.set(j, lower);
					tempcrime.set(j - 1, higher);
				} else
					break;
			}
		}

	}

}
