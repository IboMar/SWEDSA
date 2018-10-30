import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FolderReader {

	public static List<String> basicCrimesCVS = new ArrayList<String>();
	public static List<String> Stop_Search = new ArrayList<String>();
	
	public static void readFolder(final File folder) {
		
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	readFolder(fileEntry);
	        	
	        	
	        	
	        } else {
	        	
	        	if(fileEntry.getName().contains("stop-and-search")) {
	        		//System.out.println(fileEntry.getName());
	        		Stop_Search.add(folder.toPath() + "\\" + fileEntry.getName());
//	        	}else {
//	        		//System.out.println(fileEntry.getName());
//	        	basicCrimesCVS.add(folder.toPath() + "\\" + fileEntry.getName());
//	        	}
	        	
	        	
	        	
	     
	        	}
	        }
	    }
	}
	
	
	public static List<String> getbasicCrimesCVS() {
	       return basicCrimesCVS;
	   }
	
	public static List<String> getbasicStop_Search() {
	       return Stop_Search;
	   }
	
	
	public static int ListAllFiles() {
		Data_Handling allTheFiles = new Data_Handling();
		Scanner scan = new Scanner(System.in);
		List<String> fileName = FolderReader.getbasicStop_Search();
		int i = 0;
		System.out.println("Please pick a Month:");
		while (i < fileName.size()) {
			System.out.println( i + ":" + fileName.get(i));
			i++;
		}
		int choice = scan.nextInt();
		return choice;
		
		}
}

	
	
	/*
	 * for(FolderReader instanceFiles : Files) { for (final File fileEntry :
	 * folder.listFiles()) { if (fileEntry.isDirectory()) {
	 * listFilesForFolder(fileEntry); } else {
	 * System.out.println(fileEntry.getName()); } } }
	 */
