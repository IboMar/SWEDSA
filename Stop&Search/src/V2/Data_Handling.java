package V2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Data_Handling {

	public final String SEP = ",";
	private ArrayList<CrimeStopAndsearch> mergedFiles = new ArrayList<>();
	//TreeMap<Integer, CrimeStopAndsearch> map = new TreeMap<Integer, CrimeStopAndsearch>();
	AVLTree tree = new AVLTree();

	public void readFile(String filename) throws FileNotFoundException {

		File csvFile = new File(filename);
		String[] parts = filename.split("-");

		Scanner csvScan = new Scanner(csvFile);
		csvScan.nextLine(); // read header
		while (csvScan.hasNextLine()) {
			String line = csvScan.nextLine();
			String[] temp = line.split(SEP, -1);
			temp[3] = parts[3];
			//System.out.println(temp[3]);
			
			String line2 = String.join(",", temp);
			//map.put(new CrimeStopAndsearch(line2),i);
			mergedFiles.add(new CrimeStopAndsearch(line2));
		}
		csvScan.close();
	}
	
	public void dostuff() {
		for(CrimeStopAndsearch e: mergedFiles) {
			tree.root = tree.insert(tree.root, e); 
		}
		
	}
	
}
