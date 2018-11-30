package V2;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		List<CrimeStopAndsearch> policedateArray = null;
		ArrayList<CrimeStopAndsearch> temp = null;
		Data_Manipulation changeDataV2 = new Data_Manipulation();
		CSVFiles fileDIR = new CSVFiles();
		fileDIR.readInFilesDir();
		List<String> fileDIRList = FolderReader.getbasicStop_Search();
		Data_Handling allTheFiles = new Data_Handling();
		for (String file : fileDIRList) {
			allTheFiles.readFile(file);
		}
		allTheFiles.loadTrees();
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
				Map<String, List<CrimeStopAndsearch>> objectOfSearchTree = allTheFiles.getObjectOfSearchTree();
				System.out.println("\nDo you want to carry out a obeject of search on this File?: \r\n1. Yes \r\n2. No");
				int yesno = scan.nextInt();
				scan.nextLine();
				if (yesno == 1) {
					System.out.println("Please select an object of search:  ");
					allTheFiles.userChoice(objectOfSearchTree);
				}
				break;
			case "C":
				allTheFiles.alloutputCrimes();
				break;
			case "D":
				//Set<String> uniqueDates = allTheFiles.getUniqueAttributes("date");
				String uniqueDate =allTheFiles.printAttribute("date");
				allTheFiles.highestTotalLegislationForAGivenMonth(uniqueDate, 1);	

				break;
			case "E":
				uniqueDate = allTheFiles.printAttribute("date");
				allTheFiles.highestTotalLegislationForAGivenMonth(uniqueDate,2);	
				break;

			case "F":
				System.out.println("Please pick a option \r\n1. F(i) \r\n2. F(ii)");
				yesno = scan.nextInt();
				scan.nextLine();
				if (yesno == 1) {
					String uniquePolice =allTheFiles.printAttribute("date");
					String uniqueMonth =allTheFiles.printAttribute("police");
					policedateArray = (allTheFiles.highestTotalEthnicForAGivenMonthAndPolice(uniqueMonth,uniquePolice));
				}
				if (yesno == 2) {
					String uniqueLegislation =allTheFiles.printAttribute("legislation");
					allTheFiles.highestTotalEthnicForAGivenMonthAndPolice(uniqueLegislation);
				}
				
				break;
			case "G":
				if(policedateArray == null) {
					System.out.println("Please complete option F(i) to collect your list: ");
				}else {
					changeDataV2.chronoLogicalOrder(policedateArray);
				}
				
				break;
			
			case "H":
				System.out.println("Please pick an ethnicity");
				String uniqueEthnic = allTheFiles.printAttribute("ethnic");
				System.out.println("Please pick a gender");
				String uniqueGender = allTheFiles.printAttribute("gender");
				allTheFiles.EthnicityAndGenderSearch(uniqueGender, uniqueEthnic);
			
				
				
				break;
			}
		} while (!(Menu.equals("Q")));
		scan.close();
	}
}
