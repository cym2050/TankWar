package com.cym.tank;

public class FourFireStrategy implements FireStrategy{

	@Override
	public void fire(Tank tank) {
		// TODO Auto-generated method stub
		int bX = tank.getX() + tank.getWidth()/2 - Bullet.WIDTH/2;
		int bY = tank.getY() + tank.getHeight()/2 - Bullet.HEIGHT/2;
		Dir[] dirs = Dir.values();
		for(Dir dir : dirs) {
			new Bullet(bX, bY, dir, tank.getGroup(), tank.tf); 
		}
	}

}
