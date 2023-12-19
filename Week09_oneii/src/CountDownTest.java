import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountDownTest extends JFrame {
    private JLabel label;
    private Thread t;

    // 카운터 쓰레드를 나타내는 내부 클래스
    class Counter extends Thread {
        public void run() {
            for (int i = 0; i <= 100; i++) {
                try {
                    // 1000 밀리초(1초) 동안 일시 정지
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // 쓰레드가 중단되면 리턴하여 쓰레드 종료
                    return;
                }
                // JLabel을 현재 카운트 값으로 업데이트
                label.setText(i + "");
            }
        }
    }

    // CountDownTest 클래스의 생성자
    public CountDownTest() {
        // JFrame의 제목과 크기 설정
        setTitle("카운트다운");
        setSize(400, 150);
        getContentPane().setLayout(null);

        // 카운트를 표시할 JLabel 초기화 및 구성
        label = new JLabel("0");
        label.setBounds(0, 0, 384, 111);
        label.setFont(new Font("Serif", Font.BOLD, 100));
        getContentPane().add(label);

        // "카운트 중지" JButton 생성 및 구성
        JButton btnNewButton = new JButton("카운트 중지");
        btnNewButton.setBounds(247, 24, 125, 23);

        // ActionListener 추가: 버튼을 클릭하면 카운터 쓰레드 중단
        btnNewButton.addActionListener(e -> t.interrupt());
        getContentPane().add(btnNewButton);

        // "카운트 다시시작" JButton 생성 및 구성
        JButton btnNewButton2 = new JButton("카운트 다시시작");
        btnNewButton2.setBounds(247, 54, 125, 23);

        // ActionListener 추가: 버튼을 클릭하면 카운터 쓰레드 재시작
        btnNewButton2.addActionListener(e -> {
            // 쓰레드가 실행 중인지 확인하고 중단하고 다시 생성
            if (t.isAlive()) {
                t.interrupt();
            }
            t = new Counter();
            t.start();
        });
        getContentPane().add(btnNewButton2);

        // JFrame을 표시
        setVisible(true);

        // 카운터 쓰레드 생성 및 시작
        t = new Counter();
        t.start();
    }

    // CountDownTest의 인스턴스를 생성하는 메인 메서드
    public static void main(String[] args) {
        CountDownTest t = new CountDownTest();
    }
}
