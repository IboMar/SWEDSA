package V1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Data_Handling {

	public final String SEP = ",";
	private ArrayList<CrimeStopAndsearch> mergedFiles = new ArrayList<>();

	public void readFile(String filename) throws FileNotFoundException {
		File csvFile = new File(filename);
		String[] parts = filename.split("-");

		Scanner csvScan = new Scanner(csvFile);
		CrimeStopAndsearch StopandSearchtemp = null;
		csvScan.nextLine(); // read header
		while (csvScan.hasNextLine()) {
			String line = csvScan.nextLine();
			String[] temp = line.split(SEP, -1);
			temp[3] = parts[3];

			String line2 = String.join(",", temp);

			StopandSearchtemp = new CrimeStopAndsearch(line2);
			mergedFiles.add(StopandSearchtemp);

		}
		csvScan.close();
	}

	public ArrayList<CrimeStopAndsearch> getmergedFiles() {
		return mergedFiles;
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

	private static String percent(int num, int div) {
		double perc = ((double) num / div);
		perc *= 100;
		return String.format(" %.1f%%", perc);
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

	public String GetDate() {
		Data_Manipulation changeData = new Data_Manipulation();
		Scanner scan = new Scanner(System.in);
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
			i = 0;
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
		scan.close();
		return pickDate;
	}

	public String getGender() {
		// ArrayList<CrimeStopAndsearch> mergedFiles = getmergedFiles();
		Data_Manipulation changeData = new Data_Manipulation();
		Scanner scan = new Scanner(System.in);
		List<String> genders = changeData.uniqueGender(mergedFiles);

		String pickGender = null;
		int i = 1;

		while (pickGender == null) {
			i = 0;
			int choice = scan.nextInt();
			scan.nextLine();
			for (String gender : genders) {
				if (i == choice) {
					pickGender = gender;
					scan.close();
					return pickGender;

				}
				i++;
			}
			System.out.println("Please select a valid option");
		}
		scan.close();
		return pickGender;

	}

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
					scan.close();
					return pickEthnic;
				}
				i++;
			}
			System.out.println("Please select a valid option");
		}
		scan.close();
		return pickEthnic;
	}

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
			i = 0;
			System.out.println("Please eneter a Correct Police Force");
			choice = scan.nextInt();
			scan.nextLine();
			for (String police : policeForce) {
				if (i == choice) {
					policeOP = police;
				}
				i++;
			}
		}
		scan.close();
		return policeOP;
	}

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
			System.out.println("Please eneter a Correct legislation");
			choice = scan.nextInt();
			scan.nextLine();
			for (String police : legislation) {
				if (i == choice) {
					leg = police;
				}
				i++;
			}
		}
		scan.close();
		return leg;
	}
}
