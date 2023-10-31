import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		Scanner s= new Scanner(System.in);
		System.out.println("학생 이름 입력: ");
		String name=s.next();
		System.out.println("학번 입력: ");
		int num=s.nextInt();
		System.out.println("점수 입력: ");
		double score=s.nextDouble();
		
		Student newstudent= new Student(name, num, score);
		
		
	}

}
