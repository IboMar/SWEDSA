package V2;

import java.util.Comparator;

public abstract class LegislationComp implements Comparator {
	public int compare(CrimeStopAndsearch o1, CrimeStopAndsearch o2) {
		String name1 = o1.getLegislation();
		String name2 = o2.getLegislation();
		return name1.compareTo(name2);
	}
}
