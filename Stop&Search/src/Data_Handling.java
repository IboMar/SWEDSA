import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Data_Handling {
	public TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();

	private ArrayList<StopAndSearchFiles> fileList = new ArrayList<>();

	public void readFile(String filename) throws FileNotFoundException {
		ArrayList<CrimeStopAndsearch> StopandSearch = new ArrayList<>();

		File csvFile = new File(filename);
		Scanner csvScan = new Scanner(csvFile);
		CrimeStopAndsearch StopandSearchtemp = null;
		// csvScan.nextLine(); // read header
		while (csvScan.hasNextLine()) {
			String line = csvScan.nextLine();
			StopandSearchtemp = new CrimeStopAndsearch(line);
			StopandSearch.add(StopandSearchtemp);
			// StopAndSearchFiles File = new StopAndSearchFiles(StopandSearch);
		}
		StopAndSearchFiles File = new StopAndSearchFiles(StopandSearch);
		fileList.add(File);

		csvScan.close();
	}

	public ArrayList<StopAndSearchFiles> getFileList() {
		return fileList;
	}

	void outputCrimes() {
		List<String> fileName = FolderReader.getbasicStop_Search();
		int successfu_Search = 0, successfu_NotPlannedSearch = 0, other = 0, unsolved = 0, unsucessful = 0;
		int i = 0;
		while (i < fileName.size()) {
			for (StopAndSearchFiles file : fileList) {
				System.out.println(fileName.get(i));
				i++;
				for (CrimeStopAndsearch currentCrime : file.getStopAndSearchFiles()) {
					if (currentCrime != null) {
						if ((currentCrime.Outcome.startsWith("Suspect arrested")
								|| currentCrime.Outcome.startsWith("Offender cautioned")
								|| currentCrime.Outcome.startsWith("Offender given penalty notice"))
								&& currentCrime.Outcome_linked_to_object_of_search) {
							successfu_Search++;
						}
						if ((currentCrime.Outcome.startsWith("Suspect arrested")
								|| currentCrime.Outcome.startsWith("Offender cautioned")
								|| currentCrime.Outcome.startsWith("Offender given penalty notice"))
								&& !currentCrime.Outcome_linked_to_object_of_search) {
							successfu_NotPlannedSearch++;
						}
						if (currentCrime.Outcome.startsWith("Nothing found - no further action")) {
							unsucessful++;
						}
					System.out.println(currentCrime.toCSVString());
				}
				}
						System.out.println("There are " + file.getListSize() + " recorded crimes; ");
						System.out
								.println(successfu_Search + " Successful Searches - " + percent(successfu_Search, file.getListSize()));
						System.out.println(successfu_NotPlannedSearch + " successfu not Planned search - "
								+ percent(successfu_NotPlannedSearch, file.getListSize()));
						System.out.println(unsucessful + " unsucessful seach -"
								+ percent(unsucessful, file.getListSize()));
			}
		}
	}

	private static String percent(int num, int div) {
		double perc = ((double) num / div);
		perc *= 100;
		return String.format(" %.1f%%", perc);
	}

}
