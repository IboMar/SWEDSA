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
	public static ArrayList<CrimeStopAndsearch> StopandSearch = new ArrayList<>();
	
	public static void readFile(String filename) throws FileNotFoundException {
		//StopandSearch = new ArrayList<CrimeStopAndsearch>();
		
		File csvFile = new File(filename);
		Scanner csvScan = new Scanner(csvFile);

		CrimeStopAndsearch StopandSearchtemp = null;
		//csvScan.nextLine(); // read header
		while (csvScan.hasNextLine()) {
			String line = csvScan.nextLine();
			StopandSearchtemp = new CrimeStopAndsearch(line);
			StopandSearch.add(StopandSearchtemp);
		}
		StopandSearch.add(StopandSearchtemp);

		
		csvScan.close();
		//return StopandSearch;
	}

	static void outputCrimes() {
		List<String> xd = FolderReader.getbasicStop_Search();
		/*for(String temp : xd) {
			System.out.println(" File Name: " + temp);
			System.out.println(currentFile.toCSVString());
			}*/
		
		
		for(CrimeStopAndsearch currentFile : StopandSearch) {
			System.out.println(currentFile.toCSVString());
		}

	}

	private static String percent(int num, int div) {
		double perc = ((double) num / div);
		perc *= 100;
		return String.format(" %.1f%%", perc);
	}

}
