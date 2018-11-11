
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<CrimeStopAndsearch> temp = null;
		Data_Manipulation changeData = new Data_Manipulation();
		CSVFiles fileDIR = new CSVFiles();
		fileDIR.readInFilesDir();
		List<String> fileDIRList = FolderReader.getbasicStop_Search();
		Data_Handling allTheFiles = new Data_Handling();
		for (String file : fileDIRList) {
			allTheFiles.readFile(file);
		}
		Scanner scan = new Scanner(System.in);

		String Menu = "";
		do {
			System.out.println("A. List all distinct search purposes and searches for a specified purpose\r\n"
					+ "C. Determine how many Stop and Searches met the following criteria \r\n"
					+ "D. Find and report the legislation which produces the highest Stop and Search frequency for a specified month\r\n"
					+ "E. Find and report the legislation which produces the highest successful Stop and Search frequency for a specified month \r\n"
					+ "F. Find which (self-determined) ethnic group has the highest number of recorded stop and search events \r\n"
					+ "G. List, in reverse chronological order (i.e. most recent first), the search data found for F.i \r\n"
					+ "H. One more analysis (search and/or sort) feature of your choosing that uses multiple search attributes\r\n"
					+ "Q. -Quit- \r\n");
			Menu = scan.nextLine().toUpperCase();

			switch (Menu) {

			case "A":
				temp = allTheFiles.getmergedFiles();
				Set<String> uniqueobjectOfSearch = changeData.objectOfSearch(temp);
				System.out.println("Do you want to carry out a obeject of search on this File?: \r\n Y/N");
				String yesno = scan.nextLine();
				if (yesno.equalsIgnoreCase("Y")) {
					System.out.println("Please Select a object of search");
					String pickObjectOfSearch = scan.nextLine();
					for (String uniqueSeach : uniqueobjectOfSearch) {
						if (pickObjectOfSearch.equals(uniqueSeach)) {
							changeData.outPutOneObjectOfSearch(temp, pickObjectOfSearch);
						}
					}
				}
				break;

			case "C":
				allTheFiles.alloutputCrimes();

			case "D":
				String pickDate = allTheFiles.GetDate();
				changeData.highestTotal(allTheFiles.getmergedFiles(),pickDate);
				break;

			case "E":
				pickDate = allTheFiles.GetDate();
				changeData.allFilesLegislationHighestSucessful(allTheFiles.getmergedFiles(), pickDate);
				break;

			case "F":
				pickDate = allTheFiles.GetDate();
				String pickPolice = allTheFiles.GetPoliceForce();
				System.out.println(pickPolice);
				changeData.ethnic(allTheFiles.getmergedFiles(), pickDate, pickPolice);
				break;
			}

		} while (!(Menu.equals("Q")));
		scan.close();
	}
}
