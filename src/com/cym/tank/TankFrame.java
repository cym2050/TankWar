package com.cym.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	
	int x = 200,y = 200;
	
	boolean BL = false;
	boolean BR = false;
	boolean BU = false;
	boolean BD = false;
	
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
		
		addKeyListener(new MyKeylistener());
		
		addMouseListener(null);
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
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				//x -= 10;
				BL = true;
				break;
			
			case KeyEvent.VK_RIGHT:
				//x += 10;
				BR = true;
				break;
				
			case KeyEvent.VK_UP:
				//y -= 10;
				BU = true;
				break;
				
			case KeyEvent.VK_DOWN:
				//y += 10;
				BD = true;
				break;
				
			default:
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("key released");
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				//x -= 10;
				BL = false;
				break;
			
			case KeyEvent.VK_RIGHT:
				//x += 10;
				BR = false;
				break;
				
			case KeyEvent.VK_UP:
				//y -= 10;
				BU = false;
				break;
				
			case KeyEvent.VK_DOWN:
				//y += 10;
				BD = false;
				break;
				
			default:
				break;
			}
		}
		
		//if(BL) x -= 10;
	}
	
	
	
}
