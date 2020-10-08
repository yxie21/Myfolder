package Individual.Myfolder;

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

public class myfolder {

	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("config.txt"));

		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < 2; i++) {

			StringTokenizer st = new StringTokenizer(f.readLine(), "=");
			map.put(st.nextToken(), st.nextToken());

		}
		Set<String> keySet = map.keySet();
		ArrayList<String> a = new ArrayList<String>(keySet);
		Collections.sort(a);
		String rootpath = a.get(0);
		String suffix = a.get(1);
		System.out.println(rootpath);
		System.out.println(suffix);

		String folderPath = map.get(rootpath);
		System.out.println(folderPath);
		File[] list = new File(folderPath).listFiles();

		for (File folders : list) {
			if (folders.isDirectory()) {
				int folderCount = 0;
				for (File subfolder : folders.listFiles()) {
					if (subfolder.isDirectory()) {
						folderCount++;
						for (File source : subfolder.listFiles()) {
							if (source.getName().endsWith(map.get(suffix))) {
								source.renameTo(new File(source.getParentFile().getParent() + "\\" + source.getName()));

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
