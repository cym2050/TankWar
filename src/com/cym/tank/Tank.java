package com.cym.tank;

import java.awt.Graphics;

public class Tank {
	private int x, y;
	private Dir dir;
	private static final int SPEED = 20;
	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public Tank(int x, int y, Dir dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.fillRect(x, y, 50, 50);	
//		if(BL) x -= SPEED;
//		if(BR) x += SPEED;
//		if(BU) y -= SPEED;
//		if(BD) y += SPEED;
		switch(dir) {
			case LEFT:	x -= SPEED;break;
			case RIGHT:	x += SPEED;break;
			case UP:	y -= SPEED;break;
			case DOWN:	y += SPEED;break;
		}
	}
	

}
