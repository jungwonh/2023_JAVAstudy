import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CarGame extends JFrame{
	class MyThread extends Thread{
		private JLabel label;
		private int x, y;
		private JFrame frame;
		private Image img;
		
		public MyThread(String fname, int x,int y) {
			this.x=x;
			this.y=y;
			label=new JLabel();
			label.setIcon(new ImageIcon(fname));
			label.setBounds(x, y, 100, 100);
			add(label);
			img=ImageIcon.getImage(race.gif);
			label.setIcon(new ImageIcon(img));
			frame.add(label);
			
		}
		public void run() {
			for(int i=0; i<200; i++) {
				x+=0.1*Math.random();
				label.setBounds(x, y, 100, 100);
				img.setBounds(600, 600, 100, 100);
				repaint();
				try {
					Thread.sleep(100);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public CarGame() {
		setTitle("CarRace");
		setSize(600, 200);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		(new MyThread("car1.gif", 100, 0)).start();
		(new MyThread("car2.gif", 100, 0)).start();
		(new MyThread("car3.gif", 100, 0)).start();
		(new MyThread("car4.gif", 100, 0)).start();
		(new MyThread("car5.gif", 100, 0)).start();
	}
	
	public static void main(String[] args) {
		CarGame t=new CarGame();
	}

}
