import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyIp {
    public static void main(String[] args) {
        try {
            // 현재 실행 중인 컴퓨터의 InetAddress 객체를 가져옴
            InetAddress local = InetAddress.getLocalHost();
            
            // 호스트의 IP 주소를 출력
            System.out.println("내 컴퓨터 IP 주소: " + local.getHostAddress());
        } catch (UnknownHostException e) {
            // 호스트 주소를 찾을 수 없는 경우의 예외 처리
            e.printStackTrace();
        }
    }
}
