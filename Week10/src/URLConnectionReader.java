import java.net.*;
import java.io.*;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception {
        // URL 객체를 생성하여 특정 웹 사이트에 대한 연결을 나타냄
        URL site = new URL("https://www.naver.com/");
        
        // URLConnection을 통해 해당 웹 사이트에 대한 연결을 열고 정보를 읽을 수 있도록 함
        URLConnection url = site.openConnection();
        
        // BufferedReader를 사용하여 URLConnection의 입력 스트림을 읽을 준비
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                url.getInputStream()));
        
        // 한 줄씩 읽어들여서 출력
        String inLine;
        while ((inLine = in.readLine()) != null) 
            System.out.println(inLine);
        
        // 스트림을 닫아 리소스를 해제
        in.close();
    }
}
