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

	public ArrayList<StopAndSearchFiles> fileList = new ArrayList<>();

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

	 void outputCrimes() {
		List<String> xd = FolderReader.getbasicStop_Search();
		for (StopAndSearchFiles file : fileList) {
			for(String temp: xd) {
			System.out.println(temp);
			for (CrimeStopAndsearch currentFile : file.getStopAndSearchFiles()) {
				System.out.println(currentFile.toCSVString());
			}
			}
		}

	}

	private static String percent(int num, int div) {
		double perc = ((double) num / div);
		perc *= 100;
		return String.format(" %.1f%%", perc);
	}

}
