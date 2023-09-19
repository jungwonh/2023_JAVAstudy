class VPlayer implements Controllable{
	public void play() {System.out.println("비디오를 재생합니다.");}
	public void stop() {System.out.println("비디오를 멈춥니다.");}
}

public class VideoPlayer {
	public static void main(String[] args) {
		VPlayer c = new VPlayer();
		c.play();
		c.stop();
	}
}