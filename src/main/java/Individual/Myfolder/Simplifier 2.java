package Individual.Myfolder;

import java.io.File;
import java.util.ArrayList;

/**
 * Simplifies file paths by removing unnecessarily nested folders
 */
public class Simplifier {

	public void simplify(String folderPath) {

		/**
		 * The files/folders within the parent specified by folderPath
		 */
		File[] list = new File(folderPath).listFiles();

		/**
		 * The pathnames of files within the parent
		 */
		ArrayList<String> filepaths = new ArrayList<String>();

		/**
		 * The pathnames of folders within the parent
		 */
		ArrayList<String> folderlocations = new ArrayList<String>();

		/**
		 * Populates filepaths and folderlocations with the relevant pathnames
		 * Recursively calls this method for any subfolders found
		 */
		for (File file : list) {
			if (!file.isHidden()) {
				if (file.isDirectory()) {
					String temp = folderPath + File.separator + file.getName();
					folderlocations.add(temp);
					simplify(temp);
				} else {
					String temp2 = file.getName();
					filepaths.add(temp2);
				}
			}
		}

		/**
		 * Deletes subfolders
		 */
		for (String a : folderlocations) {
			File getfile = new File(a);
			getfile.delete();
		}

		int lastindex = folderPath.lastIndexOf(File.separator);

		String upperfolder = folderPath.substring(0, lastindex);

		/**
		 * Moves files out of subfolders
		 */
		for (String b : filepaths) {
			File file = new File(b);
			if (file.isHidden()) {
				continue;
			}
			System.out.println(b + "  " + upperfolder + File.separator + b);
			file.renameTo(new File(upperfolder + File.separator + b));
		}
	}
}
