package V2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeMap;

public class Data_Handling {

	public final String SEP = ",";
	// private ArrayList<StopAndSearchFiles> fileList = new ArrayList<>();
	private ArrayList<CrimeStopAndsearch> mergedFiles = new ArrayList<>();
	private TreeMap<Integer, CrimeStopAndsearch> tmap = new TreeMap<Integer, CrimeStopAndsearch>();
	public int i =0;

	public void readFile(String filename) throws FileNotFoundException {
		// ArrayList<CrimeStopAndsearch> StopandSearch = new ArrayList<>();

		File csvFile = new File(filename);
		String[] parts = filename.split("-");

		Scanner csvScan = new Scanner(csvFile);
		CrimeStopAndsearch StopandSearchtemp = null;
		csvScan.nextLine(); // read header
		while (csvScan.hasNextLine()) {
			String line = csvScan.nextLine();
			String[] temp = line.split(SEP, -1);
			temp[3] = parts[3];
			// System.out.println(temp[3]);

			String line2 = String.join(",", temp);

			StopandSearchtemp = new CrimeStopAndsearch(line2);
			mergedFiles.add(StopandSearchtemp);
			tmap.put(i,StopandSearchtemp);
			i++;

		}
		// StopAndSearchFiles File = new StopAndSearchFiles(StopandSearch);
		// fileList.add(File);
		csvScan.close();
	}

	public void tempPrint() {
		Set set = tmap.entrySet();
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	         Map.Entry mentry = (Map.Entry)iterator.next();
	         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
	         //System.out.println(mentry.getValue());
	         System.out.println(((CrimeStopAndsearch)mentry.getValue()).Legislation);
	      }

	   }
}
