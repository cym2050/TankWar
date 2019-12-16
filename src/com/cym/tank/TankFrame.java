package com.cym.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	
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
	public void paint(Graphics g) {
		System.out.println("paint");
	}
}
