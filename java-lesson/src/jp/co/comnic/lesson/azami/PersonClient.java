package jp.co.comnic.lesson.azami;

public class PersonClient {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("John");
		System.out.println("Person: " + p.getName());
	}
}
