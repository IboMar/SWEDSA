package V2;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**This class will consist of a List<String> which will be all the files given for the folder params
 * Contains {@link #readFolder} method.
 */
public class FolderReader {
	// Each File within this list
	public static List<String> Stop_Search = new ArrayList<String>();

	/**
	 * Will loop round each given folder and get all files within that folder that consists of stop-and-search and add
	 * the file Directory to a list
	 * @param folder
	 */
	public static void readFolder(final File folder) {

		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				readFolder(fileEntry);
			} else {
				if (fileEntry.getName().contains("stop-and-search")) {
					Stop_Search.add(folder.toPath() + "\\" + fileEntry.getName());
				}
			}
		}
	}

	//Getter method for the static list
	public static List<String> getBasicStop_Search() {
		return Stop_Search;
	}

}
