package V1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class will be used to read in the files and actually just get unique
 * items within the file of create counters
 */
public class Data_Handling {

	// This is used for split to add Police into the object
	public final String SEP = ",";
	// All Files
	private ArrayList<CrimeStopAndsearch> mergedFiles = new ArrayList<>();

	/**
	 * This method accepts a String filename and reads it in for each line a new
	 * arraylist will be made so in future you can navigate through ever line
	 * 
	 * @param filename String FileNames
	 */
	public void readFile(String filename) throws FileNotFoundException {
		// Creates a file Object
		File csvFile = new File(filename);
		// This split is used to find the police force for that file
		String[] parts = filename.split("-");

		Scanner csvScan = new Scanner(csvFile);
		CrimeStopAndsearch StopandSearchtemp = null;
		csvScan.nextLine(); // read header
		while (csvScan.hasNextLine()) {
			String line = csvScan.nextLine();
			String[] temp = line.split(SEP, -1);
			// Adds Police Force to the list
			temp[3] = parts[3];
			// Puts the list back together after police has been entered
			String line2 = String.join(",", temp);
			StopandSearchtemp = new CrimeStopAndsearch(line2);
			mergedFiles.add(StopandSearchtemp);

		}
		csvScan.close();
	}

	/**
	 * Gets all files into a Arraylist
	 * 
	 * @return ArrayList of CrimeStopAndsearch
	 */
	public ArrayList<CrimeStopAndsearch> getmergedFiles() {
		return mergedFiles;
	}

	/**
	 * This method will be used to loop through the arraylist and print out all the
	 * files whilst also creating a counter to see how many successful searches
	 * there are
	 */
	void alloutputCrimes() {
		ArrayList<CrimeStopAndsearch> mergedFiles = getmergedFiles();
		int successful = 0, unsuccessful = 0, partial = 0;
		for (CrimeStopAndsearch line : mergedFiles) {

			int[] temp = SuccessfulSearch(line.Outcome);
			successful = successful + temp[0];
			unsuccessful = unsuccessful + temp[1];
			partial = partial + temp[2];
			line.toCSVString();

		}
		System.out.println("There are " + mergedFiles.size() + " recorded crimes; ");
		System.out.println(successful + " Successful Searches - " + percent(successful, mergedFiles.size()));
		System.out.println(partial + " Partial Successful Searches -" + percent(partial, mergedFiles.size()));
		System.out.println(unsuccessful + " Unsuccessful Searches -" + percent(unsuccessful, mergedFiles.size()));

	}

	/**
	 * This method is used to find the percent
	 * 
	 * @param num int num / div
	 * @param div int num / div
	 * @return String.format(" %.1f%%", perc);
	 */
	private static String percent(int num, int div) {
		double perc = ((double) num / div);
		perc *= 100;
		return String.format(" %.1f%%", perc);
	}

	/**
	 * This method will accept a String of Outcome_linked_to_object_of_search to
	 * calculate if that search was successful,unsuccessful and partial and return
	 * the values This method will mainly be used for counters
	 * 
	 * @param Outcome_linked_to_object_of_search String if true successful, false
	 *                                           partial else unsuccessful
	 * @return intArray Array of 3 positions 0=successful 1=unsuccessful 2=partial
	 */
	public int[] SuccessfulSearch(String Outcome_linked_to_object_of_search) {
		int successful = 0, unsuccessful = 0, partial = 0;

		if (Outcome_linked_to_object_of_search.equalsIgnoreCase("TRUE")) {
			successful++;
		}
		if (Outcome_linked_to_object_of_search.equalsIgnoreCase("FALSE")) {
			partial++;
		}
		if (Outcome_linked_to_object_of_search.equals(null) || Outcome_linked_to_object_of_search.equals("")) {
			unsuccessful++;
		}

		int[] intArray = new int[3];
		intArray[0] = successful;
		intArray[1] = unsuccessful;
		intArray[2] = partial;

		return intArray;

	}

	/**
	 * This method will be used as user validation for them to select a unique date
	 * but will collect the unique dates from another method called uniqueDate();
	 * 
	 * @return pickDate String for the existing unique dates in the list
	 */
	public String GetDate() {
		Data_Manipulation changeData = new Data_Manipulation();
		Scanner scan = new Scanner(System.in);
		// This method will collect all the unique dates in the merged Array
		List<String> dates = changeData.uniqueDate(mergedFiles);
		int choice = scan.nextInt();
		scan.nextLine();
		String pickDate = null;
		int i = 1;
		for (String date : dates) {
			if (i == choice) {
				pickDate = date;
			}
			i++;
		}
		while (pickDate == null) {
			i = 1;
			System.out.println("Please select a valid option");
			choice = scan.nextInt();
			scan.nextLine();
			for (String date : dates) {

				if (i == choice) {
					pickDate = date;
				}
				i++;
			}
		}
		// Returning a unique date of the users choosing
		return pickDate;
	}

