import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * Contains {@link #readFolder} method.
 */
public class FolderReader {
	public static List<String> Stop_Search = new ArrayList<String>();

	/**
	 * 
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

	public static List<String> getbasicStop_Search() {
		return Stop_Search;
	}

}
