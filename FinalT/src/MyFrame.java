import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class MyFrame extends JFrame {
    JTextField stuId, name, tel, dept;
    JButton previousButton, nextButton, InsertButton, deleteButton, searchButton;
    ResultSet rs;
    Statement stmt;

    public MyFrame() throws SQLException {
        super("Student Viewer");

        // 데이터베이스 연결 및 Statement 생성
        Connection con = makeConnection();
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("SELECT * FROM Student");

        setLayout(new GridLayout(0, 2));

        // 각각의 필드와 레이블을 추가
        add(new JLabel("stuID", JLabel.CENTER));
        add(stuId = new JTextField());

        add(new JLabel("name", JLabel.CENTER));
        add(name = new JTextField());

        add(new JLabel("tel", JLabel.CENTER));
        add(tel = new JTextField());

        add(new JLabel("dept", JLabel.CENTER));
        add(dept = new JTextField());


        // Previous 버튼 설정 및 ActionListener 추가
        previousButton = new JButton("Previous");
        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    rs.previous();
                    updateFields();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        // Next 버튼 설정 및 ActionListener 추가
        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    rs.next();
                    updateFields();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        InsertButton = new JButton("Insert");
        deleteButton = new JButton("Delete");
        searchButton = new JButton("Search");

        // 버튼들을 프레임에 추가
        add(previousButton);
        add(nextButton);
        add(InsertButton);
        add(deleteButton);
        add(searchButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setVisible(true);
    }

    // 필드 값을 업데이트하는 메서드
    private void updateFields() throws SQLException {
        stuId.setText("" + rs.getInt("student_id"));
        name.setText("" + rs.getString("name"));
        tel.setText("" + rs.getString("tel"));
        dept.setText("" + rs.getString("dept"));
    }

    // 데이터베이스 연결을 수행하는 메서드
    private Connection makeConnection() {
        // 여기에 데이터베이스 연결 코드를 추가
        // 예를 들면, JDBC를 사용하여 데이터베이스에 연결하는 코드
        return null;
    }
}
