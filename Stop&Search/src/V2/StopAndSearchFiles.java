package V2;
import java.util.ArrayList;
import java.util.List;

public class StopAndSearchFiles {
	private List<CrimeStopAndSearch> OneStopAndSearchFiles = new ArrayList<>();
	private int size =0;
	public StopAndSearchFiles(ArrayList<CrimeStopAndSearch> stopandSearch) {
		OneStopAndSearchFiles = new ArrayList<CrimeStopAndSearch>(stopandSearch);
	}
	public List<CrimeStopAndSearch> getStopAndSearchFiles()
	{
		return OneStopAndSearchFiles;
	}
	public int getListSize() {
		size = OneStopAndSearchFiles.size();
		return size;	
	}

}
