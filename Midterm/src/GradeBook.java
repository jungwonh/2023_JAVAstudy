import java.util.ArrayList;

public class GradeBook {
	private ArrayList<Student> list;
	
	public GradeBook() {
		this.list=new ArrayList<>();
	}
	//학생등록 메서드
	public void saveStudent(Student student) {
		list.add(student);
		System.out.println(student.name+"학생이 저장되었습니다. ");
		System.out.println("이름: "+student.getName());
		System.out.println("학번: "+student.getNumber());
		System.out.println("성적: "+student.getGrade());

		
	}
	//전체평균구하는 메서드
	public double averageGrade() {
		double sum=0;
		double avg=1.0;
		
		for(Student student : list) {
			sum+=student.getGrade();
		}
		avg=sum/list.size();
		return avg;
	}
	
	//특정학번을 가진 학생의 정보를 검색
	public void searchStudent(String number) {
		for (Student student : list) {
			if(student.getNumber().equals(number)) {
				System.out.println("학번이 "+number+"인 학생을 찾았습니다. ");
				System.out.println("이름: "+student.getName());
				System.out.println("학번: "+student.getNumber());
				System.out.println("학번: "+student.getGrade());
				return;

				
			}
		}
		System.out.println("학번이 "+number+"인 학생을 찾을 수 없습니다. ");
	}

}
