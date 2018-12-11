package V1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * The main purpose of this class will be to call the methods to Read/Save the files
 * After that is complete this class and method will just be a case switch for the user
 * options to look at the data 
 */

public class Main {

	public static void main(String[] args) throws IOException {
		//TempArray created for task G where it will use the data from F(i)
		List<CrimeStopAndSearch> policeDateArray = null;
		//Creates objects to access Classes in a none static way
		Scanner scan = new Scanner(System.in);
		Data_Manipulation changeData = new Data_Manipulation();
		CSVFiles fileDIR = new CSVFiles();
		Data_Handling allTheFiles = new Data_Handling();
		
		//Gets all Folders and calls readFolder to read each file in that folder for all folders 
		//and creates a list which we can access to read each file
		fileDIR.readInFilesDir();
		//Gets the list of all files
		List<String> fileDIRList = FolderReader.getbasicStop_Search();
		//Loop around the list for every file read it in
		for (String file : fileDIRList) {
			allTheFiles.readFile(file);
		}
		
		//USER MENU
		String Menu = "";
		do {
			scan = new Scanner(System.in);
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
				ArrayList<CrimeStopAndSearch>temp = allTheFiles.getMergedFiles();
				List<String> uniqueObjectOfSearch = changeData.uniqueObjectOfSearch(temp);
				System.out.println("Do you want to carry out a obeject of search on this File?: \r\n Y/N");
				String yesno = scan.nextLine();
				if (yesno.equalsIgnoreCase("Y")) {
					System.out.println("Please Select a object of search");
					String pickObjectOfSearch = allTheFiles.GetObjectiveSearch();
					for (String uniqueSeach : uniqueObjectOfSearch) {
						if (pickObjectOfSearch.equals(uniqueSeach)) {
							changeData.outPutOneObjectOfSearch(temp, pickObjectOfSearch);
						}
					}
				}
				break;

			case "C":
				allTheFiles.allOutputCrimes();
				break;

			case "D":
				System.out.println("Please pick a date");
				String pickDate = allTheFiles.GetDate();
				changeData.highestTotal(allTheFiles.getMergedFiles(),pickDate);
				break;

			case "E":
				System.out.println("Please pick a date");
				pickDate = allTheFiles.GetDate();
				changeData.allFilesLegislationHighestSucessful(allTheFiles.getMergedFiles(), pickDate);
				break;

			case "F":
				System.out.println("1: based on that recorded for a specific month and police force.\n"
						+ "2. based on that recorded for a specific legislation");
				String select = scan.nextLine();
				switch(select) {
				case "1":
				System.out.println("Please pick a date");
				pickDate = allTheFiles.GetDate();
				System.out.println("Please pick a police force");
				String pickPolice = allTheFiles.GetPoliceForce();
				System.out.println(pickPolice);
				policeDateArray =
				changeData.ethnic(allTheFiles.getMergedFiles(), pickDate, pickPolice);
				break;
				case "2":
				System.out.println("================================================");
				System.out.println("Please pick a legislation");
				String pickLegislation = allTheFiles.GetLeg();
				changeData.ethnicLeg(allTheFiles.getMergedFiles(), pickLegislation);
				break;
				}
				break;
			case "G":
				if(policeDateArray !=null) {
					
					changeData.chronoLogicalOrder(policeDateArray);
				}
				else{
					System.out.println("Please use (F. Find which (self-determined) ethnic group has the highest number of recorded stop and search events)\nbefore listing in chronological order.");
				}
				break;
			
			case "H":
				System.out.println("Please pick a gender");
				String pickGender = allTheFiles.getGender();
				System.out.println("Please pick an ethnicity");
				String pickEthnic = allTheFiles.getEthnic();
				changeData.sortByLegislation(allTheFiles.getMergedFiles(), pickGender, pickEthnic);
				break;
			}
			

		} while (!(Menu.equals("Q")));
		scan.close();
	}
}
