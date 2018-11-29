package V1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/** This class gets each unique directory from txt file
 */
public class CSVFiles {
	/**
	 * This Method will read in a txt file and each line will consist of a Directory
	 * and for each directory it will call read foleder which will read all files in that directory
	 * @throws IOException
	 */
	public void readInFilesDir() throws IOException {

		FileReader fr = new FileReader("Data//ExcelDIR.txt");
		BufferedReader br = new BufferedReader(fr);
		String tempdata;
		
		while ((tempdata = br.readLine()) != null) {
			File aFile = new File(tempdata);
			FolderReader.readFolder(aFile);
		}
		br.close();

	}

}
