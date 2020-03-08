package com.cym.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.annotation.Resource;

	
public class Explode {

	static final int WIDTH = ResourceMgr.explodes[0].getWidth();
	static final int HEIGHT = ResourceMgr.explodes[0].getHeight();
	private int x, y;
	private Dir dir;
	private TankFrame tf = null;
	private int step = 0;
	
	public Explode(int x, int y, TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.tf = tf;
		
		
		//new Audio("audio/explode.wav").run();
	}
	
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[step++], x, y, null);
		if(step >= ResourceMgr.explodes.length)
			tf.explodes.remove(this);
	}

	
	
}
