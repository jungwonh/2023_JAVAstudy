

public class Student {
	String name;
	String number;
	Double grade;
	
	//생성자를 사용하여 이름, 학번, 점수 초기화
	public Student(String name, String number, Double grade) {
		super();
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNumber() {
		return number;
	}
	
	public Double getGrade() {
		return grade;
	}
	
	public String toString() {
		return "이름: "+name+", 학번: "+number+", 점수: "+grade;
		}

}
