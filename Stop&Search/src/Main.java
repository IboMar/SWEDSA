
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
		System.out.println("a. Out Put All Crimes\r\n"
				+ "b. Highest Legislation Type For A Specific Month \r\n"
				+ "c. idk" + "");
		String Menu = scan.nextLine();

		switch (Menu) {
		case "a":
			allTheFiles.outputCrimes();
			break;

		case "b":
			List<String> fileName = FolderReader.getbasicStop_Search();
			int i = 0;
			System.out.println("Please pick a Month:");
			while (i < fileName.size()) {
				System.out.println( i + ":" + fileName.get(i));
				i++;
			}
			int choice = scan.nextInt();
			StopAndSearchFiles temp = allTheFiles.getFileList().get(choice);
			changeData.LegislationHighest(temp);
			
			break;

		case "c":
			for(StopAndSearchFiles oneFile : allTheFiles.getFileList()) {
				for(CrimeStopAndsearch currentCrime : oneFile.getStopAndSearchFiles()) {
					System.out.println(currentCrime.toCSVString());
				}
			}
	
			break;

		}
	}
}
