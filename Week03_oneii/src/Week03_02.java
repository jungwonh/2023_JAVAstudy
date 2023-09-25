import javax.swing.*;

import ButtonListener.ButtonListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Week03_02 extends JFrame{
	private JButton button;
	private JTextField text, result;
	
	public Week03_02() {
		
		setSize(600, 100);
		setTitle("Mile->Km");
		setVisible(true);
		ButtonListener listener=new ButtonListener();
		
		JPanel panel=new JPanel();
		panel.add(new JLabel("마일을 입력하시오"));
		text=new JTextField(15);
		text.addActionListener((ActionListener) listener);
		panel.add(text);
		
		panel.add(new JLabel("->"));
		result=new JTextField(15);
		result.setEditable(false);
		panel.add(result);
		
		button=new JButton("변환");
		button.addActionListener((ActionListener) listener);
		panel.add(button);
		
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==button||e.getSource()==text) {
			String name = text.getText();
				int value=Integer.parseInt(name);
				result.setText(" "+value*1.609344);
				text.requestFocus();
			}
		}
	}
	
	public static void main(String args[]) {
		Week03_02 f= new Week03_02();
		
	}
	
	

}
