
import java.util.ArrayList;
import java.util.List;

public class StopAndSearchFiles {
	private static List<CrimeStopAndsearch> OneStopAndSearchFiles = new ArrayList<>();

	public StopAndSearchFiles(ArrayList<CrimeStopAndsearch> stopandSearch) {

		OneStopAndSearchFiles = new ArrayList<CrimeStopAndsearch>(stopandSearch);
	}

	public static List<CrimeStopAndsearch> getStopAndSearchFiles()
	{
		return OneStopAndSearchFiles;
	}

	
	

}
