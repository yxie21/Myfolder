//Theo Baker


UploadItem item = event.getUploadItem();
// replace name
File dir = new File("D:/FileUpload");
if (!dir.exists()) {
    dir.mkdir();
}
String [] files = dir.list();
int count = 0;

for(String file : files) {
  if (file.startsWith(item.getFileName()) {
    count++;
  }
}

File bfile = new File("D:/FileUpload" + "/" + item.getFileName() + "(" + count + ")");
OutputStream outStream = new FileOutputStream(bfile);
outStream.write(item.getData());
outStream.close();
