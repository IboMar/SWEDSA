import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// This class will be used to sort insert and modify the data
public class Data_Manipulation {

	public void LegislationHighest(StopAndSearchFiles temp) {
		Data_Handling instance = new Data_Handling();
		// HashMap<LegislationType, Integer> map = new HashMap<LegislationType,
		// Integer>();
		int legislation27 = 0, legislation23 = 0, legislation1 = 0, legislation2 = 0, legislation47 = 0,
				legislation60 = 0;
		//int successfu_Search = 0, successfu_Partial = 0, unsucessful = 0;
		for (CrimeStopAndsearch currentCrime : temp.getStopAndSearchFiles()) {

			if (currentCrime != null) {
				switch (currentCrime.Legislation) {
				case SECTION1:
					legislation1++;
					break;
				case SECTION2:
					legislation2++;
					break;
				case SECTION23:
					legislation23++;
					break;
				case SECTION27:
					legislation27++;
					break;
				case SECTION47:
					legislation47++;
					break;
				case SECTION60:
					legislation60++;
					break;
				case BLANK:
					break;

				}
			}
		}
		LegislationHigh[] Legislations = new LegislationHigh[LegislationType.values().length - 1];
		LegislationHigh Legislations1 = new LegislationHigh(LegislationType.SECTION1.getStr(), legislation1);
		LegislationHigh Legislations2 = new LegislationHigh(LegislationType.SECTION2.getStr(), legislation2);
		LegislationHigh Legislations23 = new LegislationHigh(LegislationType.SECTION23.getStr(), legislation23);
		LegislationHigh Legislations27 = new LegislationHigh(LegislationType.SECTION27.getStr(), legislation27);
		LegislationHigh Legislations47 = new LegislationHigh(LegislationType.SECTION47.getStr(), legislation47);
		LegislationHigh Legislations60 = new LegislationHigh(LegislationType.SECTION60.getStr(), legislation60);
		Legislations[0] = Legislations1;
		Legislations[1] = Legislations2;
		Legislations[2] = Legislations23;
		Legislations[3] = Legislations27;
		Legislations[4] = Legislations47;
		Legislations[5] = Legislations60;
		Arrays.sort(Legislations, Collections.reverseOrder());

		for (LegislationHigh p : Legislations) {
			System.out.println("Law: " + p.getLegName() + ", Crimes Commited : " + p.getLegHigh());
		}
		System.out.println("Crimes Commited this month:" + temp.getStopAndSearchFiles().size());
	}

}
