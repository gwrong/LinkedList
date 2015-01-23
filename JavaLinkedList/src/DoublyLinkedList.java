import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This is a Doubly LinkedList that has both a head an tail pointer.
 * 
 * @author Graham Wright
 */
public class DoublyLinkedList<T> implements LinkedListInterface<T>, Iterable<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	@Override
	public boolean add(int index, T data) {
		if (data == null) {
			return false;
		}
		Node<T> toAdd = new Node<T>(data);
		boolean successful = true;
		if (isEmpty() && index == 0) {
			head = toAdd;
			tail = toAdd;
			size++;
		} else if (index == 0) { 
			head.setPrevious(toAdd);
			toAdd.setNext(head);
			head = toAdd;
			size++;
		} else if (index == size) {
			tail.setNext(toAdd);
			toAdd.setPrevious(tail);
			tail = toAdd;
			size++;
		} else if (index < 1 || index > size - 1) {
			successful = false;
		} else {
			Node<T> current = head;
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}
			Node<T> previous = current.getPrevious();
			previous.setNext(toAdd);
			current.setPrevious(toAdd);
			toAdd.setPrevious(previous);
			toAdd.setNext(current);
			size++;
		}
		return successful;
	}
	
	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object o) {
		return indexOf((T) o) > -1;
	}
	
	@Override
	public T get(int index) {
		if (isEmpty() || index < 0 || index >= size) {
			return null;
		}
		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
			if (current == null) {
				return null;
			}
		}
		return current.getData();
	}
	
	@Override
	public int indexOf(T data) {
		int index = 0;
		Node<T> current = head;
		while (current != null) {
			if (current.getData().equals(data)) {
				return index;
			} else {
				current = current.getNext();
			}
			index++;
		}
		return -1;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public T remove(Object o) {
		if (isEmpty()) {
			return null;
		} else {
			boolean found = false;
			Node<T> current = head;
			T toReturn = null;
			while (current != null && !found) {
				if (current.getData().equals(o)) {
					toReturn = current.getData();
					if (size == 1) {
						head = null;
						tail = null;
						found = true;
					} else if (current.equals(head)) {
						head.getNext().setPrevious(null);
						head = head.getNext();
						found = true;
					} else if (current.equals(tail)) {
						tail.getPrevious().setNext(null);
						tail = tail.getPrevious();
						found = true;
					} else {
						current.getPrevious().setNext(current.getNext());
						current.getNext().setPrevious(current.getPrevious());
						found = true;
					}
				}
				if (current != null) {
					current = current.getNext();
				}
			}
			size--;
			return toReturn;
		}
	}
	
	@Override
	public T remove(int index) {
		if (index < 0 || index > size - 1 || isEmpty()) {
			return null;
		} else if (index == 0 && size == 1) {
			T toReturn = head.getData();
			head = null;
			tail = null;
			size--;
			return toReturn;
		} else if (index == 0) {
			T toReturn = head.getData();
			head.getNext().setPrevious(null);
			head = head.getNext();
			size--;
			return toReturn;
		} else if (index == size - 1) {
			T toReturn = tail.getData();
			tail.getPrevious().setNext(null);
			tail.setPrevious(null);
			size--;
			return toReturn;
		} else {
			Node<T> current = head;
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}
			T toReturn = current.getData();
			current.getPrevious().setNext(current.getNext());
			current.getNext().setPrevious(current.getPrevious());
			size--;
			return toReturn;
		}
	}
	
	@Override
	public T replace(int index, T data) {
		if (index > -1 && index < size()) {
			Node<T> current = head;
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}
			T toReturn = current.getData();
			current.setData(data);
			return toReturn;
		} else {
			return null;
		}
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public Node<T> getHead() {
		return head;
	}
	
	@Override
	public void reverseList() {
		for (int i = 0, j = size - 1; j > i; i++, j--) {
			T data = get(j);
			T toSwap = replace(i, data);
			replace(j, toSwap);
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>();
	}
	
	/**
	 * The MyIterator for a DoublyLinkedList
	 * 
	 * @author Graham Wright
	 */
	private class MyIterator<E> implements Iterator<E> {
		
		private Node<E> current;
		
		/**
		 * The MyIterator constructor
		 */
		@SuppressWarnings("unchecked")
		public MyIterator() {
			current = (Node<E>) head;
		}
		
		/**
		 * Decides if there is a next value to return
		 * 
		 * @return Whether or not here is a next
		 */
		public boolean hasNext() {
			return current != null;
		}
		
		/**
		 * Gets the next value
		 * 
		 * @return The next data value
		 */
		public E next() {
			if (current == null) {
				throw new NoSuchElementException("There isn't a next element");
			}
			E toReturn = current.getData();
			current = current.getNext();
			return toReturn;
		}
		
		/**
		 * The remove method for the iterator
		 * Currently Unsupported
		 */
		public void remove() {
			throw new UnsupportedOperationException("We don't support remove");
		}
	}
}