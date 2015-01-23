/**
 * Node class for the Doubly Linked List
 */
public class Node<E> {
	
	private E data;
	private Node<E> next;
	private Node<E> prev;
	
	/**
	 * The Node constructor, taking in dat
	 * 
	 * @param data The data for the Node
	 */
	public Node(E data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
	
	/**
	 * Getter for the data in the Node
	 * 
	 * @return data The data in the Node
	 */
	public E getData() {
		return data;
	}
	
	/**
	 * Getter for the next Node reference
	 * 
	 * @return next The Node this node is pointing to
	 */
	public Node<E> getNext() {
		return next;
	}
	
	/**
	 * Getter for the prev Node reference
	 * 
	 * @return prev The previous Node
	 */
	public Node<E> getPrevious() {
		return prev;
	}
	
	/**
	 * Setter for the next Node reference
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	/**
	 * Setter for the previous Node reference
	 */
	public void setPrevious(Node<E> prev) {
		this.prev = prev;
	}
	
	/**
	 * Setter for the data
	 */
	public void setData(E data) {
		this.data = data;
	}
	
}