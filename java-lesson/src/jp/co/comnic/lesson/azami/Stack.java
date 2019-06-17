package jp.co.comnic.lesson.azami;

public class Stack {

	private Object array[];
	private int top = 0;

	public Stack(int arraySize) {
		if(arraySize>0)
		{
		array = new Object[arraySize];
		}
		else {
			throw new IndexOutOfBoundsException("[ERROR] 配列数がおかしいなんてしょうがないな～のび太君");
		}
	}

	public void push(Object i) {
		if (top < array.length) {
			array[top] = i;
			top++;
		} else {
			throw new IndexOutOfBoundsException("[ERROR] Stack is full");
		}
	}

	public Object pop() {
		Object data=null;
		top--;
		if (top >= 0) {
			data=array[top];
		} else {
			top++;
			throw new IndexOutOfBoundsException("[ERROR] Stack is empty");
			
		}
		return data;

	}

}
