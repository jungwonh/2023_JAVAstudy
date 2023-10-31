
public class Student {
	private String name;
	private int num;
	private double score;
	
	public Student(String name, int num, double score) {
		this.name=name;
		this.num=num;
		this.score=score;
	}
	public int getStudentNum() {
		return num;
	}

public String toString() {
	return name+", "+num+", "+score;
}
}
