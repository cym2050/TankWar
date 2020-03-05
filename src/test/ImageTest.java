package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

class ImageTest {

	@Test
	void test() {
		//fail("Not yet implemented");
		
		try {
			BufferedImage image = ImageIO.read(new File("C:/Users/Alan/Desktop/projects/TankWar/src/images/10.gif"));
			assertNotNull(image);
			
			BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/10.gif"));
			assertNotNull(image2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
