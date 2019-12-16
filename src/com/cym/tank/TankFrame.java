package com.cym.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	
	int x = 200,y = 200;
	
	public TankFrame() {
		
		setSize(800,600);
		setResizable(false);
		setTitle("tank war");
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.addKeyListener(new MyKeylistener());
	}
	
	@Override 
	public void paint(Graphics g) {		//图像重新绘制时系统自动调用
		System.out.println("paint");
		g.fillRect(x, y, 50, 50);
		//x += 100;
		//y += 100;
	}
	
	class MyKeylistener extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("key pressed");
			x += 100;
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("key released");
		}
	}
	
	
	
}
