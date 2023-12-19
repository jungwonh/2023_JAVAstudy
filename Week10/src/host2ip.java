import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostToIp {
    public static void main(String[] args) throws IOException {
        // 대상 호스트의 이름을 지정
        String hostname = "www.google.com";

        try {
            // 호스트 이름을 이용하여 InetAddress 객체를 얻어옴
            InetAddress address = InetAddress.getByName(hostname);
            
            // 얻어온 InetAddress 객체로부터 IP 주소를 가져와 출력
            System.out.println("IP 주소: " + address.getHostAddress());
        } catch (UnknownHostException e) {
            // 호스트 이름을 찾을 수 없는 경우의 예외 처리
            System.out.println(hostname + "의 IP 주소를 찾을 수 없습니다.");
        }
    }
}
