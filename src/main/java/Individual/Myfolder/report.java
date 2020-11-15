package Individual.Myfolder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

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
	
	
	public void printpdfreport(File[] list) {
	    try {
            // 1.新建document对象
            Document document = new Document(PageSize.A4);// 建立一个Document对象
 
            // 2.建立一个书写器(Writer)与document对象关联
            File file = new File("/Users/yuxinxie/Desktop/reportt.pdf");
            file.createNewFile();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            writer.setPageEvent(new Watermark("REPORT"));// 水印
			
 
            // 3.打开文档
            document.open();
			document.addTitle("Report");// 标题
			document.addAuthor("Author@umiz");// 作者
			document.addSubject("Subject@iText pdf sample");// 主题
			document.addKeywords("Keywords@iTextpdf");// 关键字
			document.addCreator("Creator@umiz`s");// 创建者
 
            // 4.向文档中添加内容
            new pdfreport().generatePDF(list, document);
 
            // 5.关闭文档
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
