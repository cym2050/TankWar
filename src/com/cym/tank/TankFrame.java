package com.cym.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	
	int x = 200,y = 200;
	
	public TankFrame() {
		
		setSize(800,600);
		setResizable(false);
		setTitle("tank war");
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
				
		});
	}
	@Override 
	public void paint(Graphics g) {		//图像重新绘制时系统自动调用
		System.out.println("paint");
		g.fillRect(x, y, 20, 20);
		x += 10;
		y += 10;
	}
	
	
}
