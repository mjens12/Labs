package lab10;

public class Node<E> {
	private E data;
	private Node next;
	private Node prev;

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node(E data, Node next) {
		this.data = data;
		this.next = next;
	}

	public Node() {
		data = null;
		next = null;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getNext() {
		return next;
	}
}
