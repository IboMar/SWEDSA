package V2;
import java.util.ArrayList;
import java.util.List;

public class StopAndSearchFiles {
	private List<CrimeStopAndsearch> OneStopAndSearchFiles = new ArrayList<>();
	private int size =0;
	public StopAndSearchFiles(ArrayList<CrimeStopAndsearch> stopandSearch) {
		OneStopAndSearchFiles = new ArrayList<CrimeStopAndsearch>(stopandSearch);
	}
	public List<CrimeStopAndsearch> getStopAndSearchFiles()
	{
		return OneStopAndSearchFiles;
	}
	public int getListSize() {
		size = OneStopAndSearchFiles.size();
		return size;	
	}

}
