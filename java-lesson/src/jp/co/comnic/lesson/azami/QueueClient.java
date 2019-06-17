package jp.co.comnic.lesson.azami;

public class QueueClient {
	public static void main(String[] args) {
		Queue queue = new Queue(3);

		queue.enqueue("梶原");
	
		System.out.println(queue.dequue());
		
		queue.enqueue("ジャギィ");
		System.out.println(queue.dequue());
		queue.enqueue("3落ち");
		System.out.println(queue.dequue());
		queue.enqueue("クエスト失敗");
		
		System.out.println(queue.dequue());
		queue.enqueue("梶原");
		queue.enqueue("ジャギィ");
		queue.enqueue("3落ち");
		System.out.println(queue.dequue());
		queue.enqueue("クエスト失敗");
		System.out.println(queue.dequue());
		
		System.out.println(queue.dequue());
		
		System.out.println(queue.dequue());
		System.out.println(queue.dequue());
		
		

	}

}
