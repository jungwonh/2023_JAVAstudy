import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
    public static void main(String[] args) throws IOException {
        // 소켓을 생성하고 "time-c.nist.gov" 서버의 13번 포트로 연결
        try (Socket s = new Socket("time-c.nist.gov", 13)) {
            // 소켓으로부터 입력 스트림을 얻음
            InputStream inStream = s.getInputStream();
            
            // 입력 스트림을 Scanner로 감싸서 편리하게 읽기 위해 준비
            Scanner in = new Scanner(inStream);

            // 서버에서 받은 각 줄을 출력
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
}
