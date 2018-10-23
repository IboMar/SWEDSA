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

	private ArrayList<StopAndSearchFiles> fileList = new ArrayList<>();

	public void readFile(String filename) throws FileNotFoundException {
		ArrayList<CrimeStopAndsearch> StopandSearch = new ArrayList<>();

		File csvFile = new File(filename);
		Scanner csvScan = new Scanner(csvFile);
		CrimeStopAndsearch StopandSearchtemp = null;
		csvScan.nextLine(); // read header
		while (csvScan.hasNextLine()) {
			String line = csvScan.nextLine();
			StopandSearchtemp = new CrimeStopAndsearch(line);
			StopandSearch.add(StopandSearchtemp);

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
		int i = 0;
		while (i < fileName.size()) {
			for (StopAndSearchFiles file : fileList) {
				int successfu_Search = 0, successfu_Partial = 0, unsucessful = 0;
				System.out.println(fileName.get(i));
				i++;
				for (CrimeStopAndsearch currentCrime : file.getStopAndSearchFiles()) {

					if (currentCrime != null) {
						int[] temp = SuccessfulSearch(currentCrime.Outcome,
								currentCrime.Outcome_linked_to_object_of_search);
						successfu_Search = successfu_Search + temp[0];
						successfu_Partial = successfu_Partial + temp[1];
						unsucessful = unsucessful + temp[2];
						System.out.println(currentCrime.toCSVString());
					}
				}
				System.out.println("There are " + file.getListSize() + " recorded crimes; ");
				System.out.println(
						successfu_Search + " Successful Searches - " + percent(successfu_Search, file.getListSize()));
				System.out.println(successfu_Partial + " Successful not Planned search - "
						+ percent(successfu_Partial, file.getListSize()));
				System.out.println(unsucessful + " unsucessful seach -" + percent(unsucessful, file.getListSize()));
			}
		}

	}

	private static String percent(int num, int div) {
		double perc = ((double) num / div);
		perc *= 100;
		return String.format(" %.1f%%", perc);
	}

	public int[] SuccessfulSearch(String outcome, boolean Outcome_linked_to_object_of_search) {
		int successfu_Search = 0, successfu_Partial = 0, unsucessful = 0;

		if ((outcome.toLowerCase().contains("arrest") || outcome.toLowerCase().startsWith("caution")
				|| outcome.toLowerCase().contains("penalty") || outcome.toLowerCase().contains("offender")
				|| outcome.toLowerCase().contains("penalty") || outcome.toLowerCase().contains("penalty")
				|| outcome.toLowerCase().contains("summons") || outcome.toLowerCase().contains("article")
				|| outcome.toLowerCase().contains("community") || outcome.toLowerCase().contains("khat or cannabis")
				|| outcome.toLowerCase().contains("drugs"))) {
			if (Outcome_linked_to_object_of_search) {
				successfu_Search++;
			}
			if (!Outcome_linked_to_object_of_search) {
				successfu_Partial++;
			}
		}
		if (outcome.toLowerCase().contains("no further") || outcome.toLowerCase().contains("nothing found")
				|| outcome.toLowerCase().contains("nothing found") || outcome.toLowerCase().contains("resolution")) {
			unsucessful++;
		}
		int[] intArray = new int[3];
		intArray[0] = successfu_Search;
		intArray[1] = successfu_Partial;
		intArray[2] = unsucessful;
		return intArray;

	}
}
