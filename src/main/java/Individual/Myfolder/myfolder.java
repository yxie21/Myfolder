package Individual.Myfolder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
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
		String suffixx= map.get(suffix);
		System.out.println(folderPath);
	
		
		File[] list = new File(folderPath).listFiles();
		
       Report report = new Report();
       report.printreport(list);
		
		Simplifier sim= new Simplifier();
		sim.simplify (folderPath);
		
		imageconvertor con= new imageconvertor();
		
		System.out.println ("suffix"+suffixx);
		
		Queue<File> queue = new LinkedList<File>();
		
		for (File folders: list) {
			queue.offer(folders);
		}

		
		while (queue.size()!=0) {
			File tmp= queue.poll();
			if (tmp.isDirectory()) {
				for (File subfolder : tmp.listFiles()) {
					queue.offer(subfolder);
				}
			}
			else if (tmp.isFile()) {
				if(tmp.getName().contains("png")) {
					con.convert(tmp);
					
				}
				if (tmp.getName().endsWith(suffixx)) {
					System.out.println("print"+"  "+tmp.getParentFile().getParent()+File.separator+tmp.getName());
					tmp.renameTo(new File(tmp.getParentFile().getParent()+File.separator+tmp.getName()));
				}
			}
		}

		
		
		
//		for (File folders : list) {
//			if (folders.isDirectory()) {
//				int folderCount = 0;
//				for (File subfolder : folders.listFiles()) {
//					if (subfolder.isDirectory()) {
//						folderCount++;
//						for (File source : subfolder.listFiles()) {
//							if (source.getName().endsWith(map.get(suffix))) {
//								source.renameTo(new File(source.getParentFile().getParent() + File.separator + source.getName()));
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
