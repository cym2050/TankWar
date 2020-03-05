package com.cym.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		TankFrame tf = new TankFrame();
		for(int i=0;i<5;i++)
			tf.tanks.add(new Tank(50+i*80, 50, Dir.DOWN, tf));
		while(true) {
			Thread.sleep(50);
			tf.repaint();
		}
	}
} 

