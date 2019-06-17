package jp.co.comnic.lesson.azami;

public class Queue {
	private int top = 0;
	private int datamax = 0, datasize = 0, point = 0;
	private Object data;
	private Object[] array;

	public Queue(int arraySize) {
		if (arraySize > 0) {
			array = new Object[arraySize]; // 配列の作成
			datamax = arraySize; // データ数がいくつ入るか格納
		} else {
			throw new IndexOutOfBoundsException("[ERROR] 配列数がおかしい");
		}
	}

	public void enqueue(Object data) {
		if (datasize < datamax) {
			array[top % array.length] = data;
			top++;
			datasize++;
		} else {
			System.err.println("enqueue error");
		}
	}

	public Object dequue() {

		datasize--;
		if (datasize >= 0) {
			data = array[point % array.length];

			array[point % array.length] = null;

			point++;
		} else {
			System.err.println("error dequeue");
			datasize++;
			data = -1;
		}

		return data;

	}

}
