package com.cym.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	
	private static final int SPEED = 10;
	private static final int WIDTH = 25,LENGTH = 25;
	private int x, y;
	private Dir dir;
	private	boolean live = true;
	private TankFrame tf = null;
	
	
	public Bullet(int x, int y, Dir dir, TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}
	
	public void paint(Graphics g) {
		if(!live)
			tf.bullets.remove(this);
//		Color c = g.getColor();
//		g.setColor(Color.red);
//		g.fillOval(x, y, WIDTH, LENGTH);	
		switch(dir) {
			case LEFT :		
				g.drawImage(ResourceMgr.bulletL, x, y, null);
				break;
			case RIGHT :	
				g.drawImage(ResourceMgr.bulletR, x, y, null);
				break;
			case UP :		
				g.drawImage(ResourceMgr.bulletU, x, y, null);
				break;
			case DOWN :		
				g.drawImage(ResourceMgr.bulletD, x, y, null);
				break;
		}
		move();
//		g.setColor(c);
	}
	
	private void move() {
		switch(dir) {
		case LEFT:	x -= SPEED;break;
		case RIGHT:	x += SPEED;break;
		case UP:	y -= SPEED;break;
		case DOWN:	y += SPEED;break;
		}
		
		if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT)
			live = false;	
	}
	
	
	
}
