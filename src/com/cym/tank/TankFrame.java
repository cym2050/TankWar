package com.cym.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
	
	static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;			//战场窗口尺寸
	
	Tank myTank = new Tank(200, 200, Dir.DOWN, Group.GOOD, this);	//加入一个主战坦克对象
	List<Bullet> bullets = new ArrayList<>();						//子弹容器
	List<Tank> tanks = new ArrayList<>();							//敌方坦克容器
	List<Explode> explodes = new ArrayList<>();						//爆炸效果容器
	
	
	public TankFrame() {							//窗口属性，窗口监听，键盘监听
		setSize(GAME_WIDTH,GAME_HEIGHT);			//设置尺寸
		setResizable(false);		//不可调整
		setTitle("tank war");		//设置标题
		setVisible(true);			//显示界面
		addWindowListener(new WindowAdapter() {			//窗口监听//匿名内部类：只有这里有用
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		addKeyListener(new MyKeylistener());
		addMouseListener(null);
	}
	
	Image offScreenImage = null;
	@Override
	public void update(Graphics g) {		//双缓冲，解决闪烁问题，在paint之前调用
		if(offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	@Override 
	public void paint(Graphics g) {		//图像重新绘制时系统自动调用
		Color c = g.getColor();
		g.setColor(Color.white);
		g.drawString("子弹的数量:" + bullets.size(), 10, 60);
		g.drawString("敌人的数量:" + tanks.size(), 10, 80);
		g.drawString("爆炸的数量:" + explodes.size(), 10, 100);
		g.setColor(c);
		myTank.paint(g); 
		for(int i = 0; i < bullets.size(); i++)
			bullets.get(i).paint(g);
		
		for(int i = 0; i < tanks.size(); i++)
			tanks.get(i).paint(g); 
		
		for(int i=0;i<bullets.size();i++)
			for(int j=0;j<tanks.size();j++)
				bullets.get(i).collidWith(tanks.get(j));

		for(int i = 0; i < explodes.size(); i++)
			explodes.get(i).paint(g);
			
	}
	
	class MyKeylistener extends KeyAdapter{			//
		
		boolean BL = false;
		boolean BR = false;
		boolean BU = false;
		boolean BD = false;
		
		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("key pressed");
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				BL = true;
				break;
			case KeyEvent.VK_RIGHT:
				BR = true;
				break;	
			case KeyEvent.VK_UP:
				BU = true;
				break;
			case KeyEvent.VK_DOWN:
				BD = true;
				break;	
			default:
				break;
			}
			setMainTankDir();
		}
		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("key released");
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				BL = false;
				break;
			case KeyEvent.VK_RIGHT:
				BR = false;
				break;
			case KeyEvent.VK_UP:
				BU = false;
				break;
			case KeyEvent.VK_DOWN:
				BD = false;
				break;
			case KeyEvent.VK_CONTROL:
				myTank.fire();
				break;
			default:
				break;
			}
			
			setMainTankDir();
		}
		
		private void setMainTankDir() {
			if(!BL && !BR && !BU && !BD) 
				myTank.setMoving(false);
			else 
				myTank.setMoving(true);
			if(BL) myTank.setDir(Dir.LEFT);
			if(BR) myTank.setDir(Dir.RIGHT);
			if(BU) myTank.setDir(Dir.UP);
			if(BD) myTank.setDir(Dir.DOWN);
		}	
	}
	
	
}
