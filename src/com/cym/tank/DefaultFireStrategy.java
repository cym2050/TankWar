package com.cym.tank;

public class DefaultFireStrategy implements FireStrategy{

	@Override
	public void fire(Tank tank) {

		int bX = tank.getX() + tank.getWidth()/2 - Bullet.WIDTH/2;
		int bY = tank.getY() + tank.getHeight()/2 - Bullet.HEIGHT/2;
		new Bullet(bX, bY, tank.getDir(), tank.getGroup(), tank.tf); 
	}
	
}
