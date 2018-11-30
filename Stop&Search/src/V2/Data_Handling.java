package V2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import V1.Data_Manipulation;

public class Data_Handling {

	public final String SEP = ",";
	private ArrayList<CrimeStopAndsearch> mergedFiles = new ArrayList<>();
	private TreeMap<String, List<CrimeStopAndsearch>> legislationTree = new TreeMap<>();
	private Map<String, List<CrimeStopAndsearch>> objectOfSearchTree = new HashMap<>();
	private Map<String, List<CrimeStopAndsearch>> ethnicSearchTree = new HashMap<>();
	private Set<String> uniqueDates = new HashSet<String>();
	private Set<String> uniqueLegislation = new HashSet<String>();
	private Set<String> uniquePoliceForce = new HashSet<String>();
	private Set<String> uniqueEthnic = new HashSet<String>();
	private Scanner read = new Scanner(System.in);

	public void readFile(String filename) throws FileNotFoundException {

		File csvFile = new File(filename);
		String[] parts = filename.split("-");
		Scanner csvScan = new Scanner(csvFile);
		csvScan.nextLine(); // read header
		while (csvScan.hasNextLine()) {
			String line = csvScan.nextLine();
			String[] temp = line.split(SEP, -1);
			temp[3] = parts[3];
			String line2 = String.join(",", temp);
			mergedFiles.add(new CrimeStopAndsearch(line2));
		}
		csvScan.close();
	}

	public String printAttribute(String selection) {
		// This method will collect all the unique dates in the merged Array
		Set<String> uniqueAttributes = getUniqueAttributes(selection);
		int x = 1;
		System.out.println("Please select one of the following options for " + selection);
		for (String attribute : uniqueAttributes) {
			System.out.println(x++ + ". " + attribute);
		}
		String pickAttribute = null;
		int i = 1;
		while (pickAttribute == null) {
			int choice = read.nextInt();
			read.nextLine();
			for (String attribute : uniqueAttributes) {

				if (i == choice) {
					pickAttribute = attribute;
					return pickAttribute;
				}
				i++;
			}
			System.out.println("Please select a valid option.");
		}
		// Returning a unique date of the users choosing
		return pickAttribute;
	}

	public Set<String> getUniqueAttributes(String selection) {
		switch (selection) {
		case "date":
			if (uniqueDates.isEmpty()) {

				for (CrimeStopAndsearch currentCrime : mergedFiles) {
					if (currentCrime.Date == null || currentCrime.Date.length() == 0) {

					} else {
						String substringDate = currentCrime.Date;
						substringDate = substringDate.substring(0, 7);
						uniqueDates.add(substringDate);

					}
				}

			}

			return uniqueDates;
		case "police":
			if (uniquePoliceForce.isEmpty()) {
				for (CrimeStopAndsearch currentCrime : mergedFiles) {

					if (currentCrime.Policing_operation == null || currentCrime.Policing_operation.length() == 0) {

					} else {
						uniquePoliceForce.add(currentCrime.Policing_operation);

					}
				}

			}
			return uniquePoliceForce;

		case "legislation":
			if (uniqueLegislation.isEmpty()) {
				for (CrimeStopAndsearch currentCrime : mergedFiles) {
					if (currentCrime.Legislation == null || currentCrime.Legislation.length() == 0) {

					} else {
						uniqueLegislation.add(currentCrime.Legislation);

					}
				}

			}
			return uniqueLegislation;
		case "ethnic":
			if (uniqueEthnic.isEmpty()) {
				for (CrimeStopAndsearch currentCrime : mergedFiles) {
					if (currentCrime.Self_defined_ethnicity == null
							|| currentCrime.Self_defined_ethnicity.length() == 0) {
					} else {
						uniqueEthnic.add(currentCrime.Self_defined_ethnicity);
					}
				}

			}
			return uniqueEthnic;
		}
		return null;

	}

