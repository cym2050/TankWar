package com.cym.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	private int x, y;
	private Dir dir;
	private boolean moving = false;
	private static final int SPEED = 20;
	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

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
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillRect(x, y, 50, 50);	
		move();
		g.setColor(c);
	}

	private void move() {
		if(!moving) return;
		switch(dir) {
		case LEFT:	x -= SPEED;break;
		case RIGHT:	x += SPEED;break;
		case UP:	y -= SPEED;break;
		case DOWN:	y += SPEED;break;
		}
	}
	

}
