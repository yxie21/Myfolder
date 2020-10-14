package Individual.Myfolder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Report {

	public void printreport(File[] list) {
		PrintWriter pw = null;
		try {

			pw = new PrintWriter(new BufferedWriter(new FileWriter("report.out")));

			for (File folders : list) {
				if(!folders.isDirectory()) {
					if (folders.getName().startsWith(".")) {
						continue;
					}
					pw.println(folders.getName());
				}
				
				else if (folders.isDirectory()) {
					
					if (folders.getName().startsWith(".")) {
						continue;
					}
					pw.println("Folder"+" "+ folders.getName());
					for (File subfolder : folders.listFiles()) {
						if (!subfolder.isDirectory()) {
							if (subfolder.getName().startsWith(".")) {
								continue;
							}
							pw.println(subfolder.getName());
						} else if (subfolder.isDirectory()) {
							if (subfolder.getName().startsWith(".")) {
								continue;
							}
							pw.println("Subfolder" + "  " + subfolder.getName());
							for (File source : subfolder.listFiles()) {
								if (source.getName().startsWith(".")) {
									continue;
								}
								pw.println(source.getName());

							}
						}
					}
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}

	}
}
