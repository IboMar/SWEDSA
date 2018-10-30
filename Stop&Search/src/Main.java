
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
				+ "C. List of all the possible Objects of Search"
				+ "D. Highest Sucessful Legislation Type For A Specific Month \r\n" + "Q. -Quit- \r\n");
		Menu = scan.nextLine().toUpperCase();

		switch (Menu) {
		case "A":
			allTheFiles.outputCrimes();
			break;

		case "B":
			int choice = FolderReader.ListAllFiles();

			StopAndSearchFiles temp = allTheFiles.getFileList().get(choice);
			changeData.LegislationHighest(temp);
			break;

		case "C":
			choice = FolderReader.ListAllFiles();
			temp = allTheFiles.getFileList().get(choice);
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

			choice = FolderReader.ListAllFiles();
			temp = allTheFiles.getFileList().get(choice);
			changeData.LegislationHighest(temp);

			break;

		}
		
		}while(!(Menu.equals("Q")));
		scan.close();
	}
}
