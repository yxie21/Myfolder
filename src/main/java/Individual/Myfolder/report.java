package Individual.Myfolder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

public class Report {

	public void printreport(File[] list) {
		PrintWriter pw = null;
		try {
			GregorianCalendar calender = new GregorianCalendar();
			
			String name= new String (calender.get(GregorianCalendar.YEAR) + "_" +
		       calender.get(GregorianCalendar.MONTH) + "_" +
		       calender.get(GregorianCalendar.DATE) + "_" +
		       calender.get(GregorianCalendar.HOUR)  + "" +
		       calender.get(GregorianCalendar.MINUTE)  + "" +
		       calender.get(GregorianCalendar.SECOND));
		 
			pw = new PrintWriter(new BufferedWriter(new FileWriter(name+ ".out")));

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
