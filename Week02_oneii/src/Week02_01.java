class Circlee {
	String name;
	protected int radius;
	public Circlee(int r) { radius=r;}
	
	public Circlee(String name, int radius) {
		this.name=name;
		this.radius=radius;
	}
}

class Pizzaa extends Circlee{
	public Pizzaa(String name, int radius) {
		super(name, radius);
	}
	public void print() {
		System.out.println(name +" 피자의 넓이는 "+ radius*radius*3.14 +"입니다.");
	}
}

public class Week02_01 {
	public static void main(String args[]) {
		Pizzaa obj=new Pizzaa("Pepperoni", 20);
		obj.print();
	}

}
