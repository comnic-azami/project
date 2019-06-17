package jp.co.comnic.lesson.azami;

public class StackCient {
	public static void main(String[] args) {
				
		Stack stack =new Stack(3);
		
		stack.push("3落ち");		
		stack.push("ジャギィ");
		stack.push("梶原");
		
		stack.push(4);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
  		System.out.println(stack.pop());
	}
}
