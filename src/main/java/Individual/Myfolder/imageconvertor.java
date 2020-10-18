package Individual.Myfolder;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class imageconvertor {
	public void convert (File s) throws IOException {
	
	BufferedImage bufferedImage = ImageIO.read(s);
    BufferedImage newImage =new BufferedImage(bufferedImage.getWidth(),bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
   newImage.createGraphics().drawImage(bufferedImage,0,0,Color.white, null);               
    ImageIO.write(newImage,"jpg",new File(s.getPath().replace("png", "jpg")) );
	}

//    BufferedImage bufferedImage = ImageIO.read(如果是jpg);
//    BufferedImage newBufferedImage =new BufferedImage(bufferedImage.getWidth(),bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
//    newBufferedImage .createGraphics().drawImage(bufferedImage,0,0,Color.white,null);               
//    ImageIO.write(newBufferedImage,"png",new File("C:\\Users\\lenovo\\Desktop\\Download\\z.png")  );
}

