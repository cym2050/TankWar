package com.cym.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Tank {
	private int x, y;
	private Dir dir;

	private boolean moving = true;
	private boolean live = true;
	TankFrame tf;
	private static final int SPEED = 10;
	private Random random = new Random();
	private Group group = Group.BAD;
	
	FireStrategy fS = new DefaultFireStrategy();
	
	static final int WIDTH = ResourceMgr.badTankL.getWidth();
	static final int HEIGHT = ResourceMgr.badTankL.getHeight();
	
	Rectangle rect = new Rectangle();
	
	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

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
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;
		
		rect.x = x;
		rect.y = y;
		rect.width = this.WIDTH;
		rect.height = this.HEIGHT;
	}



	public void paint(Graphics g) {
		if(!live)
			tf.tanks.remove(this);
		switch(dir) {
			case LEFT :		
				g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
				break;
			case RIGHT :	
				g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
				break;
			case UP :		
				g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
				break;
			case DOWN :		
				g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
			break;
		} 
		
		move();
	}

	private void move() {
		if(!moving) return;
		switch(dir) {
		case LEFT:	x -= SPEED;break;
		case RIGHT:	x += SPEED;break;
		case UP:	y -= SPEED;break;
		case DOWN:	y += SPEED;break;
		}
		
		if(this.group == Group.BAD && random.nextInt(10) > 8) {		//随机发射
			this.fire();
		}
		
		if(this.group == Group.BAD && random.nextInt(10) > 8) {		//随机方向
			randomDir();
		}
		
		boundCheck();
		
		rect.x = this.x;
		rect.y = this.y;
	}
	
	private void boundCheck() {
		// TODO Auto-generated method stub
		if(this.x < 0) 
			x = 0;
		if(this.y < 30)
			y = 30;
		if(this.x > TankFrame.GAME_WIDTH - Tank.WIDTH)
			x = TankFrame.GAME_WIDTH - Tank.WIDTH;
		if(this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT)
			y = TankFrame.GAME_HEIGHT - Tank.HEIGHT;
	}

	private void randomDir() {
		// TODO Auto-generated method stub
		this.dir = Dir.values()[random.nextInt(4)];
	}

	public void fire() {
		fS.fire(this);
	}

	public void die() {
		// TODO Auto-generated method stub
		this.live = false;
		
	}	

}
