import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class StuMain extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField_01;
	private JTextField textField_02;
	private JTextField textField_03;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuMain frame=new StuMain();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				
				}
			}
		});
	}
	public StuMain() {
		GradeBook gradeBook=new GradeBook();
		
		setTitle("학생 정보 관리 시스템");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 252);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_00=new JLabel("학생 등록하기");
		label_00.setBounds(12, 30, 100, 15);
		label_00.setFont(new Font("맑음고딕", Font.BOLD, 15));
		label_00.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(label_00);
		
		JLabel label_01=new JLabel("이름");
		label_01.setBounds(12, 60, 57, 15);
		contentPane.add(label_01);
		
		JLabel label_02=new JLabel("학번");
		label_02.setBounds(12, 90, 57, 15);
		contentPane.add(label_02);
		
		JLabel label_03=new JLabel("성적");
		label_03.setBounds(12, 120, 57, 15);
		contentPane.add(label_03);
		
		textField_01=new JTextField();
		
		textField_02=new JTextField();
		textField_02.setColumns(10);
		textField_02.setBounds(81, 90, 243, 21);
		contentPane.add(textField_02);
		
		textField_03=new JTextField();
		textField_03.setColumns(10);
		textField_03.setBounds(81, 120, 243, 21);
		contentPane.add(textField_03);
		
		JButton button_01=new JButton("저장");
		button_01.setBounds(12, 150, 97, 23);
		contentPane.add(button_01);
		
		button_01.addActionListener(e->{
			String name=textField_01.getText();
			String number=textField_02.getText();
			Double grade=Double.valueOf(textField_03.getText());
			
			Student student=new Student(name, number, grade);
			
			gradeBook.saveStudent(student);
			
			textField_01.setText("");
			textField_02.setText("");
			textField_03.setText("");
		});
	}

}
