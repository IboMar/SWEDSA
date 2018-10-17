
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
		CSVFiles fileDIR = new CSVFiles();
		fileDIR.readInFilesDir();
		List<String> fileDIRList = FolderReader.getbasicStop_Search();
		Data_Handling allTheFiles = new Data_Handling();	
		for (String file : fileDIRList) {
			allTheFiles.readFile(file);
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("a. By Crime type (lexicographic order)\r\n"
				+ "b. By Last outcome category (again, lexicographic order)\r\n"
				+ "c. By LSOA Name (this is as presented in the file)" + "");
		String Menu = scan.nextLine();

		switch (Menu) {
		case "a":
			allTheFiles.outputCrimes();
			break;

		case "b":
			allTheFiles.outputCrimes();
			break;

		case "c":
			allTheFiles.outputCrimes();
			break;

		}
	}
}
