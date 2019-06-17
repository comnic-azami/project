package jp.co.comnic.lesson.azami;

public class Node {
	

	  	private Object element;  // Nodeが保持するデータ
	    private Node   prevNode; // このNodeの前のNodeの参照
	    private Node   nextNode; // このNodeの次のNodeの参照
	                
	      public Node(Object element) {
	          this.element = element;
	      }
	      
	      public Object getElement() {
	          return element;
	      }
	      
	      public void setNext(Node node) {
	          nextNode = node;
	     
	      }
	      
	      public void setPrev(Node node) {
	          prevNode = node;
	      }
	      
	      public Node getNext() {
	          return nextNode;
	      }
	      
	      public Node getPrev() {
	          return prevNode;
	      }
	
	
	
	

}
