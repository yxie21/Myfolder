package Individual.Myfolder;

import java.io.File;
import java.util.ArrayList;

public class mergefolder {
	public void merge (String rootpath, String folderpath1, String folderpath2, String folderName, String newfolder) {
		int dotindex= rootpath.lastIndexOf("/");
		
		String sub= rootpath.substring(0, dotindex);
		File file = new File(sub+File.separator+folderName);
		System.out.println(file.getName());
		if(newfolder.equals("yes")) {
		file.mkdir();
		
		
		File folder1= new File (folderpath1);
		File folder2= new File (folderpath2);
		
		File[] files1= folder1.listFiles();
		File[] files2= folder2.listFiles();
		
		for (File items : files1) {
			String newpath= file+File.separator+ items.getName();
			System.out.println("from folder1"+" "+newpath);
			items.renameTo(new File(newpath));
		}
		
		for (File items : files2) {
			String newpath= file+File.separator+ items.getName();
			System.out.println("from folder2"+" "+newpath);
			items.renameTo(new File(newpath));
		}
		}
		
		else {
			File folder1= new File (folderpath1);
			
			
			File[] files1= folder1.listFiles();
			
			
			for (File items : files1) {
				String newpath= folderpath2+File.separator+ items.getName();
				
				items.renameTo(new File(newpath));
			}
			
		}
			

	
	
}
}
