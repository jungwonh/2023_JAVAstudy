
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card extends JFrame{
	private JPanel panel;
	private JLabel label;
	private JLabel name;
	private JLabel job;
	private JLabel company;
	
	public Card() {
		setTitle("BusinessCard");
		setSize(200, 300);
		
		panel=new JPanel();
		name= new JLabel("허정원");
		job=new JLabel("학생");
		company=new JLabel("덕성여자대학교");
		ImageIcon icon=new ImageIcon("HAM.jpg");
		label=new JLabel(icon);
		
		panel.add(label);
		panel.add(name);
		panel.add(job);
		panel.add(company);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		Card F=new Card();
	} 
}
