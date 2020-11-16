import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

// this has no function except for main
public class MyFolder {

	public static void main(String args[]) throws IOException {
		String workingDir = System.getProperty("user.dir");
		String configPath = workingDir + File.separator + "config.txt"; // using relative path
		BufferedReader config = new BufferedReader(new FileReader(configPath));

		Map<String, String> map = new HashMap<>();


		while(true) {
            String entry = config.readLine();
            if(entry == null || entry.trim().equals("")) {
            	break;
            }
		StringTokenizer st = new StringTokenizer(entry, "=");
		map.put(st.nextToken(), st.nextToken());

		}
		config.close();
		String folderPath = map.get("rootpath");
		String suffix = map.get("suffix");
		
		File[] list = new File(folderPath).listFiles();

		for (File folders : list) {
			if (folders.isDirectory()) {
				int folderCount = 0;
				for (File subfolder : folders.listFiles()) {
					if (subfolder.isDirectory()) {
						folderCount++;
						for (File source : subfolder.listFiles()) {
							if (source.getName().endsWith(suffix)) {
								source.renameTo(new File(source.getParentFile().getParent() + File.separator + source.getName()));

							}
						}
					}
				}
				if (folderCount == 0) {
					System.err.println(folders.getName() + "");
				}
			}

		}

	}
}
