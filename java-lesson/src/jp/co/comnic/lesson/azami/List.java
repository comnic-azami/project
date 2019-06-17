package jp.co.comnic.lesson.azami;

public class List {


	   private Node headNode;        // 先頭ノード
	    private Node tailNode;        // 末尾ノード
	    private int  size;            // ノードの数

	    public List() {
	        headNode = tailNode = new Node(null);
	    }

	    public void add(Object obj) {
	        Node newNode = new Node(obj); // 渡されたデータを格納する新ノードの生成
	        
	        tailNode.setNext(newNode);    // 現在の末尾ノードの次ノードに新ノードを設定
	        newNode.setPrev(tailNode);    // 新ノードの前ノードに現在の末尾ノードを設定
	        tailNode = newNode;           // 新ノードを末尾ノードとして設定

	        size++;// 要素数をカウントアップ
	    }

	    public Object get(int index) {
	        return getNode(index).getElement();         
	    }

	    public Object remove(int index) {

	        // getNodeメソッドを使用して削除対象のノードを取得
	        Node removeNode = getNode(index);        
	                        
	        if (removeNode.getNext() == null) { // 削除するノードが最後のノードの場合            
	            removeNode.getPrev().setNext(null); 
	                
	        } else { // 削除するノードが中間ノードもしくは先頭ノードの場合         
	        
	            // 新しいリンクのつなぎ直し
	            removeNode.getNext().setPrev(removeNode.getPrev());
	            removeNode.getPrev().setNext(removeNode.getNext());
	            
	            // ※ 上記2行のコードは下記4行のコードと等価
	            // Node prevNode = removeNode.getPrev(); // 削除ノードの前ノード
	            // Node nextNode = removeNode.getNext(); // 削除ノードの次ノード
	            // nextNode.setPrev(prevNode); 
	            // prevNode.setNext(nextNode);
	        }
	        
	        Object rtnObj = removeNode.getElement();
	        removeNode = null;
	        
	        size--;        
	        return rtnObj;
	    }

	    private Node getNode(int index) {
	                
	        if(index < 0 || index >= size) {
	            throw new IndexOutOfBoundsException();
	        }
	            
	        Node currentNode = null;
	        if(index <= size / 2) { // 指定されたインデックスが中央値よりも小さい場合

	            currentNode = headNode.getNext(); // 先頭ノードから辿る
	            for(int i = 0; i < index; i++) { 
	                currentNode = currentNode.getNext();
	            }
	        } else { // 指定されたインデックスが中央値よりも大きい場合

	            currentNode = tailNode; // 末尾ノードから辿る
	            for(int i = size - 1; i > index; i--) {
	                currentNode = currentNode.getPrev();
	            }
	        }
	        return currentNode;
	    }
}
