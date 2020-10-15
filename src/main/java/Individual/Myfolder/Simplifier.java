package Individual.Myfolder;

import java.io.File;
import java.util.ArrayList;

public class Simplifier {

	public void simplify(String folderPath) {
		
		File[] list = new File(folderPath).listFiles();
	
		ArrayList<String> filepaths = new ArrayList<String>();
		
		ArrayList<String> folderlocations = new ArrayList<String>();

		for (File file : list) {

			if (!file.getName().contains(".")) {
				String temp = folderPath + File.separator + file.getName();
				folderlocations.add(temp);
				simplify(temp);
 
			} else {
				String temp2 = file.getName();
				filepaths.add(temp2);

			}

		}

		for (String a : folderlocations) {
			
			File getfile = new File(a);
			getfile.delete();

		}
		
         int lastindex= folderPath.lastIndexOf(File.separator);
   
         
		 String upperfolder= folderPath.substring(0, lastindex);
		
		 
		 for (String b: filepaths) {
			 if(b.startsWith(".")) {
				 continue;
			 }
			 File file= new File(b);
			 System.out.println(b+ "  "+ upperfolder+ File.separator+b );
			 file.renameTo(new File (upperfolder+ File.separator+b ));
		 }
		 
	}

}
