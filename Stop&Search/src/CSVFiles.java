import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CSVFiles {
	/**
	 * This method reads in a single file and passes it to FolderReader
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
