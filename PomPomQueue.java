package pomPomTree;


public class PomPomQueue {

	private Node<PomPom> head;
	private Node<PomPom> tail;
	private int size;

	public PomPomQueue () {
		head = null;
		tail = null;
		size = 0;	
	}
	
	@SuppressWarnings("hiding")
	public class Node<PomPom>{
		PomPom data;
		Node<PomPom> next;
	
		Node(PomPom data) {
			this.data = data;
			this.next = null;
	}}
	
	public void enqueue(PomPom data) {
		Node<PomPom> newNode = new Node<PomPom>(data);
		
		
		if (isEmpty()) {
			head = newNode;
		}
		else {
			tail.next = newNode;
		}
		tail = newNode;
		size++;
		
	}
	
	public PomPom dequeue() {
		PomPom data = null;
		if (!isEmpty()) {
			data = head.data;
			head = head.next;
			size--;
		}
		if (isEmpty()) {
			tail = null;
		}
		return data;
	}
	
	public PomPom peek() {
		PomPom data = null;
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		if (!isEmpty()) {
			return head.data;
		}
		return data;
	}
	
	public boolean isEmpty() {
			return size == 0;
	}
	
	public int size() {
		return size;
	}

}
