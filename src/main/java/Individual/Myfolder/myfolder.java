package Individual.Myfolder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class myfolder {
  
   
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("config.txt"));


		String workingDir = System.getProperty("user.dir");
		String configPath = workingDir + File.separator + "config.txt"; // using relative path
		BufferedReader config = new BufferedReader(new FileReader(configPath));

		Map<String, String> map = new HashMap<String, String>();
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
		String grouptogether= map.get("grouptogether");
		String printtypeout= map.get("printfiletype");
		
		
		File[] list = new File(folderPath).listFiles();
		
       Report report = new Report();
       report.printreport(list);
		
//       Simplifier sim= new Simplifier();
//        sim.simplify(folderPath, false);
		
		imageconvertor con= new imageconvertor();
		
		if(printtypeout.equals("yes")) {
		Filetype filetypes= new Filetype();
		HashSet<String> endings= filetypes.type(folderPath);
		for(String b: endings) {
			System.out.println("type"+"   "+b);
		}
		}
		
				
		Queue<File> queue = new LinkedList<File>();
		
		
		for (File folders: list) {
			queue.offer(folders);
		}

		
		while (queue.size()!=0) {
			File tmp= queue.poll();
			if (tmp.isDirectory()) {
				
				String temp = folderPath + File.separator + tmp.getName();
			
				
				if(tmp.getName().contains("zip")) {
					Ziphelp unzip= new Ziphelp();
					unzip.ziphelp(temp);
				}
				for (File subfolder : tmp.listFiles()) {
					queue.offer(subfolder);
			}
		}
		else if (tmp.isFile()) {
			if(tmp.getName().startsWith(".")) {
				continue;
			}
			String temp2 = folderPath + File.separator + tmp.getName();
			
			       if(tmp.getName().contains("zip")) {
			    	   Ziphelp unzip2= new Ziphelp();
			    	   unzip2.ziphelp(temp2);
			       }
				
//				if(tmp.getName().contains("png")) {
//					con.convert(tmp);
//					
//				}
				
//				if(grouptogether.equals("no")) {
//					if(tmp.getName().startsWith(".")) {
//						continue;
//					}
//				tmp.renameTo(new File(folderPath+File.separator+tmp.getName()));
//				
//				}
//				else {
//					
//				
//				
//				if(tmp.getName().startsWith(".")) {
//					continue;
//				}
//				
//				int dotindex= tmp.getName().lastIndexOf('.');
//				if(dotindex<0) {
//					continue;
//				}
//				
//				String sub= tmp.getName().substring(dotindex+1, tmp.getName().length());
//				
//				
//				File a = new File(folderPath + File.separator+sub);
//			     if(!a.exists()) {
//			      a.mkdir();
//			     }
//			     tmp.renameTo(new File(a+File.separator+tmp.getName()));
//				}
			     

				
//				if (tmp.getName().endsWith(suffixx)) {
//					System.out.println("print"+"  "+tmp.getParentFile().getParent()+File.separator+tmp.getName());
//					tmp.renameTo(new File(folderPath+File.separator+tmp.getName()));
//				}
			}
}

		
		
//		
//		for (File folders : list) {
//			if (folders.isDirectory()) {
//				int folderCount = 0;
//				for (File subfolder : folders.listFiles()) {
//					if (subfolder.isDirectory()) {
//						folderCount++;
//						for (File source : subfolder.listFiles()) {
//							if (source.getName().endsWith(map.get(suffix))) {
//							source.renameTo(new File(source.getParentFile().getParent() + File.separator + source.getName()));
//
//							}
//						}
//					}
//				}
//				if (folderCount == 0) {
//					System.err.println(folders.getName() + "");
//				}
//			}
//
//		}
		
		

	}
}
