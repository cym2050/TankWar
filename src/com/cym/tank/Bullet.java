package com.cym.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	
	private static final int SPEED = 10;
	private static final int WIDTH = 20,LENGTH = 20;
	private int x, y;
	private Dir dir;
	
	public Bullet(int x, int y, Dir dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public void paint(Graphics g) {

		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(x, y, WIDTH, LENGTH);	
		move();
		g.setColor(c);
	}
	
	private void move() {
		switch(dir) {
		case LEFT:	x -= SPEED;break;
		case RIGHT:	x += SPEED;break;
		case UP:	y -= SPEED;break;
		case DOWN:	y += SPEED;break;
		}
	}
	
	
	
}
