import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Data_Handling {
	
	public static ArrayList<CrimeStopAndsearch> readFile(String filename) throws FileNotFoundException {
		ArrayList<CrimeStopAndsearch> StopandSearch = new ArrayList<>();
		File csvFile = new File(filename);
		Scanner csvScan = new Scanner(csvFile);

		csvScan.nextLine(); // read header
		while (csvScan.hasNextLine()) {
			String line = csvScan.nextLine();
			CrimeStopAndsearch StopandSearchtemp = new CrimeStopAndsearch(line);
			StopandSearch.add(StopandSearchtemp);
		}

		csvScan.close();
		return StopandSearch;
	}

	static void outputCrimes(ArrayList<CrimeStopAndsearch> StopandSearch) {
		int underInvestigation = 0, other = 0, unsolved = 0;
		for (int i = 0; i < StopandSearch.size(); i++) {
			CrimeStopAndsearch currentCrime = StopandSearch.get(i);
			if (currentCrime != null) {
				if (currentCrime.Outcome.startsWith("Under invest"))
					underInvestigation++;
				else if (currentCrime.Outcome.startsWith("Investigation complete; no"))
					unsolved++;
				else
					other++;

				System.out.println(currentCrime.type + ": (" + currentCrime.Legislation + ") " + currentCrime.Policing_operation
						+ " --> " + currentCrime.Outcome);
			}
		}
		System.out.println("There are " + StopandSearch.size() + " recorded crimes; ");
		System.out.println(
				underInvestigation + " are under investigation - " + percent(underInvestigation, StopandSearch.size()));
		System.out.println(unsolved + " have been investigated, but are unsolved - " + percent(unsolved, StopandSearch.size()));
		System.out.println(other + " other -" + percent(other, StopandSearch.size()));
	}

	private static String percent(int num, int div) {
		double perc = ((double) num / div);
		perc *= 100;
		return String.format(" %.1f%%", perc);
	}

}
