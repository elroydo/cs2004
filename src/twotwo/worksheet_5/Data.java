package twotwo.worksheet_5;

public class Data {
	private String name;
	private int age;
	Data(String n, int a) {
		name = n;
		age = a;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void Print() {
		System.out.print(("("+getName()));
		System.out.print(", ");
		System.out.print(getAge());
		System.out.print(") ");
	}
}
