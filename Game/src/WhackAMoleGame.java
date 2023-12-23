import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WhackAMoleGame {
    private static final int GRID_SIZE = 5;
    private static final int GAME_DURATION = 30;

    private JFrame frame;
    private JButton[][] buttons;
    private Timer timer;
    private JLabel scoreLabel;
    private int currentMoleRow;
    private int currentMoleCol;

    private int score;

    public WhackAMoleGame() {
        frame = new JFrame("Whack-A-Mole Game");
        buttons = new JButton[GRID_SIZE][GRID_SIZE];
        timer = new Timer(1000, new TimerListener());
        score = 0;

        initializeUI();
        startGame();
    }

    private void initializeUI() {
        frame.setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground(Color.LIGHT_GRAY);
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                gridPanel.add(buttons[i][j]);
            }
        }

        frame.add(gridPanel, BorderLayout.CENTER);

        scoreLabel = new JLabel("점수: " + score + " | 남은 시간: " + GAME_DURATION + "초", SwingConstants.CENTER);
        frame.add(scoreLabel, BorderLayout.SOUTH);

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void startGame() {
        timer.start();
        placeMole();
    }

    private void stopGame() {
        timer.stop();

        // 게임 종료 후 다시하기, 그만하기 버튼이 있는 새로운 프레임 생성
        JFrame resultFrame = new JFrame("게임 결과");
        resultFrame.setLayout(new BorderLayout());

        JLabel resultLabel = new JLabel("게임 종료!\n최종 점수: " + score, SwingConstants.CENTER);
        resultFrame.add(resultLabel, BorderLayout.CENTER);

        // 다시하기 버튼
        JButton playAgainButton = new JButton("다시하기");
        playAgainButton.addActionListener(e -> {
            resultFrame.dispose();
            resetGame();
        });

        // 그만하기 버튼
        JButton quitButton = new JButton("그만하기");
        quitButton.addActionListener(e -> System.exit(0));

        // 버튼을 담을 패널
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(playAgainButton);
        buttonPanel.add(quitButton);

        resultFrame.add(buttonPanel, BorderLayout.SOUTH);

        resultFrame.setSize(300, 150);
        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resultFrame.setVisible(true);
    }

    private void resetGame() {
        // 게임 재시작을 위해 초기화
        score = 0;
        updateScoreLabel();

        // 타이머를 재시작하기 전에 이전 타이머를 중지
        timer.stop();

        // 남은 시간과 게임 중인 상태를 초기화
        TimerListener timerListener = (TimerListener) timer.getActionListeners()[0];
        timerListener.remainingTime = GAME_DURATION;
        timerListener.gameRunning = true;

        // 타이머를 재시작
        timer.start();
        placeMole();
    }

    private void updateScoreLabel() {
        scoreLabel.setText("점수: " + score + " | 남은 시간: " + ((TimerListener) timer.getActionListeners()[0]).remainingTime + "초");
    }

    private void placeMole() {
        // 현재 두더지 위치를 비활성화
        if (currentMoleRow >= 0 && currentMoleRow < GRID_SIZE
                && currentMoleCol >= 0 && currentMoleCol < GRID_SIZE) {
            buttons[currentMoleRow][currentMoleCol].setBackground(Color.LIGHT_GRAY);
        }

        // 랜덤한 위치에 두더지 생성
        currentMoleRow = (int) (Math.random() * GRID_SIZE);
        currentMoleCol = (int) (Math.random() * GRID_SIZE);
        buttons[currentMoleRow][currentMoleCol].setBackground(Color.RED);
    }

    private class TimerListener implements ActionListener {
        private int remainingTime = GAME_DURATION;
        private boolean gameRunning = true;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!gameRunning) {
                return; // 게임 중이 아니라면 처리하지 않음
            }

            if (remainingTime <= 0) {
                stopGame();
            } else {
                updateScoreLabel();
                remainingTime--;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                placeMole();
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        private final int row;
        private final int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (row == currentMoleRow && col == currentMoleCol) {
                score++;
            } else {
                score--;
            }

            updateScoreLabel();
            placeMole();
            System.out.println("현재 점수: " + score);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WhackAMoleGame());
    }
}
