package V2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/** This class gets each unique directory from txt file
 */
public class CSVFiles {
	/**
	 * This Method will read in a txt file and each line will consist of a Directory
	 * and for each directory it will call read folder which will read all files in that directory
	 * @throws IOException
	 */
	public void readInFilesDir() throws IOException {

		FileReader fReader = new FileReader("Data//ExcelDIR.txt");
		BufferedReader bReader = new BufferedReader(fReader);
		String tempdata;
		
		while ((tempdata = bReader.readLine()) != null) {
			File aFile = new File(tempdata);
			FolderReader.readFolder(aFile);
		}
		bReader.close();

	}

}
