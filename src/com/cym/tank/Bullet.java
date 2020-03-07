package com.cym.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

	
public class Bullet {
	
	private static final int SPEED = 15;
	static final int WIDTH = ResourceMgr.bulletD.getWidth();
	static final int HEIGHT = ResourceMgr.bulletD.getHeight();
	private int x, y;
	private Dir dir;
	private	boolean live = true;
	private TankFrame tf = null;
	private Group group = Group.BAD;
	
	
	public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;
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

	public void collidWith(Tank tank) {
		// TODO Auto-generated method stub
		if(this.group == tank.getGroup())
			return;
		Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
		Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
		if(rect1.intersects(rect2)) {
			tank.die();
			this.die();
			tf.explodes.add(new Explode(this.x, this.y, tf));
		}
	}

	private void die() {
		// TODO Auto-generated method stub
		this.live = false;
	}
	
	
	
}
