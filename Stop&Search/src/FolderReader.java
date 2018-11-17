import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 *	Contains {@link #readFolder} method.
 */
public class FolderReader {

	public static List<String> basicCrimesCVS = new ArrayList<String>();
	public static List<String> Stop_Search = new ArrayList<String>();
	/**
	 * 
	 * @param folder 
	 */
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
	
	
	
}

	
	
	/*
	 * for(FolderReader instanceFiles : Files) { for (final File fileEntry :
	 * folder.listFiles()) { if (fileEntry.isDirectory()) {
	 * listFilesForFolder(fileEntry); } else {
	 * System.out.println(fileEntry.getName()); } } }
	 */
