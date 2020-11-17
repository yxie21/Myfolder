package Individual.Myfolder;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Filetype {
	
	public HashSet<String> type(String folderPath) {
		

	File[] list = new File(folderPath).listFiles();
	
	ArrayList<String> types = new ArrayList<String>();
	if(list!=null) {
	

	
	
	ArrayList<String> folderlocations = new ArrayList<String>();
	
	
	for (File file : list) {

		if (!file.getName().contains(".")) {
			String temp = folderPath + File.separator + file.getName();
			System.out.println(file.getName());
			System.out.println(file.getName()+" "+temp);
			folderlocations.add(temp);
			HashSet <String> newtypes= type(temp);
			for( String a: newtypes) {
				
				types.add(a);
				
			}
			

		}
		
		else {
			if(file.getName().startsWith(".")) {
				continue;
			}
			int index= file.getName().lastIndexOf(".");
			String ending= file.getName().substring(index);
			if(ending!=".DS_Store") {
				types.add(ending);
				}
			
		}

	}

}
	
	HashSet<String> myset= new HashSet<String>(types);
	return myset;
	

	}	
}	
