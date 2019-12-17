package com.cym.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		TankFrame tf = new TankFrame();
		while(true) {
			Thread.sleep(50);
			if(tf.BL) tf.x -= 10;
			if(tf.BR) tf.x += 10;
			if(tf.BU) tf.y -= 10;
			if(tf.BD) tf.y += 10;
			
			tf.repaint();
			
		}
	}

	
} 