	/**
	 * This method will be used as user validation for them to select a unique
	 * Gender but will collect the unique Gender from another method called
	 * uniqueGender();
	 * 
	 * @return pickGender String for the existing unique Genders in the list
	 */
	public String getGender() {
		// All GetAttributes will be repetitive code
		Data_Manipulation changeData = new Data_Manipulation();
		Scanner scan = new Scanner(System.in);
		List<String> genders = changeData.uniqueGender(mergedFiles);

		String pickGender = null;
		int i = 0;

		while (pickGender == null) {
			i = 1;
			int choice = scan.nextInt();
			scan.nextLine();
			for (String gender : genders) {
				if (i == choice) {
					pickGender = gender;

					return pickGender;

				}
				i++;
			}
			System.out.println("Please select a valid option");
		}

		return pickGender;

	}

	/**
	 * This method will be used as user validation for them to select a unique
	 * Ethnic but will collect the unique Ethnic from another method called
	 * uniqueEthnic();
	 * 
	 * @return pickEthnic String for the existing unique Ethnic in the list
	 */
	public String getEthnic() {
		Data_Manipulation changeData = new Data_Manipulation();
		Scanner scan = new Scanner(System.in);
		List<String> ethnics = changeData.uniqueEthnic(mergedFiles);

		String pickEthnic = null;
		int i = 1;

		while (pickEthnic == null) {
			i = 0;
			int choice = scan.nextInt();
			scan.nextLine();
			for (String ethnic : ethnics) {
				if (i == choice) {
					pickEthnic = ethnic;

					return pickEthnic;
				}
				i++;
			}
			System.out.println("Please select a valid option");
		}

		return pickEthnic;
	}

	/**
	 * This method will be used as user validation for them to select a unique
	 * PoliceForce but will collect the unique PoliceForce from another method called
	 * uniquePolice();
	 * 
	 * @return policeOP String for the existing uniquePolice in the list
	 */
	public String GetPoliceForce() {
		Data_Manipulation changeData = new Data_Manipulation();
		Scanner scan = new Scanner(System.in);
		List<String> policeForce = changeData.uniquePolice(mergedFiles);
		int choice = scan.nextInt();
		scan.nextLine();
		String policeOP = null;
		int i = 1;
		for (String police : policeForce) {
			if (i == choice) {
				policeOP = police;
			}
			i++;
		}
		while (policeOP == null) {
			i = 1;
			System.out.println("Please enter a Correct Police Force");
			choice = scan.nextInt();
			scan.nextLine();
			for (String police : policeForce) {
				if (i == choice) {
					policeOP = police;
				}
				i++;
			}
		}
		

		return policeOP;
	}

	
	/**
	 * This method will be used as user validation for them to select a unique
	 * legislation but will collect the unique legislation from another method called
	 * uniqueLeg();
	 * 
	 * @return leg String for the existing unique Legislation in the list
	 */
	public String GetLeg() {
		Data_Manipulation changeData = new Data_Manipulation();
		Scanner scan = new Scanner(System.in);
		List<String> legislation = changeData.uniqueLeg(mergedFiles);
		int choice = scan.nextInt();
		scan.nextLine();
		String leg = null;
		int i = 1;
		for (String legislationtemp : legislation) {
			if (i == choice) {
				leg = legislationtemp;
			}
			i++;
		}
		while (leg == null) {
			i = 0;
			System.out.println("Please enter a Correct legislation");
			choice = scan.nextInt();
			scan.nextLine();
			for (String police : legislation) {
				if (i == choice) {
					leg = police;
				}
				i++;
			}
		}

		return leg;
	}
	
	/**
	 * This method will be used as user validation for them to select a unique
	 * ObjectiveSearch but will collect the unique ObjectiveSearchs from another method called
	 * uniqueObjectOfSearch();
	 * 
	 * @return leg String for the existing unique Legislation in the list
	 */
	public String GetObjectiveSearch() {
		Data_Manipulation changeData = new Data_Manipulation();
		Scanner scan = new Scanner(System.in);
		List<String> objectOfSearch = changeData.uniqueObjectOfSearch(mergedFiles);
		int choice = scan.nextInt();
		int i = 0;
		String Search = null;
		for (String temps : objectOfSearch) {
			if (i == choice) {
				Search = temps;
			}
			i++;
		}
		while (Search == null) {
			i = 0;
			System.out.println("Please enter a Correct legislation");
			choice = scan.nextInt();
			scan.nextLine();
			for (String temps : objectOfSearch) {
				if (i == choice) {
					Search = temps;
				}
				i++;
			}
		}

		return Search;
	}
	
}
