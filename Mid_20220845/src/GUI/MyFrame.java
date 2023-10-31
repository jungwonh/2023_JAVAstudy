package GUI;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MyFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	ButtonListener listener=new ButtonListener();
	private JTextField name, num, score;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 237);
		setTitle("덕성여대화이팅");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setBounds(36, 45, 151, 15);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("학번");
		lblNewLabel_1.setBounds(36, 70, 151, 15);
		contentPane.add(lblNewLabel_1);
	
		
		JLabel lblNewLabel_2 = new JLabel("성적");
		lblNewLabel_2.setBounds(36, 95, 113, 15);
		contentPane.add(lblNewLabel_2);
		
				
		

		JLabel lblNewLabel_4 = new JLabel("학생 등록하기");
		lblNewLabel_4.setFont(new Font(" ",Font.PLAIN, 16));
		lblNewLabel_4.setBounds(36, 10, 151, 25);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(187, 45, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10); //이름 텍스트필드
		name.addActionListener(listener);
				
		passwordField = new JPasswordField();
		passwordField.setBounds(187, 70, 116, 21);
		contentPane.add(passwordField); //학번 텍스트필드
		num.addActionListener(listener);

		textField_1 = new JTextField();
		textField_1.setBounds(187, 95, 116, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10); //성적 텍스트필드
		score.addActionListener(listener);
		//score=new JTextField(10);
		//score.setBounds(187, 95, 116, 21);
		//contentPane.add(score);
		//score.addActionListener(listener);

		
		btnNewButton = new JButton("등록하기");
		btnNewButton.setBounds(90, 120, 97, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(206, 120, 97, 23);
		contentPane.add(btnNewButton_1);
	}
}

class ButtonListener implements ActionListener{

	public void actionPerformed(ActionEvent e)
	{
		Object btnNewButton;
		if(e.getSource()==btnNewButton)
		{
			String name1=name.getText();
			String num1=num.getText();
			String score1=score.getText();

			System.out.println("이름:"+name1+" 학번:"+num1+" 성적:"+score1);
		}
	}
}