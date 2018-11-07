
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
		System.out.println("A. Out Put All Crimes\r\n" + "B. Highest Legislation Type For A Specific Month \r\n"
				+ "C. List of all the possible Objects of Search \r\n"
				+ "D. Highest Sucessful Legislation Type For A Specific Month \r\n" + "E. Ethnic \r\n" + "F. Ethnic For Each Leg \r\n" + "Q. -Quit- \r\n");
		Menu = scan.nextLine().toUpperCase();

		switch (Menu) {
		case "A":
			allTheFiles.alloutputCrimes();
			break;

		case "B":
			temp = allTheFiles.getmergedFiles();
			changeData.uniqueDate(temp);
			System.out.println("Please choose a date");
			String pickDate = scan.nextLine();
			ArrayList<CrimeStopAndsearch> dates = changeData.outPutOneDate(temp, pickDate);
			changeData.highestTotal(dates);
			break;

		case "C":
			
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
		case "D":
			temp = allTheFiles.getmergedFiles();
			changeData.uniqueDate(temp);
			System.out.println("Please choose a date");
			pickDate = scan.nextLine();
			dates = changeData.outPutOneDate(temp, pickDate);
			changeData.allFilesLegislationHighestSucessful(dates);
			
			
			
//			changeData.LegislationHighestSucessful(temp);

			break;
			
			
		case "E":
//			
//			System.out.println("View highest number of crimes commited by ethnicgroup based on: \n1: based on that recorded for a specific month and police force \n2: based on that recorded for a specific legislation");
//			int choice = scan.nextInt();
//			switch(choice) {
//			case 1:
//				temp = allTheFiles.getmergedFiles();
//				changeData.uniqueDate(temp);
//				System.out.println("Please choose a date");
//				pickDate = scan.nextLine();
//				dates = changeData.outPutOneDate(temp, pickDate);
//				changeData.uniquePoliceForce(dates);
//				break;
//			case 2:
//				
//				break;
//			}
//			choice = FolderReader.ListAllFiles();
//			temp = allTheFiles.getFileList().get(choice);
//			changeData.ethnic(temp);

			break;
			
		case "F":

//			choice = FolderReader.ListAllFiles();
//			temp = allTheFiles.getFileList().get(choice);
//			changeData.ethnicForLeg(temp);

			break;

		}
		
		}while(!(Menu.equals("Q")));
		scan.close();
	}
}
