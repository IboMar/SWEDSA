import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFiles {
	
	
	

	
	public static  void readInFilesDir() throws IOException {	
		
	FileReader fr = new FileReader("Data//ExcelDIR.txt");
	 BufferedReader br=new BufferedReader(fr);
     String tempdata;
     int i = 0;

     while((tempdata=br.readLine()) != null ){
    	 
    	 File xd = new File(tempdata);
    	 FolderReader.FolderReader(xd);
         i++;
     }

     
	}
	
	
}

