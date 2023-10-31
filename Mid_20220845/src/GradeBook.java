import java.util.ArrayList;

public class GradeBook {
	private ArrayList <Student> arrayList;
	
	public GradeBook() {
		arrayList=new ArrayList<Student>();
	}

public boolean search (int num) {
	for (int i=0; i<arrayList.size(); i++) {
		Student student=arrayList.get(i);
		int tempNum=student.getStudentNum();
		if(tempNum==num) {
			return true;
		}
		return false;
	}
}
	
	
public void showAllStudent() {
	for(Student student:arrayList) {
		System.out.println(student);
	}
	System.out.println();
}
}
