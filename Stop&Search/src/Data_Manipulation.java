import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// This class will be used to sort insert and modify the data
public class Data_Manipulation {

	 void HighestlegislationForEachMonth(List<CrimeStopAndsearch> list) {
		 System.out.println("wahh");
		for (CrimeStopAndsearch currentCrime : list) {
			if (currentCrime.Legislation != null) {
				Set<String> set = new HashSet<>();

			if(set.add(currentCrime.Legislation)) {
				System.out.println("gj");
			}
			}

		}
	}
}
