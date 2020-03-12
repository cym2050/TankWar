package com.cym.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		TankFrame tf = new TankFrame();		//new出战场窗口
		
		int Initial = Integer.parseInt((String)PropertyMgr.get("Initial"));
		
		for(int i=0; i<Initial; i++)
			tf.tanks.add(new Tank(50+i*80, 50, Dir.DOWN, Group.BAD, tf));	//添加敌方坦克
		while(true) {
			Thread.sleep(50);
			tf.repaint();
		}
	}
} 

