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
	private ArrayList<CrimeStopAndsearch> mergedFiles = new ArrayList<>();
	
	
	public void readFile(String filename) throws FileNotFoundException {
		ArrayList<CrimeStopAndsearch> StopandSearch = new ArrayList<>();

		File csvFile = new File(filename);
		Scanner csvScan = new Scanner(csvFile);
		CrimeStopAndsearch StopandSearchtemp = null;
		csvScan.nextLine(); // read header
		while (csvScan.hasNextLine()) {
			String line = csvScan.nextLine();
			StopandSearchtemp = new CrimeStopAndsearch(line);
			mergedFiles.add(StopandSearchtemp);
			
		}

//		StopAndSearchFiles File = new StopAndSearchFiles(StopandSearch);
//		fileList.add(File);

		csvScan.close();
	}

	public ArrayList<StopAndSearchFiles> getFileList() {
		return fileList;
	}

	public ArrayList<CrimeStopAndsearch> getmergedFiles() {
		return mergedFiles;
	}

	
	void outputCrimes() {
		List<String> fileName = FolderReader.getbasicStop_Search();
		int i = 0;
		while (i < fileName.size()) {
			for (StopAndSearchFiles file : fileList) {
				int successful = 0, unsuccessful = 0, partial = 0;
				System.out.println(fileName.get(i));
				i++;
				for (CrimeStopAndsearch currentCrime : file.getStopAndSearchFiles()) {

					
						int[] temp = SuccessfulSearch(currentCrime.Outcome_linked_to_object_of_search);
						successful = successful + temp[0];
						unsuccessful = unsuccessful + temp[1];
						partial = partial + temp[2];
						System.out.println(currentCrime.toCSVString());
					
				}
				System.out.println("There are " + file.getListSize() + " recorded crimes; ");
				System.out.println(
						successful + " Successful Searches - " + percent(successful, file.getListSize()));
				System.out.println(partial + " Partial Successful Searches -" + percent(partial, file.getListSize()));
				System.out.println(unsuccessful + " Unsuccessful Searches -" + percent(unsuccessful, file.getListSize()));
				
			}
		}
	}
	
	void alloutputCrimes() {
		ArrayList<CrimeStopAndsearch> mergedFiles = getmergedFiles();
		int successful = 0, unsuccessful = 0, partial = 0;
			for (CrimeStopAndsearch line : mergedFiles) {

						int[] temp = SuccessfulSearch(line.Outcome_linked_to_object_of_search);
						successful = successful + temp[0];
						unsuccessful = unsuccessful + temp[1];
						partial = partial + temp[2];
						System.out.println(line.toCSVString());
					
				}
				System.out.println("There are " + mergedFiles.size() + " recorded crimes; ");
				System.out.println(
						successful + " Successful Searches - " + percent(successful, mergedFiles.size()));
				System.out.println(partial + " Partial Successful Searches -" + percent(partial, mergedFiles.size()));
				System.out.println(unsuccessful + " Unsuccessful Searches -" + percent(unsuccessful, mergedFiles.size()));
				
			}
		
	
	
	
	void testOutput() {
		ArrayList<CrimeStopAndsearch> mergedFiles = getmergedFiles();
		int i = 0;
		System.out.println("2222");
		
			for(CrimeStopAndsearch line : mergedFiles) {
			System.out.print(line.toCSVString() + "\n");
			}
			
			
			
		
	}
	
	private static String percent(int num, int div) {
		double perc = ((double) num / div);
		perc *= 100;
		return String.format(" %.1f%%", perc);
	}

	public int[] SuccessfulSearch (String Outcome_linked_to_object_of_search) {
		int successful = 0, unsuccessful = 0, partial = 0;
			
			
	
			if (Outcome_linked_to_object_of_search.equalsIgnoreCase("TRUE")) {
				successful++;
			}
			if(Outcome_linked_to_object_of_search.equalsIgnoreCase("FALSE")) {
				partial++;
			}
			if(Outcome_linked_to_object_of_search.equals(null) || Outcome_linked_to_object_of_search.equals("")) {
				unsuccessful++;
				}
			
	
		int[] intArray = new int[3];
		intArray[0] = successful;
		intArray[1] = unsuccessful;
		intArray[2] = partial;
		
		return intArray;

	}
}