	public void loadTrees() {
		for (CrimeStopAndsearch e : mergedFiles) {
			List<CrimeStopAndsearch> legList = legislationTree.get(e.Legislation);
			if (legList == null) {
				legList = new ArrayList<>();
				legislationTree.put(e.Legislation, legList);
			}
			legList.add(e);

			List<CrimeStopAndsearch> objectSearchList = objectOfSearchTree.get(e.Object_of_search);
			if (objectSearchList == null) {
				objectSearchList = new ArrayList<>();
				objectOfSearchTree.put(e.Object_of_search, objectSearchList);
			}
			objectSearchList.add(e);
			List<CrimeStopAndsearch> ethnicList = ethnicSearchTree.get(e.Self_defined_ethnicity);
			if (ethnicList == null) {
				ethnicList = new ArrayList<>();
				ethnicSearchTree.put(e.Self_defined_ethnicity, ethnicList);
			}
			ethnicList.add(e);

		}
		/*
		 * int count = 0; long start = System.currentTimeMillis();
		 * List<CrimeStopAndsearch> matches =
		 * objectOfSearchTree.get("Controlled drugs"); for (CrimeStopAndsearch stop :
		 * matches) count++; // System.out.println(stop); long total =
		 * System.currentTimeMillis() - start; System.out.println("This took " + total +
		 * " to count " + count);
		 * 
		 * long start2 = System.nanoTime();
		 * 
		 * int count2 = 0; for (CrimeStopAndsearch stop : mergedFiles) if
		 * (stop.Object_of_search.equals("Controlled drugs")) count2++; long total2 =
		 * System.currentTimeMillis() - start2; System.out.println("This took " + total2
		 * + " to count " + count2);
		 * 
		 * System.out.println("set size " + mergedFiles.size());
		 */
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
		System.out.println(successful + " Successful Searches - " + percent(successful, mergedFiles.size()));
		System.out.println(partial + " Partial Successful Searches -" + percent(partial, mergedFiles.size()));
		System.out.println(unsuccessful + " Unsuccessful Searches -" + percent(unsuccessful, mergedFiles.size()));

	}

	public ArrayList<CrimeStopAndsearch> getmergedFiles() {
		return mergedFiles;
	}

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

	private static String percent(int num, int div) {
		double perc = ((double) num / div);
		perc *= 100;
		return String.format(" %.1f%%", perc);
	}

	public TreeMap<String, List<CrimeStopAndsearch>> getLegislationTree() {
		return legislationTree;
	}

	public Map<String, List<CrimeStopAndsearch>> getObjectOfSearchTree() {
		int i = 0;
		for (String temp : objectOfSearchTree.keySet()) {
			if (temp.isEmpty()) {
				System.out.println(i + " TBD");
			} else {
				System.out.println(i + " " + temp);
			}
			i++;
		}
		return objectOfSearchTree;
	}

	public String userChoice(Map<String, List<CrimeStopAndsearch>> Unique) {
		String userChoice = null;
		int choiceCounter = 0;
		for (String temp : Unique.keySet()) {
			if (temp.isEmpty())
				System.out.println(choiceCounter + " NULL");
			else
				System.out.println(choiceCounter + " " + temp);

			choiceCounter++;
		}
		choiceCounter = 0;
		Scanner scan = new Scanner(System.in);
		int pickObjectOfSearch = scan.nextInt();
		for (String uniqueSeach : Unique.keySet()) {
			if (pickObjectOfSearch == choiceCounter) {
				userChoice = uniqueSeach;
				List<CrimeStopAndsearch> List = Unique.get(uniqueSeach);
				for (CrimeStopAndsearch looping : List) {
					System.out.println(looping.toCSVString());
				}
			}
			choiceCounter++;
		}
		return userChoice;
	}

	/**
	 * This method will be used to accept a specific date and then find find the
	 * most crimes for each legislation in that given month
	 * 
	 * @param UserDate String user date
	 */
	public void highestTotalLegislationForAGivenMonth(String UserDate) {
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		for (String temp : legislationTree.keySet()) {
			int counter = 0;
			List<CrimeStopAndsearch> legislationList = legislationTree.get(temp);
			for (CrimeStopAndsearch currentCrime : legislationList) {
				if (currentCrime.Date.contains(UserDate)) {
					counter++;
				}
			}
			hashMap.put(temp, counter);
		}
		String max = Collections.max(hashMap.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue())
				.getKey();
		int highestCounet = hashMap.get(max);
		System.out.println(max + "Total Crimes: " + highestCounet);
	}

	/** This method will be used to find the highest stopandsearch on ethnic for a given date and police 
	 * 
	 * @param police String user police
	 * @param UserDate String user date
	 */
	public void highestTotalEthnicForAGivenMonthAndPolice(String police, String UserDate) {
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		for (String temp : ethnicSearchTree.keySet()) {
			int counter = 0;
			List<CrimeStopAndsearch> ethnicList = ethnicSearchTree.get(temp);
			for (CrimeStopAndsearch currentCrime : ethnicList) {
				if (currentCrime.Date.contains(UserDate) && currentCrime.Policing_operation.contains(police)) {
					counter++;
				}
			}
			hashMap.put(temp, counter);
		}
		String max = Collections.max(hashMap.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue())
				.getKey();
		int highestCounet = hashMap.get(max);
		System.out.println(max + "Total Crimes: " + highestCounet);
	}

}
