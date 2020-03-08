package com.cym.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ResourceMgr {
	public static BufferedImage goodTankL, goodTankR, goodTankU, goodTankD;
	public static BufferedImage badTankL, badTankR, badTankU, badTankD;
	public static BufferedImage bulletL, bulletR, bulletU, bulletD;
	public static BufferedImage[] explodes = new BufferedImage[16];
	
	static {
		try {
			goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank2.png"));
			goodTankL = ImageUtil.rotateImage(goodTankU, -90);
			goodTankR =	ImageUtil.rotateImage(goodTankU, 90);
			goodTankD = ImageUtil.rotateImage(goodTankU, 180);
			
			badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			badTankL = ImageUtil.rotateImage(badTankU, -90);
			badTankR =	ImageUtil.rotateImage(badTankU, 90);
			badTankD = ImageUtil.rotateImage(badTankU, 180);
			
			
			bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
			bulletL = ImageUtil.rotateImage(bulletU, -90);
			bulletR = ImageUtil.rotateImage(bulletU, 90);
			bulletD = ImageUtil.rotateImage(bulletU, 180);
//			bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
//			bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
//			bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			
			for(int i=0; i < 16; i++)
				explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
