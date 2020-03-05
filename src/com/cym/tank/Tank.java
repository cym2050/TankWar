package com.cym.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	private int x, y;
	private Dir dir;

	private boolean moving = false;
	private boolean live = true;
	private TankFrame tf;
	private static final int SPEED = 20;
	
	static final int WIDTH = ResourceMgr.tankL.getWidth();
	static final int HEIGHT = ResourceMgr.tankL.getHeight();
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
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

	public Tank(int x, int y, Dir dir, TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
//		Color c = g.getColor();
//		g.setColor(Color.yellow);
//		g.fillRect(x, y, 50, 50);	
		if(!live)
			tf.tanks.remove(this);
		switch(dir) {
			case LEFT :		
				g.drawImage(ResourceMgr.tankL, x, y, null);
				break;
			case RIGHT :	
				g.drawImage(ResourceMgr.tankR, x, y, null);
				break;
			case UP :		
				g.drawImage(ResourceMgr.tankU, x, y, null);
				break;
			case DOWN :		
				g.drawImage(ResourceMgr.tankD, x, y, null);
				break;
		}  
		move();
//		g.setColor(c);
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
	
	public void fire() {
		int bX = this.x + this.WIDTH/2 - Bullet.WIDTH/2;
		int bY = this.y + this.HEIGHT/2 - Bullet.HEIGHT/2;
		tf.bullets.add(new Bullet(bX, bY, this.dir, this.tf)); 
	}

	public void die() {
		// TODO Auto-generated method stub
		this.live = false;
		
	}	

}
