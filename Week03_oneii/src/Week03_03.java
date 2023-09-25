import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

import Image.img;

public class Week03_03 extends JFrame{
	
	Image img;
	int pos_x=100, pos_y=0;
	
	public Week03_03() {
		ImageIcon icon=new ImageIcon("donggleii.png");
		img=icon.getImage();
		setSize(700,650);
		add(new MyPanel(), BorderLayout.CENTER);
		JPanel panel=new JPanel();
		JButton b1=new JButton("LEFT");
		JButton b2=new JButton("RIGHT");
		b1.addActionListener(e->{
			pos_x-=10;
			repaint();
		});
		b2.addActionListener(e -> {
			pos_x+=10;
			repaint();
		});
		panel.add(b1);
		panel.add(b2);
		add(panel, BorderLayout.SOUTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, pos_x, pos_y, this);
		}
	}
	
	public static void main(String[] args) {
		Week03_03 week3=new Week03_03();
	}
}
